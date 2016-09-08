package com.ubosque.objectPool.bd;


import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class ConexionFactory extends BasePooledObjectFactory<Conexion> {


    @Override
    public Conexion create() throws Exception {
        return new Conexion();
    }

    @Override
    public PooledObject<Conexion> wrap(Conexion conexion) {
        return new DefaultPooledObject<Conexion>(conexion);
    }


}