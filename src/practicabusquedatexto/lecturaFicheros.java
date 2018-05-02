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
      String texto="";
      FileReader f = new FileReader(archivo);
        try (BufferedReader b = new BufferedReader(f)) {
            while((cadena = b.readLine())!=null) {
                texto +=cadena;
                texto +="\n";
            } }
        return texto;
}
}
