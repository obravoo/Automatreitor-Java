/**
 * Automatreitor "Fundamentos de la Ciencia de la Computación"
 * Profesora: Jacqueline Kohler
 * Universidad San Sebastian
 * @author Grupo de Trabajo: Oscar Bravo, Yasser Isa, Francisco Madrid y Jose Valenzuela.
 */

package automatreitor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/**
 * Clase AF
 * Contiene la estructura de un Automata.
 * 
 * @author Grupo de Trabajo: Oscar Bravo, Yasser Isa, Francisco Madrid y Jose Valenzuela.
 */
public class AF {
    protected String id;                    // Contiene el ID del Automata.
    protected String tipo;                  // Tipo de Automata
    protected LinkedHashSet
            <String> alfabeto;              // Contenedor del Alfabeto
    protected String estadoInicial;         // Estado Inicial
    protected LinkedHashSet
            <String> estadosFinales;        // Estados Finales
    protected LinkedHashMap<String, 
            LinkedHashMap<String, 
            LinkedHashSet
            <String>>> estructura;          // Arbol del Automata
    
    
    //Metodos generales de Interacción Común.
    Funciones funcion = new Funciones();
    BufferedReader lectorConsola = new BufferedReader(new InputStreamReader(System.in));    
        
    //Atributos asociados a funciones.
    private Integer estadosAgregados = 0;
    private String estadoInicioTemp;
    private String estadoFinalTemp;

    /**
     * Constructor según ID
     * Instancia nueva clase.
     */
    public AF(String id) {
        this.id = id;
        this.estructura = new LinkedHashMap<>();
        this.estadosFinales = new LinkedHashSet<>();
        this.alfabeto = new LinkedHashSet<>();
    }
    
    /**
     * Constructor según AF
     * Clona al receptor.
     */
    public AF(AF afnd) {
        this.estructura = new LinkedHashMap<>(afnd.estructura);
        this.estadosFinales = new LinkedHashSet<>(afnd.estadosFinales);
        this.estadoInicial = afnd.estadoInicial;
        this.alfabeto = afnd.alfabeto;
        this.id = afnd.id;
    }
    
    /**
     * Agrega el String estado recibido al grafo en su primer nivel.
     * Recibe booleano como bandera para permitir nombres largos.
     * @return boolean
     */
    public boolean agregarEstado(String estado, boolean bo) {
        if (this.estructura.containsKey(estado)) {
            return true;
        } else {
            this.estructura.put(estado, new LinkedHashMap<String, LinkedHashSet<String>>());
            return this.estructura.containsKey(estado);
        }
    }
    
    /**
     * Agrega el String Estado recibido al grafo en su primer nivel.
     * Limita el ingreso de los estados a 2 caracteres.
     * @return boolean
     */
    public boolean agregarEstado(String estado) {
        if (this.estructura.containsKey(estado)) {
            return true;
        } else {
            if(estado.length() > 2){
                estado = estado.substring(0, 2);
            }
            this.estructura.put(estado, new LinkedHashMap<String, LinkedHashSet<String>>());
            return this.estructura.containsKey(estado);
        }
    }
    
    /**
     * Recibe, valida y limpia las cadenas ingresadas por el usuario.
     * Separa las opciones por (,) y las envía a agregarEstado()
     * @return boolean
     */
    public boolean agregarEstados(String estadosDelUsuario){
        estadosDelUsuario = estadosDelUsuario.replaceAll("\\s","");
        String[] estadosTemp = estadosDelUsuario.split(",");
        for(String estado : estadosTemp){
            this.agregarEstado(estado);
        }
        return true;
    }
    
    public LinkedHashSet<String> Transiciones(String estadoOrigen, String simbolo) {
        if (this.estructura.containsKey(estadoOrigen) && this.estructura.get(estadoOrigen).containsKey(simbolo)) {
            return this.estructura.get(estadoOrigen).get(simbolo);
        } else {
            return new LinkedHashSet<>();
        }
    }
    
    public LinkedHashSet<String> obtenerAlfabeto() {
        return this.alfabeto;
    }
    
    public boolean verificaEstado(String state) {
        return this.estructura.containsKey(state);
    }  
    
