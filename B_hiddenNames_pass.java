// (Ejercicio J)
import java.io.*;
import java.util.*;

public class B_hiddenNames_pass {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String s1 = br.readLine();
            String s2 = br.readLine();

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

            if (sorted1.equals(sorted2)) {
                System.out.println("Case " + (i + 1) + ": Yes");
            } else {
                System.out.println("Case " + (i + 1) + ": No");
            }
        }
    }
}
