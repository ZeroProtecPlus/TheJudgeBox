// (Ejercicio B)
import java.io.*;
import java.util.*;

public class B_hiddenNames_pass {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );
        // T = número de casos de prueba
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            // s1 = primer string a comparar
            String s1 = br.readLine();
            // s2 = segundo string a comparar
            String s2 = br.readLine();

            // Limpiamos espacios y pasamos a minúsculas
            String sClean = s1.replace(" ", "").toLowerCase();
            String s2Clean = s2.replace(" ", "").toLowerCase();

            // Conviertes el string limpio a un arreglo de chars primitivos
            char[] chars1 = sClean.toCharArray();
            // Lo ordenas directamente con Arrays.sort (más eficiente que Collections.sort)
            Arrays.sort(chars1);
            // Conviertes de vuelta a String para comparar
            String sorted1 = new String(chars1);

            // Lo mismo para el segundo string
            char[] chars2 = s2Clean.toCharArray();
            Arrays.sort(chars2);
            String sorted2 = new String(chars2);

            // Si los strings ordenados son iguales, son anagramas (nombres ocultos)
            if (sorted1.equals(sorted2)) {
                System.out.println("Case " + (i + 1) + ": Yes");
            } else {
                System.out.println("Case " + (i + 1) + ": No");
            }
        }
    }
}

// La lógica es así: Para saber si un nombre está "oculto" en otro (ignorando espacios y mayúsculas),
// simplemente limpiamos ambos strings, los ordenamos alfabéticamente y comparamos si son idénticos.
// Si al ordenar los caracteres obtenemos lo mismo, significa que ambos tenían las mismas letras.
