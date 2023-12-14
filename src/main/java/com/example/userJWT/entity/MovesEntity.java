package com.example.userJWT.entity;

import com.example.userJWT.DataEnum.RoleEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Builder
@Entity
@Table(name="moves")
public class MovesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Role")
    @Enumerated(EnumType.STRING)
    private RoleEnum role;
    @Column(name = "Mes de trabajo")
    private int mes;
    @Column(name = "Cantidad de entregas")
    private int num_entregas;
    @Column(name = "Dias de trabajo por mes")
    private int diasTrabMes;
    @ManyToOne
    @JoinColumn(name = "id_user_entity")
    private UserEntity userEntity;
}
