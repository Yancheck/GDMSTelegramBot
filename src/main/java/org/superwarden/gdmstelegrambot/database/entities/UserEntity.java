package org.superwarden.gdmstelegrambot.database.entities;

import jakarta.persistence.*;

@Table(name = "users")
@Entity
public class UserEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "chat_id")
    private Long chatId;

    @Column(name = "username")
    private String username;

    @Column(name = "permission_level")
    private Integer permissionLevel;

    public UserEntity() {}

    public UserEntity(Long id, Long chatId, String username, Integer permissionLevel) {
        this.id = id;
        this.chatId = chatId;
        this.username = username;
        this.permissionLevel = permissionLevel;
    }

    // Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPermissionLevel(Integer permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    // Getters

    public Long getId() {
        return id;
    }

    public Long getChatId() {
        return chatId;
    }

    public String getUsername() {
        return username;
    }

    public Integer getPermissionLevel() {
        return permissionLevel;
    }
}
