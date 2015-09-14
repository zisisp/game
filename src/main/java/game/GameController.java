package game;

import game.logic.Game;
import game.logic.GameState;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zais on 9/15/2015.
 */
@Controller
public class GameController {

    private static Game game = new Game();

    @RequestMapping("/play")
    public
    @ResponseBody
    GameState play(
            @RequestParam(value = "gamestate", required = false) GameState gameState,
            @RequestParam(value = "move", required = false) String move) {
        try {
            int moveToMake=Integer.parseInt(move);
        } catch (NumberFormatException e) {
        }
        return game.makeTheMove(gameState, move);
    }
}
