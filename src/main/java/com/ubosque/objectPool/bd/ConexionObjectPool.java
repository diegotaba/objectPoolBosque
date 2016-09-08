package com.ubosque.objectPool.bd;

import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;


public class ConexionObjectPool {

    private ObjectPool<Conexion> pool;

    public ConexionObjectPool(ObjectPool<Conexion> pool) {
        this.pool = pool;
    }

}
