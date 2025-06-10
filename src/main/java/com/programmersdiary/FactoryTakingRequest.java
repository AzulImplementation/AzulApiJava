package com.programmersdiary;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Request to take tiles from a factory display")
public record FactoryTakingRequest(
    @Schema(description = "Factory display index (0-4)", example = "0", minimum = "0", maximum = "4")
    int factoryIndex, 
    
    @Schema(description = "Tile color to take", example = "RED", 
            allowableValues = {"RED", "BLUE", "YELLOW", "BLACK", "WHITE"})
    Tile tileToTake, 
    
    @Schema(description = "Number of tiles to put on floor", example = "0", minimum = "0")
    int tilesToPutOnFloor, 
    
    @Schema(description = "Pattern line index (0-4) where remaining tiles go", example = "1", minimum = "0", maximum = "4")
    int patternLineIndex
) {}
