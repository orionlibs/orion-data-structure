package io.github.orionlibs.orion_data_structure.array;

import io.github.orionlibs.orion_assert.Assert;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ArrayRules
{
    public static void isValidIndex(int size, int index)
    {
        Assert.withinRange(index, 0, size - 1, "The given index is out of bounds.");
    }


    public static void isValid(int size)
    {
        Assert.isNonNegative(size, "Array size cannot be negative.");
    }


    public static void isValid(int[] indices)
    {
        Assert.notEmpty(indices, "Indices is null/empty.");
        Arrays.stream(indices).forEach(index -> isValid(index));
    }


    public static void isValid(List<Integer> indices)
    {
        Assert.notEmpty(indices, "Indices is null/empty.");
        indices.forEach(index -> isValid(index));
    }


    public static void isValid(Class<?> classToCastElementsTo)
    {
        Assert.notNull(classToCastElementsTo, "ClassToCastElementsTo is null.");
    }


    public static void isValid(Collection<?> elementsToAdd)
    {
        Assert.notNull(elementsToAdd, "elementsToAdd is null.");
    }


    public static <T> void isValid(T[] array)
    {
        Assert.notEmpty(array, "Array is null or empty.");
    }


    public static <T> void isValid(T[][] array)
    {
        Assert.notEmpty(array, "Array is null or empty.");
        Arrays.stream(array).forEach(a -> isValid(a));
    }
}