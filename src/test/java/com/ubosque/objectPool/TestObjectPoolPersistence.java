package com.ubosque.objectPool;

import com.ubosque.objectPool.daos.DAOSqlImpl;
import org.postgresql.util.PSQLException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;


public class TestObjectPoolPersistence {



    @Test
    public void validateInsertIntoDatabaBase() throws Exception {
        String dato = "Dato";
        DAOSqlImpl daoSql = new DAOSqlImpl();
        try {
            daoSql.insertar(dato);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            daoSql.delete();
        }
    }

    @Test
    public void validateIntantesOfDb()  {
        String dato = "Dato";
        String dato2 = "Dato2";
        String dato3 = "Dato3";
        String dato4 = "Dato4";
        String dato5 = "Dato5";
        String dato6 = "Dato6";

        ArrayList<String> list = new ArrayList<String>(6);

        list.add(dato);
        list.add(dato2);
        list.add(dato3);
        list.add(dato4);
        list.add(dato5);
        list.add(dato6);

        for (String datos : list){
            DAOSqlImpl daoSql = new DAOSqlImpl();
            try {
                daoSql.insertar(dato);
            }catch (Exception e){
                System.out.println(e);
            }
            System.out.println(datos);

        }

    }
}
