package com.example.userJWT.controller;

import com.example.userJWT.entity.MovesEntity;
import com.example.userJWT.entity.UserEntity;
import com.example.userJWT.service.MovesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/moves")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class MovesController {
    @Autowired
    MovesService movesService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MovesEntity> getAllMoves(){
        return movesService.AllMoves();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<MovesEntity> getAllMoves(@PathVariable Long id ) {
        return movesService.getMovesById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postMoves(@RequestBody MovesEntity movesEntity){
        movesService.postMoves(movesEntity);
    }
//    @GetMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public Optional<MovesEntity> getNomina(@PathVariable Long id ) {
//        return movesService.getMoviminos(id);
//    }
}
