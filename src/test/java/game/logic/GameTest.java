package game.logic;

import game.Application;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zais on 9/5/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class GameTest extends TestCase {

    @Autowired
    private Game game;


    @Test
    public void testFirstMove() throws Exception {
        GameState gameState = new GameState();
        int startingPlayer=gameState.playersTurn;
        GameState newGameState=game.makeTheMove(gameState, 0);

        assertTrue("It should be still be "+startingPlayer+" players turn",newGameState.playersTurn==startingPlayer);
        assertTrue("First hole should have zero balls",newGameState.players.get(startingPlayer).balls.get(0)==0);
        assertTrue("Big hole should have 1 ball", newGameState.players.get(startingPlayer).balls.get(6) == 1);
    }

    @Test(expected=RuntimeException.class)
    public void testWrongInput1() throws Exception {
//        GameState newGameState=game.makeTheMove(GameState.init(), -1);
    }

    @Test(expected=RuntimeException.class)
    public void testWrongInput2() throws Exception {
//        GameState newGameState=game.makeTheMove(GameState.init(), 6);
    }

    @Test
    public void testLastMove() {
//        GameState lastMove=GameState.init();

    }
}