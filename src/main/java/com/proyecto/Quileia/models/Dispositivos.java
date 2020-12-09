package com.proyecto.Quileia.models;

import javax.persistence.*;
import java.util.List;

@Entity (name = "dispositivos")
public class Dispositivos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DISPOSITIVO_ID")
    private int dipositivo_id;
    @Column(name = "MAC")
    private String mac;
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "CONEXION_RED")
    private boolean conexion_red;
    @Column(name = "CONEXION_ACTUAL")
    private int conexion_actual;
    @Column(name = "IP")
    private String ip;

    public Dispositivos() {
        //Vacio por conveniencia
    }

    public Dispositivos(int dipositivo_id, String mac, String tipo, boolean conexion_red, int conexion_actual, String ip) {
        super();
        this.dipositivo_id = dipositivo_id;
        this.mac = mac;
        this.tipo = tipo;
        this.conexion_red = conexion_red;
        this.conexion_actual = conexion_actual;
        this.ip = ip;
    }


    public int getDipositivo_id() {
        return dipositivo_id;
    }

    public void setDipositivo_id(int dipositivo_id) {
        this.dipositivo_id = dipositivo_id;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isConexion_red() {
        return conexion_red;
    }

    public void setConexion_red(boolean conexion_red) {
        this.conexion_red = conexion_red;
    }

    public int getConexion_actual() {
        return conexion_actual;
    }

    public void setConexion_actual(int conexion_actual) {
        this.conexion_actual = conexion_actual;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}