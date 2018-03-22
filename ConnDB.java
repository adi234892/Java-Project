package sanchay;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnDB {
    public static Connection conLink()throws Exception
    { 
        Class.forName("oracle.jdbc.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-A5VTGI5:1521:XE","sanchay","sanchay");
        return(con);
    }        
}
