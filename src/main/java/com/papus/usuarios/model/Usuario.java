package com.papus.usuarios.model;

import jakarta.persistence.*; //Para conectar con MySQL
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // Marca esta clase como una entidad de base de datos
@Table(name = "usuarios") // El nombre de la tabla será "usuarios"
@Getter @Setter // Genera automáticamente getters y setters (Lombok)
@NoArgsConstructor // Genera un constructor vacío

public class Usuario {

    @Id // Marca este campo como la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) 
    private String nombre;

    @Column(nullable = false, unique = true) 
    private String correo;

    @Column(nullable = false) 
    private String contrasena;

    @Column(nullable = false) 
    private String rol;
}

