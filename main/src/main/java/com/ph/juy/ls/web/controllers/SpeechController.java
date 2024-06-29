package com.ph.juy.ls.web.controllers;

import com.ph.juy.ls.model.Request;
import com.ph.juy.ls.model.Response;
import com.ph.juy.ls.model.Speech;
import com.ph.juy.ls.service.SpeechService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Response<Speech>> create(@Valid  @RequestBody final Request<Speech> request) {
        final Speech speech = speechService.create(request.getData());
        return ResponseEntity.status(HttpStatus.CREATED).body(Response.wrapObject(speech));
    }

    @PutMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Response<Speech>> update(@Valid  @RequestBody final Request<Speech> request) {
        final Speech speech = speechService.update(request.getData());
        return ResponseEntity.status(HttpStatus.OK).body(Response.wrapObject(speech));
    }

    @GetMapping(
            path = { "/{id}"},
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Response<Speech>> findById(@PathVariable(name = "id") final String id) {
        final Speech speech = speechService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(Response.wrapObject(speech));
    }
    
    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Response<Speech>> list(
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
        final List<Speech> items = speechService.query(speech);
        return ResponseEntity.status(HttpStatus.OK).body(Response.wrapList(items));
    }

    @DeleteMapping(
            path = { "/{id}"},
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Response<Speech>> delete(@PathVariable(name = "id") final String id) {
        final Speech speech = speechService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(Response.wrapObject(speech));
    }

}
