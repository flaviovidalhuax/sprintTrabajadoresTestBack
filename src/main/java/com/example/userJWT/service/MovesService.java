package com.example.userJWT.service;

import com.example.userJWT.entity.MovesEntity;
import com.example.userJWT.entity.UserEntity;
import com.example.userJWT.repository.MovesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovesService {
    @Autowired
    MovesRepository movesRepository;
    @Autowired
    MovesEntity movesEntity;

    public List<MovesEntity> AllMoves( ){
        return (List<MovesEntity>) movesRepository.findAll();
    }
    public Optional<MovesEntity> getMovesById(Long id){
        return movesRepository.findById(id);
    }
    public MovesEntity  postMoves(MovesEntity movesEntity){
        return movesRepository.save(movesEntity);
    }


}
