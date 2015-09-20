package com.saurabh;

/**
 * Created by Saurabh on 20/09/2015.
 */
public class Hand {

    public void addCard(Card deal) {

    }

    public void show(boolean dealer, boolean firstCard) {
        if (dealer) {
            System.out.println("Dealer: ");
        }
        else {
            System.out.println("Player: ");
        }
    }
}
