package game;

import game.logic.Game;
import game.logic.GameState;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zais on 9/15/2015.
 */
@Controller
public class GameController {

    private static Game game = new Game();

    @RequestMapping(value = "/play", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseEntity<GameReqWrapper> play(
            @RequestBody GameReqWrapper gameReqWrapper) throws GameException {
        GameReqWrapper toReturn=new GameReqWrapper();
        toReturn.setGameState(game.makeTheMove(gameReqWrapper.gameState, gameReqWrapper.getMove()));
        return new ResponseEntity<>(toReturn, HttpStatus.OK);
    }
}