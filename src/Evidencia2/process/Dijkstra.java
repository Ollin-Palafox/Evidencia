package Evidencia2.process;

import Evidencia2.utils.Grafo;
import Evidencia2.utils.NodoPrioridad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.HashSet;

public class Dijkstra {
    private final Grafo grafo; // Grafo predefinido
    private final Grafo.Vertice nodoInicial; // Vértice de inicio
    public final HashMap<Grafo.Vertice, Integer> distancias; // Almacena las distancias calculadas

    public Dijkstra(Grafo grafo, Grafo.Vertice nodoInicial) {
        this.nodoInicial = nodoInicial;
        this.grafo = grafo;
        this.distancias = new HashMap<>();
    }

    public void encontrarRutasMasCortas() {
        Set<Grafo.Vertice> visitados = new HashSet<>();
        PriorityQueue<NodoPrioridad> colaPrioridad = new PriorityQueue<>(grafo.vertices.size(), new NodoPrioridad());

        for (Grafo.Vertice vertice : grafo.vertices.keySet()) {
            distancias.put(vertice, Integer.MAX_VALUE);
        }

        distancias.put(nodoInicial, 0);
        colaPrioridad.add(new NodoPrioridad(nodoInicial, 0));

        while (!colaPrioridad.isEmpty()) {
            Grafo.Vertice nodoActual = colaPrioridad.remove().vertice;
            visitados.add(nodoActual);
            actualizarDistancias(nodoActual, distancias, colaPrioridad, visitados);
        }
    }

    private void actualizarDistancias(Grafo.Vertice verticeActual, HashMap<Grafo.Vertice, Integer> distancias, PriorityQueue<NodoPrioridad> colaPrioridad, Set<Grafo.Vertice> visitados) {
        ArrayList<Grafo.Arista> adyacencias = grafo.obtenerAdyacencias(verticeActual);

        for (Grafo.Arista arista : adyacencias) {
            Grafo.Vertice verticeDestino = (verticeActual == arista.v1()) ? arista.v2() : arista.v1();
            if (!visitados.contains(verticeDestino)) {
                int nuevaDistancia = distancias.get(verticeActual) + (int) arista.weight;
                if (nuevaDistancia < distancias.get(verticeDestino)) {
                    distancias.put(verticeDestino, nuevaDistancia);
                    colaPrioridad.add(new NodoPrioridad(verticeDestino, nuevaDistancia));
                }
            }
        }
    }
}

