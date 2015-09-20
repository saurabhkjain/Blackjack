package com.saurabh;

/**
 * Created by Saurabh on 20/09/2015.
 */
public class Hand {

    private int numCards;
    private Card cards[];

    public Hand() {
        numCards = 0;
        int maxCards = 12;
        cards = new Card[maxCards];
    }

    public void addCard(Card deal) {
        cards[numCards] = deal;
        ++numCards;
    }

    public void show(boolean dealer, boolean firstCard) {
        if (dealer) {
            System.out.println("Dealer's cards are: ");
        }
        else {
            System.out.println("Player's cards are: ");
        }

        for (int i = 0; i < numCards; i++) {
            if (i == 0 && firstCard) {
                System.out.println("    X");
            } else {
                System.out.println("    " + cards[i].getValue() + " of " + cards[i].getSuit());
            }
        }
    }
}
