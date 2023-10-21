package Evidencia2.ui;

import Evidencia2.process.Dijkstra;
import Evidencia2.utils.Elementos;
import Evidencia2.utils.Grafo;

import java.util.Scanner;

public class CLI {

    public static void Menu() {
        // Crear el grafo predefinido
        Grafo grafo = Elementos.crearGrafoPredefinido();

        // Mostrar opciones al usuario
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Selecciona una opción:");
            System.out.println("1. Mostrar vértices");
            System.out.println("2. Mostrar aristas");
            System.out.println("3. Encontrar ruta más corta (Dijkstra)");
            System.out.println("4. Encontrar ruta más corta (Prim)");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Elementos.mostrarVertices(grafo);
                    break;
                case 2:
                    Elementos.mostrarAristas(grafo);
                    break;
                case 3:
                    Grafo.Vertice nodoInicial = Elementos.obtenerVerticeInicioPredeterminado();
                    Grafo.Vertice nodoFinal = Elementos.obtenerVerticeDestinoPredeterminado();

                    Dijkstra dijkstra = new Dijkstra(grafo, nodoInicial);
                    dijkstra.encontrarRutasMasCortas();

                    System.out.println("Ruta más corta a " + nodoFinal.name() + " y distancia:");
                    System.out.println("Desde " + nodoInicial.name() + " a " + nodoFinal.name() + " - Distancia: " + dijkstra.distancias.get(nodoFinal));
                    break;
                case 4:

                    break;

                case 5:
                    System.out.println("¡Hasta luego!");

                    // Cerrar el escáner y finalizar la aplicación de manera ordenada
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (true);
    }
}
