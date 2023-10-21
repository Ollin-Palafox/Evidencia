import Evidencia2.process.Dijkstra;
import Evidencia2.utils.Elementos;
import Evidencia2.utils.Grafo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class DijkstraTest {
    private Grafo grafo;

    @Before
    public void setUp() {
        // Configura el grafo para las pruebas
        grafo = Elementos.crearGrafoPredefinido();
    }

    @Test
    public void testDijkstra() {
        // Selecciona un nodo de inicio y final
        Grafo.Vertice nodoInicial = Elementos.obtenerVerticeInicioPredeterminado();
        Grafo.Vertice nodoFinal = Elementos.obtenerVerticeDestinoPredeterminado();

        // Asegúrate de que los nodos de inicio y final sean válidos
        assertNotNull(nodoInicial);
        assertNotNull(nodoFinal);

        // Ejecuta el algoritmo de Dijkstra
        Dijkstra dijkstra = new Dijkstra(grafo, nodoInicial);
        dijkstra.encontrarRutasMasCortas();

        // Verifica que la distancia a nodoFinal sea la esperada
        // Especifica la distancia esperada
    }
}
