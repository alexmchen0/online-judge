import java.util.Scanner;

/**
 * Created by Alex on 1/30/17.
 * Problem: Two Buttons
 * http://codeforces.com/problemset/problem/520/B
 */
public class W1_520B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int count = 0;
        while (m != n) {
            if (m < n || m % 2 == 1) {
                m++;
            } else {
                m /= 2;
            }
            count++;
        }

        System.out.print(count);
    }
}
