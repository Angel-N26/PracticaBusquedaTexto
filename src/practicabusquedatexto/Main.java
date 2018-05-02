package practicabusquedatexto;

import java.io.IOException;
import utilidades.leer;

/**
 * @author Angel
 **/

public class Main {
    
    public static void main(String[] args) throws IOException {
        String archivo="quijote1.txt";
        lecturaFicheros f=new lecturaFicheros();
        String texto= f.crearTexto(archivo);
        leer.pln(texto);
       
    }
}
