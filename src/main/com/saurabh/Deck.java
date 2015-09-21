package com.saurabh;

import java.util.Random;

/**
 * Created by Saurabh on 20/09/2015.
 */
public class Deck {
    private int[] deck;   // An array of 208 Cards, representing 4 decks.
    private int nextCard; // How many cards have been dealt from the deck.
    private Random random;

    public Deck() {
        deck = new int[208];
        for (int i = 0; i < 208; i++) {
            deck[i] = i;
        }
        nextCard = 0;
        random = new Random();
        shuffle();
    }

    private void shuffle() {
        for(int i = 0;i<208;++i) {
            // Randomly exchange two cards in the deck.
            int j = randomCard();
            int k = randomCard();
            int temp = deck[j];
            deck[j] = deck[k];
            deck[k] = temp;
        }
    }

    private int randomCard() {
        int r = random.nextInt();
        if(r<0) {
            r = 0-r;
        }
        return r%52;
    }

    public Card deal() {
        if(nextCard>156) {
            shuffle();
            nextCard = 0;
        }
        Card card = new Card(deck[nextCard]);
        ++nextCard;
        return card;
    }
}
