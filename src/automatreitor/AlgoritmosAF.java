/**
 * Automatreitor "Fundamentos de la Ciencia de la Computación"
 * Profesora: Jacqueline Kohler
 * Universidad San Sebastian
 * @author Grupo de Trabajo: Oscar Bravo, Yasser Isa, Francisco Madrid y Jose Valenzuela.
 */

package automatreitor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Stack;

/**
 * Clase AlgoritmosAF
 * Contiene la logica de operaciones de Automatas.
 * 
 * @author Grupo de Trabajo: Oscar Bravo, Yasser Isa, Francisco Madrid y Jose Valenzuela.
 */
public class AlgoritmosAF {
    
    //Variables globales.
    AF afnd;
    AF afd; 
    
    
    /**
     * Constructor según AFND
     * Copia el AFND a el AF global 'afnd'.
     */
    public AlgoritmosAF(AF afnd) {
        this.afnd = new AF(afnd);
        this.afd = new AF("Resultado AFND -> AFD");
    }
    
    /**
     * Calcula el Hashset ordenado con el recorrido desde un estado siguiendo
     * transiciones vacías.
     * $ = transición vacía.
     * @return Hashset
     */
    public LinkedHashSet<String> transicionesVacias(HashSet<String> estado) {
        Stack<String> pila = new Stack<>();    //Instanciamos pila.
        LinkedHashSet<String> recorrido = new 
                LinkedHashSet<>();              //Instanciamos LinkedHashset
        pila.addAll(estado);                   //Se añade el estado a la pila
        recorrido.addAll(estado);
        
        //Mientras la pila no esté vacía, se continúa la busqueda.
        while (!pila.isEmpty()) {
            String estadoRecursivo = pila.pop();
            //Si contiene el simbolo vacío. Procesamos y añadimos al recorrido.
            if (this.afnd.obtenerEstructura().get(estadoRecursivo).containsKey("$")) {
                for (String transicion:this.afnd.obtenerEstructura().get(estadoRecursivo).get("$")) {
                    if (!recorrido.contains(transicion)) {
                        recorrido.add(transicion);
                        pila.push(transicion);
                    }
                }
            }
        }
        return recorrido;
    }

    /**
     * Recibe un String y crea el Hashset con dicho String
     * para ser procesado por el metodo equivalente.
     * @return Hashset
     */
    public LinkedHashSet<String> transicionesVacias(String estado) {
        LinkedHashSet<String> aux = new LinkedHashSet<>();
        aux.add(estado);
        return this.transicionesVacias(aux);
    }

    // the f****** 'move'
    public LinkedHashSet<String> transicionHacia(HashSet<String> S, String symbol) {
        LinkedHashSet<String> R = new LinkedHashSet<>();
        for (String s:S) {
            R.addAll(this.afnd.Transiciones(s, symbol));
        }
        return R;
    }

    public LinkedHashSet<String> transicionHacia(String S, String symbol) {
        LinkedHashSet<String> aux = new LinkedHashSet<>();
        aux.add(S);
        return this.transicionHacia(aux, symbol);
    }

    // returns a name for the union state:
    public String generaNombre(HashSet<String> S) {
        String r = "e";
        for (String s:S) {
            r += s.substring(1);
        }
        return r;
    }

    public AF obtenerAFD() {
        return this.afd;
    }

    /**
     * Convierte el AFND de la instancia a un AFD.
     */
    public void convertir() throws IOException {
        // Copiamos el alfabeto del AFND al AFD sin el simbolo vacío.
        this.afd.obtenerAlfabeto().addAll(this.afnd.obtenerAlfabeto());
        this.afd.obtenerAlfabeto().remove("$");
        
        // Instanciamos variables auxiliares
        ArrayList<HashSet<String>> estadosNoProcesados = new ArrayList<>();
        HashSet<String> estadoAFN = new HashSet<>();
        HashSet<String> estadoAFD = new HashSet<>();
        estadoAFN = this.transicionesVacias(this.afnd.obtenerEstadoInicial());
        estadosNoProcesados.add(estadoAFN);
        this.afd.agregarEstado(this.generaNombre(estadoAFN));
        this.afd.establecerEstadoInicial(this.generaNombre(estadoAFN));
        while (!estadosNoProcesados.isEmpty()) {
            estadoAFD = estadosNoProcesados.remove(0);
            for (String simbolo:this.afd.obtenerAlfabeto()) {
                estadoAFN = this.transicionesVacias(this.transicionHacia(estadoAFD, simbolo));
                if (!estadoAFN.isEmpty()) {
                    if (!this.afd.verificaEstado(this.generaNombre(estadoAFN))) {
                        estadosNoProcesados.add(estadoAFN);
                        this.afd.agregarEstado(this.generaNombre(estadoAFN), true);
                    }
                    this.afd.agregarTransicion(this.generaNombre(estadoAFD), 
                            this.generaNombre(estadoAFN), simbolo, true);
                    for(String estadofinal : this.afnd.obtenerEstadosFinales()){
                        if (estadoAFN.contains(estadofinal)) {
                            this.afd.nuevoEstadoFinal(this.generaNombre(estadoAFN));
                        }
                    }
                }
            }
        } // FIN DE WHILE
    }
}
