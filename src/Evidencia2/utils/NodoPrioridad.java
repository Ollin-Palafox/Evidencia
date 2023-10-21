package Evidencia2.utils;

import java.util.Comparator;

public class NodoPrioridad implements Comparator<NodoPrioridad> {
    public Grafo.Vertice vertice;
    int distancia;

    public NodoPrioridad() {}

    public NodoPrioridad(Grafo.Vertice vertice, int distancia) {
        this.vertice = vertice;
        this.distancia = distancia;
    }

    @Override
    public int compare(NodoPrioridad nodo1, NodoPrioridad nodo2) {
        if (nodo1.distancia < nodo2.distancia) return -1;
        if (nodo1.distancia > nodo2.distancia) return 1;
        return 0;
    }
}
