import java.util.Scanner;

/**
 * Created by Alex on 3/6/17.
 * Problem: Santa Claus and Candies
 * Description: http://codeforces.com/problemset/problem/753/A
 */
public class W6_753A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int totalCandies = Integer.parseInt(in.nextLine());
        StringBuilder solution = new StringBuilder();
        int numCandies = 1;
        int count = 0;
        while (true) {
            count++;
            if (totalCandies - numCandies <= numCandies) {
                solution.append(totalCandies);
                break;
            }

            solution.append(numCandies).append(" ");
            totalCandies -= numCandies;
            numCandies++;
        }
        System.out.println(count);
        System.out.println(solution.toString());
    }
}
