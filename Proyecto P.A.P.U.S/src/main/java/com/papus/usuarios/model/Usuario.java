package com.papus.usuarios.model;

import jakarta.persistence.*; //Para conectar con MySQL
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank; //Importacion de Extencion Validation
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email; //Importacion de Extencion Validation

@Entity // Marca esta clase como una entidad de base de datos
@Table(name = "usuarios") // El nombre de la tabla será "usuarios"
@Getter @Setter // Genera automáticamente getters y setters (Lombok)
@NoArgsConstructor // Genera un constructor vacío

public class Usuario {

    @Id // Marca este campo como la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;

    @Email(message = "El correo no es válido")
    @NotBlank(message = "El correo es obligatorio")
    private String correo;

    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    private String contrasena;

    @NotBlank(message = "El rol es obligatorio")
    private String rol;
    
}

