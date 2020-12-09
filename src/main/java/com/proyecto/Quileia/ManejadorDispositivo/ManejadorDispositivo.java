package com.proyecto.Quileia.ManejadorDispositivo;

import com.proyecto.Quileia.Service.ServiceDispositivo;
import com.proyecto.Quileia.models.Dispositivos;
import com.proyecto.Quileia.repositorio.RepositorioDispositivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorDispositivo {

    private final ServiceDispositivo serviceDispositivo;

    private final RepositorioDispositivo repositorioDispositivo;


    public ManejadorDispositivo(ServiceDispositivo serviceDispositivo, RepositorioDispositivo repositorioDispositivo) {
        this.serviceDispositivo = serviceDispositivo;
        this.repositorioDispositivo = repositorioDispositivo;
    }

    public void guadar(Dispositivos dispositivo) {
        serviceDispositivo.guardar(dispositivo);
    }

    public List<Dispositivos> listar() {
        return serviceDispositivo.listar();
    }
}
