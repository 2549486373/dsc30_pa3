import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SortsTest {

    @org.junit.jupiter.api.Test
    void insertionSort() {
        Sorts sort = new Sorts();
        ArrayList<Integer> test1 = new ArrayList<>();
        test1.add(4);
        test1.add(3);
        test1.add(5);
        test1.add(1);

        Integer[] result1 = {1, 3, 4, 5};
        sort.InsertionSort(test1, 0, 3);
        assertArrayEquals(result1, test1.toArray());


        ArrayList<Integer> test2 = new ArrayList<>();
        test2.add(4);
        test2.add(3);
        test2.add(3);
        test2.add(6);
        test2.add(34);
        test2.add(21);
        sort.InsertionSort(test2, 3, 5);
        Integer[] result2 = {4, 3, 3, 6, 21, 34};
        assertArrayEquals(test2.toArray(), result2);


        sort.InsertionSort(test2, 0, 5);
        Integer[] result3 = {3, 3, 4, 6, 21, 34};
        assertArrayEquals(test2.toArray(), result3);
    }

    @org.junit.jupiter.api.Test
    void mergeSort() {

    }

    @org.junit.jupiter.api.Test
    void quickSort() {
        Sorts sort = new Sorts();
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(1);
        arr1.add(9);
        arr1.add(6);
        arr1.add(0);
        arr1.add(4);

        sort.QuickSort(arr1, 0, 4);
        Integer[] result1 = {0, 1, 4, 6, 9};
        assertArrayEquals(result1, arr1.toArray());

        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(1);
        arr2.add(2);
        arr2.add(3);
        arr2.add(4);

        sort.QuickSort(arr2, 2, 3);
        assertArrayEquals(new Integer[] {1, 2, 3, 4},arr2.toArray());

        ArrayList<Integer> arr3 = new ArrayList<>();
        arr3.add(4);
        arr3.add(3);
        arr3.add(2);
        arr3.add(2);
        arr3.add(0);

        sort.QuickSort(arr3, 0, 4);

        assertArrayEquals(new Integer[] {0, 2, 2, 3, 4}, arr3.toArray());
    }

    @org.junit.jupiter.api.Test
    void modified_QuickSort() {
        Sorts sort = new Sorts();
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(1);
        arr1.add(9);
        arr1.add(6);
        arr1.add(0);
        arr1.add(4);

        sort.Modified_QuickSort(arr1, 0, 4, 3);
        Integer[] result1 = {0, 1, 4, 6, 9};
        assertArrayEquals(result1, arr1.toArray());

        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(1);
        arr2.add(2);
        arr2.add(3);
        arr2.add(4);

        sort.Modified_QuickSort(arr2, 2, 3, 3);
        assertArrayEquals(new Integer[] {1, 2, 3, 4},arr2.toArray());

        ArrayList<Integer> arr3 = new ArrayList<>();
        arr3.add(4);
        arr3.add(3);
        arr3.add(2);
        arr3.add(2);
        arr3.add(0);

        sort.Modified_QuickSort(arr3, 0, 4, 2);

        assertArrayEquals(new Integer[] {0, 2, 2, 3, 4}, arr3.toArray());
    }

    @org.junit.jupiter.api.Test
    void bucketSort() {
        Sorts sort = new Sorts();
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(1);
        arr1.add(9);
        arr1.add(6);
        arr1.add(0);
        arr1.add(4);

        Integer[] result1 = {0, 1, 4, 6, 9};
        assertArrayEquals(result1, sort.bucketSort(arr1).toArray());

        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(1);
        arr2.add(2);
        arr2.add(3);
        arr2.add(4);

        assertArrayEquals(new Integer[] {1, 2, 3, 4}, sort.bucketSort(arr2).toArray());

        ArrayList<Integer> arr3 = new ArrayList<>();
        arr3.add(4);
        arr3.add(3);
        arr3.add(2);
        arr3.add(2);
        arr3.add(0);

        assertArrayEquals(new Integer[] {0, 2, 2, 3, 4}, sort.bucketSort(arr3).toArray());

    }

    @org.junit.jupiter.api.Test
    void countSort() {
        Sorts sort = new Sorts();
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(1);
        arr1.add(9);
        arr1.add(6);
        arr1.add(0);
        arr1.add(4);

        assertArrayEquals(new Integer[] {0, 1, 4, 6, 9}, sort.countSort(arr1).toArray());

        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(new Integer[] {0, 1, 4, 6, 9}));

        assertArrayEquals(new Integer[] {0, 1, 4, 6, 9}, sort.countSort(arr2).toArray());


        ArrayList<Integer> arr3 = new ArrayList<>(Arrays.asList(new Integer[] {9, 4, 4, 1, 0}));

        assertArrayEquals(new Integer[] {0, 1, 4, 4, 9}, sort.countSort(arr3).toArray());

        ArrayList<Integer> arr4 = new ArrayList<>(Arrays.asList(new Integer[]{1, 4, 5, 6, 6, 7, 34, 345, 54}));

        assertArrayEquals(new Integer[]{1, 4, 5, 6, 6, 7, 34, 54, 345}, sort.countSort(arr4).toArray());

    }
}