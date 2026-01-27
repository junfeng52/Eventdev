package com.azahartech.eventdev.servicio;

import com.azahartech.eventdev.datos.RepositorioGenerico;
import com.azahartech.eventdev.modelo.Usuario;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
public class ServicioUsuario {
//    private List<Usuario> listaUsuarios = new ArrayList<>();
//    private RepositorioGenerico<Usuario> repositorio = new RepositorioGenerico<>();
    private HashMap<String, Usuario> mapaUsuario;

    public ServicioUsuario(){
        this.mapaUsuario = new HashMap<>();
    }

    public void registrarUsuario(Usuario usuario){
//        this.listaUsuarios.add(usuario);
//        this.repositorio.guardar(usuario);
        if (this.mapaUsuario.containsKey(usuario.consultarEmail())){
            System.out.println("Fallo en el registro de usuario.");
        }else {
            this.mapaUsuario.put(usuario.consultarEmail(), usuario);
        }
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

    public Usuario buscarUsuarioPorNombre(String nombre){
        return this.mapaUsuario.values().stream().filter(usuario -> nombre.equals(usuario.consultarNombre())).findFirst().orElse(null);
    }

//    public void imprimirNombreUsuariosVip(){
//        this.repositorio.listar().stream().filter(usuario -> usuario.esVip()).map(usuario -> usuario.consultarNombre()).forEach(nombre -> System.out.println(nombre));
//    }

}
