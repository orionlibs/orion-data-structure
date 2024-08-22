package io.github.orionlibs.orion_data_structure.array;

import java.util.Arrays;
import java.util.Comparator;

public class ArraySearchService<T>
{
    public static int search(byte[] array, byte key)
    {
        ArraySortService.sort(array);
        return searchOrderedArray(array, key);
    }


    public static int search(short[] array, short key)
    {
        ArraySortService.sort(array);
        return searchOrderedArray(array, key);
    }


    public static int search(int[] array, int key)
    {
        ArraySortService.sort(array);
        return searchOrderedArray(array, key);
    }


    public static int search(long[] array, long key)
    {
        ArraySortService.sort(array);
        return searchOrderedArray(array, key);
    }


    public static int search(float[] array, float key)
    {
        ArraySortService.sort(array);
        return searchOrderedArray(array, key);
    }


    public static int search(double[] array, double key)
    {
        ArraySortService.sort(array);
        return searchOrderedArray(array, key);
    }


    public static int search(char[] array, char key)
    {
        ArraySortService.sort(array);
        return searchOrderedArray(array, key);
    }


    public static <T> int search(T[] array, T key)
    {
        ArraySortService.<T>sort(array);
        return searchOrderedArray(array, key);
    }


    public static <T> int search(T[] array, T key, Comparator<T> comparator)
    {
        ArraySortService.<T>sort(array, comparator);
        return searchOrderedArray(array, key);
    }


    public static int searchOrderedArray(byte[] array, byte key)
    {
        return Arrays.binarySearch(array, key);
    }


    public static int searchOrderedArray(short[] array, short key)
    {
        return Arrays.binarySearch(array, key);
    }


    public static int searchOrderedArray(int[] array, int key)
    {
        return Arrays.binarySearch(array, key);
    }


    public static int searchOrderedArray(long[] array, long key)
    {
        return Arrays.binarySearch(array, key);
    }


    public static int searchOrderedArray(float[] array, float key)
    {
        return Arrays.binarySearch(array, key);
    }


    public static int searchOrderedArray(double[] array, double key)
    {
        return Arrays.binarySearch(array, key);
    }


    public static int searchOrderedArray(char[] array, char key)
    {
        return Arrays.binarySearch(array, key);
    }


    public static <T> int searchOrderedArray(T[] array, T key)
    {
        return Arrays.binarySearch(array, key);
    }
}