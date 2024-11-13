import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

import files.Files;

public class BinarySearchFiles {
    public static void main(String[] args) throws IOException {
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        Files fileManager = new Files();

        // Nombre de los archivos para leer
        System.out.println("Ingresa el nombre del archivo que contiene el arreglo:");
        String arrayFileName = bufer.readLine();

        System.out.println("Ingresa el nombre del archivo que contiene las consultas:");
        String queriesFileName = bufer.readLine();

        // Nombre del archivo para escribir
        System.out.println("Ingresa el nombre del archivo para escribir las respuestas:");
        String outputFileName = bufer.readLine();

        // Leer el arreglo desde archivo
        int[] array = fileManager.fileToIntArray(arrayFileName);
        if (array == null || array.length == 0) {
            System.out.println("Error: No se pudo leer el arreglo desde el archivo o el archivo está vacío");
            return;
        }

        // Ordenar el arreglo para Binary Search
        Arrays.sort(array);

        // Leer las consultas desde archivo
        int[] queries = fileManager.fileToIntArray(queriesFileName);
        if (queries == null || queries.length == 0) {
            System.out.println("Error: No se pudo leer las consultas desde el archivo o el archivo está vacío");
            return;
        }

        // Responder consultas y almacenar en el StringBuilder
        StringBuilder output = new StringBuilder();
        for (int query : queries) {
            int index = Arrays.binarySearch(array, query);
            output.append(index >= 0 ? "SI" : "NO").append("\n");
        }

        // Escribir el resultado en el archivo de salida
        fileManager.writeStringArrayToFile(outputFileName, output.toString().split("\n"));
        System.out.println("Las respuestas se han escrito en el archivo: " + outputFileName);
    }
}