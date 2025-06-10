package com.programmersdiary;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Request to take tiles from the center area")
public record CenterTakingRequest(
    @Schema(description = "Tile color to take from center", example = "BLUE", 
            allowableValues = {"RED", "BLUE", "YELLOW", "BLACK", "WHITE"})
    Tile tileToTake, 
    
    @Schema(description = "Number of tiles to put on floor", example = "1", minimum = "0")
    int tilesToPutOnFloor, 
    
    @Schema(description = "Pattern line index (0-4) where remaining tiles go", example = "2", minimum = "0", maximum = "4")
    int patternLineIndex
) {}
