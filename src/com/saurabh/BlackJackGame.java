package com.saurabh;

import java.io.DataInputStream;

/**
 * Created by Saurabh on 20/09/2015.
 */
public class BlackJackGame {
    private int bet;
    private int chip;
    private Deck deck;
    private Hand playersHand;
    private Hand dealersHand;
    private DataInputStream usersInput;

    public BlackJackGame() {
        this.bet =0;
        this.chip = 100;
        this.deck = new Deck();
        this.usersInput = new DataInputStream(System.in);
    }

    public void play() {
        System.out.println("Welcome to Blackjack!");
        System.out.println("You have " + chip + " chips.");
    }
}
