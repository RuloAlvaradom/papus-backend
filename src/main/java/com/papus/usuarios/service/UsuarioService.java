package com.papus.usuarios.service;

import com.papus.usuarios.model.Usuario;
import com.papus.usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RestTemplate restTemplate;

    // Guardar o actualizar
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Listar todos
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    // Buscar por ID
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    // Eliminar por ID
    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

    // Buscar por correo
    public Optional<Usuario> buscarPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    // Buscar por rol
    public List<Usuario> buscarPorRol(String rol) {
        return usuarioRepository.findByRol(rol);
    }

    // Simular integración con el microservicio de proveedores
    public String obtenerNombreProveedor(Long idProveedor) {
        String url = "http://localhost:8081/api/v1/proveedores/" + idProveedor;

        try {
            // Usamos Map 
            ResponseEntity<Map> respuesta = restTemplate.getForEntity(url, Map.class);

            if (respuesta.getStatusCode().is2xxSuccessful()) {
                Map proveedor = respuesta.getBody();

                // Extraemos el valor del campo "nombre"
                if (proveedor.containsKey("nombre")) {
                    return proveedor.get("nombre").toString();
                } else {
                    return "Proveedor sin nombre";
                }
            } else {
                return "Proveedor no encontrado";
            }

        } catch (Exception e) {
            return "Error consultando proveedor: " + e.getMessage();
        }
        
    }
}

