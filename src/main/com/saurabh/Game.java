package com.saurabh;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Saurabh on 20/09/2015.
 */
public class Game {
    private int bet;
    private int chip;
    private Deck deck;
    private Hand playersHand;
    private Hand dealersHand;
    private Scanner usersInput;

    /**
     * Constructor
     */
    public Game() {
        this.bet = 0;
        this.chip = 100;
        this.deck = new Deck();
        usersInput = new Scanner(System.in);
    }

    /**
     * Setter to set chip's value.
     * @param chip Number of chips
     */
    public void setChip(int chip) {
        this.chip = chip;
    }

    /**
     * Setter to set the bet value.
     * @param bet Value of the bet
     */
    public void setBet(int bet) {
        this.bet = bet;
    }

    /**
     * Main method which start the blackjack game.
     * @throws IOException
     */
    public void play() throws IOException {
        System.out.println("Welcome to Blackjack!");
        System.out.println("You have " + chip + " chips.");

        do {
            betting();
            if (bet > 0) {
                startDeal();
                // If the inital 2 card of the player is 21.
                if (playersHand.blackjack())
                    playerWins();

                // If the total value for the player is under 22 and the player wants another card.
                while (playersHand.under(22) && playerTakesAHit()) {
                    playersHand.addCard(deck.deal());
                    playersHand.show(false, false);
                    System.out.println("Player's hand is " + playersHand.getTotalValue());
                    if (playersHand.getTotalValue() == 21)
                        playerWins();
                }
                while (dealersHand.mustHit())
                    dealersHand.addCard(deck.deal());

                dealersHand.show(true, false);
                System.out.println("Dealer is now showing " + dealersHand.getTotalValue());
                showResults();
            }
        } while (bet > 0);
    }

    /**
     * Determines if the player or dealer has won and then calls the appropriate method.
     */
    private void showResults() {
        if (playersHand.busted()) {
            dealerWins();
        } else if (dealersHand.busted()) {
            playerWins();
        } else if (playersHand.score() > dealersHand.score()) {
            playerWins();
        } else if (playersHand.score() < dealersHand.score()) {
            dealerWins();
        } else {
            dealerWins();
        }
    }

    /**
     * Method is called if the dealer wins
     */
    public void dealerWins() {
        chip -= bet;
        System.out.println("Dealer wins!!!!.");
        System.out.println("You now have " + Integer.toString(chip) + " chips");
    }

    /**
     * Called if the player wants another card.
     * @return Returns true if 'H' is inputed.
     * @throws IOException
     */
    public boolean playerTakesAHit() throws IOException {
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

    /**
     * Deals the cards out the player and the dealer.
     */
    public void startDeal() {
        playersHand = new Hand();
        dealersHand = new Hand();

        for (int i = 0; i < 2; i++) {
            playersHand.addCard(deck.deal());
            dealersHand.addCard(deck.deal());

        }
        dealersHand.show(true, true);
        playersHand.show(false, false);
        System.out.println("Player's hand is " + playersHand.getTotalValue());
    }

    /**
     * Determines how much the user has bet on the game.
     */
    public void betting() {
        do {
            // End if the player has no more chips left
            if (chip == 0) {
                System.out.println("You don't have any more chips left. The game will now exit");
                System.exit(0);
            }
            System.out.println("How much do you want to bet? (Enter 0 to end)");
            System.out.flush();
            bet = Integer.parseInt(usersInput.nextLine());
            if (bet < 0 || bet > chip)
                System.out.println("Your must choose between 0 and " + chip + '.');
            if (bet == 0)
                break;
        } while (bet < 0 || bet > chip);

    }

    /**
     * Called is the player wins the game.
     */
    private void playerWins() {
        chip = chip + bet;
        System.out.println("Player wins " + Integer.toString(bet) + " chips.");
        System.out.println("You now have " + Integer.toString(chip) + " chips");
    }
}
