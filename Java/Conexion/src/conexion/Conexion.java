/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author PC-4
 */
public class Conexion {

    Connection con;

    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteles", "root", "");
        } catch (Exception e) {
            System.err.println("Error:" + e);
        }
    }

    public static void main(String[] args) {
        long Inicial = 0, Final = 0, Promedio = 0;
        long[] Tiempo = new long[100];
        for (int i = 0; i < 100; i++) {
            Inicial = 0;
            Conexion cn = new Conexion();
            Inicial = System.currentTimeMillis();
            Statement st;
            ResultSet rs;
            try {
                st = cn.con.createStatement();
                rs = st.executeQuery("select * from hotel_tourism");
                while (rs.next()) {
                    System.out.println(rs.getString("HOTELNAME")
                            + " " + rs.getString("ADDRESS")
                            + " " + rs.getString("STATE")
                            + " " + rs.getString("PHONE")
                            + " " + rs.getString("FAX")
                            + " " + rs.getString("EMAILID")
                            + " " + rs.getString("WEBSITE")
                            + " " + rs.getString("TYPE")
                            + " " + rs.getInt("ROOMS")
                            + " " + rs.getInt("HOTELID"));
                }
                cn.con.close();
            } catch (Exception e) {
            }
            Final = System.currentTimeMillis();
            System.out.println(Inicial + " ..." + Final);
            Tiempo[i] = Final - Inicial;
            Promedio = Promedio + Tiempo[i];
            System.out.println("El tiempo de ejecucion es: " + Tiempo[i]);
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(Tiempo[i]);
        }
        Promedio = Promedio / 100;
        System.out.println("El promedio de tiempo de ejecucion es:" + Promedio);

    }

}
