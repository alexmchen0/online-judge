import java.util.Scanner;

/**
 * Created by Alex on 4/3/17.
 * http://codeforces.com/problemset/problem/267/A
 */
public class W9_267A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTests = Integer.parseInt(in.nextLine());
        for (int t = 0; t < numTests; t++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int count = 0;

            while (a != 0 && b != 0) {
                if (b > a) {
                    count += b / a;
                    b %= a;
                } else {
                    count += a / b;
                    a %= b;
                }
            }

            System.out.println(count);
        }
    }
}
