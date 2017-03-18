import java.util.Scanner;

/**
 * Created by Alex on 2/10/17.
 */
public class FlightNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTests = Integer.parseInt(in.nextLine());
        for (int t = 0; t < numTests; t++) {
            int numFlights = in.nextInt();
            int count = 0;
            for (int i = 0; i < numFlights; i++) {
                int flight = in.nextInt();
                int powerOf2 = 1;

                while (flight >= powerOf2) {
                    powerOf2 *= 2;
                }
                powerOf2 /= 2;

                int numOnes = 0;

                while (powerOf2 > 1) {
                    if (flight >= powerOf2) {
                        numOnes++;
                        flight -= powerOf2;
                    }
                    powerOf2 /= 2;
                }

                if (flight == 1) {
                    numOnes++;
                }

                if (numOnes % 2 == 1) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
