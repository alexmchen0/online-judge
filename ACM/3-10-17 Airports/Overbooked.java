import java.util.*;

/**
 * Created by Alex on 2/10/17.
 */
public class Overbooked {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTests = Integer.parseInt(in.nextLine());
        for (int t = 0; t < numTests; t++) {
            int numPassengers = in.nextInt();
            int numSeats = in.nextInt();
            int numExtra = numPassengers - numSeats;

            if (numExtra == 0) {
                System.out.println(0);
                continue;
            }

            PriorityQueue<Integer> minPrices = new PriorityQueue<>(Comparator.reverseOrder());
            for (int i = 0; i < numPassengers; i++) {
                int price = in.nextInt();
                if (minPrices.size() < numExtra) {
                    minPrices.add(price);
                } else {
                    if (minPrices.peek() > price) {
                        minPrices.poll();
                        minPrices.add(price);
                    }
                }
            }
            long sum = 0;
            for (int price : minPrices) {
                sum += price;
            }
            System.out.println(sum);
        }
    }
}
