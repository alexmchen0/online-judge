import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by Alex on 2/10/17.
 */
public class AirportCodes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTests = Integer.parseInt(in.nextLine());
        for (int t = 0; t < numTests; t++) {
            int numPriority = in.nextInt();
            in.nextLine();
            HashSet<String> priority = new HashSet<>(numPriority);
            for (int i = 0; i < numPriority; i++) {
                priority.add(in.nextLine());
            }

            int numCodes = in.nextInt();
            in.nextLine();
            PriorityQueue<String> priorityCodes = new PriorityQueue<>();
            PriorityQueue<String> codes = new PriorityQueue<>();
            for (int i = 0; i < numCodes; i++) {
                String code = in.nextLine();
                if (priority.contains(code)) {
                    priorityCodes.add(code);
                } else {
                    codes.add(code);
                }
            }

            while (!priorityCodes.isEmpty()) {
                System.out.println(priorityCodes.poll());
            }

            while (!codes.isEmpty()) {
                System.out.println(codes.poll());
            }
        }
    }
}
