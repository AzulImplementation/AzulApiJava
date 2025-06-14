package com.programmersdiary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Tile {
    BLUE("B"), YELLOW("Y"), RED("R"), BLACK("K"), WHITE("W");

    private final String displayName;

    Tile(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }

    public static String printedTiles(List<Tile> tiles) {
        int[] tileCount = new int[Tile.values().length];
        for (Tile tile : tiles) {
            tileCount[tile.ordinal()]++;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < tileCount.length; i++) {
            if (tileCount[i] > 0) {
                if(tileCount[i] == 1) {
                    result.append(Tile.values()[i].toString());
                }
                else {
                    result.append(tileCount[i]).append(Tile.values()[i].toString());
                }
                result.append(" ");
            }
        }
        if(!result.isEmpty()) {
            return result.substring(0, result.length() - 1);
        }
        return result.toString();
    }

    public static Map<String, Integer> groupedTiles(List<Tile> tiles) {
        int[] tileCount = new int[Tile.values().length];
        for (Tile tile : tiles) {
            tileCount[tile.ordinal()]++;
        }

        Map<String, Integer> result = new HashMap<>();
        for (int i = 0; i < tileCount.length; i++) {
            if (tileCount[i] > 0) {
                result.put(Tile.values()[i].toString(), tileCount[i]);
            }
        }
        return result;
    }
}
