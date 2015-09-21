package com.saurabh;

import java.util.Random;

/**
 * Created by Saurabh on 20/09/2015.
 */
public class Deck {
    private int[] deck;   // An array of 208 Cards, representing 4 decks.
    private int nextCard; // How many cards have been dealt from the deck.
    private Random random;

    /**
     * Constructor
     */
    public Deck() {
        deck = new int[208];
        for (int i = 0; i < 208; i++) {
            deck[i] = i;
        }
        nextCard = 0;
        random = new Random();
        shuffle();
    }

    public void setNextCard(int nextCard) {
        this.nextCard = nextCard;
    }

    /**
     * Randomly exchange two cards in the deck.
     */
    public void shuffle() {
        for(int i = 0;i<208;++i) {
            int j = randomCard();
            int k = randomCard();
            int temp = deck[j];
            deck[j] = deck[k];
            deck[k] = temp;
        }
    }

    /**
     * Randomly selects a card from the deck.
     * @return
     */
    private int randomCard() {
        int r = random.nextInt();
        if(r<0) {
            r = 0-r;
        }
        return r%52;
    }

    /**
     * Returns a randomly selected card from the stack.
     * @return {@link Card}
     */
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
