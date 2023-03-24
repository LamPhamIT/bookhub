package com.shinn.dao.impl;

import com.shinn.dao.idao.GenericDAO;
import com.shinn.mapper.RowMapper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbstractDAO<T> implements GenericDAO<T> {
    @Override
    public <T1> List<T1> query(String sql, RowMapper<T1> rowMapper, Object... parameters) {
        List<T1> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            setParameters(statement, parameters);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                list.add(rowMapper.mapRow(resultSet));
            }
            return list;
        } catch (SQLException e) {
            return null;
        } finally {
            try {
                if(connection != null) {
                    connection.close();
                }
                if(statement != null) {
                    statement.close();
                }
                if(resultSet != null) {
                    resultSet.close();
                }
            } catch (Exception e) {
                return null;
            }
        }
    }

    @Override
    public <T1> Long insert(String sql, Object... paramters) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement =  connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            setParameters(statement, paramters);
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            Long id = null;
            while(resultSet.next()) {
                id =  resultSet.getLong(1);
                return id;
            }
            connection.commit();
            return null;
        } catch (SQLException e) {
            if(connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    return null;
                }
            }
            return null;
        } finally {
            try {
                if(connection != null) {
                    connection.close();
                }
                if(statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
                return null;
            }
        }
    }


    @Override
    public <T1> void update(String sql, Object... paramters) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            setParameters(statement, paramters);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/JSP_Servlet";
            String user = "root";
            String password = "lamdz2k4";
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }

    public void setParameters(PreparedStatement statement, Object... paramters) {
        try {
            for(int i = 1; i <= paramters.length; i++) {
                Object parameter = paramters[i - 1];
                if(parameter instanceof Long) {
                    statement.setLong(i, (Long) parameter);
                } else if(parameter instanceof String) {
                    statement.setString(i, (String) parameter);
                } else if(parameter instanceof Double) {
                    statement.setDouble(i, (Double) parameter);
                } else if(parameter instanceof Timestamp) {
                    statement.setTimestamp(i, (Timestamp) parameter);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
