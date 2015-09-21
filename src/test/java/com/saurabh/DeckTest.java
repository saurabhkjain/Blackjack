package com.saurabh;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by saurabh.jain on 21/09/2015.
 */
public class DeckTest {

    private Deck deck;
    @Before
    public void setup() {
        deck = Mockito.spy(new Deck());
    }
    @Test
    public void testDealShuggleMethodIsCalledWhenMajorityOfTheDeckIsConsumed() throws Exception {
        deck.setNextCard(157);
        deck.deal();
        verify(deck,times(1)).shuffle();
    }
}