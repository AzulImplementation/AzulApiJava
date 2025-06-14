package com.programmersdiary;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.programmersdiary.PatternLineTest.patternLines;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    @Test
    void playerCanAddTilesToPatternLineAndFloor() {
        Floor floor = new Floor();
        PatternLine[] patternLines = patternLines();
        Player player = new Player(new Board(patternLines, new Wall(), floor));
        Game game = new Game(
                List.of(player, new Player(new Board(patternLines()))), new Center(), 0
        );
        game.changeFactoryDisplay(0, List.of(Tile.RED, Tile.RED, Tile.RED, Tile.BLUE));

        game.executeFactoryOfferPhaseWithFactory(0, Tile.RED, 2, 2);

        assertEquals(1, patternLines[2].tileCount());
        assertEquals(-2, floor.score());
    }
}
