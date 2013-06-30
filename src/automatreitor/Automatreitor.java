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

/**
 *
 * @author Oscar Bravo, Yasser Isa, Francisco Madrid y Jose Valenzuela.
 */
public class Automatreitor {
    private static String opcionUsuario;
    private static boolean flag = true;
    private static Integer numeroTransicion;
    private static AF afnd1 = null;
    private static AF afnd2 = null;
    private static AF afoperacion = null;
    private static String ruta = "/home/obravo/automata.csv";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader lectorConsola = new BufferedReader(new InputStreamReader(System.in));
        Funciones funcion = new Funciones();
        funcion.escribe("Bienvendio a Automatreitor.\n");
        funcion.escribe("Menu:\n");
        funcion.escribe("1. Ingresar 1er Automáta.\n");
        funcion.escribe("2. Ingresar 2do Automáta.\n");
        funcion.escribe("3. Ver Automatas Ingresados.\n");
        funcion.escribe("4. Guardar Automata a Archivo.\n");
        funcion.escribe("5. Cargar Automata desde Archivo.\n");
        funcion.escribe("6. Convertir AFND a AFD");
        funcion.escribe("E. Salir.\n");
        funcion.escribe("__________________________\n");
        while(flag == true){
            funcion.escribe("* Ingrese su opción según el menú: ");
            opcionUsuario = lectorConsola.readLine();
            switch(opcionUsuario){
                case "1": 
                    funcion.escribe("--- INGRESO DEL AUTOMATA N° 1 ---\n");
                    funcion.escribe("* Ingrese un nombre para su automata (Ej: 1 ó Primero) : ");
                    afnd1 = new AF(lectorConsola.readLine());
                    funcion.escribe("--- A continuación debe ingresar los estados de su automata, separado por comas (,). ---");
                    funcion.escribe("\n--- OJO que los nombres de estados se reducirán a 2 caracteres ---");
                    funcion.escribe("\n* Ingrese los estados a continuación: ");
                    afnd1.agregarEstados(lectorConsola.readLine());
                    funcion.escribe("--- Se agregaron los estados: "+afnd1.obtenerEstados().keySet().toString()+" ---");
                    funcion.escribe("\n* Ingrese el Estado Inicial : ");
                    afnd1.establecerEstadoInicial(lectorConsola.readLine());
                    funcion.escribe("--- Se agrego el estado inicial: "+afnd1.obtenerEstadoInicial() +" ---");
                    funcion.escribe("\n* Ingrese los estados finales separados por coma (,) : ");
                    afnd1.agregarEstadosFinales(lectorConsola.readLine());
                    funcion.escribe("--- Estados finales: "+afnd1.obtenerEstadosFinales().toString()+" ---");
                    funcion.escribe("\n*¿Cuantas Transiciones desea Ingresar? : ");
                    numeroTransicion = Integer.parseInt(lectorConsola.readLine()) + 1;
                    funcion.escribe("--- Los simbolos del alfabeto son de 1 caracter ---");
                    funcion.escribe("\n--- Puede ingresar concatenaciones de la siguiente manera (aa ó abc) ---");
                    funcion.escribe("\n--- O bien ingresar 2 o mas transiciones (a,b ó a,b,c) ---");
                    for (int i = 1; i < numeroTransicion; i++) {
                        funcion.escribe("***Ingresando la transición n°"+i+" ");
                        funcion.escribe("\nEstado Inicial: ");
                        String estadoInicial = lectorConsola.readLine();
                        funcion.escribe("Estado Final : ");
                        String estadoFinal = lectorConsola.readLine();
                        funcion.escribe("Simbolo del alfabeto : ");
                        String simbolo = lectorConsola.readLine();
                        afnd1.agregarTransicion(estadoInicial, estadoFinal, simbolo);
                    }
                    afnd1.reconocer();
                    funcion.escribe("\n--- El automata ingresado es un:"+afnd1.tipo+" ---");
                    funcion.escribe("\n--- Se ha ingresado correctamente el Automata ---\n");
                    break;
                case "2": 
                    funcion.escribe("--- INGRESO DEL AUTOMATA N° 2 ---\n");
                    funcion.escribe("Ingrese un nombre para su automata (Ej: 1 ó Primero) : ");
                    afnd2 = new AF(lectorConsola.readLine());
                    funcion.escribe("--- A continuación debe ingresar los estados de su automata, separado por comas (,). ---");
                    funcion.escribe("\n--- OJO que los nombres de estados se reducirán a 2  caracteres ---");
                    funcion.escribe("\n* Ingrese los estados a continuación: ");
                    afnd2.agregarEstados(lectorConsola.readLine());
                    funcion.escribe("--- Se agregaron los estados: "+afnd2.obtenerEstados().keySet().toString()+" ---");
                    funcion.escribe("\n* Ingrese el Estado Inicial : ");
                    afnd2.establecerEstadoInicial(lectorConsola.readLine());
                    funcion.escribe("--- Se agrego el estado inicial: "+afnd2.obtenerEstadoInicial() +" ---");
                    funcion.escribe("\n*Ingrese los estados finales separados por coma (,) : ");
                    afnd1.agregarEstadosFinales(lectorConsola.readLine());
                    funcion.escribe("--- Estados finales: "+afnd2.obtenerEstadosFinales().toString()+" ---");
                    funcion.escribe("\n*¿Cuantas Transiciones desea Ingresar? : ");
                    numeroTransicion = Integer.parseInt(lectorConsola.readLine()) + 1;
                    for (int i = 1; i < numeroTransicion; i++) {
                        funcion.escribe("\n***Ingresando la transición n°"+i+" ");
                        funcion.escribe("\nEstado Inicial: ");
                        String estadoInicial = lectorConsola.readLine();
                        funcion.escribe("Estado Final : ");
                        String estadoFinal = lectorConsola.readLine();
                        funcion.escribe("Simbolo del alfabeto : ");
                        String simbolo = lectorConsola.readLine();
                        afnd2.agregarTransicion(estadoInicial, estadoFinal, simbolo);
                    }
                    afnd2.reconocer();
                    funcion.escribe("\n--- El automata ingresado es un: "+afnd2.tipo+" ---");
                    funcion.escribe("\n--- Se ha ingresado correctamente el Automata ---\n");
                    break;
                case "3":
                    if(afnd1 != null){
                        funcion.escribe("-------------");
                        System.out.print(afnd1);
                        funcion.escribe("________\n");
                    }else{
                        funcion.escribe("--- No se a ingresado el Automata 1 ---\n");
                    }
                    if(afnd2 != null){
                        System.out.print(afnd2);
                        funcion.escribe("________\n");
                    }else{
                        funcion.escribe("--- No se a ingresado el Automata 2 ---\n");
                    }
                    break;
                case "4":
                    if(afnd1 != null || afnd2 != null){
                        funcion.escribe("\n¿Cual Automata desea guardar?");
                        if(afnd1 != null){
                            funcion.escribe("\n1.- "+afnd1.id);
                        }
                        if(afnd2 != null){
                            funcion.escribe("\n2. "+afnd2.id);
                        }
                        funcion.escribe("\nIngrese el número de su opción: " );
                        String opcion = lectorConsola.readLine();
                        Integer opcionTemp = (Integer.parseInt(opcion) == 1 || Integer.parseInt(opcion) == 2 ) ? Integer.parseInt(opcion) : 0;
                        if(opcionTemp == 0){
                            funcion.escribe("Número incorrecto, ingrese nuevamente: " );
                            opcion = lectorConsola.readLine();
                        }
                        opcionTemp = Integer.parseInt(opcion);
                        AF afndTemp = (opcionTemp == 1) ? afnd1 : afnd2 ;
                        funcion.escribe("Ingrese la ruta del archivo a guardar: " );
                        ruta = lectorConsola.readLine();
                        if(funcion.guardarArchivo(afndTemp, ruta)){
                            funcion.escribe("Archivo creado exitosamente (Ruta:'"+ruta+"').\n");
                        }else{
                            funcion.escribe("Error al guardar. Compruebe la ruta." );
                        }
                    }else{
                        funcion.escribe("--- Antes de guardar, debe ingresar los automatas a través de la opción 1. ---\n");
                    }
                    break;
                case "5":
                    funcion.escribe("\n¿A que automata desea cargar?");
                    funcion.escribe("\n1.- Automata n° 1.");
                    funcion.escribe("\n2.- Automata n° 2.");
                    funcion.escribe("\n*Ingrese su opcion: ");
                    String opcion = lectorConsola.readLine();
                    Integer opcionTemp = Integer.parseInt(opcion);
                    funcion.escribe("Escribe la ruta del archivo a cargar: " );
                    ruta = lectorConsola.readLine();
                    AF afnd = funcion.leerArchivo(ruta);
                    if(opcionTemp == 1){
                        afnd1 = afnd;
                    }else{
                        afnd2 = afnd;
                    }
                    funcion.escribe("--- El automata fue cargado exitosamente. Verifiquelo en la opción 3 del menu. ---\n");
                    break;
                case "6":
                    if( (afnd1 != null || afnd2 != null) && (!"AFD".equals(afnd1.tipo) || !"AFD".equals(afnd2.tipo)) ){
                        funcion.escribe("\n--- A continuación se presentan los Automatas cargados");
                        if(afnd1 != null){
                            funcion.escribe("\n1.- "+afnd1.id+" ("+afnd1.tipo+")");
                        }
                        if(afnd2 != null){
                            funcion.escribe("\n2.- "+afnd2.id+" ("+afnd2.tipo+")");
                        }
                        funcion.escribe("\n* Ingresa tu opción.");
                        opcion = lectorConsola.readLine();
                        afoperacion = ("1".equals(opcion)) ? afnd1 : afnd2;
                        if("AFD".equals(afoperacion.tipo)){
                            funcion.escribe("--- El automata ingresado no es AFND, Escoga otra opción ---");
                            funcion.escribe("\n* Ingresa tu opción.");
                            opcion = lectorConsola.readLine();
                            afoperacion = ("1".equals(opcion)) ? afnd1 : afnd2;
                        }
                        AlgoritmosAF AFD = new AlgoritmosAF(afoperacion);
                        AFD.convertir();
                        afoperacion = AFD.obtenerAFD();
                        afoperacion.renombrarEstados(0);
                        afoperacion.reconocer();
                        funcion.escribe("--- SE HA CONVERTIDO EXITOSAMENTE EL AUTOMATA. ---");
                        funcion.escribe("¿A que automata desea copiarlo? (1 ó 2) : ");
                        opcion = lectorConsola.readLine();
                        if("1".equals(opcion)){
                            afnd1 = afoperacion;
                        }else{
                            afnd2 = afoperacion;
                        }
                        funcion.escribe("--- EL RESULTADO SE HA COPIADO AL AUTOMATA N° "+opcion+" Y SE PRESENTA A CONTINUACIÓN. ---\n");
                        System.out.println(afoperacion);
                    }else{
                        funcion.escribe("--- No existe un AFND o AFND-E cargado actualmente ---\n");
                    }
                    break;
                case "E":
                    funcion.escribe("Muchas Gracias por ocupar Automatreitor");
                    flag = false;
                    break;
            }
        }
    }
}
