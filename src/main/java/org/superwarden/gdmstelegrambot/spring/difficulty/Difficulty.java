package org.superwarden.gdmstelegrambot.spring.difficulty;

public class Difficulty {
    private final DifficultyType difficultyType;
    private final int topPlacement;

    public Difficulty(DifficultyType difficultyType) {
        if (difficultyType.equals(DifficultyType.EXTREME_DEMON) || difficultyType.equals(DifficultyType.CHALLENGE) || difficultyType.equals(DifficultyType.SHITTY)) {
            throw new IllegalStateException("This type of difficulty must have demon must have top");
        }

        this.difficultyType = difficultyType;
        this.topPlacement = -1;
    }

    public Difficulty(DifficultyType difficultyType, int topPlacement) {
        if (!difficultyType.equals(DifficultyType.EXTREME_DEMON) && !difficultyType.equals(DifficultyType.SHITTY) && !difficultyType.equals(DifficultyType.CHALLENGE)) {
            throw new IllegalStateException("This type of difficulty cannot have top placement");
        }

        if (!isTopCorrect(difficultyType, topPlacement)) {
            throw new IllegalStateException("Top placement is incorrect");
        }
        this.difficultyType = difficultyType;
        this.topPlacement = topPlacement;
    }

    private boolean isTopCorrect(DifficultyType difficultyType, int topPlacement) {
        if (topPlacement < 1)
            return false;

        switch (difficultyType) {
            case EXTREME_DEMON -> {
                return topPlacement <= AredlManager.getExtremeCount();
            }
            case SHITTY, CHALLENGE -> {
                return topPlacement <= 200;
            }

            default -> {
                return true;
            }
        }
    }
}
