package Evidencia2.utils;

import java.util.ArrayList;
import java.util.HashMap;

public class Grafo {
    public final HashMap<Vertice, ArrayList<Arista>> vertices;

    public Grafo() {
        this.vertices = new HashMap<>();
    }

    public void agregarVertice(Vertice vertice) {
        if (!vertices.containsKey(vertice)) {
            vertices.put(vertice, new ArrayList<>());
        }
    }

    public void agregarArista(Vertice v1, Vertice v2, double weight) {
        Arista arista = new Arista(v1, v2, weight);
        vertices.get(v1).add(arista);
    }


    public ArrayList<Arista> obtenerAdyacencias(Vertice vertice) {
        return vertices.get(vertice);
    }

    public static class Vertice {
        private final String name;

        public Vertice(String name) {
            this.name = name;
        }

        public String name() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertice vertice = (Vertice) o;
            return name.equals(vertice.name);
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }
    }

    public static class Arista {
        public final Vertice v1;
        public final Vertice v2;
        public final double weight;

        public Arista(Vertice v1, Vertice v2, double weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }

        public Vertice v1() {
            return v1;
        }

        public Vertice v2() {
            return v2;
        }

        public double weight() {
            return weight;
        }
    }
}
