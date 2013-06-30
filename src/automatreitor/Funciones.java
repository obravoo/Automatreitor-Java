/**
 * Automatreitor "Fundamentos de la Ciencia de la Computación"
 * Profesora: Jacqueline Kohler
 * Universidad San Sebastian
 * @author Grupo de Trabajo: Oscar Bravo, Yasser Isa, Francisco Madrid y Jose Valenzuela.
 */

package automatreitor;
import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * Clase Funciones
 * Contiene las funciones más generales del programa, tales 
 * como escribir en consola, leer y guardar archivos csv.
 * 
 * @author Grupo de Trabajo: Oscar Bravo, Yasser Isa, Francisco Madrid y Jose Valenzuela.
 */
public class Funciones {
    
    //Variables Globales Auxiliares
    List<String[]> data = new ArrayList<>();
    AF af;
    
    
    /**
     * Recibe un texto y lo despliega en pantalla según System.out.print
     * @param String
     */
    public void escribe(String texto){
        System.out.print(texto);
    }
    
    /**
     * Obtiene el Automata y lo guarda en un CSV según las convenciones
     * del programa.
     * @param AF Automata a guardar.
     * @param String Ruta del archivo a guardar.
     * @return boolean
     */
    public boolean guardarArchivo(AF afnd, String csv){
        CSVWriter writer;
        try {
            writer = new CSVWriter(new FileWriter(csv));
            data.add(new String[] {"ID",afnd.id,"",""});
            data.add(new String[] {"TIPO",afnd.tipo,"",""});
            for (String estado : afnd.estructura.keySet()){
                data.add(new String[] {"E",estado,"",""});
            }
            data.add(new String[] {"EI",afnd.estadoInicial, "",""});
            for ( String finala : afnd.estadosFinales){
                data.add(new String[] {"EF",finala, "",""});
            }
            for (String estadoInicio:afnd.estructura.keySet()) {
                for (String simbolo:afnd.estructura.get(estadoInicio).keySet()) {
                    for(String estadoDestino:afnd.estructura.get(estadoInicio).get(simbolo)){
                        data.add(new String[] {"TR",estadoInicio,estadoDestino, simbolo});
                    }
                }
            }
            writer.writeAll(data);
            writer.close();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
    
    /**
     * Obtiene la ruta del CSV a leer A través de las Librerias obtiene
     * el código y lo parsea según las convenciones del programa,
     * para cargarlos en un Automata.
     * @param String Ruta del archivo a leer.
     * @return AF Automata Finito.
     */
    public AF leerArchivo(String csv) throws IOException{
        CSVReader csvReader;
        try {
            csvReader = new CSVReader(new FileReader(csv));
            String[] row = null;
            while((row = csvReader.readNext()) != null) {
                switch(row[0]){
                    case "ID":
                        af = new AF(row[1]);
                        break;
                    case "TIPO":
                        af.tipo = row[1];
                        break;
                    case "E":
                        af.agregarEstado(row[1]);
                        break;
                    case "EI":
                        af.establecerEstadoInicial(row[1]);
                        break;
                    case "EF":
                        af.agregarEstadoFinal(row[1]);
                        break;
                    case "TR":
                        af.agregarTransicion(row[1], row[2], row[3]);
                        break;
                    default:
                        break;
                }
            }
            csvReader.close();
            return af;
        } catch (FileNotFoundException ex) {
            escribe("La ruta ingresada es incorrecta ("+csv+"). Ingrese una nuevamente: ");
            BufferedReader lectorConsola = new BufferedReader(new InputStreamReader(System.in));
            return leerArchivo(lectorConsola.readLine());
        }
    }
    
}
