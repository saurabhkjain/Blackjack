package com.saurabh;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * Created by saurabh.jain on 21/09/2015.
 */
public class GameTest {

    private Game game;
    private Scanner usersInput;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        game = Mockito.spy(new Game());
        usersInput = Mockito.mock(Scanner.class);
        System.setOut(new PrintStream(outContent));
    }
    @Test
    public void testPlay() throws Exception {
        game.play();
        verify(game, times(1)).betting();
    }

    @Test
    public void testDealerWins() throws Exception {

    }

    @Test
    public void testStartDeal() throws Exception {

    }

    @Test
    public void testBetting() throws Exception {
        game.setChip(0);
        game.betting();
        System.out.println("You don't have any more chips left. The game will now exit");
        assertEquals("You don't have any more chips left. The game will now exit", outContent.toString());
    }

    @Test
    public void testPlayerTakesAHit() throws Exception {
        game.playerTakesAHit();
        verify(usersInput, times(1)).nextLine();
    }
}