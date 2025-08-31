package org.example;
import java.util.*;

public class GrafoLista {
    private HashMap<String, List<String>> grafo;

    public GrafoLista() {
        grafo = new HashMap<>();
    }

    public void agregarVertice(String vertice) {
        grafo.putIfAbsent(vertice, new ArrayList<>());
    }

    public void agregarArista(String origen, String destino) {
        grafo.get(origen).add(destino);
        grafo.get(destino).add(origen); // Grafo no dirigido
    }

    public void mostrarGrafo() {
        System.out.println("Lista de Adyacencia:");
        for (String v : grafo.keySet()) {
            System.out.println(v + " -> " + grafo.get(v));
        }
    }

    public static void main(String[] args) {
        GrafoLista grafo = new GrafoLista();

        grafo.agregarVertice("A");
        grafo.agregarVertice("B");
        grafo.agregarVertice("C");
        grafo.agregarVertice("D");

        grafo.agregarArista("A", "B");
        grafo.agregarArista("A", "C");
        grafo.agregarArista("B", "D");

        grafo.mostrarGrafo();
    }
}
