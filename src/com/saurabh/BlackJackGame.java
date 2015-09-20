package com.saurabh;

import java.io.BufferedReader;
import java.io.Console;
import java.io.DataInputStream;
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
        this.bet =0;
        this.chip = 100;
        this.deck = new Deck();
        usersInput = new Scanner(System.in);
    }

    public void play() {
        System.out.println("Welcome to Blackjack!");
        System.out.println("You have " + chip + " chips.");

        do {
            betting();
            if (bet >0) {
                startDeal();
            }
        } while (bet >0);
    }

    public void startDeal() {
        playersHand = new Hand();
        dealersHand = new Hand();

        for (int i = 0; i < 2; i++) {
            playersHand.addCard(deck.deal());
            dealersHand.addCard(deck.deal());
            dealersHand.show(true, true);
            playersHand.show(false, false);
        }
    }

    public void betting() {
        do {
            System.out.println("How much do you want to bet?");
            System.out.flush();
            bet = Integer.parseInt(usersInput.nextLine());
            if (bet < 0 || bet > chip)
                System.out.println("Your must choose between 0 and " + chip + '.');
        } while (bet<0 || bet>chip);

    }
}
