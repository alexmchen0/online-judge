import java.util.*;
import java.io.*;

/**
 * Problem: The least round way
 * http://codeforces.com/contest/2/problem/B
 */
public class W7_2B {
    private static class Tuple {
        int power;
        char dir;

        Tuple(int power, char dir) {
            this.power = power;
            this.dir = dir;
        }
    }

    private static int powerOf(int num, int factor) {
        if (num == 0) {
            return 1;
        }
        int count = 0;
        while (num % factor == 0) {
            num /= factor;
            count++;
        }
        return count;
    }

    private static Tuple[][] findDP(int[][] matrix, int factor) {
        int size = matrix.length;
        Tuple[][] dp = new Tuple[size][size];
        dp[0][0] = new Tuple(powerOf(matrix[0][0], factor), ' ');
        for (int i = 1; i < size; i++) {
            dp[0][i] = new Tuple(dp[0][i - 1].power + powerOf(matrix[0][i],
                    factor), 'R');
            dp[i][0] = new Tuple(dp[i - 1][0].power + powerOf(matrix[i][0],
                    factor), 'D');
        }

        for (int r = 1; r < size; r++) {
            for (int c = 1; c < size; c++) {
                int power = powerOf(matrix[r][c], factor);
                if (dp[r][c - 1].power < dp[r - 1][c].power) {
                    dp[r][c] = new Tuple(dp[r][c - 1].power + power, 'R');
                } else {
                    dp[r][c] = new Tuple(dp[r - 1][c].power + power, 'D');
                }
            }
        }

        return dp;
    }

    public static void main(String[] args) throws IOException {
        FastIO io = new FastIO(System.in, System.out);
        int size = io.nextInt();
        boolean zero = false;
        int zeroC = 0;

        int[][] matrix = new int[size][size];
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                int nextInt = io.nextInt();
                matrix[r][c] = nextInt;
                if (nextInt == 0 && !zero) {
                    zero = true;
                    zeroC = c;
                }
            }
        }

        Tuple[][] dp2 = findDP(matrix, 2);
        Tuple[][] dp5 = findDP(matrix, 5);

        Tuple[][] dp;
        if (dp2[size - 1][size - 1].power < dp5[size - 1][size - 1].power) {
            dp = dp2;
        } else {
            dp = dp5;
        }

        StringBuilder path = new StringBuilder(size * 2 - 2);
        if (zero && dp[size - 1][size - 1].power > 1) {
            io.println(1 + "");
            for (int c = 0; c < size - 1; c++) {
                if (c == zeroC) {
                    for (int r = 0; r < size - 1; r++) {
                        path.append('D');
                    }
                }
                path.append('R');
            }
        } else {
            io.println(dp[size - 1][size - 1].power + "");
            int r = size - 1, c = size - 1;
            while (r != 0 || c != 0) {
                char dir = dp[r][c].dir;
                path.append(dir);
                if (dir == 'R') {
                    c--;
                } else {
                    r--;
                }
            }
            path.reverse();
        }
        io.println(path.toString());

        io.close();
    }

    private static class FastIO {

        private BufferedReader reader;
        private PrintWriter writer;

        private StringTokenizer tokenizer;

        private FastIO(InputStream in, PrintStream out) {
            this.reader = new BufferedReader(new InputStreamReader(in));
            this.writer = new PrintWriter(new BufferedOutputStream(out));
        }

        private String nextToken() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreElements()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }

            return tokenizer.nextToken();
        }

        private int nextInt() throws IOException {
            return Integer.parseInt(nextToken());
        }

        private void println(String line) {
            writer.println(line);
        }

        private void close() throws IOException {
            reader.close();
            writer.close();
        }
    }
}
