package com.ph.juy.ls.web.controllers;

import com.ph.juy.ls.repository.entity.SampleEntity;
import com.ph.juy.ls.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/samples")
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public SampleEntity create() {
        return sampleService.create();
    }

}
