package org.superwarden.gdmstelegrambot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.superwarden.gdmstelegrambot.spring.difficulty.Difficulty;
import org.superwarden.gdmstelegrambot.spring.difficulty.DifficultyType;

@SpringBootApplication
public class GdmsTelegramBotApplication {
    public static void main(String[] args) {
        SpringApplication.run(GdmsTelegramBotApplication.class, args);
//        Difficulty difficulty = new Difficulty(DifficultyType.EXTREME_DEMON, 400);
    }
}
