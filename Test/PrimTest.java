import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import Evidencia2.process.Prim;
import Evidencia2.utils.Elementos;
import Evidencia2.utils.Grafo;

public class PrimTest {

    private Grafo grafo;

    @Before
    public void setUp() {
        // Configura el grafo para las pruebas
        grafo = Elementos.crearGrafoPredefinido();
    }

    @Test
    public void testPrim() {
        // Selecciona un nodo de inicio y final
        Grafo.Vertice nodoInicial = Elementos.obtenerVerticeInicioPredeterminado();
        Grafo.Vertice nodoFinal = Elementos.obtenerVerticeDestinoPredeterminado();

        // Asegúrate de que los nodos de inicio y final sean válidos
        assertNotNull(nodoInicial);
        assertNotNull(nodoFinal);

        // Ejecuta el algoritmo de Dijkstra
        Prim prim = new Prim(grafo, nodoInicial);
        prim.encontrarRutaMasCortaPrim();

        // Verifica que la distancia a nodoFinal sea la esperada
        // Especifica la distancia esperada
    }
    
}
