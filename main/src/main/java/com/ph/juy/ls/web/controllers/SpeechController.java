package com.ph.juy.ls.web.controllers;

import com.ph.juy.ls.model.*;
import com.ph.juy.ls.service.SpeechService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/speeches")
@AllArgsConstructor
public class SpeechController {

    private final SpeechService speechService;

    @PostMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<Response<Speech>> create(@Valid  @RequestBody final Request<Speech> request) {
        final Speech speech = speechService.create(request.getData());
        return ResponseEntity.status(HttpStatus.CREATED).body(Response.wrapObject(speech));
    }

    @PutMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<Response<Speech>> update(@Valid  @RequestBody final Request<Speech> request) {
        final Speech speech = speechService.update(request.getData());
        return ResponseEntity.status(HttpStatus.OK).body(Response.wrapObject(speech));
    }

    @GetMapping(
            path = { "/{id}"},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<Response<Speech>> findById(@PathVariable(name = "id") final String id) {
        final Speech speech = speechService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(Response.wrapObject(speech));
    }
    
    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<PaginationResponse<Speech>> list(
            @RequestParam(name = "author", required = false) final String author,
            @RequestParam(name = "content", required = false) final String content,
            @RequestParam(name = "author_date", required = false)
            @DateTimeFormat(pattern = "MM/dd/yyyy") final LocalDate authorDate,
            @RequestParam(name = "keyword", required = false) final String keyword,
            @RequestParam(name = "current", required = false, defaultValue = "0") final Integer current,
            @RequestParam(name = "size", required = false, defaultValue = "5") final Integer size

    ) {
        final Speech speech = new Speech();
        speech.setAuthor(author);
        speech.setContent(content);
        speech.setAuthorDate(authorDate);
        speech.setKeyword(keyword);
        final PaginationRequest paginationRequest = new PaginationRequest(current, size);
        final SearchFilter<Speech> searchFilter = new SearchFilter<>(speech, paginationRequest);
        final PaginationResponse<Speech> paginationResponse = speechService.query(searchFilter);
        return ResponseEntity.status(HttpStatus.OK).body(paginationResponse);
    }

    @DeleteMapping(
            path = { "/{id}"},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<Response<Speech>> delete(@PathVariable(name = "id") final String id) {
        final Speech speech = speechService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(Response.wrapObject(speech));
    }

}
