import java.util.*;
/**
 * Created by Alex on 7/29/17.
 */
public class p011 {
    public static void main(String[] args) {
        int[][] grid = parseGrid();
        int length = 4;
        int ans = 0;
        for (int r = 0; r < grid.length - length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                ans = Math.max(ans, grid[r][c] * grid[r + 1][c] *
                        grid[r + 2][c] * grid[r + 3][c]);
                if (c + length <= grid[r].length) {
                    ans = Math.max(ans, grid[r][c] * grid[r + 1][c + 1] *
                            grid[r + 2][c + 2] * grid[r + 3][c + 3]);
                    ans = Math.max(ans, grid[r][c] * grid[r][c + 1] *
                            grid[r][c + 2] * grid[r][c + 3]);
                }

                if (c - length >= 1) {
                    ans = Math.max(ans, grid[r][c] * grid[r + 1][c - 1] *
                            grid[r + 2][c - 2] * grid[r + 3][c - 3]);
                }
            }
        }

        System.out.println(ans);
    }

    private static int[][] parseGrid() {
        Scanner in = new Scanner(System.in);
        int[][] grid = new int[20][20];
        for (int r = 0; r < grid.length; r++) {
            String[] line = in.nextLine().split(" ");
            for (int c = 0; c < line.length; c++) {
                grid[r][c] = Integer.parseInt(line[c]);
            }
        }
        return grid;
    }
}
