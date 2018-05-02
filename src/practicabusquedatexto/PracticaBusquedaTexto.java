package practicabusquedatexto;

import java.util.ArrayList;

/**
 * @author Angel Loro, Angel Sánchez
 *
 */
public class PracticaBusquedaTexto {
    
    //Metodo KarpRabin
    public ArrayList<Integer> KarpRabin(String patron, String texto) {
        ArrayList<Integer> ocurrencias = new ArrayList<Integer>();
        if (patron.length() > 0 && texto.length() >= patron.length()) {
            KarpRabin(patron, texto, ocurrencias);
        }
        return ocurrencias;
    }

    private void KarpRabin(String patron, String texto, ArrayList<Integer> ocurrencias) {
        int m = patron.length();
        for (int n = 0; n <= texto.length() - m; n++) {
            String aux = texto.substring(n, n + m);
            if (aux.hashCode() == patron.hashCode() && aux.equals(patron)) {
                ocurrencias.add(n);
            }
        }
    }
    
    //Metodo KnuthMorrisPrat
    public ArrayList<Integer> KnuthMorrisPrat(String patron, String texto) {
        ArrayList<Integer> ocurrencias = new ArrayList<Integer>();
        if (patron.length() > 0 && texto.length() >= patron.length()) {
            int[] fallo = new int[patron.length()];
            fallo = preproceso(patron);//matriz de fallos
            ocurrencias = KnuthMorrisPrat(patron, texto, fallo);
        }
        return ocurrencias;
    }

    private int[] preproceso(String patron) {
        int[] fallo = new int[patron.length()];
        int i = 2;
        int j = 0;
        fallo[0] = -1;
        if (patron.length() > 1) {
            fallo[1] = 0;
            while (i < patron.length()) {
                if (patron.charAt(i - 1) == patron.charAt(j)) {
                    j++;
                    fallo[i] = j;
                    i++;
                } else {
                    if (j > 0) {
                        j = fallo[j];
                    } else {
                        fallo[i] = 0;
                        i++;
                    }
                }
            }
        }
        return fallo;
    }

    
    private ArrayList<Integer> KnuthMorrisPrat(String patron, String texto, int[] fallo) {
        ArrayList<Integer> pos = new ArrayList<Integer>();
        int t = 0;
        int p = 0;
        while (texto.length() - t >= patron.length()) {
            if (p == patron.length()) {
                pos.add(t);
                p = 0;
                t++;
            } else {
                if (texto.charAt(t + p) == patron.charAt(p)) {
                    p++;
                } else {
                    t = t + p - fallo[p];
                    if (p > 0) {
                        p = fallo[p];
                    }
                }
            }
        }
        return pos;
    }
}
