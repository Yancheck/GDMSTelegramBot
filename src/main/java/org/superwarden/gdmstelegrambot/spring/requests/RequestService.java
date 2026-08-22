package org.superwarden.gdmstelegrambot.spring.requests;

import org.springframework.stereotype.Service;
import org.superwarden.gdmstelegrambot.database.repositories.RequestRepository;

@Service
public class RequestService {
    private final RequestRepository requestRepository;

    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    // TODO: creating request in db
    public void createRequest(Request request) {
    }
}
