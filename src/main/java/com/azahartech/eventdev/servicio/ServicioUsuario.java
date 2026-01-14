package com.azahartech.eventdev.servicio;

import com.azahartech.eventdev.datos.RepositorioGenerico;
import com.azahartech.eventdev.modelo.Usuario;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class ServicioUsuario {
//    private List<Usuario> listaUsuarios = new ArrayList<>();
//    private RepositorioGenerico<Usuario> repositorio = new RepositorioGenerico<>();
    private Map<String, Usuario> mapaUsuario;

    public ServicioUsuario(){
        this.mapaUsuario = new HashMap<>();
    }

    public void registrarUsuario(Usuario usuario){
//        this.listaUsuarios.add(usuario);
//        this.repositorio.guardar(usuario);
        this.mapaUsuario.put(usuario.consultarEmail(), usuario);
    }

    public Usuario buscarUsuarioPorEmail(String email){
//        for (Usuario usuario:repositorio.listar()){
//            if(usuario.consultarEmail() == email){
//                return usuario;
//            }
//        }
//        return null;

        return this.mapaUsuario.get(email);
    }

//    public void imprimirNombreUsuariosVip(){
//        this.repositorio.listar().stream().filter(usuario -> usuario.esVip()).map(usuario -> usuario.consultarNombre()).forEach(nombre -> System.out.println(nombre));
//    }

}
