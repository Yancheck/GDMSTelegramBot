package org.superwarden.gdmstelegrambot.spring;

import org.superwarden.gdmstelegrambot.spring.difficulty.Difficulty;

public record Request(
        Long username,
        String levelName,
        Difficulty difficulty
) {
}
