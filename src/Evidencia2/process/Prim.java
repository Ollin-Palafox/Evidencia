package Evidencia2.process;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import Evidencia2.utils.Grafo;
import Evidencia2.utils.NodoPrioridad;

public class Prim {

    private final Grafo grafo; // Grafo predefinido
    private final Grafo.Vertice nodoInicial; // Vértice de inicio
    public final HashMap<Grafo.Vertice, Double> distancias; // Almacena las distancias calculadas

    public Prim(Grafo grafo, Grafo.Vertice nodoInicial) {
        this.nodoInicial = nodoInicial;
        this.grafo = grafo;
        this.distancias = new HashMap<>();
    }

    public void encontrarRutaMasCortaPrim() {
        Set<Grafo.Vertice> visitado = new HashSet<>();
        PriorityQueue<NodoPrioridad> colaPrioridad = new PriorityQueue<>(new NodoPrioridad()); // Provide the custom comparator
    
        for (Grafo.Vertice vertice : grafo.vertices.keySet()) {
            distancias.put(vertice, Double.POSITIVE_INFINITY);
        }
    
        distancias.put(nodoInicial, 0.0);
        colaPrioridad.add(new NodoPrioridad(nodoInicial, 0.0));
    
        while (!colaPrioridad.isEmpty()) {
            Grafo.Vertice nodoActual = colaPrioridad.remove().vertice;
            visitado.add(nodoActual);
            actualizarDistancias(nodoActual, distancias, colaPrioridad, visitado);
        }
    }

    public void actualizarDistancias(Grafo.Vertice verticeActual, HashMap<Grafo.Vertice, Double> distancias, PriorityQueue<NodoPrioridad> colaPrioridad, Set<Grafo.Vertice> visitados) {
        for (Grafo.Arista arista : grafo.obtenerAdyacencias(verticeActual)) {
            Grafo.Vertice vecino = arista.v2();
            double pesoArista = arista.weight();
            if (!visitados.contains(vecino) && pesoArista < distancias.get(vecino)) {
                distancias.put(vecino, pesoArista);
                // Add the updated NodoPrioridad instance to the priority queue
                colaPrioridad.add(new NodoPrioridad(vecino, pesoArista));
            }
        }
    }
}
