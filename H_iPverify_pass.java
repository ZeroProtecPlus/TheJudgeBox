// (Ejercicio H)
import java.io.*;

public class H_iPverify_pass {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        // T = número de casos de prueba
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            // Leemos la IP en formato decimal (ej: "192.168.1.1")
            String[] iP_decimal = br.readLine().split("\\.");
            // Leemos la IP en formato binario (ej: "11000000.10101000.00000001.00000001")
            String[] iP_binario = br.readLine().split("\\.");

            // Asumimos que la IP es válida (los octetos coinciden)
            Boolean status = true;

            for (int j = 0; j < iP_binario.length; j++) {
                // Convertimos cada octeto binario a decimal para comparar
                int aux = Integer.parseInt(iP_binario[j], 2);

                // Si algún octeto no coincide con su par decimal, la IP no es válida
                if (aux != Integer.parseInt(iP_decimal[j])) {
                    status = false;
                    break;
                }
            }

            // Imprimimos el resultado del caso
            if (status) {
                System.out.println("Case " + (i + 1) + ": Yes");
            } else {
                System.out.println("Case " + (i + 1) + ": No");
            }
        }
    }
}

// La lógica es así: Dada una dirección IP en formato decimal y la misma IP en formato binario,
// hay que verificar si ambas representan el mismo valor.
//
// Una IP tiene 4 octetos separados por puntos (ej: 192.168.1.1).
// Cada octeto es un número entre 0 y 255, que también puede expresarse en binario de 8 bits.
//
// El proceso de verificación es simple:
// 1. Separamos cada IP por el punto "." para obtener los 4 octetos.
// 2. Por cada octeto, convertimos el valor binario a decimal usando Integer.parseInt(valor, 2).
//    - El segundo argumento "2" le dice a Java que el string está en base 2 (binario).
// 3. Comparamos el decimal convertido con el decimal original.
//    - Si todos los octetos coinciden → "Yes"
//    - Si alguno falla → "No" (y cortamos con break para no seguir comparando innecesariamente)
//
// Ejemplo:
//   Decimal: 192.168.1.1
//   Binario: 11000000.10101000.00000001.00000001
//   - 11000000 en binario = 192 ✓
//   - 10101000 en binario = 168 ✓
//   - 00000001 en binario = 1   ✓
//   - 00000001 en binario = 1   ✓
//   → Resultado: Yes
