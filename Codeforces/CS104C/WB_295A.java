import java.util.Scanner;

/**
 * Created by Alex on 4/17/17.
 * http://codeforces.com/problemset/problem/295/A
 */
public class WB_295A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = in.nextInt();
        }

        // All operations
        Operation[] ops = new Operation[m + 1];
        for (int i = 1; i <= m; i++) {
            ops[i] = new Operation(in.nextInt(), in.nextInt(), in.nextInt());
        }

        // Changes of number of times each operation is performed
        int[] numOps = new int[m + 2];
        for (int i = 0; i < k; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            numOps[start]++;
            numOps[end + 1]--;
        }

        // Changes of the value to be added to each element of original array
        long[] values = new long[n + 2];
        long numOp = 0; // running total for num times each op is performed
        for (int i = 1; i <= m; i++) {
            numOp += numOps[i];
            values[ops[i].left] += numOp * ops[i].value;
            values[ops[i].right + 1] -= numOp * ops[i].value;
        }

        StringBuilder ans = new StringBuilder();
        long value = 0; // running total for value to be added to each element
        for (int i = 1; i <= n; i++) {
            value += values[i];
            ans.append(arr[i] + value).append(" ");
        }

        System.out.println(ans.toString());
    }

    private static class Operation {
        int left, right, value;

        Operation(int left, int right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }
}
