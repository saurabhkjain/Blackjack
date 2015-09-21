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

    /**
     * Adds a card to the player's/dealer's hand
     * @param deal {@link Card}
     */
    public void addCard(Card deal) {
        cards[numCards] = deal;
        ++numCards;
    }

    /**
     * Displays the type and the value of the card to the console.
     * @param dealer
     * @param firstCard
     */
    public void show(boolean dealer, boolean firstCard) {
        if (dealer) {
            System.out.println("Dealer's cards are: ");
        } else {
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


    /**
     * Returns true if the player/dealer has blackjack
     *
     * @return
     */
    public boolean blackjack() {
        if (numCards == 2) {
            if (cards[0].getiValue() == 1 && cards[1].getiValue() == 10) {
                return true;
            }
            if (cards[1].getiValue() == 1 && cards[0].getiValue() == 10) {
                return true;
            }
        }
        return false;
    }

    /**
     * Determines if the value of the hand is below is specified number
     * @param n
     * @return Returns true if its under
     */
    public boolean under(int n) {
        int points = 0;
        for (int i = 0; i < numCards; ++i) {
            points += cards[i].getiValue();
        }
        if (points < n) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the total value of all the card for a plaer/dealer
     * @return
     */
    public int getTotalValue() {
        int cardValue = 0;
        for (int i = 0; i < numCards; ++i) {
            cardValue += cards[i].getiValue();
        }
        return cardValue;
    }

    public int score() {
        int points = 0;
        boolean haveAce = false;
        for (int i = 0; i < numCards; ++i) {
            points += cards[i].getiValue();
            if (cards[i].getiValue() == 1) haveAce = true;
        }
        if (haveAce) {
            if (points + 10 < 22) points += 10;
        }
        return points;
    }

    public boolean mustHit() {
        return score() < 17;
    }

    public boolean busted() {
        return !under(22);
    }

}
