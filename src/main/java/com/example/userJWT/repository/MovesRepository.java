package com.example.userJWT.repository;

import com.example.userJWT.entity.MovesEntity;
import com.example.userJWT.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface MovesRepository extends CrudRepository<MovesEntity, Long> {
}
