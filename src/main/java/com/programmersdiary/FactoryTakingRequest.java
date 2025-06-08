package com.programmersdiary;

public record FactoryTakingRequest(int factoryIndex, Tile tileToTake, int tilesToPutOnFloor, int patternLineIndex) {
}
