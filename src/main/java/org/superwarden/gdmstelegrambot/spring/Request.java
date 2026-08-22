package org.superwarden.gdmstelegrambot.spring;

import org.superwarden.gdmstelegrambot.spring.difficulty.Difficulty;

public record Request(
        Long chatId,
        String levelName,
        Difficulty difficulty,
        String comment,
        String proofLink,
        Integer enjoyment
) {
}
