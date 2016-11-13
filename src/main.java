/*
    Algoritmos y Estructuras de Datos

    Integrantes:
    Alejandro Chaclan
    Sebastian Galindo
    Rodrigo Arriaza

    Este programa implementa grafos y el algoritmo de Floyed para buscar las distancias mas cortas entre ciudades.
 */

import java.util.Scanner; //Importa la clase del Scanner
import java.io.BufferedReader;
import java.io.FileReader;

public class main {
    public static void main (String[] args) {
        Scanner teclado = new Scanner(System.in); //Variable para leer los datos ingresados por el usuario
        int opc = 0;
        Graph cities = new Graph();

        try {
            BufferedReader bf = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\guategrafo.txt")); // Direccion donde se encuentra el archivo

            String line;

            //Realiza el ciclo, mientras se encuentren datos
            while ((line = bf.readLine()) != null) {
                //Se agrega la arista correspondiente (y nodo si es necesario)
                cities.addEdge(line);
            }

            //En caso de no poder abrir el archivo, imprime "ERROR"
        } catch (Exception e) {
            System.err.println("ERROR: No se encontro el archivo.");
        }

        while (opc != 5) {
            //Se muestra en pantalla el menu
            System.out.println("1. Distancia entre ciudades\n" +
                    "2. Centro del grafo\n" +
                    "3. Interrupcion de trafico entre ciudades\n" +
                    "4. Establecer ruta entre ciudades\n" +
                    "5. Salir");

            //Se lee la opcion del usuario
            opc = (int)teclado.nextDouble();

            //Codigo para la primera opcion
            if (opc == 1) {
                System.out.println ("Escriba el nombre de la ciudad origen:");
                String city1 = teclado.next();
                while (!cities.contains(city1)) {
                    System.out.println("Esa ciudad no se encuentra registrada.");
                    city1 = teclado.next();
                }

                System.out.println("Escriba el nombre de la ciudad destino:");
                String city2 = teclado.next();
                while (!cities.contains(city2)) {
                    System.out.println("Esa ciudad no se encuentra registrada.");
                    city2 = teclado.next();
                }

                city1 = city1.toLowerCase();
                city2 = city2.toLowerCase();

                //Se muestra la distancia y las ciudades intermedias
                String temp = cities.toString(city1, city2);
                if (temp.isEmpty())
                    System.out.println("La distancia mas corta es de " + cities.distBetweenNodes(city1, city2) + "KM");
                else
                    System.out.println("La distancia mas corta es de " + cities.distBetweenNodes(city1, city2) + "KM y debe pasar por: " + temp);

            } else if (opc == 3) { //Codiog para la tercera opcion

                //Se leen las ciudades ingresadas por el usuario
                System.out.println ("Escriba el nombre la primera ciudad:");
                String city1 = teclado.next();
                while (!cities.contains(city1)) {
                    System.out.println("Esa ciudad no se encuentra registrada.");
                    city1 = teclado.next();
                }

                System.out.println ("Escriba el nombre la segunda ciudad:");
                String city2 = teclado.next();
                while (!cities.contains(city2)) {
                    System.out.println("Esa ciudad no se encuentra registrada.");
                    city2 = teclado.next();
                }

                //Se elimina la arista correspondiente
                cities.deleteEdge(city1, city2);

            } else if (opc == 2) { //Codigo para la segunda opcion
                System.out.println("El centro del grafo es: " + cities.getCenter());

            } else if (opc == 4) { // Codigo para la cuarta opcion
                //Se leen las ciudades y la distancia
                System.out.println("Escriba el nombre de las ciudades y su distancia. (Ej. Ciudad1 Ciudad2 XXX)");
                String line = teclado.next() + " " + teclado.next() + " " + teclado.next();

                //Se agrega la arista correspondientes (y nodo si es necesario)
                cities.addEdge(line);
            }
        }
    }
}

