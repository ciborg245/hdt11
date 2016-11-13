/*
    Algoritmos y Estructuras de Datos

    Integrantes:
    Alejandro Chaclan
    Sebastian Galindo
    Rodrigo Arriaza

    Este clase implementa un grafo mediante una matriz de adyacencia y utiliza el algoritmo de Floyd para buscar las distancias mas cortas.
 */

import java.util.ArrayList;

public class Graph {

    ArrayList<String> nodes = new ArrayList<>();
    ArrayList<ArrayList<Integer>> edges = new ArrayList<>(), floyd, floydNodes = new ArrayList<>();

    //Constructor
    public Graph () {}

    //Funcion para añadir una arista
    public void addEdge(String line) {
        String city1 = "", city2 = "";
        String temp = "", tempNum = "";

        //Se recorre cada Char de la linea leida
        for (int i = 0; i < line.length(); i++) {
            //Si no es un espacio, se guarda en un string temporal dependiendo si es letra o digito
            if (line.charAt(i) != ' ') {
                if (Character.isLetter(line.charAt(i)))
                    temp += line.charAt(i);
                else if (Character.isDigit(line.charAt(i)))
                    tempNum += line.charAt(i);
            } else {
                //Una vez encontrado el espacio, se lee la ciudad y se revisa si ya esta registrada, si no, se añade
                if (!temp.isEmpty()){
                    if (!nodes.contains(temp.toLowerCase()))
                        addNode(temp.toLowerCase());
                    if (city1.isEmpty())
                        city1 = temp.toLowerCase();
                    else
                        city2 = temp.toLowerCase();

                    temp = "";
                }
            }
            // Se guarda la distancia entre las ciudades
            if (!tempNum.isEmpty() && i == line.length()-1) {
                edges.get(nodes.indexOf(city1)).set(nodes.indexOf(city2), Integer.parseInt(tempNum));
                edges.get(nodes.indexOf(city2)).set(nodes.indexOf(city1), Integer.parseInt(tempNum));

                floydNodes.get(nodes.indexOf(city1)).set(nodes.indexOf(city2), nodes.indexOf(city1));
                floydNodes.get(nodes.indexOf(city2)).set(nodes.indexOf(city1), nodes.indexOf(city2));
            }
        }

        //Se reconstruye la matriz de Floyd
        floydAlgorithm();
    }

    //Funcion para agregar un nuevo nodo
    private void addNode(String city) {
        //Se añade una nueva fila en cada matriz
        nodes.add(city);
        edges.add(new ArrayList<>());
        floydNodes.add(new ArrayList<>());

        //Se añade una nueva columna con valores iniciales en las matrices
        for (int i = 0; i < nodes.size()-1; i++) {
            edges.get(i).add(Integer.MAX_VALUE);
            edges.get(edges.size()-1).add(Integer.MAX_VALUE);

            floydNodes.get(i).add(-1);
            floydNodes.get(floydNodes.size()-1).add(-1);
        }

        //Por ultimo se añade el ultimo valor de la matriz
        edges.get(edges.size()-1).add(0);
        floydNodes.get(floydNodes.size()-1).add(-1);
    }

    //Funcion que devuelve la distancia mas corta entre dos ciudades
    public int distBetweenNodes(String city1, String city2) {
        int indexCity1 = nodes.indexOf(city1);
        int indexCity2 = nodes.indexOf(city2);

        int dist = floyd.get(indexCity1).get(indexCity2);

        return dist;
    }

    //Funcion para eliminar una arista
    public void deleteEdge (String city1, String city2) {
        //Los valores correspondientes de las ciudades se convierten en valores iniciales
        edges.get(nodes.indexOf(city1)).set(nodes.indexOf(city2), Integer.MAX_VALUE);
        edges.get(nodes.indexOf(city2)).set(nodes.indexOf(city1), Integer.MAX_VALUE);

        floydNodes.get(nodes.indexOf(city1)).set(nodes.indexOf(city2), -1);
        floydNodes.get(nodes.indexOf(city2)).set(nodes.indexOf(city1), -1);

        //Se reconstruye la matriz de Floyd
        floydAlgorithm();
    }

    //Funcion que revisa si se contiene a un elemento en el grafo
    public boolean contains (String city) {
        return nodes.contains(city);
    }

    public String toString() {
        return floydNodes.toString();
    }

    //Función que devuelve un string diciendo la distancia entre ciudades y las ciudades intermedias
    public String toString(String city1, String city2) {
        int index1 = nodes.indexOf(city1);
        int index2 = nodes.indexOf(city2);

        String s = "";

        //Se revisan las ciudades intermedias segun el algoritmo de Floyd y se van agregando a un string
        while (floydNodes.get(index1).get(index2) != index1) {
            s += nodes.get(floydNodes.get(1).get(index1)).toUpperCase().charAt(0) + nodes.get(floydNodes.get(1).get(index1)).substring(1) + " -> ";
            index1 = floydNodes.get(index1).get(index2);
        }

        if (!s.isEmpty())
            s = s.substring(0,s.length()-4);

        return s;
    }

    //Función que actualiza una matriz de distancias mas cortas utilizando el algoritmo de Floyd
    public void floydAlgorithm(){
        floyd = edges;
        for (int i = 0; i < floyd.size(); i++)
            for (int j = 0; j < floyd.size(); j++)
                for (int k = 0;  k < floyd.size(); k++) {
                    if ((floyd.get(j).get(i) + floyd.get(i).get(k)) < floyd.get(j).get(k)) {
                        floydNodes.get(j).set(k, i);
                    }
                    floyd.get(j).set(k, Integer.min(floyd.get(j).get(k), floyd.get(j).get(i) + floyd.get(i).get(k)));
                }
    }

    //Función que devuelve el centro de la matriz
    public String getCenter () {
        int centerEx = Integer.MAX_VALUE, ex = 0, center = 0;

        //Se revisan los valores maximos de las columnas de la matriz de Floyd para obtener las excentricidades de cada nodo
        for (int i = 0; i < floyd.size(); i++) {
            for (int j = 0; j < floyd.size(); j++) {
                if (floyd.get(j).get(i) > ex)
                    ex = floyd.get(j).get(i);
            }

            //Se lleva un contador de la excentricidad minima para obtener el centro
            if (centerEx > ex) {
                centerEx = ex;
                center = i;
            }
        }

        return nodes.get(floydNodes.get(1).get(center)).toUpperCase().charAt(0) + nodes.get(floydNodes.get(1).get(center)).substring(1);
    }
}