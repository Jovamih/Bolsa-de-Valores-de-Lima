/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package Modelo.DataAccessObject;
import java.sql.*;
/**
 * @author JOHAN
 * @version 2020
 * @since 1.2
 */
public class ConexionSQLServer {
    private static Connection conn=null;
    private static String server="DESKTOP-TQPEOLM";
    private static String database="";
    private static String usuario="";
    private static String password="";
    public static Connection getConnection() throws SQLException{
        if(conn==null){
            String conexionString=String.format("jdbc:sqlserver://%s; database=%s",server,database);
                conn=DriverManager.getConnection(conexionString,usuario,password); 
        }
        return conn;
    }
    public static void close() throws SQLException{
        if(conn!=null){
                conn.close();
        }
    }
}
