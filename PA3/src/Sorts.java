/*
 * NAME: Ziyu Huang
 * PID:  A17678575
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
/**
 * the sort class will create six methods which implements six different sorting algorithms(Insertion sort, Quick Sort
 * Counting Sort, Merge Sort, Modified Quick Sort, Bucket Sort)
 * @author Ziyu Huang
 * @since 04/24/2023
 */

public class Sorts {

    /**
     * This method performs insertion sort on the input arraylist
     *
     * @param list The arraylist we want to sort
     * @param start The initial index on subsection of Arraylist we want to sort
     * @param end The final index of the subsection of Arraylist we want to sort
     */
    public void InsertionSort(ArrayList<Integer> list, int start, int end) {
        for (int i = start; i <= end; i++) {
            while ((i > start) && (list.get(i) < list.get(i - 1))) {
                Integer temp = list.get(i);
                list.set(i, list.get(i - 1));
                list.set(i - 1, temp);
                i--;
            }
        }
    }

    /**
     * This method performs merge sort on the input arraylist
     *
     * @param list The arraylist we want to sort
     * @param start The initial index on subsection of Arraylist we want to sort
     * @param end The final index of the subsection of Arraylist we want to sort
     */
    public void MergeSort(ArrayList<Integer> list, int start, int end) {

        if (start < end) {
            int mid = start + (end - start) / 2;
            MergeSort(list, start, mid);
            MergeSort(list, mid + 1, end);

            merge(list, start, mid, end);
        }
    }

    /**
     * merge helper function for MergeSort
     *
     * @param arr The arraylist we want to sort
     * @param l left-most index we want to merge
     * @param m the middle index we want to merge
     * @param r right-most index we want to merge
     */
    private void merge(ArrayList<Integer> arr, int l, int m, int r) {

        int mergedSize = r - l + 1;

        ArrayList<Integer> mergedNums = new ArrayList<>();
        int left = l, right = m + 1;
        while (left <= m && right <= r) {
            if (arr.get(left).compareTo(arr.get(right)) <= 0) {
                mergedNums.add(arr.get(left));
                left++;
            } else {
                mergedNums.add(arr.get(right));
                right++;
            }
        }

        while (left <= m) {
            mergedNums.add(arr.get(left));
            left++;
        }
        while (right <= r) {
            mergedNums.add(arr.get(right));
            right++;
        }
        for (int i = 0; i < mergedSize; i++) {
            arr.set(l + i, mergedNums.get(i));
        }
    }

    /**
     * This method performs merge sort on the input arraylist
     *
     * @param list The arraylist we want to sort
     * @param start The initial index on subsection of Arraylist we want to sort
     * @param end The final index of the subsection of Arraylist we want to sort
     */
    public void QuickSort(ArrayList<Integer> list, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(list, start, end);

            QuickSort(list, pivotIndex + 1, end);
            QuickSort(list, start, pivotIndex);
        }
    }

    /** This method will rearrange
     * @param arr the array that is ready for rearrange
     * @param h represent the higher bound of the quick sort
     * @param l represent the lower bound of the quick sort
     * */
    private int partition(ArrayList<Integer> arr, int l, int h) {
        int mid = (l + h) / 2;
        Integer pivot = arr.get(mid);
        int i = l;
        int j = h;

        while (i <= j) {
            // Increment i until arr[i] >= pivot
            while (arr.get(i) < pivot) {
                i++;
            }

            // Decrement j until arr[j] <= pivot
            while (arr.get(j) > pivot) {
                j--;
            }

            if (i < j) {
                Integer temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
                i++;
                j--;
            } else {
                break;
            }

        }

        return mid;
    }
    /**
     * This method perform a*/
    public void Modified_QuickSort(ArrayList<Integer> list, int start, int end, int cutoff) {
        if (start < end) {
            int pivotIndex = partition(list, start, end);
            if (end - start <= cutoff) {
                InsertionSort(list, start, end);
            } else {
                Modified_QuickSort(list, pivotIndex + 1, end, cutoff);
                Modified_QuickSort(list, start, pivotIndex , cutoff);
            }
        }
    }

    /**
     * this helper finds the appropriate number of buckets you should allocate
     * based on the range of the values in the input list
     * @param list the input list to bucket sort
     * @return number of buckets
     */
    private int assignNumBuckets(ArrayList<Integer> list) {
        Integer max = Collections.max(list);
        Integer min = Collections.min(list);
        return (int) Math.sqrt(max - min) + 1;
    }

    /**
     * this helper finds the appropriate bucket index that a data should be
     * placed in
     * @param data a particular data from the input list if you are using
     *             loop iteration
     * @param numBuckets number of buckets
     * @param listMin the smallest element of the input list
     * @return the index of the bucket for which the particular data should
     * be placed in
     */
    private int assignBucketIndex(Integer data, int numBuckets, Integer listMin) {
        return (data - listMin) / numBuckets;
    }

    /**
     *
     * the method will perform bucket sort algorithms
     *
     * @param list the array that is ready to be sorted
     * */
    public ArrayList<Integer> bucketSort(ArrayList<Integer> list) {
        int numBucket = assignNumBuckets(list);
        int minValue = Collections.min(list);
        ArrayList<Integer>[] buckets = new ArrayList[numBucket];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (Integer elem : list) {
            int index = assignBucketIndex(elem, numBucket, minValue);
            buckets[index].add(elem);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (ArrayList<Integer> bucket : buckets) {
            InsertionSort(bucket, 0, bucket.size() - 1);
            for (Integer elem : bucket) {
                if (elem != null) {
                    result.add(elem);
                }
            }
        }
        return result;

    }


    /**
     * The method will perform a counting sort Algorithm.
     * @list the input array that is ready for counting
     * @return the method will return another Arraylist that contains the sorted the list.
     * */
    public ArrayList<Integer> countSort(ArrayList<Integer> list) {
        Integer max = Collections.max(list);

        int[] count = new int[max + 1];
        for (int i = 0; i < list.size(); i++) {
            count[list.get(i)]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        Integer[] result = new Integer[list.size()];
        for (Integer elem : list) {
            int index = count[elem] - 1;
            count[elem]--;
            result[index] = elem;
        }

        ArrayList<Integer> finalResult = new ArrayList<>(Arrays.asList(result));
        return finalResult;
    }
}


