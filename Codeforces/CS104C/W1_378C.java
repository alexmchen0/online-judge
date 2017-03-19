import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Alex on 1/30/17.
 * Problem: Maze
 * http://codeforces.com/problemset/problem/378/C
 */
public class W1_378C {
    private static int[] dr = {1, 0, -1, 0};
    private static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numRows = in.nextInt();
        int numCols = in.nextInt();
        int numToAdd = in.nextInt();
        in.nextLine();

        char grid[][] = new char[numRows][numCols];
        for (int r = 0; r < numRows; r++) {
            grid[r] = in.nextLine().toCharArray();
        }

        int numsAdjWalls[][] = new int[numRows][numCols];
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {
                int numAdjWalls = 0;
                if (grid[r][c] == '#') {
                    numsAdjWalls[r][c] = -1;
                    continue;
                }

                for (int d = 0; d < 4; d++) {
                    int newR = r + dr[d];
                    int newC = c + dc[d];

                    if (newR < 0 || newR >= numRows || newC < 0 || newC >= numCols ||
                            grid[newR][newC] == '#' || grid[newR][newC] == 'X') {
                        numAdjWalls++;
                    }
                }

                numsAdjWalls[r][c] = numAdjWalls;
            }
        }
/*
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {
                if (numsAdjWalls[r][c] == -1) {
                    System.out.print("-");
                } else {
                    System.out.print(numsAdjWalls[r][c]);
                }
            }
            System.out.println();
        }
        System.out.println();
        */

        LinkedList<Cell> toCheck = new LinkedList<>();
        if (numToAdd != 0) {
            search:
            for (int r = 0; r < numRows; r++) {
                for (int c = 0; c < numCols; c++) {
                    toCheck.add(new Cell(r, c));
                    while (!toCheck.isEmpty()) {
                        Cell cell = toCheck.pop();
                        if (cell.r < 0 || cell.r >= numRows || cell.c < 0 || cell.c >= numCols ||
                                numsAdjWalls[cell.r][cell.c] == -1) {
                            continue;
                        }
                        if (numsAdjWalls[cell.r][cell.c] >= 3) {
                            numsAdjWalls[cell.r][cell.c] = -1;
                            grid[cell.r][cell.c] = 'X';
                            numToAdd--;
                            if (numToAdd == 0) {
                                break search;
                            }

                            for (int d = 0; d < 4; d++) {
                                int newR = cell.r + dr[d];
                                int newC = cell.c + dc[d];

                                if (newR < 0 || newR >= numRows || newC < 0 || newC >= numCols ||
                                        numsAdjWalls[newR][newC] == -1) {
                                    continue;
                                }

                                numsAdjWalls[newR][newC]++;
                                toCheck.push(new Cell(newR, newC));
                            }
                        }
                    }
                }
            }
        }

        if (numToAdd != 0) {
            toCheck = new LinkedList<>();
            search:
            for (int r = 0; r < numRows; r++) {
                for (int c = 0; c < numCols; c++) {
                    if (numsAdjWalls[r][c] >= 2) {
                        numsAdjWalls[r][c] = -1;
                        grid[r][c] = 'X';
                        numToAdd--;
                        if (numToAdd == 0) {
                            break search;
                        }

                        for (int d = 0; d < 4; d++) {
                            int newR = r + dr[d];
                            int newC = c + dc[d];

                            if (newR < 0 || newR >= numRows || newC < 0 || newC >= numCols ||
                                    numsAdjWalls[newR][newC] == -1) {
                                continue;
                            }

                            numsAdjWalls[newR][newC]++;
                            toCheck.push(new Cell(newR, newC));
                        }
                    }

                    while (!toCheck.isEmpty()) {
                        Cell cell = toCheck.pop();
                        if (cell.r < 0 || cell.r >= numRows || cell.c < 0 || cell.c >= numCols ||
                                numsAdjWalls[cell.r][cell.c] == -1) {
                            continue;
                        }
                        if (numsAdjWalls[cell.r][cell.c] >= 3) {
                            numsAdjWalls[cell.r][cell.c] = -1;
                            grid[cell.r][cell.c] = 'X';
                            numToAdd--;
                            if (numToAdd == 0) {
                                break search;
                            }

                            for (int d = 0; d < 4; d++) {
                                int newR = cell.r + dr[d];
                                int newC = cell.c + dc[d];

                                if (newR < 0 || newR >= numRows || newC < 0 || newC >= numCols ||
                                        numsAdjWalls[newR][newC] == -1) {
                                    continue;
                                }

                                numsAdjWalls[newR][newC]++;
                                toCheck.push(new Cell(newR, newC));
                            }
                        }
                    }
                }
            }
        }
/*
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {
                if (numsAdjWalls[r][c] == -1) {
                    System.out.print("-");
                } else {
                    System.out.print(numsAdjWalls[r][c]);
                }
            }
            System.out.println();
        }
        System.out.println();
*/
        print:
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {
                System.out.print(grid[r][c]);
            }
            System.out.println();
        }
    }

    public static class Cell {
        int r, c;

        Cell(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
