package com.proyecto.Quileia.repositorio_mysql;

import ch.qos.logback.classic.db.SQLBuilder;
import com.proyecto.Quileia.jdbc.CustomNamedParameterJdbcTemplate;
import com.proyecto.Quileia.models.Dispositivos;
import com.proyecto.Quileia.repositorio.RepositorioDispositivo;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.management.Query;
import java.util.List;

@Repository
public class RepositorioDispositivoRest implements RepositorioDispositivo {

    private static String SQL_GUARDAR = "insert into dispositivos(conexion_actual, conexion_red, ip, mac, tipo)\n" +
            "values (:conexion_actual, :conexion_red, :ip, :mac, :tipo);";

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    private static  String SQL_LISTAR = "Select * from dispositivos";


    public RepositorioDispositivoRest(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public void guardar(Dispositivos dispositivo) {
        MapSqlParameterSource parametros = new MapSqlParameterSource();
        parametros.addValue("mac", dispositivo.getMac());
        parametros.addValue("tipo", dispositivo.getTipo());
        parametros.addValue("conexion_red", dispositivo.isConexion_red());
        parametros.addValue("conexion_actual", dispositivo.getConexion_actual());
        parametros.addValue("ip", dispositivo.getIp());
        this.customNamedParameterJdbcTemplate.guardar(parametros, SQL_GUARDAR);
    }

    @Override
    public List<Dispositivos> listar() {
        return (List<Dispositivos>) new SQLBuilder();
    }
}
