package com.shinn.dao.idao;

import com.shinn.mapper.RowMapper;

import java.util.List;

public interface GenericDAO<T> {
    <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);
    <T> Long insert(String sql, Object... paramters);
    <T> void update(String sql, Object... paramters);
    <T> Integer count(String sql, Object... parameters);
}
