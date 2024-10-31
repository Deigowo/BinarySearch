import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        
        // Leer n y k
        System.out.println("Ingrese los valores de n (arreglo) y k (consultas) )");
        String[] firstLine = bufer.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int k = Integer.parseInt(firstLine[1]);
        
        // Leer el arreglo
        System.out.println("Ingresa elementos para el arreglo");
        String[] arrayLine = bufer.readLine().split(" ");
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(arrayLine[i]);
        }
        
        // Leer las consultas
        System.out.println("Ingrese las queries para hacer el Binary Search");
        String[] queriesLine = bufer.readLine().split(" ");
        int[] queries = new int[k];
        for (int i = 0; i < k; i++) {
            queries[i] = Integer.parseInt(queriesLine[i]);
        }
        
        // Responder consultas
        StringBuilder salida = new StringBuilder();
        for (int query : queries) {
            int index = Arrays.binarySearch(array, query);
            salida.append(index >= 0 ? "SI" : "NO").append("\n");
        }
        
        // Imprimir resultados
        System.out.print(salida.toString());
    }
}
