package com.saurabh;

import java.util.Random;

/**
 * Created by Saurabh on 20/09/2015.
 */
public class Deck {
    private int[] deck;   // An array of 52 Cards, representing the deck.
    private int nextCard; // How many cards have been dealt from the deck.
    private Random random;

    public Deck() {
        deck = new int[52];
        for (int i = 0; i < 52; i++) {
            deck[i] = i;
        }
        nextCard = 0;
        random = new Random();
//        shuffle();
    }

    public Card deal() {
        if(nextCard>51) {
//            shuffle();
            nextCard = 0;
        }
        Card card = new Card(deck[nextCard]);
        ++nextCard;
        return card;
    }
}
