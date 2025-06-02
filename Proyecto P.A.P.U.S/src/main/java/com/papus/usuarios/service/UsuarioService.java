package com.papus.usuarios.service;

import com.papus.usuarios.model.Usuario;
import com.papus.usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import com.papus.usuarios.repository.UsuarioRepository;

@Service
@Transactional// Asegura que las operaciones se ejecuten en una transacción
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    //Guardar o actualizar
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    //Listar todos
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    //buscar por ID
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    //Eliminar por ID
    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Optional<Usuario> buscarPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    public List<Usuario> buscarPorRol(String rol) {
        return usuarioRepository.findByRol(rol);
    }

}
