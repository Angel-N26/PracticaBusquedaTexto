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
    
    //Metodo ShiftOr
    public ArrayList<Integer> ShiftOr(String patron, String texto) {
        ArrayList<Integer> ocurrencias = new ArrayList<Integer>();
        if (patron.length() > 0 && texto.length() >= patron.length()) {
            String patronInvertido = invertir(patron);
            ArrayList<Character> alfabeto = new ArrayList<Character>();
            //guardada los caracteres para localizarlos en alfabetoPatron
            ArrayList<int[]> alfabetoPatron = new ArrayList<int[]>();//lista de bits de caracteres
            bitsPatron(patronInvertido, alfabeto, alfabetoPatron);//preproceso
            ocurrencias = ShiftOr(patron, texto, alfabeto, alfabetoPatron);
        }
        return ocurrencias;
    }

    public String invertir(String patron) {
        String inv = "";
        for (int n = patron.length() - 1; n >= 0; n--) {
            inv = inv + patron.charAt(n);
        }
        return inv;
    }

    private void bitsPatron(String inv, ArrayList<Character> alfabeto, ArrayList<int[]> alfabetoPatron) {
    //saca la lista de los bits de los caracteres. Preproceso
        for (int n = 0; n < inv.length(); n++) {
            if (!alfabeto.contains(inv.charAt(n))) {
                alfabeto.add(inv.charAt(n));
                int[] bits = new int[inv.length()];
                for (int p = 0; p < inv.length(); p++) {
                    if (inv.charAt(p) == inv.charAt(n)) {
                        bits[p] = 0;
                    } else {
                        bits[p] = 1;
                    }
                }
                alfabetoPatron.add(bits);
            }
        }
    }

    public ArrayList<Integer> ShiftOr(String patron, String texto, ArrayList<Character> alfabeto, ArrayList<int[]> alfabetoPatron) {
        ArrayList<Integer> ocurrencias = new ArrayList<Integer>();
        int[] estado = new int[patron.length()];
        for (int e = 0; e < estado.length; e++) {
            estado[e] = 1;
        }
        Boolean coincide = false;
        for (int n = 0; n < texto.length(); n++) {
            coincide = OR(texto.charAt(n), estado, coincide, alfabeto, alfabetoPatron);
            if (estado[0] == 0) {
                ocurrencias.add(n - patron.length() + 1);
            }
        }
        return ocurrencias;
    }

    private boolean OR(char c, int[] estado, Boolean coincide, ArrayList<Character> alfabeto, ArrayList<int[]> alfabetoPatron) {
        if (coincide) { //desplazamiento a la izqda y cero a la dcha
            for (int n = 0; n < estado.length - 1; n++) {
                estado[n] = estado[n + 1];
            }
        }
        estado[estado.length - 1] = 0;
        int[] aux = new int[estado.length];
        if (alfabeto.contains(c)) {
            aux = alfabetoPatron.get(alfabeto.indexOf(c));
            coincide = true;
        } else {
            for (int n = 0; n < aux.length; n++) {
                aux[n] = 1;
            }
            coincide = false;
        }
        for (int n = 0; n < aux.length; n++) {
            if (aux[n] == 0 && estado[n] == 0) {
                estado[n] = 0;
            } else {
                estado[n] = 1;
            }
        }
        return coincide;
    }
}
