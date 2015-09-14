package game.logic;

import org.springframework.stereotype.Component;

/**
 * Created by zais on 9/5/2015.
 */
@Component
public class Game {
    private static final int BIG_HOLE_INDEX = 6;

    public GameState makeTheMove(GameState gameState, Integer originatingPit) {
        if (inputWrong(originatingPit)) {
            throw new RuntimeException("Unsupported input");
        }
        if (gameState == null) {
            gameState = new GameState();
        }
        gameState = moveBalls(originatingPit, gameState);
        return gameState;
    }

    private boolean inputWrong(Integer originatingPit) {
        return originatingPit < 0 || originatingPit > 5;
    }


    private GameState moveBalls(Integer originatingPit, GameState gameState) {
        Player moving = gameState.players.get(gameState.playersTurn);
        int ballsToMove = moving.balls.get(originatingPit);
        moving.balls.set(originatingPit, 0);//empty this pit
        int indexToUse = 0;
        boolean changePlayer = true;
        for (int i = originatingPit + 1; i < ballsToMove; i++) {
            indexToUse = i % 7;
            moving.balls.set(indexToUse, moving.balls.get(indexToUse) + 1);
            if (indexToUse == 6) {
                changePlayer = false;
            }
        }

        //see if you have captured opponents balls
        boolean captured=false;
        if (indexToUse != 6) {
            captured = captureOpponentsBalls(gameState, indexToUse);
        }
        if (captured) {
            if (checkIfGameEnded(gameState)) {
                gameState.gameEnded=true;
                return gameState;
            }
        }
//        //its next players turn
        if (changePlayer) {
            gameState.changeActivePlayer();
        }
        return gameState;
    }

    private boolean checkIfGameEnded(GameState gameState) {
        Player opponent=gameState.players.get(Math.abs(gameState.playersTurn-1));
        for (int i = 0; i < 6; i++) {
            if (opponent.balls.get(i) != 0) {
                return false;
            }
        }
        return true;
    }

    private boolean captureOpponentsBalls(GameState gameState, int indexToUse) {
        Player opponent = gameState.players.get(Math.abs(gameState.playersTurn - 1));
        //see if you have captured opponents balls
        Integer ballsInPit = opponent.balls.get(5 - indexToUse);
        if (ballsInPit != 0) {
            Player playerCapturing = gameState.players.get(gameState.playersTurn);
            opponent.balls.set(5 - indexToUse, 0);
            playerCapturing.balls.set(indexToUse, playerCapturing.balls.get(indexToUse) + ballsInPit);
            return true;
        } else return false;
    }
}