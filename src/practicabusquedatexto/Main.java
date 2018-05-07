package practicabusquedatexto;

import java.io.IOException;
import java.util.ArrayList;
import utilidades.leer;

/**
 * @author Angel Loro, Angel Sánchez
 *
 */
public class Main {

    public static void main(String[] args) throws IOException, Exception {
        busqueda();
    }

    public static String creacionTexto() throws IOException {
        String archivo = "quijote1.txt", texto;
        int lineasDeseadas;
        lecturaFicheros f = new lecturaFicheros();

        //lineas = f.leerLineas(archivo);
        lineasDeseadas = leer.entero("Indique el porcentaje que desea leer:\n", 0, 100);
        //Dividimos el porcentaje entre 10 que son los ratios de lineas que haremos
        lineasDeseadas=lineasDeseadas/10;
        ArrayList<Integer> lineasLeer=f.lineasLeer(lineasDeseadas);
        texto = f.crearTexto(archivo,lineasLeer);
        return texto;
    }

    public static void busqueda() throws IOException {
        String texto = creacionTexto();
        leer.pln(texto);
        String patron = leer.cadena("Introduzca el patron a buscar:\n");
        Boolean seguir = true;
        PracticaBusquedaTexto p = new PracticaBusquedaTexto();
        ArrayList<Integer> ocurrencias;
        long time_start,tiempo_CPi;
        do {
            switch (leer.entero("Indica la opcion que desea realizar:\n\t1)Shift Or\n\t2)Karp Rabin\n\t3)Knuth Morris Prat\n\t4)Boyer Moore\n\t5)Naive\n\t6)Cambiar patron\n\t7)Salir\n")) {
                case 1:
                    time_start = System.nanoTime();
                    ocurrencias = p.ShiftOr(patron, texto);
                    tiempo_CPi = System.nanoTime() - time_start;
                    leer.pln("Numero de ocurrencias: " + ocurrencias.size());
                    leer.pln("Posiciones de las ocurrencias: " + ocurrencias);
                    leer.pln("Ha tardado " + tiempo_CPi + " nanosegundos");
                    break;
                case 2:
                    time_start = System.nanoTime();
                    ocurrencias = p.KarpRabin(patron, texto);
                    tiempo_CPi = System.nanoTime() - time_start;
                    leer.pln("Numero de ocurrencias: " + ocurrencias.size());
                    leer.pln("Posiciones de las ocurrencias: " + ocurrencias);
                    leer.pln("Ha tardado " + tiempo_CPi + " nanosegundos");
                    break;
                case 3:
                    time_start = System.nanoTime();
                    ocurrencias = p.KnuthMorrisPrat(patron, texto);
                    tiempo_CPi = System.nanoTime() - time_start;
                    leer.pln("Numero de ocurrencias: " + ocurrencias.size());
                    leer.pln("Posiciones de las ocurrencias: " + ocurrencias);
                    leer.pln("Ha tardado " + tiempo_CPi + " nanosegundos");
                    break;
                case 4:
                    time_start = System.nanoTime();
                    ocurrencias = p.BoyerMoore(patron, texto);
                    tiempo_CPi = System.nanoTime() - time_start;
                    leer.pln("Numero de ocurrencias: " + ocurrencias.size());
                    leer.pln("Posiciones de las ocurrencias: " + ocurrencias);
                    leer.pln("Ha tardado " + tiempo_CPi + " nanosegundos");
                    break;
                case 5:
                    time_start = System.nanoTime();
                    ocurrencias = p.Naive(patron, texto);
                    tiempo_CPi = System.nanoTime() - time_start;
                    leer.pln("Numero de ocurrencias: " + ocurrencias.size());
                    leer.pln("Posiciones de las ocurrencias: " + ocurrencias);
                    leer.pln("Ha tardado " + tiempo_CPi + " nanosegundos");
                    break;
                case 6:
                    patron = leer.cadena("Introduzca el patron a buscar:\n");
                    break;
                case 7:
                    seguir = false;
                    break;
                default:
                    leer.pln("Opcion invalida");
                    break;
            }
        } while (seguir);
    }
}
