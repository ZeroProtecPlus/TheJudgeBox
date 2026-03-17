// (Ejercicio F)
import java.io.*;

public class F_Parallelogram_pass {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        // T = número de casos de prueba
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            // Leemos las coordenadas de los 3 puntos conocidos: A(x,y), B(x,y) y C(x,y)
            String[] userInput = br.readLine().split("\\s+");
            double Ax = Double.parseDouble(userInput[0]);
            double Ay = Double.parseDouble(userInput[1]);
            double Bx = Double.parseDouble(userInput[2]);
            double By = Double.parseDouble(userInput[3]);
            double Cx = Double.parseDouble(userInput[4]);
            double Cy = Double.parseDouble(userInput[5]);

            // Calculamos la cuarta coordenada (D) usando suma/resta de vectores
            double Dx = Cx - (Bx - Ax);
            double Dy = Cy - (By - Ay);

            // Calculamos el área del paralelogramo usando el producto cruz de vectores adyacentes (AB y AD)
            double Area = Math.abs(
                (Bx - Ax) * (Dy - Ay) - (By - Ay) * (Dx - Ax)
            );

            // Imprimimos el caso, las coordenadas de D y el Área (redondeados)
            System.out.println(
                "Case " +
                    (i + 1) +
                    ": " +
                    Math.round(Dx) +
                    " " +
                    Math.round(Dy) +
                    " " +
                    Math.round(Area)
            );
        }
    }
}

// La lógica es así: Dado un paralelogramo con vértices A, B, C y D en orden consecutivo, se busca hallar D y el Área.
//
// 1. Cómo encontrar la coordenada faltante (D):
//    En un paralelogramo, los lados opuestos son paralelos y miden lo mismo (son el mismo vector).
//    Por lo tanto, el vector que va de A hacia B (AB) es idéntico al que va de D hacia C (DC).
//    - Vector AB = (Bx - Ax, By - Ay)
//    - Sabiendo que D + AB = C, podemos despejar D como D = C - AB.
//    - Matemáticamente:
//      Dx = Cx - (Bx - Ax)
//      Dy = Cy - (By - Ay)
//
// 2. Cómo calcular el Área:
//    El área de un paralelogramo en un plano 2D se obtiene con el valor absoluto del producto cruz (o determinante) de dos vectores que comparten un vértice (por ejemplo, AB y AD).
//    - Vector AB = (Bx - Ax, By - Ay)
//    - Vector AD = (Dx - Ax, Dy - Ay)
//    - Área = |(ABx * ADy) - (ABy * ADx)|
//    - Reemplazando: Área = |(Bx - Ax) * (Dy - Ay) - (By - Ay) * (Dx - Ax)|
