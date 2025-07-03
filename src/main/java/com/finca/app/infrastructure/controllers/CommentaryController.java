package com.finca.app.infrastructure.controllers;

import com.finca.app.application.dto.commentary.ComentaryDtoRequest;
import com.finca.app.application.dto.commentary.CommentaryDtoResponse;
import com.finca.app.application.dto.finca.FincaDTORequest;
import com.finca.app.application.dto.finca.FincaDTOResponse;
import com.finca.app.application.service.commentary.CommentaryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commentary")
@Tag(name = "Commentary" , description = "Controller for Commentary")
public class CommentaryController {

    private final CommentaryService commentaryService;

    public CommentaryController(CommentaryService commentaryService){
        this.commentaryService = commentaryService;
    }
    @PostMapping
    public ResponseEntity<CommentaryDtoResponse> create(@Valid @RequestBody ComentaryDtoRequest commentaryDto){
        return new ResponseEntity<>(commentaryService.create(commentaryDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public CommentaryDtoResponse getById(@PathVariable("id") Long id){
        return commentaryService.getById(id);
    }

    @GetMapping("/getByUserId/{userId}")
    public List<CommentaryDtoResponse> getByUserId(@PathVariable("userId") Long userId){
        return commentaryService.getByUserId(userId);
    }

    @GetMapping("/getByFincaId/{fincaId}")
    public List<CommentaryDtoResponse> getByFincaId(@PathVariable("fincaId") Long fincaId){
        return commentaryService.getByFincaId(fincaId);
    }

    @PutMapping("/{id}")
    public CommentaryDtoResponse update(@PathVariable("id") Long id, @RequestBody ComentaryDtoRequest commentaryToUpdate){
        return commentaryService.update(id, commentaryToUpdate);
    }

    @DeleteMapping("/{id}")
    public CommentaryDtoResponse delete(@PathVariable("id") Long id){
        return commentaryService.delete(id);
    }

}
