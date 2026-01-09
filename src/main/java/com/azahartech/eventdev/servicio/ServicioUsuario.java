package com.azahartech.eventdev.servicio;

import com.azahartech.eventdev.datos.RepositorioGenerico;
import com.azahartech.eventdev.modelo.Usuario;

import java.util.List;
import java.util.ArrayList;

public class ServicioUsuario {
//    private List<Usuario> listaUsuarios = new ArrayList<>();
    private RepositorioGenerico<Usuario> repositorio = new RepositorioGenerico<>();

    public void registrarUsuario(Usuario usuario){
//        this.listaUsuarios.add(usuario);
        this.repositorio.guardar(usuario);
    }

    public Usuario buscarUsuarioPorEmail(String email){
        for (Usuario usuario:repositorio.listar()){
            if(usuario.consultarEmail() == email){
                return usuario;
            }
        }
        return null;
    }

}
