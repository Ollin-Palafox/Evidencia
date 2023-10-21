package Evidencia2.utils;

public class Elementos {

    private static Grafo.Vertice verticeInicioPredeterminado;
    private static Grafo.Vertice verticeDestinoPredeterminado;

    public static Grafo crearGrafoPredefinido() {
        Grafo grafo = new Grafo();

        // Agregar vértices
        Grafo.Vertice A = new Grafo.Vertice("A");
        Grafo.Vertice B = new Grafo.Vertice("B");
        Grafo.Vertice C = new Grafo.Vertice("C");
        Grafo.Vertice D = new Grafo.Vertice("D");
        Grafo.Vertice E = new Grafo.Vertice("E");
        Grafo.Vertice F = new Grafo.Vertice("F");

        grafo.agregarVertice(A);
        grafo.agregarVertice(B);
        grafo.agregarVertice(C);
        grafo.agregarVertice(D);
        grafo.agregarVertice(E);
        grafo.agregarVertice(F);

        // Agregar aristas
        grafo.agregarArista(A, B, 4.0);
        grafo.agregarArista(A, C, 2.0);
        grafo.agregarArista(B, C, 5.0);
        grafo.agregarArista(B, D, 10.0);
        grafo.agregarArista(B, F, 9.0);
        grafo.agregarArista(C, D, 3.0);
        grafo.agregarArista(D, E, 7.0);
        grafo.agregarArista(F, E, 1.0);

        // Establecer el nodo de inicio y destino predeterminado
        verticeInicioPredeterminado = A;
        verticeDestinoPredeterminado = E;

        return grafo;
    }

    public static Grafo.Vertice obtenerVerticeInicioPredeterminado() {
        return verticeInicioPredeterminado;
    }

    public static Grafo.Vertice obtenerVerticeDestinoPredeterminado() {
        return verticeDestinoPredeterminado;
    }


    public static void mostrarVertices(Grafo grafo) {
        System.out.println("Vértices del grafo:");
        for (Grafo.Vertice vertice : grafo.vertices.keySet()) {
            System.out.println(vertice.name());
        }
    }

    public static void mostrarAristas(Grafo grafo) {
        System.out.println("Aristas del grafo:");
        for (Grafo.Vertice vertice : grafo.vertices.keySet()) {
            for (Grafo.Arista arista : grafo.vertices.get(vertice)) {
                System.out.println("Vértice " + arista.v1().name() + " - Vértice " + arista.v2().name() + ", Peso: " + arista.weight());
            }
        }
    }
}
