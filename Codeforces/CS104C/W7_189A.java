import java.util.Scanner;

/**
 * Created by Alex on 3/18/17.
 * Problem: Cut Ribbon
 * http://codeforces.com/contest/189/problem/A
 */
public class W7_189A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int ribbonLength = in.nextInt();
        int[] lengths = new int[3];
        for (int i = 0; i < 3; i++) {
            lengths[i] = in.nextInt();
        }

        int dp[] = new int[ribbonLength + 1];
        dp[0] = 0;
        for (int i = 1; i <= ribbonLength; i++) {
            dp[i] = -4001;
            for (int length: lengths) {
                if (i - length >= 0 && dp[i - length] + 1 > dp[i]) {
                    dp[i] = dp[i - length] + 1;
                }
            }
        }

        System.out.println(dp[ribbonLength]);
    }
}
