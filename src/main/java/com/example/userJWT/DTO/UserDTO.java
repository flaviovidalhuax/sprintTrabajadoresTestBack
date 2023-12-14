package com.example.userJWT.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO  {
    private Long id;
    private String nombre;
    private  String apellido;
    private String correo;
    private Long num_empleado;
    private List<MovesDTO> movesByMonth;
}
