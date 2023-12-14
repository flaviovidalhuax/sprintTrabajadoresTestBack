package com.example.userJWT.service;

import com.example.userJWT.entity.MovesEntity;
import com.example.userJWT.entity.UserEntity;
import com.example.userJWT.repository.MovesRepository;
import com.example.userJWT.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    MovesRepository movesRepository;
    @Autowired
    UserEntity userEntity;
    public List<UserEntity> AllUser(){
        return (List<UserEntity>) userRepository.findAll();
    }
    public UserEntity  postUser(UserEntity userEntity){
        return userRepository.save(userEntity);
    }
//    public UserEntity  postUserDTO(UserDTO userDTO){
//        UserEntity userData=UserEntity.builder()
//                .name(userDTO.getNombre())
//                .lastName(userDTO.getApellido())
//                .email(userDTO.getCorreo())
//                .num_Empleado(userDTO.getNum_empleado())
//                .build();
//
//
//        return userRepository.save(userData);
//    }
    public Optional<UserEntity> getUserById(Long id){
        return userRepository.findById(id);
    }
    public Optional<Map> getMovimientos(Long id){
        Optional<UserEntity> datoUser=userRepository.findById(id);
        Optional<MovesEntity> datoMoves=movesRepository.findById(datoUser.get().getId());
        Integer pagoHora=30;
        Integer horaDia=8;
        Integer CHOFERESextra=10;
        Integer AUXILIARESextra=0;
        Integer CARGADORESextra=5;
        Map<String,Object> datoTrabajoresGeneral=new HashMap<>();
        datoTrabajoresGeneral.put("pagoHora", pagoHora);
        datoTrabajoresGeneral.put("horaDia", horaDia);
        datoTrabajoresGeneral.put("CHOFERES", CHOFERESextra);
        datoTrabajoresGeneral.put("AUXILIARES", AUXILIARESextra);
        datoTrabajoresGeneral.put("CARGADORES", CARGADORESextra);
        datoTrabajoresGeneral.put("ROLE",  datoMoves.map(e-> e.getRole()));
        datoTrabajoresGeneral.put("nomina",datoMoves.map(e->e.getDiasTrabMes()* (horaDia*pagoHora))  );
        datoTrabajoresGeneral.put("rol",datoMoves.stream().filter(e->"AUXILARES".equals(e.getRole())));


        //datos generales de nomina
        Map<String,Object> datoNomina=new HashMap<>();
        datoNomina.put("numEmpleado", datoUser.map(e->e.getNum_Empleado()));
        datoNomina.put("name", datoUser.map(e->e.getName()));
        datoNomina.put("lastName", datoUser.map(e->e.getLastName()));
        datoNomina.put("role", datoMoves.map(e-> e.getRole()));
        datoNomina.put("mes", datoMoves.map(e->e.getMes()));
        datoNomina.put("entregasDeMes", datoMoves.map(e-> e.getNum_entregas()));
        datoNomina.put("NominaMensual", datoTrabajoresGeneral.get("nomina") );
        datoNomina.put("NominaRol", datoTrabajoresGeneral.get("nomina_chofer"));

        return Optional.of(datoNomina);
    }

    public void deletedByUser(Long id) {
        userRepository.deleteById(id);
    }
}
