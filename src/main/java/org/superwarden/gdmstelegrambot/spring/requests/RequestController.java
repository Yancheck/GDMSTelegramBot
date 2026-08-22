package org.superwarden.gdmstelegrambot.spring.requests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/request")
public class RequestController {
    private static final Logger log = LoggerFactory.getLogger(RequestController.class);
    private final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> sendRequest(@RequestBody Request request) {
        log.info("Creating request");
        requestService.createRequest(request);
        return ResponseEntity.ok().build();
    }
}
