// (Ejercicio K)
import java.io.*;

public class K_CircleSquare {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        // pi = valor de la constante matemática PI
        double pi = 2 * Math.acos(0.0);
        // T = número de casos de prueba
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            // r = radio del círculo (y mitad del lado del cuadrado)
            double r = Double.parseDouble(br.readLine());
            // areaSombreada = diferencia entre el área del cuadrado y el área del círculo
            double areaSombreada = (4 * r * r) - (pi * r * r) + 1e-9;

            // Output format: Dos decimales de precisión
            System.out.printf("Case " + (i + 1) + ": %.2f\n", areaSombreada);
        }
    }
}

// La lógica es así: Tenemos un círculo inscrito en un cuadrado.
// El lado del cuadrado es 2*r. El área del cuadrado es (2r)^2 = 4r^2.
// El área del círculo es pi * r^2.
// El área sombreada (las esquinas) es AreaCuadrado - AreaCirculo.
// Agregamos un pequeño epsilon (1e-9) para evitar errores de redondeo en punto flotante.
