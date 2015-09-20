package com.saurabh;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Saurabh on 20/09/2015.
 */
public class BlackJackGame {
    private int bet;
    private int chip;
    private Deck deck;
    private Hand playersHand;
    private Hand dealersHand;
    private Scanner usersInput;

    public BlackJackGame() {
        this.bet = 0;
        this.chip = 100;
        this.deck = new Deck();
        usersInput = new Scanner(System.in);
    }

    public void play() throws IOException {
        System.out.println("Welcome to Blackjack!");
        System.out.println("You have " + chip + " chips.");

        do {
            betting();
            if (bet > 0) {
                startDeal();

                if (playersHand.blackjack())
                    playerWins();
                while (playersHand.under(22) && playerTakesAHit()) {
                    playersHand.addCard(deck.deal());
                    playersHand.show(false, false);
                    System.out.println("Player's hand is " + playersHand.getTotalValue());
                }
                while(dealersHand.mustHit())
                    dealersHand.addCard(deck.deal());

                dealersHand.show(true,false);
                System.out.println("Dealer is now showing " + dealersHand.getTotalValue());
                showResults();
            }
        } while (bet > 0);
    }

    private void showResults() {
        if(playersHand.busted() && dealersHand.busted()) {
            tie();
        }
        else if(playersHand.busted()) {
            dealerWins();
        }
        else if(dealersHand.busted()) {
            playerWins();
        }
        else if(playersHand.score() > dealersHand.score()) {
            playerWins();
        }
        else if(playersHand.score() < dealersHand.score()) {
            dealerWins();
        }
        else {
            tie();
        }
    }

    public void dealerWins() {
        chip -= bet;
        System.out.println("Dealer wins!!!!.");
        System.out.println("You now have " + Integer.toString(chip)+ " chips");
    }

    public void tie() {
        System.out.println("Tie.");
        System.out.println("You now have " + Integer.toString(chip)+ " chips");
    }

    private boolean playerTakesAHit() throws IOException {
        char a = ' ';
        do {
            System.out.print("Hit (H) or Stand (S)? ");
            System.out.flush();
            String playersDecision = usersInput.nextLine();
            try {
                a = playersDecision.charAt(0);
            } catch (StringIndexOutOfBoundsException exception) {
                exception.printStackTrace();
            }
            ;
            if (a == 'H' || a == 'h') {
                return true;
            }
            if (a == 'S' || a == 's') {
                return false;
            }
        } while (true);
    }


    public void startDeal() {
        playersHand = new Hand();
        dealersHand = new Hand();

        for (int i = 0; i < 2; i++) {
            playersHand.addCard(deck.deal());
            dealersHand.addCard(deck.deal());

        }
        dealersHand.show(true, true);
        playersHand.show(false, false);
        System.out.println("Player's hand is "+ playersHand.getTotalValue());
    }

    public void betting() {
        do {
            System.out.println("How much do you want to bet?");
            System.out.flush();
            bet = Integer.parseInt(usersInput.nextLine());
            if (bet < 0 || bet > chip)
                System.out.println("Your must choose between 0 and " + chip + '.');
        } while (bet < 0 || bet > chip);

    }

    private void playerWins() {
        chip = chip + bet;
        System.out.println("Player wins " + Integer.toString(bet) + " chips.");
        System.out.println("You now have " + Integer.toString(chip) + " chips");
    }
}
