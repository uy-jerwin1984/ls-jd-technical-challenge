package com.ph.juy.ls.web.controllers;

import com.ph.juy.ls.repository.entity.SpeechEntity;
import com.ph.juy.ls.service.SpeechService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/speeches")
public class SpeechController {

    @Autowired
    private SpeechService speechService;

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public SpeechEntity create() {
        return speechService.create();
    }

}
