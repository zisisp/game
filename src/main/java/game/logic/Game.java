package game.logic;

import org.springframework.stereotype.Component;

/**
 * Created by zais on 9/5/2015.
 */
@Component
public class Game {
    private static final int BIG_PIT_INDEX = 6;

    public GameState makeTheMove(GameState gameState, Integer originatingPit) {
        if (inputWrong(originatingPit)) {
            throw new RuntimeException("Unsupported input");
        }
        if (gameState == null) {
            gameState = new GameState();
        }
        gameState = moveStones(originatingPit, gameState);
        return gameState;
    }

    private boolean inputWrong(Integer originatingPit) {
        return originatingPit < 0 || originatingPit > 5;
    }


    private GameState moveStones(Integer originatingPit, GameState gameState) {
        Player moving = gameState.players.get(gameState.playersTurn);
        int stonesToMove = moving.stones.get(originatingPit);
        moving.stones.set(originatingPit, 0);//empty this pit
        int indexToUse = 0;
        boolean changePlayer = true;
        for (int i = originatingPit + 1; i <(originatingPit + 1)+ stonesToMove; i++) {
            indexToUse = i % 7;
            moving.stones.set(indexToUse, moving.stones.get(indexToUse) + 1);
            if (indexToUse == 6) {
                changePlayer = false;
            }
        }

        //see if you have captured opponents stones
        boolean captured=false;
        if (indexToUse != 6) {
            captured = captureOpponentsStones(gameState, indexToUse);
        }
        if (captured) {
            if (gameEnded(gameState)) {
                gameState.gameEnded=true;
                gameState.winner=gameState.playersTurn;
                return gameState;
            }
        }
//        //its next players turn
        if (changePlayer) {
            gameState.changeActivePlayer();
        }
        return gameState;
    }

    private boolean gameEnded(GameState gameState) {
        Player opponent=gameState.players.get(Math.abs(gameState.playersTurn-1));
        for (int i = 0; i < 6; i++) {
            if (opponent.stones.get(i) != 0) {
                return false;
            }
        }
        return true;
    }

    private boolean captureOpponentsStones(GameState gameState, int indexToUse) {
        Player opponent = gameState.players.get(Math.abs(gameState.playersTurn - 1));
        //see if you have captured opponents stones
        Integer stonesInPit = opponent.stones.get(5 - indexToUse);
        if (stonesInPit != 0) {
            Player playerCapturing = gameState.players.get(gameState.playersTurn);
            opponent.stones.set(5 - indexToUse, 0);
            playerCapturing.stones.set(indexToUse, playerCapturing.stones.get(indexToUse) + stonesInPit);
            return true;
        } else return false;
    }
}