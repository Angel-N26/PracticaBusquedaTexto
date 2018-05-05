package practicabusquedatexto;

/**
 * @author Angel Loro, Angel Sánchez
 **/

import java.io.*;
import java.util.ArrayList;

public class lecturaFicheros {
    
    public String crearTexto(String archivo, int lineasTotales, ArrayList<Integer> lineasLeer) throws FileNotFoundException, IOException {
        String cadena;
        String texto = "";
        FileReader f = new FileReader(archivo);
        try (BufferedReader b = new BufferedReader(f)) {
            for (int i = 0; i < lineasTotales; i++) {
                if ((cadena = b.readLine()) != null) {
                    if (lineasLeer.contains(i)) {
                        texto += cadena;
                        texto += "\n";
                    }
                }
            }
        }
        return texto;
    }

    public Integer leerLineas(String archivo) throws FileNotFoundException, IOException {
        int lineas = 0;
        FileReader f = new FileReader(archivo);
        try (BufferedReader b = new BufferedReader(f)) {
            while (b.readLine() != null) {
                lineas++;
            }
        }
        return lineas;
    }

    public ArrayList lineasLeer(int numLineas, int lineasPorcentaje) { //Metodo para coger las lineas que vamos a leer
        ArrayList<Integer> lineasLeer = new ArrayList<>();
        int cont = 0;        
        while (cont < lineasPorcentaje) {
            int numero = (int) (Math.random() * numLineas);
            if (!lineasLeer.contains(numero)) {
                lineasLeer.add(numero);
                cont++;
            }
        }
        lineasLeer.sort((o1, o2) -> o1.compareTo(o2));
        return lineasLeer;
    }
    
    /*public String crearTextoAleatoria(String archivo, double porcentaje) throws FileNotFoundException, IOException {
        String cadena;
        String texto = "";
        RandomAccessFile f = new RandomAccessFile(archivo, "rw");
        int par = 2;
        int total = (int) (porcentaje * 2);
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
    }*/
}
