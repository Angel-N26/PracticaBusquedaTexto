/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicabusquedatexto;

/**
 *
 * @author Angel
 */
import java.io.*;

public class lecturaFicheros {

    String crearTexto(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        String texto = "";
        FileReader f = new FileReader(archivo);
        try (BufferedReader b = new BufferedReader(f)) {
            while ((cadena = b.readLine()) != null) {
                texto += cadena;
                texto += "\n";
            }
        }
        return texto;
    }

    String crearTextoAleatoria(String archivo,double porcentaje) throws FileNotFoundException, IOException {
        String cadena;
        String texto = "";
        RandomAccessFile f = new RandomAccessFile(archivo, "rw");
        int par = 2;
        int total=(int) (porcentaje*2);
        for (int i = 0; i < total; i++) {
                if ((cadena = f.readLine()) != null) {
                    if (par % 2 == 0) {
                    texto += cadena;
                    texto += "\n";
                }
            }
            par++;
        }
        return texto;
    }
     Integer leerLineas(String archivo) throws FileNotFoundException, IOException {
        int lineas=0;
        FileReader f = new FileReader(archivo);
        try (BufferedReader b = new BufferedReader(f)) {
            while (b.readLine() != null) {
                    lineas++;
            }
        }
        return lineas;
    }

}
