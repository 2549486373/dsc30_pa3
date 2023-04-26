/*
 * NAME: Ziyu Huang
 * PID:  A17678575
 */

import java.util.ArrayList;

/**
 * The class will run all different sorting methods, and compare their running time
 * @author Ziyu Huang
 * @since 04/24/2023
 */
public class RuntimeAnalysis {

    private static final int NUM_DATA = 10000;
    private static final int NUM_RUN = 10;
    private static final int NUM_TEST = 5;
    private static final int MIN = 0;
    private static final int MAX = 100000;

    /**
     * Returns an ArrayList of random numbers
     *
     * @param size the number of random numbers wanted
     * @param min the min value for random number
     * @param max the max value for random number
     * @return an ArrayList of random numbers
     */
    public static ArrayList<Integer> randomNumbers(int size, int min, int max) {

        ArrayList<Integer> randNums = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            randNums.add((int) (Math.random() * ((max - min) + 1)) + min);
        }
        return randNums;
    }

    /**
     * Returns a deep copy of the input array list.
     *
     * @param data list to copy
     * @return a deep copy of the list
     */
    private static ArrayList<Integer> deepCopyArrayList(ArrayList<Integer> data) {
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer d : data) {
            result.add(d);
        }
        return result;
    }

    /**
     * Times the insertion sort.
     * @param data list of data to sort
     * @param numRun the number of trials to run
     */
    public static void timeInsertionSort(ArrayList<Integer> data, int numRun) {
        long startTime = 0, endTime = 0, totalTime = 0;
        Sorts sorts = new Sorts();
        ArrayList<Integer> temp = deepCopyArrayList(data);
        for (int i = 0; i < numRun; i++) {
            data = deepCopyArrayList(temp);
            startTime = System.currentTimeMillis();
            sorts.InsertionSort(data, 0, data.size() - 1);
            endTime = System.currentTimeMillis();
            totalTime += (endTime - startTime);
        }
        System.out.println("Benchmarking insertion sort: ");
        System.out.println("Number of data to sort: " + data.size());
        System.out.println("Average time taken to sort: " + totalTime / numRun + " ms");
        System.out.println();
    }

    /**
     * Times the merge sort.
     * @param data list of data to sort
     * @param numRun the number of trials to run
     */
    public static void timeMergeSort(ArrayList<Integer> data, int numRun) {
        long startTime = 0, endTime = 0, totalTime = 0;
        Sorts sorts = new Sorts();
        ArrayList<Integer> temp = deepCopyArrayList(data);
        for (int i = 0; i < numRun; i++) {
            data = deepCopyArrayList(temp);
            startTime = System.currentTimeMillis();
            sorts.MergeSort(data, 0, data.size() - 1);
            endTime = System.currentTimeMillis();
            totalTime += (endTime - startTime);
        }
        System.out.println("Benchmarking merge sort: ");
        System.out.println("Number of data to sort: " + data.size());
        System.out.println("Average time taken to sort: " + totalTime / numRun + " ms");
        System.out.println();
    }

    /**
     * Times the Quicksort.
     * @param data list of data to sort
     * @param numRun the number of trials to run
     */
    public static void timeQuickSort(ArrayList<Integer> data, int numRun) {
        long startTime = 0, endTime = 0, totalTime = 0;
        Sorts sorts = new Sorts();
        ArrayList<Integer> temp = deepCopyArrayList(data);
        for (int i = 0; i < numRun; i++) {
            data = deepCopyArrayList(temp);
            startTime = System.currentTimeMillis();
            sorts.QuickSort(data, 0, data.size() - 1);
            endTime = System.currentTimeMillis();
            totalTime += (endTime - startTime);
        }
        System.out.println("Benchmarking quick sort: ");
        System.out.println("Number of data to sort: " + data.size());
        System.out.println("Average time taken to sort: " + totalTime / numRun + " ms");
        System.out.println();
    }

    /**
     * Times the modified Quicksort.
     * @param data list of data to sort
     * @param numRun the number of trials to run
     * @param param the extra parameter the sorting algorithm takes (cutoff)
     */
    public static void timeModifiedQuickSort(ArrayList<Integer> data, int numRun, int param) {
        long startTime = 0, endTime = 0, totalTime = 0;
        Sorts sorts = new Sorts();
        ArrayList<Integer> temp = deepCopyArrayList(data);

        for (int i = 0; i < numRun; i++) {
            data = deepCopyArrayList(temp);
            startTime = System.currentTimeMillis();
            sorts.Modified_QuickSort(data, 0, data.size() - 1, param);
            endTime = System.currentTimeMillis();
            totalTime += (endTime - startTime);
        }
        System.out.println("Modified QuickSort Cutoff Value: " + param);
        System.out.println("Benchmarking quick sort: ");
        System.out.println("Number of data to sort: " + data.size());
        System.out.println("Average time taken to sort: " + totalTime / numRun + " ms");
        System.out.println();
    }

    /**
     * Times the bucket sort.
     * @param data list of data to sort
     * @param numRun the number of trials to run
     */
    public static void timeBucketSort(ArrayList<Integer> data, int numRun) {
        long startTime, endTime, totalTime = 0;
        Sorts sorts = new Sorts();
        ArrayList<Integer> temp = deepCopyArrayList(data);
        for (int i = 0; i < numRun; i++) {
            ArrayList<Integer> sortedArray;
            data = deepCopyArrayList(temp);
            startTime = System.currentTimeMillis();
            sortedArray = sorts.bucketSort(data);
            endTime = System.currentTimeMillis();
            totalTime += (endTime - startTime);
        }
        System.out.println("Benchmarking bucket sort: ");
        System.out.println("Number of data to sort: " + data.size());
        System.out.println("Average time taken to sort: " + totalTime / numRun + " ms");
        System.out.println();
    }

    /**
     * Times countSort.
     * @param data list of data to sort
     * @param numRun the number of trials to run
     */
    public static void timeCountSort(ArrayList<Integer> data, int numRun) {
        long startTime = 0, endTime = 0, totalTime = 0;
        Sorts sorts = new Sorts();
        ArrayList<Integer> temp = deepCopyArrayList(data);
        for (int i = 0; i < numRun; i++) {
            ArrayList<Integer> sortedArray;
            data = deepCopyArrayList(temp);
            startTime = System.currentTimeMillis();
            sortedArray = sorts.countSort(data);
            endTime = System.currentTimeMillis();
            totalTime += (endTime - startTime);
        }
        System.out.println("Benchmarking count sort: ");
        System.out.println("Number of data to sort: " + data.size());
        System.out.println("Average time taken to sort: " + totalTime / numRun + " ms");
        System.out.println();
    }

    /**
     * Main method to run the time methods. Modify it as you need.
     * @param args arguments (not used)
     */
    public static void main(String[] args) {
        int numData;
        ArrayList<Integer> data;

        //task1
        numData = NUM_DATA;
        for (int i = 0; i < NUM_TEST; i++) {
            data = randomNumbers(numData, MIN, MAX);
            timeCountSort(data, NUM_RUN);
            timeInsertionSort(data, NUM_RUN);
            timeMergeSort(data, NUM_RUN);
            numData += numData;
        }



        //task 2
        numData = 1000000;
        int[] cutoffs = {2, 4, 8, 16, 32, 64, 128};
        for (int cutoff : cutoffs) {
            data = randomNumbers(numData, MIN, MAX);
            timeModifiedQuickSort(data, 3, cutoff);
        }


        //task 3
        numData = 100000;
        int fastCut = 4;
        for (int i = 0; i < NUM_TEST; i++) {
            data = randomNumbers(numData, MIN, MAX);
            timeModifiedQuickSort(data, 5, fastCut);
            timeQuickSort(data, NUM_RUN);
            numData += 100000;
        }




        //task 4
        numData = NUM_DATA;
        for (int i = 0; i < NUM_TEST; i++) {
            data = randomNumbers(numData, MIN, MAX);
            timeInsertionSort(data, NUM_RUN);
            timeBucketSort(data, NUM_RUN);
            numData += numData;
        }

        //task 5
        int newMax = 800000;
        int numData1 = 50000;
        int numData2 = 200000;
        int numTest = 5;
        int numRun = 10;
        for (int i = 0; i < numTest; i++) {
            ArrayList<Integer> data1 = randomNumbers(numData1, MIN, newMax);
            ArrayList<Integer> data2 = randomNumbers(numData2, MIN, newMax);
            timeCountSort(data1, numRun);
            timeCountSort(data2, numRun);
            timeQuickSort(data1, numRun);
            timeQuickSort(data2, numRun);
            newMax += newMax;
        }
    }
}