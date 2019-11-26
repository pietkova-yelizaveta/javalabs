package lab1;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int MAX_RANDOM_VALUE = 10;
    private static Object matrixFill;

    public static void main(String[] args) {
        int[][] matrix = getMatrix();
        MatrixCalculator matrixCalculator = new MatrixCalculator();
        System.out.println("Maximum is " + matrixCalculator.getMax(matrix));
        System.out.println("Minimum is " + matrixCalculator.getMin(matrix));
        System.out.println("Sum is " + matrixCalculator.getSum(matrix));
    }

    private static int[][] getMatrix() {
        boolean returner = false;
        int[][] matrix = null;
        do {
            System.out.println("Matrix build option:\n press 1 for Manual\n press 2 for Auto");
            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    matrix = createAndFillMatrix();
                    printMatrix(matrix);
                    break;
                case 2:
                    matrix = createAndFillMatrix(new Random());
                    printMatrix(matrix);
                    break;
                default:
                    System.out.println("Invalid choice");
                    returner = true;
                    break;
            }
        } while (returner == true);
        return matrix;
    }

    private static int[][] createAndFillMatrix() {
        Scanner scanner = new Scanner(System.in);
        int length = getLength(scanner);
        int width = getWidth(scanner);
        int[][] matrix = new int[length][width];

        System.out.println("Enter Matrix Data");
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                System.out.println("enter element [" + i + " ," + j + "]");
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static int[][] createAndFillMatrix(Random random) {
        Scanner scanner = new Scanner(System.in);
        int length = getLength(scanner);
        int width = getWidth(scanner);
        int[][] matrix = new int[length][width];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = random.nextInt(MAX_RANDOM_VALUE);
            }
        }
        return matrix;
    }

    private static int getLength(Scanner scanner) {
        System.out.println("Enter The Number Of Matrix Length");
        return scanner.nextInt();
    }

    private static int getWidth(Scanner scanner) {
        System.out.println("Enter The Number Of Matrix Width");
        return scanner.nextInt();
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println("Your Matrix is : ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

