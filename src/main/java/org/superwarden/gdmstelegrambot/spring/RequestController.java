package org.superwarden.gdmstelegrambot.spring;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/request")
public class RequestController {
    @PostMapping("")
    public ResponseEntity<String> sendRequest(@RequestBody Request request) {
        return ResponseEntity.ok("ok");
    }
}
