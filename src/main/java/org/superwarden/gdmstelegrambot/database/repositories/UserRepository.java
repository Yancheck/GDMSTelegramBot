package org.superwarden.gdmstelegrambot.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.superwarden.gdmstelegrambot.database.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,  Long> {

}
