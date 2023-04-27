import lombok.Getter;
import lombok.Setter;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Getter
public class Principal {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://Localhost/Ronda", "root", "1977");
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select *from partidos");
        Scanner teclado = new Scanner(System.in);

        System.out.println("Resultados del la Primera Ronda: ");

        Ronda1 listaPartidos = new Ronda1();

        while (rs.next()) {
            int num = rs.getInt("numero");
            String loc = rs.getString("local");
            int golloc = rs.getInt("golesLoc");
            String visi = rs.getString("visitante");
            int golvisi = rs.getInt("golesVis");

            Partido nuevo = new Partido(num, loc, golloc, visi, golvisi);
            listaPartidos.agregarPartido(nuevo);
            System.out.println(nuevo);

        }


        rs.close();
        conn.close();

        Connection conne = DriverManager.getConnection("jdbc:mysql://Localhost/Apuesta", "root", "1977");
        Statement sta = conne.createStatement();
        ResultSet rse = sta.executeQuery("select *from pronostico");

       // System.out.println("Pronóstico del Apostador en la Primera Ronda");

        Apuesta1 listaApuesta = new Apuesta1();

        while (rse.next()) {
            int num = rse.getInt("numero");
            String loc = rse.getString("local");
            int golloc = rse.getInt("golesLoc");
            String visi = rse.getString("visitante");
            int golvisi = rse.getInt("golesVis");

            Partido nueApu = new Partido(num, loc, golloc, visi, golvisi);
            listaApuesta.agregarPronos(nueApu);
           // System.out.println(nueApu);
        }
        rse.close();
        conne.close();

        System.out.println();
        System.out.println("Pronóstico del Apostador en la Primera Ronda:");




        int nume;
        int puntosApos=0;
        for (Partido a: listaApuesta.getPronostico().values()){
          nume =a.getNumero();
           Partido finalizada = listaApuesta.resulApuesta(nume);
           Partido finalizado = listaPartidos.resulPartido(nume);
           System.out.println(finalizada);
            if (finalizado.getGolesLoc() == finalizada.getGolesLoc() && finalizado.getGolesVis()== finalizada.getGolesVis()){
            puntosApos++;
        }
        }


       System.out.println("PUNTAJE DEL APOSTADOR:    " + puntosApos);
    }

}





