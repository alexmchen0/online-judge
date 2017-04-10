import java.util.Scanner;

/**
 * Created by Alex on 2/10/17.
 */
public class AirplaneSpeed {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTests = Integer.parseInt(in.nextLine());
        for (int t = 0; t < numTests; t++) {
            int numData = in.nextInt();
            long totalTime = 0;
            long totalDist = 0;
            for (int i = 0; i < numData; i++) {
                int speed = in.nextInt();
                int time = in.nextInt();
                long distance = speed * time;

                totalTime += time;
                totalDist += distance;
            }

            System.out.println(Math.round(totalDist / (double) totalTime));
        }
    }
}
