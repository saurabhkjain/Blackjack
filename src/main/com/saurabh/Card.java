package com.saurabh;

/**
 * Created by Saurabh on 20/09/2015.
 */
public class Card {

    private int number; // Numeric value corresponding to card.
    private String value; // "A" "2" through "9" "T" "J" "Q" "K"
    private String suit; // "S" "H" "C" "D"

    public Card(int n) {
        int iSuit = n/13;
        number = n%13+1;
        switch(iSuit) {
            case 0: suit = "Spades"; break;
            case 1: suit = "Hearts"; break;
            case 2: suit = "Clubs"; break;
            default: suit = "Diamonds";
        }
        if(number == 1)
            value = "Ace";
        else if(number == 10)
            value = "Ten";
        else if(number == 11)
            value = "Jack";
        else if(number == 12)
            value = "Queen";
        else if(number == 13)
            value = "King";
        else
            value = Integer.toString(number);
        if(number>10)
            number = 10;

    }

    public int getiValue() {
        return number;
    }

    public String getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }}
