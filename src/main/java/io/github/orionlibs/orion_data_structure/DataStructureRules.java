package io.github.orionlibs.orion_data_structure;

import io.github.orionlibs.orion_assert.Assert;
import io.github.orionlibs.orion_data_structure.list.OrionList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class DataStructureRules
{
    public static void isNotNull(Collection<?> dataStructure)
    {
        Assert.notNull(dataStructure, "The input dataStructure cannot be null.");
    }


    public static void isNotNull(OrionList<?> dataStructure)
    {
        Assert.notNull(dataStructure, "The input dataStructure cannot be null.");
    }


    public static void isNotNull(DataStructure dataStructure)
    {
        Assert.notNull(dataStructure, "The input dataStructure cannot be null.");
    }


    public static void isNotEmpty(Collection<?> dataStructure)
    {
        isNotNull(dataStructure);
        Assert.notEmpty(dataStructure, "The input dataStructure cannot be empty.");
    }


    public static void isNotEmpty(OrionList<?> dataStructure)
    {
        isNotNull(dataStructure);
        Assert.notEmpty(dataStructure, "The input dataStructure cannot be empty.");
    }


    public static void isNotEmpty(DataStructure dataStructure)
    {
        isNotNull(dataStructure);
        if(dataStructure.isEmpty())
        {
            //throw new InvalidDataStructureException("Data structure cannot be empty.");
        }
    }


    public static void isNotNullAndNotEmpty(DataStructure dataStructure)
    {
        isNotEmpty(dataStructure);
    }


    public static void isNotEmpty(int size)
    {
        Assert.isPositive(size, "Data structure size should not be 0.");
    }


    public static void isValidSize(int size)
    {
        Assert.isNonNegative(size, "Data structure size cannot be negative.");
    }


    public static void isValidIndex(int index)
    {
        Assert.isNonNegative(index, "Index cannot be negative.");
    }


    public static void isValidIndex(int size, int index) throws InvalidDataStructureException
    {
        isValidSize(size);
        isValidIndex(index);
        if(index >= size)
        {
            throw new InvalidDataStructureException("Index cannot be >= size of the data structure.");
        }
    }


    public static void isValidIndexInclusive(int size, int index) throws InvalidDataStructureException
    {
        isValidSize(size);
        isValidIndex(index);
        if(index > size)
        {
            throw new InvalidDataStructureException("Index cannot be > size of the data structure.");
        }
    }


    public static void isValidDivisorOfSize(int divisor)
    {
        Assert.isPositive(divisor, "Data structure can only be divided in at least 1 substructures.");
    }


    public static void areValidIndices(int size, int startIndex, int endIndex)
    {
        DataStructureRules.isValidSize(size);
        Assert.isNonNegative(startIndex, "startIndex cannot be negative: " + startIndex);
        Assert.isNonNegative(endIndex, "endIndex cannot be negative: " + endIndex);
        if(startIndex > endIndex || endIndex >= size)
        {
            throw new ArrayIndexOutOfBoundsException("Required: startIndex <= endIndex < size");
        }
    }


    public static void areValidIndicesInclusive(int size, int startIndex, int endIndex)
    {
        DataStructureRules.isValidSize(size);
        Assert.isNonNegative(startIndex, "startIndex cannot be negative: " + startIndex);
        Assert.isNonNegative(endIndex, "endIndex cannot be negative: " + endIndex);
        if(startIndex > endIndex || endIndex > size)
        {
            throw new ArrayIndexOutOfBoundsException("Required: startIndex <= endIndex <= size");
        }
    }


    public static void areValidIndices(int[] indices)
    {
        Assert.notEmpty(indices, "Indices is null/empty.");
        Arrays.stream(indices).forEach(index -> DataStructureRules.isValidIndex(index));
    }


    public static void areValidIndices(int size, int[] indices)
    {
        Assert.notEmpty(indices, "Indices is null/empty.");
        Arrays.stream(indices).forEach(index ->
        {
            try
            {
                DataStructureRules.isValidIndex(size, index);
            }
            catch(InvalidDataStructureException e)
            {
                //
            }
        });
    }


    public static void areValidIndices(List<Integer> indices)
    {
        Assert.notEmpty(indices, "Indices is null/empty.");
        indices.forEach(index -> DataStructureRules.isValidIndex(index));
    }


    public static void areValidIndices(int size, List<Integer> indices)
    {
        Assert.notEmpty(indices, "Indices is null/empty.");
        indices.forEach(index ->
        {
            try
            {
                DataStructureRules.isValidIndex(size, index);
            }
            catch(InvalidDataStructureException e)
            {
                //
            }
        });
    }
}