    public boolean renombrarEstados(Integer valor) {
        boolean r = true;
        ArrayList<String> states = new ArrayList<>();
        states.addAll(this.estructura.keySet());

        Integer contador = 0;
        while (r == true && contador < states.size()) {
            r = this.renombrarEstado(states.get(contador), "q" + (contador + valor));
            contador++;
        }
        return r;
    }
    
    public boolean renombrarEstado(String nombreActual, String nombreNuevo) {
        while (this.estructura.containsKey(nombreNuevo)) {
            nombreNuevo += "'";
        }
        if (this.estructura.containsKey(nombreActual)) {
            this.estructura.put(nombreNuevo, this.estructura.get(nombreActual));
            this.estructura.remove(nombreActual);

            for (String s:this.estructura.keySet()) {
                for (String t:this.estructura.get(s).keySet()) {
                    if (this.estructura.get(s).get(t).contains(nombreActual)) {
                        LinkedHashSet <String> asD = new LinkedHashSet<>();
                        asD.add(nombreNuevo);
                        this.estructura.get(s).put(t, asD);
                        this.estructura.get(s).remove(nombreActual);
                    }
                }
            }
            if (this.estadoInicial.equals(nombreActual)) this.estadoInicial = nombreNuevo;
            if (this.estadosFinales.contains(nombreActual)) {
                this.estadosFinales.add(nombreNuevo);
                this.estadosFinales.remove(nombreActual);
            }
            return true;
        } else {
            return false;
        }
    }
    
    public boolean agregarEstadosFinales(String estadosFinales) throws IOException{
        estadosFinales = estadosFinales.replaceAll("\\s","");
        String[] estadosTemp = estadosFinales.split(",");
        for(String estado : estadosTemp){
            this.agregarEstadoFinal(estado);
        }
        return true;
    }
    
    public boolean agregarEstadoFinal(String estado) throws IOException {
        if(estado.isEmpty()){
            return false;
        }
        if (this.estructura.containsKey(estado)) {
            this.estadosFinales.add(estado);
            return true;
        } 
        else {
            funcion.escribe("El estado '"+estado+"' no existe en el automata. Ingrese uno nuevamente, o deje en blanco si no desea ingresar nada.");
            return (agregarEstadoFinal(lectorConsola.readLine()));
        }
    }
    
    public boolean nuevoEstadoFinal(String estado) {
        if (this.agregarEstado(estado)) {
            this.estadosFinales.add(estado);
            return true;
        } else {
            return false;
        }
    }
    
    public Integer numeroEstados() {
        return this.estructura.size();
    }
    
    
    public LinkedHashMap<String, LinkedHashMap<String, LinkedHashSet<String>>> obtenerEstructura() {
        return this.estructura;
    }

    
    

    public boolean agregarSimbolos(String simbolosUsuario){
        simbolosUsuario = simbolosUsuario.replaceAll("\\s","");
        String[] simbolosTemp = simbolosUsuario.split(",");
        for(String simbolo : simbolosTemp){
            this.alfabeto.add(simbolo);
        }
        return true;
    }
    
    protected boolean agregarSimbolo(String simbolo) {
        return this.alfabeto.add(simbolo);
    }
    
    public boolean agregarTransicion(String estadoOrigen, String estadoDestino, String simbolo, boolean bol) {
        if (this.estructura.containsKey(estadoOrigen) && this.estructura.containsKey(estadoDestino)) {
            if (this.estructura.get(estadoOrigen).containsKey(simbolo)) {
                return this.estructura.get(estadoOrigen).get(simbolo).add(estadoDestino);
            } else {
                this.estructura.get(estadoOrigen).put(simbolo, new LinkedHashSet<String>());
                this.agregarSimbolo(simbolo);
                return this.estructura.get(estadoOrigen).get(simbolo).add(estadoDestino);
            }
        }
        return false;
    }
    
