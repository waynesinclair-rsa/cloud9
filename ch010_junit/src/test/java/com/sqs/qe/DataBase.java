package com.sqs.qe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBase {
    public Connection conn;
    String url = "jdbc:sqlite:c:/users/6219/chinook.db";
    // private String url = "jdbc:sqlite:sqlite3/chinook.db";
    // sqlite3/chinook.db
    private Statement stmt;

    public DataBase() throws Exception
    {

        /*
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            URL _url = classLoader.getResource("classpath:sqlite3/chinook.db");
            assertThat(_url, is(notNullValue()));
            System.out.println("File: " + _url.getFile());

         */
        conn = DriverManager.getConnection(url);
        stmt = conn.createStatement();

    }

    public ResultSet qry(String qryStr) throws Exception{
        return stmt.executeQuery(qryStr);
    }

    public ResultSet ins(String qryStr) throws Exception{
        return stmt.executeQuery(qryStr);
    }
/*
    private String resolveName(String name) {
        if (name == null) {
            return name;
        }
        if (!name.startsWith("/")) {
            Class c = this;
            while (c.isArray()) {
                c = c.getComponentType();
            }
            String baseName = c.getName();
            int index = baseName.lastIndexOf('.');
            if (index != -1) {
                name = baseName.substring(0, index).replace('.', '/') + "/" + name;
            }
        } else {
            name = name.substring(1);
        }
        return name;
    }
*/

}
