package com.proyecto.Quileia.Service;

import com.proyecto.Quileia.models.Dispositivos;
import com.proyecto.Quileia.repositorio.RepositorioDispositivo;

import java.util.List;

public class ServiceDispositivo {

    private final RepositorioDispositivo repositorioDispositivo;


    public ServiceDispositivo(RepositorioDispositivo repositorioDispositivo) {
        this.repositorioDispositivo = repositorioDispositivo;
    }

    public void guardar(Dispositivos dispositivo) {
        repositorioDispositivo.guardar(dispositivo);
    }

    public List<Dispositivos> listar() {
        return repositorioDispositivo.listar();
    }
}
