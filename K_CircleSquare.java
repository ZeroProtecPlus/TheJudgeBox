import java.io.*;

public class K_CircleSquare {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        double pi = 2 * Math.acos(0.0);
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            double r = Double.parseDouble(br.readLine());
            double areaSombreada = (4 * r * r) - (pi * r * r) + 1e-9;

            System.out.printf("Case " + (i + 1) + ": %.2f\n", areaSombreada);
        }
    }
}
