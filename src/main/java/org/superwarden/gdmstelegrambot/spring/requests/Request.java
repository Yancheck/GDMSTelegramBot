package org.superwarden.gdmstelegrambot.spring.requests;

import org.superwarden.gdmstelegrambot.spring.difficulty.Difficulty;

public record Request(
        Long chatId,
        String levelName,
        Difficulty difficulty,
        String comment,
        String proofLink,
        Device device,
        Integer enjoyment
) {
}
