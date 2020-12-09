package com.proyecto.Quileia.configuracion;

import com.proyecto.Quileia.Service.ServiceDispositivo;
import com.proyecto.Quileia.repositorio.RepositorioDispositivo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServiceDispositivo serviceDispositivo(RepositorioDispositivo repositorioDispositivo) {
        return new ServiceDispositivo(repositorioDispositivo);
    }

    //TODO: Todo servicio nuevo tiene que estar agg aqui
}
