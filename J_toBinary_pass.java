// (Ejercicio J)
import java.io.*;

public class J_toBinary_pass {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );
        int T = Integer.parseInt(br.readLine());
        if (T > 0 && T <= 1000) {
            for (int j = 0; j < T; j++) {
                // n puede ser muy grande, por eso long
                long n = Long.parseLong(br.readLine());
                // Convertimos a binario como string
                String binaryN = toBinaryNum(n);
                int aux = 0;
                // Contamos cuántos '1' tiene la representación binaria
                for (int i = 0; i < binaryN.length(); i++) {
                    if (binaryN.charAt(i) == '1') {
                        aux++;
                    }
                }
                // Si la cantidad de unos es par → even, sino → odd
                if (aux % 2 == 0) {
                    System.out.println("Case " + (j + 1) + ": even");
                } else {
                    System.out.println("Case " + (j + 1) + ": odd");
                }
            }
        }
        br.close();
    }

    // Función recursiva que convierte decimal a binario
    public static String toBinaryNum(long n) {
        // Casos base
        if (n == 0) {
            return "0";
        }
        if (n == 1) {
            return "1";
        }
        // Recursión: dividir por 2 hasta llegar a 1, y concatenar el residuo
        return toBinaryNum(n / 2) + (n % 2);
    }
}

// La lógica es así: Tomás un número, lo convertís a binario, contás cuántos unos tiene, y decis si es par o impar.
// Por ejemplo:
// - n = 7 → binario = "111" → 3 unos → odd (impar)
// - n = 8 → binario = "1000" → 1 uno → odd
// - n = 10 → binario = "1010" → 2 unos → even (par)
// El truco está en usar long porque puede ser un número muy grande, y la conversión recursiva es elegante.
