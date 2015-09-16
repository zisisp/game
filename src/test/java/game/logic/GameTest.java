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

import java.util.Arrays;
import java.util.List;

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
        GameState gameState = new GameState();
        game.makeTheMove(gameState, -1);
    }

    @Test(expected=RuntimeException.class)
    public void testWrongInput2() throws Exception {
        GameState gameState = new GameState();
        game.makeTheMove(gameState, 6);
    }

    @Test
    public void testLastMove() {
        GameState gameState = new GameState();
        Player player1=gameState.players.get(0);
        List<Integer> player1Balls= Arrays.asList(0, 0, 0, 0, 0, 6, 6);
        player1.balls=player1Balls;
        Player player2=gameState.players.get(1);
        List<Integer> player2Balls= Arrays.asList(7, 8, 8, 8, 8, 8,13 );
        player2.balls=player2Balls;
        gameState.playersTurn=1;

        game.makeTheMove(gameState, 0);
        assertTrue("Game winner should be player 2", gameState.winner == 1);
        assertTrue("Game should have ended",gameState.gameEnded);
        assertTrue("Player1 should not have any balls in his pits", player1HasNoMoreBalls(gameState.players.get(0)));
    }

    private boolean player1HasNoMoreBalls(Player player) {
        for (int i = 0; i < 6; i++) {
            if (player.balls.get(i) != 0) {
                return false;
            }
        }
        return true;
    }
}