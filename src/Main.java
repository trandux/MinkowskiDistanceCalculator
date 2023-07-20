// package edu.kit.informatik;

/**
 * This class serves as a entry point for the program and contains main method.
 *
 * <p> This program takes a grade for Minkowski-Distance calculation and a set of vectors as command-line arguments and
 * calculates the nearest neighbor path according to Minkowski-Distance with the given grade.
 * The result is then displayed on console
 *
 * <p>Usage: java Main [grade] [firstVector] [secondVector]...
 *
 * @author upiol
 * @version 1.0
 */

public class Main {

    /**
     * This is the entry point of the program.
     *
     * @param args contains the vectors and the grade for Minkowski-Distance calculation.
     *
     */

    public static void main(String[] args) {

        int p = Integer.parseInt(args[0]);

        int[][] allVectors = NearestNeighborPath.makeArgsVectors(args);

        int[][] pathVectors = NearestNeighborPath.findPath(p, allVectors);

        String returnString = NearestNeighborPath.makeVectorsString(pathVectors);

        System.out.println(returnString);

    }
}