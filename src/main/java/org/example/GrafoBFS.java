package org.example;
import java.util.*;

public class GrafoBFS {
    private HashMap<String, List<String>> lista;

    public GrafoBFS() {
        lista = new HashMap<>();
    }

    public void agregarVertice(String v) {
        lista.putIfAbsent(v, new ArrayList<>());
    }

    public void agregarArista(String origen, String destino) {
        lista.get(origen).add(destino);
        lista.get(destino).add(origen);
    }

    public void BFS(String inicio) {
        Queue<String> cola = new LinkedList<>();
        Set<String> visitados = new HashSet<>();

        cola.add(inicio);
        visitados.add(inicio);

        System.out.print("Recorrido BFS: ");
        while (!cola.isEmpty()) {
            String actual = cola.poll();
            System.out.print(actual + " ");

            for (String vecino : lista.get(actual)) {
                if (!visitados.contains(vecino)) {
                    cola.add(vecino);
                    visitados.add(vecino);
                }
            }
        }
    }

    public static void main(String[] args) {
        GrafoBFS grafo = new GrafoBFS();

        grafo.agregarVertice("A");
        grafo.agregarVertice("B");
        grafo.agregarVertice("C");
        grafo.agregarVertice("D");

        grafo.agregarArista("A", "B");
        grafo.agregarArista("A", "C");
        grafo.agregarArista("B", "D");

        grafo.BFS("A");
    }
}
