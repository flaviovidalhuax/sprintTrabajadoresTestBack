package com.example.userJWT.DTO;

import com.example.userJWT.DataEnum.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovesDTO {
    private Long id;
    private RoleEnum role;
    private int mes;
    private int numEntregas;
    private Long userId;

}
