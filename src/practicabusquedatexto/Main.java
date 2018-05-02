package practicabusquedatexto;

import java.io.IOException;
import java.util.ArrayList;
import utilidades.leer;

/**
 * @author Angel
 *
 */
public class Main {

    public static void main(String[] args) throws IOException{
        busqueda();
    }
    public static String creacionTexto() throws IOException{
        String archivo = "quijote1.txt";
        lecturaFicheros f = new lecturaFicheros();
        String texto = f.crearTexto(archivo);
        return texto;
    }
    public static void busqueda() throws IOException{
        String texto= creacionTexto();
        String patron = leer.cadena("Introduzca el patron a buscar:\n");
        Boolean seguir=true;
        PracticaBusquedaTexto p = new PracticaBusquedaTexto();
        ArrayList<Integer> ocurrencias = new ArrayList<Integer>();
        do{
        switch (leer.entero("Indica la opcion que desea realizar:\n\t1)Shift Or\n\t2)Karp Rabin\n\t3)Knuth Morris Prat\n\t4)Boyer Moore\n\t5)Cambiar patron\n\t6)Salir\n")) {
            case 1:
                ocurrencias=p.ShiftOr(patron, texto);
                leer.pln("Numero de ocurrencias: " + ocurrencias.size());
                leer.pln("Posiciones de las ocurrencias: "+ocurrencias);
                break;
            case 2:
                ocurrencias=p.KarpRabin(patron, texto);
                leer.pln("Numero de ocurrencias: " + ocurrencias.size());
                leer.pln("Posiciones de las ocurrencias: "+ocurrencias);
                break;
            case 3:
                ocurrencias=p.KnuthMorrisPrat(patron, texto);
                leer.pln("Numero de ocurrencias: " + ocurrencias.size());
                leer.pln("Posiciones de las ocurrencias: "+ocurrencias);
                break;
            case 4:
                ocurrencias=p.BoyerMoore(patron, texto);
                leer.pln("Numero de ocurrencias: " + ocurrencias.size());
                leer.pln("Posiciones de las ocurrencias: "+ocurrencias);
                break;
            case 5:
                patron = leer.cadena("Introduzca el patron a buscar:\n");
                break;
            case 6:
                seguir=false;
                break;
            default:
                leer.pln("Opcion invalida");
                break;
        }
        }while(seguir);
    }
}
