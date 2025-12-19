package com.azahartech.eventdev.servicio;

import com.azahartech.eventdev.modelo.Usuario;

import java.util.List;
import java.util.ArrayList;

public class ServicioUsuario {
    private List<Usuario> listaUsuarios = new ArrayList<>();

    public void registrarUsuario(Usuario usuario){
        listaUsuarios.add(usuario);
    }

    public Usuario buscarUsuarioPorEmail(String email){
        for (Usuario usuario:listaUsuarios){
            if(usuario.consultarEmail() == email){
                return usuario;
            }
        }
        return null;
    }

}
