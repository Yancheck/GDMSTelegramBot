package org.superwarden.gdmstelegrambot.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.superwarden.gdmstelegrambot.database.entities.RequestEntity;

public interface RequestRepository extends JpaRepository<RequestEntity, Long> {
}
