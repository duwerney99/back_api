package com.proyecto.Quileia.rest;


import com.proyecto.Quileia.ManejadorDispositivo.ManejadorDispositivo;
import com.proyecto.Quileia.models.Dispositivos;
import com.proyecto.Quileia.repositorio.RepositorioDispositivo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dispositivos")
public class RestDemoController {

    private final ManejadorDispositivo manejadorDispositivo;
    //private final ManejadorListarDispositivo manejadorListarDispositivo;

    private final RepositorioDispositivo repositorioDispositivo;


    public RestDemoController(ManejadorDispositivo manejadorDispositivo, RepositorioDispositivo repositorioDispositivo) {
        this.manejadorDispositivo = manejadorDispositivo;
        this.repositorioDispositivo = repositorioDispositivo;
    }

    @PostMapping
    public void guardarDispositivo(@RequestBody Dispositivos dispositivo) {
        manejadorDispositivo.guadar(dispositivo);
    }

    @GetMapping("/listar")
    public List<Dispositivos> listar(Model model) {
        List<Dispositivos>dispositivos = repositorioDispositivo.listar();
        model.addAttribute("dispositivos", dispositivos);
        return (dispositivos);
    }
}

