package Lesson7HW;

public class Array2D {

    public static void main(String[] args) {
        int[][] matrix = {
                {3, 3, 4, 5, 9, 10},
                {1, 3, 2, 2, 2, 4},
                {1, 1, 4, 3, 5, 5},
                {8, -4, 2, 3, 5, 6},
                {3, 44, 4, 3, -5, 5},
                {1, 22, 4, 43, 5, 5},
        };

        // 1a. Calculate the sum above right diagonal
        int count = 1;
        int sumAboveRightDiagonal = 0;

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - count ; j++) {
                sumAboveRightDiagonal += matrix[i][j];
            }
            count++;
        }

        System.out.println(sumAboveRightDiagonal);


        // 1b. Calculate the sum below right diagonal
        int sumBelowRightDiagonal = 0;


        for (int i = 1; i < matrix.length ; i++) {
            for (int j = matrix[i].length -1 ;  j > matrix[i].length - 1 - i; j--) {
                sumBelowRightDiagonal += matrix[i][j];
            }
        }

        System.out.println(sumBelowRightDiagonal);


        // 2. Calculate the sum above both diagonals
        // only works on squares 3x3,4x4,5x5

        int sumAboveBothDiagonals = 0;
        int lastRow = 0;

        if(matrix.length % 2 == 0) {
            lastRow = matrix.length / 2 - 1;
        } else {
            lastRow = matrix.length / 2;
        }

        for (int i = 0; i < lastRow ; i++) {
            for (int j = 0; j < matrix[i].length  - 1 - i; j++) {
                if(j >= i+1) {
                    sumAboveBothDiagonals += matrix[i][j];
                }
            }
        }

        System.out.println(sumAboveBothDiagonals);

    }
}
