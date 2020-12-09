package com.proyecto.Quileia.repositorio;

import com.proyecto.Quileia.models.Dispositivos;

import java.util.List;

public interface RepositorioDispositivo {

    void guardar(Dispositivos dispositivos);

    List<Dispositivos>listar();
}
