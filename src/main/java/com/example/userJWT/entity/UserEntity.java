package com.example.userJWT.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Builder
@Entity
@Table(name="usuario")

public class UserEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "Nombre", nullable = false)
        private String name;
        @Column(name = "Apellido", nullable = false)
        private String lastName;
        @Column(name = "Email", nullable = false)
        private String email;
        @Column(name = "Numero de Empleado")
        private Long num_Empleado;

        @OneToMany(mappedBy = "userEntity")
        //@Builder.Default
        private List<MovesEntity> moveByMonth= new ArrayList<>();



}
