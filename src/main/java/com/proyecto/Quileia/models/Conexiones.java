package com.proyecto.Quileia.models;

import javax.persistence.*;

@Entity (name = "conexiones")
public class Conexiones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "TIPO")
    private int tipo;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "TIPO_CIFRADO")
    private String tipo_cifrado;
    @Column(name = "USUARIO_CONEXION")
    private String usuario_conexion;
    @Column(name = "CONTRASEÑA_CONEXION")
    private String contraseña_conexion;

    @ManyToOne
    @JoinColumn(name=" CONEXION_ID")
    private Dispositivos dispositivos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo_cifrado() {
        return tipo_cifrado;
    }

    public void setTipo_cifrado(String tipo_cifrado) {
        this.tipo_cifrado = tipo_cifrado;
    }

    public String getUsuario_conexion() {
        return usuario_conexion;
    }

    public void setUsuario_conexion(String usuario_conexion) {
        this.usuario_conexion = usuario_conexion;
    }

    public String getContraseña_conexion() {
        return contraseña_conexion;
    }

    public void setContraseña_conexion(String contraseña_conexion) {
        this.contraseña_conexion = contraseña_conexion;
    }
}
