package org.example;
import java.util.*;

public class GrafoMatriz {
    private int[][] matriz;
    private List<String> nodos;

    public GrafoMatriz(int tamaño) {
        matriz = new int[tamaño][tamaño];
        nodos = new ArrayList<>();
    }

    public void insertarNodo(String nodo) {
        if (!nodos.contains(nodo)) {
            nodos.add(nodo);
        } else {
            System.out.println("El nodo " + nodo + " ya existe.");
        }
    }

    public void conectar(String origen, String destino) {
        int i = nodos.indexOf(origen);
        int j = nodos.indexOf(destino);
        if (i != -1 && j != -1) {
            matriz[i][j] = 1;
            matriz[j][i] = 1;
        } else {
            System.out.println("Error: uno de los nodos no existe.");
        }
    }

    public void imprimirMatriz() {
        System.out.println("Matriz de Adyacencia:");
        System.out.print("   ");
        for (String v : nodos) {
            System.out.print(v + " ");
        }
        System.out.println();
        for (int i = 0; i < nodos.size(); i++) {
            System.out.print(nodos.get(i) + "  ");
            for (int j = 0; j < nodos.size(); j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GrafoMatriz grafo = new GrafoMatriz(4);

        grafo.insertarNodo("A");
        grafo.insertarNodo("B");
        grafo.insertarNodo("C");
        grafo.insertarNodo("D");

        grafo.conectar("A", "B");
        grafo.conectar("B", "C");
        grafo.conectar("C", "D");
        grafo.conectar("D", "A");

        grafo.imprimirMatriz();
    }
}
