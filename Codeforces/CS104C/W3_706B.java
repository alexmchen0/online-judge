import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Alex on 2/13/17.
 * Problem: Interesting Drink
 * http://codeforces.com/problemset/problem/706/B
 */
public class W3_706B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numShops = in.nextInt();
        int[] shopPrices = new int[numShops];
        for (int i = 0; i < numShops; i++) {
            shopPrices[i] = in.nextInt();
        }
        Arrays.sort(shopPrices);

        int numDays = in.nextInt();
        for (int i = 0; i < numDays; i++) {
            int low = 0;
            int high = numShops;
            int money = in.nextInt();
            if (money < shopPrices[0]) {
                System.out.println(0);
                continue;
            }
            while (low + 1 < high) {
                int mid = (low + high) / 2;
                if (money >= shopPrices[mid]) {
                    low = mid;
                } else {
                    high = mid;
                }
            }
            System.out.println(low + 1);
        }
    }
}
