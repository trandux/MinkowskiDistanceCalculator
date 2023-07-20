// package edu.kit.informatik;

/**
 * This class contains 3 different methods to find the nearest neighbor path according to Minkowski-Distance
 * and to manipulate the result.
 *
 * @author upiol
 * @version 1.0
 */
public class NearestNeighborPath {

    final static String comma = ",";

    /**
     * Finds the nearest neighbor path of given vectors according to Minkowski-Distance
     *
     * @param p grade of Minkowski-Distance calculation as integer.
     * @param a set of vectors
     * @return the nearest neighbor path as int[][]
     */

    public static int[][] findPath(int p, int[][] a) {

        int vektorNumber = 0;

        int vektorLength = 0;

        for (int[] b : a) { // determines how many vectors are there

            vektorNumber++;

        }

        for (int d : a[0]) { // determines how long a vector is.

            vektorLength++;

        }

        int[][] path = new int[vektorNumber][vektorLength]; // creates path to be returned

        boolean[] visited = new boolean[vektorNumber];

        path[0] = a[0];

        visited[0] = true;

        for (int i = 1; i < vektorNumber; i++) {

            int minIndex = -1;

            double minDistance = Double.MAX_VALUE; // min distance is max so that first distance is always less than it

            for (int j = 1; j < vektorNumber; j++) {

                if (!visited[j]) {

                    double distance = MinkowskiDistanceMeasure.calculateDistance(p, path[i - 1], a[j]);

                    if (distance < minDistance) {

                        minDistance = distance;

                        minIndex = j;

                    }
                }
            }

            path[i] = a[minIndex]; // vector with the smallest distance gets added to the path

            visited[minIndex] = true; // added vector is now visited

        }

        return path;

    }

    /**
     * Makes the command line arguments set of vectors.
     *
     * @param args command lone arguments
     * @return vectors in command line arguments as int[][]
     */

    public static int[][] makeArgsVectors(String[] args) {

        int vectorNumberIndex = 0;

        int vectorLengthIndex = 0;

        String[] vectorLengthArray = args[1].split(comma);

        for (String vector: args) { // determines the number of vectors

            vectorNumberIndex++;

        }

        for (String vectorElement: vectorLengthArray) { // determine how long a vector is

            vectorLengthIndex++;

        }

        int vectorNumber = vectorNumberIndex - 1;

        // we subtract one from the result because first element of the args array is the grade of calculation.

        int vectorLength = vectorLengthIndex;

        int[][] allVectors = new int[vectorNumber][vectorLength];

        for (int i = 1; i < vectorNumber + 1; i++) { // this loop fills the two-dimensional return array

            String[] vectorInputsAsString = args[i].split(comma);

            for (int j = 0; j < vectorLength; j++) {

                allVectors[i - 1][j] = Integer.parseInt(vectorInputsAsString[j]);

            }

        }

        return allVectors;

    }

    /**
     * turns a set of vectors to string in requested format
     *
     * @param pathVectors vectors to be turned into string
     * @return string in requested format
     */

    public static String makeVectorsString(int[][] pathVectors) {

        String returnString = "";

        String vectorAsString = "";

        int vectorNumber = 0;

        int vectorLength = 0;

        for (int[] vector: pathVectors) { // determines the number of vector

            vectorNumber++;

        }

        for (int vectorElement: pathVectors[0]) { // determines how long a vector is

            vectorLength++;

        }

        for (int i = 0; i < vectorNumber; i++) {

            for (int j = 0; j < vectorLength; j++) {

                String currentVectorElementAsString = String.valueOf(pathVectors[i][j]);

                if (j == vectorLength - 1) { // does not add comma after a vector element if it is the last element

                    vectorAsString += currentVectorElementAsString;

                }

                else {
                    vectorAsString += currentVectorElementAsString + comma;

                }

            }

            vectorAsString = "(" + vectorAsString + ")"; // puts the vector in brackets.

            if (i == vectorNumber - 1) { // does not add arrow if ot is the last vector

                returnString += vectorAsString;

            }

            else {

                returnString += vectorAsString + " -> ";

            }

            vectorAsString = ""; // makes the string empty again for the next vector

        }

        return returnString;

    }

}
