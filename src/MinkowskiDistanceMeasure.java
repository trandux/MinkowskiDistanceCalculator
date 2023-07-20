// package edu.kit.informatik;

/**
 * This class contains 3 different method to calculate Minkowski-Distance between to vectors.
 *
 * @author upiol
 * @version 1.0
 */

public class MinkowskiDistanceMeasure {

    /**
     * Calculates Minkowski-Distance between two vectors with a given grade.
     *
     * @param p grade of Minkowski-Distance calculation as  integer. 1 if it is smaller than 1.
     * @param a first vector as integer array.
     * @param b second vector as integer array.
     * @return double Minkowski-Distance between two given vectors with given grade.
     */

    public static double calculateDistance(int p, int[] a, int[] b) {

        double gradeOfCalculation = (double) p; // converts p to double for right calculation

        if (p < 1) {

            gradeOfCalculation = 1.0;

        }

        double sum = 0;

        int vectorLength = 0;

        for (int number: a) {

            vectorLength++; // determines how long given vectors are.

        }

        for (int i = 0; i < vectorLength; i++) { // performs summation part of calculation.

            int currentDifference = a[i] - b[i];

            int currentAbsolute = Math.abs(currentDifference);

            double doubleAbsolute = (double) currentAbsolute;

            double currentPowered = Math.pow(doubleAbsolute, gradeOfCalculation);

            sum += currentPowered;

        }

        double result = Math.pow(sum, 1.0 / gradeOfCalculation); // performs exponential part of calculation.

        return result;

    }

    /**
     * Calculates Manhattan-Distance between two vectors.
     * @param a first vector as integer array.
     * @param b second vector as integer array.
     * @return double Manhattan-Distance between two given vectors.
     */

    public static double manhattanDistance(int[] a, int[] b) {

        final int grade = 1;

        return calculateDistance(grade, a, b);
    }

    /**
     * Calculates Euclidean-Distance between two vectors.
     * @param a first vector as integer array.
     * @param b second vector as integer array.
     * @return double Euclidean-Distance between two given vectors.
     */

    public static double euclideanDistance(int[] a, int[] b) {

        final int grade = 2;

        return calculateDistance(grade, a, b);

    }

}
