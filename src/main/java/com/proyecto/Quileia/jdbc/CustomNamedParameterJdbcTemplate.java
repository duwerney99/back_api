package com.proyecto.Quileia.jdbc;

import com.proyecto.Quileia.models.Dispositivos;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomNamedParameterJdbcTemplate {

    private static final String ERROR_OBTENIENDO_EL_NOMBRE_Y_VALOR_DE_OBJETO = "Error obteniendo el nombre y valor del objeto";
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    public DayOfWeek getNamedParameterJdbcTemplate;

    public CustomNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void guardar(Object object, String sql) throws Exception {
        MapSqlParameterSource paramSource = crearParametros(object);
        this.namedParameterJdbcTemplate.update(sql, paramSource);
    }

    public void guardar(MapSqlParameterSource paramSource, String sql) {
        this.namedParameterJdbcTemplate.update(sql, paramSource);
    }

    public Long crearGenerado(Object object, String sql, String primaryKey) throws Exception {
        MapSqlParameterSource paramSource = crearParametros(object);
        return crearGenerado(paramSource, sql, primaryKey);
    }

    public Long crearGenerado(MapSqlParameterSource paramSource, String sql, String primaryKey) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.namedParameterJdbcTemplate.update(sql, paramSource, keyHolder, new String[]{primaryKey});
        return keyHolder.getKey().longValue();
    }

    public <T> Optional<T> consultarUnicoResultado(String sql, MapSqlParameterSource parametros, RowMapper<T> mapper) {
        try {
            T result = namedParameterJdbcTemplate.queryForObject(sql, parametros, mapper);
            return Optional.of(result);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    public <T> Optional<T> consultarUnicoResultadoSinMapeo(String sql, MapSqlParameterSource parametros, Class<T> tipo) {
        try {
            T result = namedParameterJdbcTemplate.queryForObject(sql, parametros, tipo);
            return Optional.of(result);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    private MapSqlParameterSource crearParametros(Object object) throws Exception {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        Field[] fields = object.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            try {
                Field field = fields[i];
                if (!Modifier.isStatic(field.getModifiers()) && !Modifier.isFinal(field.getModifiers())) {
                    field.setAccessible(true);
                    paramSource.addValue(field.getName(), field.get(object));
                    field.setAccessible(false);
                }
            } catch (IllegalAccessException e) {
                throw new Exception(ERROR_OBTENIENDO_EL_NOMBRE_Y_VALOR_DE_OBJETO, e);
            }
        }
        return paramSource;
    }

    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        return this.namedParameterJdbcTemplate;
    }
}
