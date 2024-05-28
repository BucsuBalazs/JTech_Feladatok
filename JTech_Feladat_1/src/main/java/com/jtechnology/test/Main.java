package com.jtechnology.test;

public class Main {
    public static void main(String[] args) {

        double[][] matrix = ConvertMatrixToDouble(TestDataI.MATRIX);

        double maxRowAverage = FindMaxOfRowAverages(matrix);
        System.out.println("The maximum row average is: " + maxRowAverage);
    }

    public static double[][] ConvertMatrixToDouble(String[][] stringMatrix) {
        int rows = stringMatrix.length;
        int cols = stringMatrix[0].length;
        double[][] matrix = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Double.parseDouble(stringMatrix[i][j]);
            }
        }

        return matrix;
    }

    public static double FindMaxOfRowAverages(double[][] matrix) {
        double max = Double.MIN_VALUE;

        for (double[] row : matrix) {
            double sum = 0;
            double divider = row.length;

            for (double num : row) {
                sum += num;
            }

            double average = sum / divider;
            max = Math.max(max, average);
        }

        return max;
    }
}