import java.io.*;
import java.util.HashMap;

public class F_Parallelogram {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        long T = Long.parseLong(br.readLine());

        for (int i = 0; i < T; i++) {
            HashMap<String, Double> points = new HashMap<>();

            points.put("Ax", Double.parseDouble(br.readLine()));
            points.put("Ay", Double.parseDouble(br.readLine()));
            points.put("Bx", Double.parseDouble(br.readLine()));
            points.put("By", Double.parseDouble(br.readLine()));
            points.put("Cx", Double.parseDouble(br.readLine()));
            points.put("Cy", Double.parseDouble(br.readLine()));

            double Dx =
                points.get("Cx") - (points.get("Bx") - points.get("Ax"));
            double Dy =
                points.get("Cy") - (points.get("By") - points.get("Ay"));

            System.out.println(Dx);
            System.out.println(Dy);
        }
    }
}

/*

3
distancia X = Bx - Ax

Dx = Cx - (Bx - Ax)
Dy = Cy - (By - Ay)


(Dx + distancia X = )

Ax Ay Bx By Cx Cy
0  0  10 0  10 10
0 0 10 0 10 -20
-12 -10 21 21 1 40

*/
