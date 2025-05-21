
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Sergio Ruiz de León Almuedo
 * @version 1.0
 * @date 2025-04-12
 */

public class Ciudades {

  public static void main(String[] args) {

    // Creamos la colección para almacenar las ciudades
    Set<String> ciudades = new HashSet<>();

    // Creamos la clase scanner
    Scanner scanner = new Scanner(System.in);
    String entradaUsuario; // entrada de texto introducida por el usuario
    int opcion; // opción elegida por el usuario

    // Saludamos al usuario
    System.out.println("--- Bienvenido ---");

    // Iniciamos el bucle del programa
    while (true) {
      // Menú principal
      System.out.println("\n--- OPCIONES ---");
      System.out.println("Elige una opción, pon el número correspondiente y pulsa Enter.");
      System.out.println("1. Agregar una ciudad nueva.");
      System.out.println("2. Mostrar todas las ciudades.");
      System.out.println("3. Buscar una ciudad.");
      System.out.println("4. Eliminar una ciudad.");
      System.out.println("5. Salir del programa\n");

      // Guardamos la entrada del usuario
      entradaUsuario = scanner.nextLine();

      // comprobamos que la opción sea válida
      if(entradaUsuario.equals("1") || entradaUsuario.equals("2") || entradaUsuario.equals("3") || entradaUsuario.equals("4") || entradaUsuario.equals("5")) {
        // Guardamos la opción elegida del usuario
        opcion = Integer.parseInt(entradaUsuario);
      } else {
        // Opción elegida errónea
        System.out.println("\n------\nERROR: Opción no válida, vuelve a intentarlo.\n------\n");
        continue;
      }

      // Gestionamos los casos posibles de opciones
      switch (opcion) {
        case 1:
          while(true) {
            System.out.println("\n--------\nMESSAGE: Introduce el nombre de la ciudad o escribe \"Volver\" para volver al menú principal:\n--------\n");
            entradaUsuario = scanner.nextLine();
            if(entradaUsuario.equalsIgnoreCase("Volver")){
              break; // Volver al menú principal
            } else if(ciudades.add(entradaUsuario.toLowerCase())){ // Guardamos la ciudad en minúsculas
              System.out.println("\n--------\nSUCCESS: Ciudad añadida con éxito.\n--------\n");
            } else { // Error la ciudad ya estaba en la lista
              System.out.println("\n------\nERROR: la ciudad ya estaba añadida. Vuelve a intentarlo.\n------\n");
            }
          }
          break;

        case 2:
          if(ciudades.isEmpty()) { // Si el listado está vacío
            System.out.println("\n--------\nMESSAGE: Lista vacía, prueba a añadir una ciudad.\n--------\n");
          } else { // Si el listado tiene elementos
            System.out.println("\n------------------------\n| Ciudades en la lista |\n------------------------");

            // Creamos el iterador para recorrer el set
            Iterator<String> iteradorCiudades = ciudades.iterator();
            while (iteradorCiudades.hasNext()) { // Si existe un siguiente elemento
              // Guardamos la ciudad
              String ciudad = iteradorCiudades.next();
              // Creamos substring para colocar primera en mayúscula y resto minúsculas
              System.out.println("- "+ciudad.substring(0, 1).toUpperCase()+ciudad.substring(1, ciudad.length()));
            }
            System.out.println();

          }
          break;

        case 3:
          while (true) {
            System.out.println("--------\nMESSAGE: Introduce el nombre de la ciudad que quieres BUSCAR o escribe \"Volver\" para volver al menú principal:\n--------\n");
            entradaUsuario = scanner.nextLine();
            if(entradaUsuario.equalsIgnoreCase("Volver")){ // Volver al menú principal
              break;
            } else if(ciudades.contains(entradaUsuario.toLowerCase())) { // Si contiene el elemento mensaje de éxito
              System.out.println("\n--------\nSUCCESS: "+ entradaUsuario +" se encuentra en el listado.\n--------\n");
            } else { // Si no contiene el elemento mensaje de error
              System.out.println("\n------\nERROR: "+ entradaUsuario +" no se encuentra en el listado.\n------\n");
            }
          }
          break;

        case 4:
          while (true) {
            System.out.println("--------\nMESSAGE: Introduce el nombre de la ciudad que quieres BORRAR o escribe \"Volver\" para volver al menú principal:\n--------\n");
            entradaUsuario = scanner.nextLine();
            if(entradaUsuario.equalsIgnoreCase("Volver")){ // Volver al menú principal
              break;
            } else if(ciudades.contains(entradaUsuario.toLowerCase())) { // Si contiene el elemento, lo borramos y mensaje de éxito
              ciudades.remove(entradaUsuario.toLowerCase());
              System.out.println("\n--------\nSUCCESS: "+ entradaUsuario +" eliminada con éxito del listado.\n--------\n");
            } else { // Si no contiene el elemento mensaje de error
              System.out.println("\n------\nERROR: "+ entradaUsuario +" no se encuentra en el listado.\n------\n");
            }
          }
          break;

        case 5:
          scanner.close(); // Cerramos escaner
          return; // Cerramos el programa
      }
    }
  }
}
