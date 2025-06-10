package com.programmersdiary;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Tag(name = "Azul Game", description = "An API for Azul board game")
public class GameController {
    private final Game game;

    public GameController(Game game) {
        this.game = game;
    }

    @GetMapping("/show")
    @Operation(summary = "Get game state as a plain-text", description = "Returns the current game state as a plain-text")
    @ApiResponse(responseCode = "200", description = "Current game state")
    public String show() {
        return game.toString();
    }

    @GetMapping("/showJson")
    @Operation(summary = "Get game state as JSON", description = "Returns the current game state as a JSON object")
    @ApiResponse(responseCode = "200", description = "Current game state in JSON format")
    public Map<String, Object> showJson() {
        return game.jsonObject();
    }

    @PostMapping("/takeFromFactory")
    @Operation(summary = "Take tiles from factory", 
               description = "Take tiles of a specific color from a factory display, drop some on the floor (if you want) and put them on a pattern line")
    @ApiResponse(responseCode = "200", description = "Updated game state after taking tiles")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
        content = @Content(
            examples = {
                @ExampleObject(
                    name = "Take RED tiles",
                    description = "The example is not guaranteed to work due to randomness of game. Please check the board state first!",
                    value = "{\"factoryIndex\": 0, \"tileToTake\": \"RED\", \"tilesToPutOnFloor\": 0, \"patternLineIndex\": 1}"
                )
            }
        )
    )
    public Map<String, Object> takeTilesFromFactory(@RequestBody FactoryTakingRequest factoryTakingRequest) {
        game.executeFactoryOfferPhaseWithFactory(
                factoryTakingRequest.factoryIndex(), factoryTakingRequest.tileToTake(),
                factoryTakingRequest.tilesToPutOnFloor(), factoryTakingRequest.patternLineIndex()
        );
        return game.jsonObject();
    }

    @PostMapping("/takeFromCenter")
    @Operation(summary = "Take tiles from center", 
               description = "Take tiles of a specific color from the center area, drop some on the floor (if you want) and put them on a pattern line")
    @ApiResponse(responseCode = "200", description = "Updated game state after taking tiles")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
        content = @Content(
            examples = {
                @ExampleObject(
                    name = "Take BLUE tiles",
                    description = "The example is not guaranteed to work due to randomness of game. Please check the board state first!",
                    value = "{\"tileToTake\": \"BLUE\", \"tilesToPutOnFloor\": 1, \"patternLineIndex\": 2}"
                )
            }
        )
    )
    public Map<String, Object> takeTilesFromCenter(@RequestBody CenterTakingRequest centerTakingRequest) {
        game.executeFactoryOfferPhaseWithCenter(
                centerTakingRequest.tileToTake(), centerTakingRequest.tilesToPutOnFloor(),
                centerTakingRequest.patternLineIndex()
        );
        return game.jsonObject();
    }


}