    public boolean agregarTransicion(String estadoOrigen, String estadoDestino, String simbolo) throws IOException {
        if(estadoOrigen.isEmpty() && estadoDestino.isEmpty()){
            funcion.escribe("--- Transición omitida ---");
            return false;
        }
        if("\\s".equals(simbolo) || "".equals(simbolo)){
            simbolo = "$";
        }
        if(simbolo.length() > 1){
            simbolo = simbolo.replaceAll("\\s","");
            String[] simbolosTemp = simbolo.split(",");
            for(String Simbolo : simbolosTemp){
                if(Simbolo.length() > 1){
                    estadoInicioTemp = estadoOrigen;
                    estadoFinalTemp = estadoDestino;
                    for(int x= 0; x<Simbolo.length(); x++){
                        if(x == (Simbolo.length()-1)){
                            String s = String.valueOf(Simbolo.charAt(x));
                            this.agregarTransicion(estadoInicioTemp, estadoDestino, s);
                        }else{
                            estadoFinalTemp = "#"+this.estadosAgregados;
                            this.agregarEstado(estadoFinalTemp);
                            String s = String.valueOf(Simbolo.charAt(x));
                            this.agregarTransicion(estadoInicioTemp, estadoFinalTemp, s);
                            this.estadosAgregados++;
                            estadoInicioTemp = estadoFinalTemp;
                        }
                    }
                }else{
                    this.agregarTransicion(estadoOrigen, estadoDestino, Simbolo);
                }
            }
            return true;
        }
        if (this.estructura.containsKey(estadoOrigen) && this.estructura.containsKey(estadoDestino)) {
            if (this.estructura.get(estadoOrigen).containsKey(simbolo)) {
                return this.estructura.get(estadoOrigen).get(simbolo).add(estadoDestino);
            } else {
                this.agregarSimbolo(simbolo);
                this.estructura.get(estadoOrigen).put(simbolo, new LinkedHashSet<String>());
                return this.estructura.get(estadoOrigen).get(simbolo).add(estadoDestino);
            }
        }else{
            funcion.escribe("--- La transición contiene un estado no existente. ---");
            funcion.escribe("\n--- Los estados ingresados son: "+this.estructura.keySet().toString()+" ---");
            funcion.escribe("\n--- Ingrese la nueva transición o deje los elementos en blanco para continuar ---");
            funcion.escribe("\nEstado Inicial: ");
            estadoOrigen = lectorConsola.readLine();
            funcion.escribe("Estado Final : ");
            estadoDestino = lectorConsola.readLine();
            funcion.escribe("Simbolo del alfabeto : ");
            simbolo = lectorConsola.readLine();
            this.agregarTransicion(estadoOrigen, estadoDestino, simbolo);
        }
        return false;
    }

    public LinkedHashSet<String> obtenerEstadosFinales() {
        return this.estadosFinales;
    }
    
    public LinkedHashMap<String, LinkedHashMap<String, LinkedHashSet<String>>> obtenerEstados(){
        return this.estructura;
    }
    
    public void establecerEstadoInicial(String estado) throws IOException {
        if (this.estructura.containsKey(estado)) {
            this.estadoInicial = estado;
        } else {
            funcion.escribe("El estado ingresado no existe en el automata. Ingrese un nuevo estado inicial: ");
            this.establecerEstadoInicial(lectorConsola.readLine());
        }
    }
     
    public String obtenerEstadoInicial() {
        return this.estadoInicial;
    }
    
    public String reconocer(){
        this.tipo = "AFD";
        for (String estado:this.estructura.keySet()) {
            for (String simbolo: this.estructura.get(estado).keySet()) {
                if(this.estructura.get(estado).get(simbolo).size() > 1){
                    if(!this.tipo.equals("AFND-E")){
                        this.tipo = "AFND";
                    }
                }
                if(simbolo.isEmpty()){
                    this.tipo = "AFND-E";
                }
            }
        }
        return this.tipo;
    }
     
    @Override
    public String toString() {
        String aux = "Nombre: "+ this.id + "\n";
        aux += "Alfabeto: " + this.alfabeto.toString() + "\n";
        aux += "Tipo: " + this.tipo + "\n";
        aux += "Estados: " + this.estructura.keySet().toString() + "\n";
        aux += "Estado Inicial: " + this.obtenerEstadoInicial() + "\n";
        aux += "Estado Final(es): " + this.obtenerEstadosFinales() + "\n";
        for (String estado:this.estructura.keySet()) {
            aux += "Transición Estado " + estado + ":\n";
            for (String simbolo:this.estructura.get(estado).keySet()) {
                aux += "\t" + simbolo + " --> " + this.estructura.get(estado).get(simbolo).toString() + "\n";
            }
        }
        return aux;
    } 

}
