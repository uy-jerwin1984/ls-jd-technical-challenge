package com.ph.juy.ls.web.controllers;

import com.ph.juy.ls.model.Speech;
import com.ph.juy.ls.service.SpeechService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/speeches")
public class SpeechController {

    @Autowired
    private SpeechService speechService;

    @PostMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Speech create(@Valid  @RequestBody final Speech speech) {
        return speechService.create(speech);
    }

    @GetMapping(
            path = { "/{id}"},
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Speech findById(@PathVariable(name = "id") final String id) {
        return speechService.findById(id);
    }
    
    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public List<Speech> list(
            @RequestParam(name = "author", required = false) final String author,
            @RequestParam(name = "content", required = false) final String content,
            @RequestParam(name = "author_date", required = false) final Instant authorDate,
            @RequestParam(name = "keyword", required = false) final String keyword

    ) {
        final Speech speech = new Speech();
        speech.setAuthor(author);
        speech.setContent(content);
        speech.setAuthorDate(authorDate);
        speech.setKeyword(keyword);
        return speechService.query(speech);
    }

}
