package com.ubosque.objectPool.daos;

import com.ubosque.objectPool.bd.Conexion;
import com.ubosque.objectPool.bd.ConexionFactory;
import com.ubosque.objectPool.interfaces.SqlInterface;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Timer;

public class DAOSqlImpl implements SqlInterface {

    static ObjectPool<Conexion> pool = new GenericObjectPool<Conexion>(new ConexionFactory());
    static Conexion conexion;
    static Connection connection;

    public void insertar(String dato) throws Exception {

        try {

            this.conexion = pool.borrowObject();
            connection = this.conexion.getConnection();
            String sql = "INSERT INTO data(dato) VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,dato);
            ps.execute();
            connection.close();

        }catch (Exception e ){
            System.out.println("Error " + e);
        }finally {
           pool.returnObject(this.conexion);

        }

    }

    public void delete() throws Exception {

        try {
            conexion = pool.borrowObject();
            connection = this.conexion.getConnection();
            String sql = "DELETE from data";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.execute();
            connection.close();
        }catch (Exception e ){
            System.out.println("Error " + e);
        }finally {
            pool.returnObject(this.conexion);
        }

        }
}
