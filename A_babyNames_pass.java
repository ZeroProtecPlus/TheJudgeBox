// (Ejercicio A)
import java.io.BufferedReader;
import java.util.*;

public class A_babyNames_pass {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new java.io.InputStreamReader(System.in)
        );
        // T = número de casos de prueba
        int T = Integer.parseInt(br.readLine());
        for (int j = 0; j < T; j++) {
            // S = string grande donde buscaremos substrings
            String S = br.readLine();
            // P y Q = largo mínimo y máximo de los nombres a buscar
            String[] PQ = br.readLine().split(" ");
            int P = Integer.parseInt(PQ[0]);
            int Q = Integer.parseInt(PQ[1]);
            // HashSet para guardar los nombres únicos (sin duplicados)
            HashSet<String> nombres = new HashSet<>();
            // Recorremos cada posición inicial en el string
            for (int i = 0; i < S.length(); i++) {
                // Probamos todos los largos desde P hasta Q
                for (int len = P; len <= Q; len++) {
                    // Si nos pasamos del string, cortamos
                    if (i + len > S.length()) {
                        break;
                    } else {
                        // Agregamos el substring al set (automáticamente elimina duplicados)
                        nombres.add(S.substring(i, i + len));
                    }
                }
            }
            // Output: cuántos nombres únicos encontramos
            System.out.println("Case " + (j + 1) + ": " + nombres.size());
        }
    }
}

// La lógica es así: Dada una cadena S, y un rango P-Q, tenés que contar cuántos substring únicos de longitud entre P y Q aparecen en S.
// Por ejemplo, si S = "abcabc" y P=2, Q=3:
// - Longitud 2: "ab", "bc", "ca", "ab" (repetido), "bc" (repetido) → únicos: "ab", "bc", "ca"
// - Longitud 3: "abc", "bca", "cab", "abc" → únicos: "abc", "bca", "cab"
// El set se encarga de darte los únicos automáticamente.
