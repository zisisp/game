package game.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * Created by zais on 9/5/2015.
 */
public class GameState {

    protected int playersTurn=0;
    protected String gameId;
    protected boolean gameEnded=false;
    protected int winner=0;
    protected List<Player> players;


    public GameState() {
        init();
    }

    private void init(String player1,String player2) {
        playersTurn=(int) (Math.random()*2);//random start
        gameId=UUID.randomUUID().toString();
        players=new ArrayList<>();
        players.add(new Player(player1));
        players.add(new Player(player2));
    }

    private void init() {
        init("Player1", "Player2");
    }

    public void changeActivePlayer() {
        playersTurn=(playersTurn==1)?0:1;
    }

    public int getPlayersTurn() {
        return playersTurn;
    }

    public void setPlayersTurn(int playersTurn) {
        this.playersTurn = playersTurn;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public boolean isGameEnded() {
        return gameEnded;
    }

    public void setGameEnded(boolean gameEnded) {
        this.gameEnded = gameEnded;
    }

    public int getWinner() {
        return winner;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}