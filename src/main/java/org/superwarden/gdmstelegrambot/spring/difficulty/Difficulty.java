package org.superwarden.gdmstelegrambot.spring.difficulty;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.io.IOException;

@Embeddable
public class Difficulty {
    @Enumerated(EnumType.STRING)
    @Column(name = "difficulty_type")
    private DifficultyType difficultyType;

    @Column(name = "top_placement")
    private int topPlacement;

    public Difficulty() {}

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

        try {
            if (!isTopCorrect(difficultyType, topPlacement)) {
                throw new IllegalStateException("Top placement is incorrect");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        this.difficultyType = difficultyType;
        this.topPlacement = topPlacement;
    }

    private boolean isTopCorrect(DifficultyType difficultyType, int topPlacement) throws IOException, InterruptedException {
        if (topPlacement < 1)
            return false;

        switch (difficultyType) {
            case EXTREME_DEMON -> {
                return topPlacement <= GdLvlsManager.getDemonListLvlCount();
            }
            case SHITTY, CHALLENGE -> {
                return topPlacement <= 200;
            }

            default -> {
                return true;
            }
        }
    }

    public DifficultyType getDifficultyType() {
        return difficultyType;
    }

    public int getTopPlacement() {
        return topPlacement;
    }
}
