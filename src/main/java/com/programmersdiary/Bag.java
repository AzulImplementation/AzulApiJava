package com.programmersdiary;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Bag {
    private final List<Tile> tiles;

    Bag() {
        this(initTiles());
    }

    private static List<Tile> initTiles() {
        List<Tile> result = new ArrayList<>();
        for (Tile tileValue : Tile.values()) {
            for (int j = 0; j < 20; j++) {
                result.add(tileValue);
            }
        }
        return result;
    }

    Bag(List<Tile> tiles) {
        this.tiles = tiles;
    }

    public List<Tile> takeTiles(int amount, Lid lid) {
        List<Tile> takenTiles = new ArrayList<>(amount);
        if (amount > tiles.size()) {
            tiles.addAll(lid.giveTiles());
        }
        for(int i = 0; i < Math.min(tiles.size(), amount); i++) {
            takenTiles.add(tiles.remove(new Random().nextInt(tiles.size())));
        }
        return takenTiles;
    }

    public List<Tile> tiles() {
        return tiles;
    }

    @Override
    public String toString() {
        if (tiles.size() == 0) {
            return "Empty";
        }
        return Tile.printedTiles(tiles);
    }

    public Map<String, Integer> jsonObject() {
        return Tile.groupedTiles(tiles);
    }
}
