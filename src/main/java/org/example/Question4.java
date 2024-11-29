package org.example;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Name:
 * Class Group:
 */

public class Question4  // Flood Fill (Stack, 2D Array)
{
    static final int MAX_ROWS = 5;
    static final int MAX_COLS = 5;

    public static void main(String[] args) {
        System.out.println("Question 4. Floodfill algorithm.");

        // Starter matrix (2D Array) with 0 representing an empty cell,
        // and -1 representing a wall. Flood fill can not cross through
        // a wall ( and not pass through diagionally).
        //
        int[][] matrix = new int[MAX_ROWS][MAX_COLS]; // 2D Array of int
        // define values for each row, -1 to prevent change
        matrix[0] = new int[]{ 0, 0, -1, -1, 0};
        matrix[1] = new int[]{ 0, 0, -1, -1, 0};
        matrix[2] = new int[]{-1, 0,  0,  0, 0};
        matrix[3] = new int[]{-1, 0, -1, -1, 0};
        matrix[4] = new int[]{ 0,-1, -1,  0, 0};

        display(matrix);

    }

    /*
        Helper function to display the 2D Array
     */
    public static void display(int[][] arr) {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                System.out.printf("%4d", arr[x][y]);
            }
            System.out.println();
        }
    }

    private static void floodFill(int r, int c, int[][] arr) {

    }

}
