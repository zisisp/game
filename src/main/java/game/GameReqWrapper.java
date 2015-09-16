package game;

import game.logic.GameState;

/**
 * Created by zais on 9/16/2015.
 */
public class GameReqWrapper {
    GameState gameState;
    int move;

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }
}
