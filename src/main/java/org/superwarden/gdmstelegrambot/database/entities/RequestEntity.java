package org.superwarden.gdmstelegrambot.database.entities;

import jakarta.persistence.*;
import org.superwarden.gdmstelegrambot.spring.difficulty.Difficulty;
import org.superwarden.gdmstelegrambot.spring.requests.Device;

@Table(name = "requests")
@Entity
public class RequestEntity {
    @Id
    private Long id;

    @Column(name = "chat_id")
    private Long chatId;

    @Column(name = "level_name")
    private String levelName;

    @Embedded
    private Difficulty difficulty;

    @Column(name = "comment")
    private String comment;

    @Column(name = "proof_link")
    private String proofLink;

    @Enumerated(EnumType.STRING)
    @Column(name = "device")
    private Device device;

    @Column(name = "enjoyment")
    private Integer enjoyment;

    public RequestEntity() {}

    public RequestEntity(Long id, Long chatId, String levelName, Difficulty difficulty, String comment, String proofLink, Device device, Integer enjoyment) {
        this.id = id;
        this.chatId = chatId;
        this.levelName = levelName;
        this.difficulty = difficulty;
        this.comment = comment;
        this.proofLink = proofLink;
        this.device = device;
        this.enjoyment = enjoyment;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setProofLink(String proofLink) {
        this.proofLink = proofLink;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public void setEnjoyment(Integer enjoyment) {
        this.enjoyment = enjoyment;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public Long getChatId() {
        return chatId;
    }

    public String getLevelName() {
        return levelName;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public String getComment() {
        return comment;
    }

    public String getProofLink() {
        return proofLink;
    }

    public Device getDevice() {
        return device;
    }

    public Integer getEnjoyment() {
        return enjoyment;
    }
}
