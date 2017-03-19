import java.util.Scanner;

/**
 * Created by Alex on 3/6/17.
 * Problem: Vladik And Flights
 * http://codeforces.com/problemset/problem/743/A
 */
public class W6_743A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextInt();
        int start = in.nextInt() - 1;
        int dest = in.nextInt() - 1;
        in.nextLine();
        char[] airports = in.nextLine().toCharArray();
        if (airports[start] == airports[dest]) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }
}
