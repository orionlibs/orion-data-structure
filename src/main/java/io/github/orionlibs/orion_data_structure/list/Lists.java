package io.github.orionlibs.orion_data_structure.list;

import java.util.List;

public class Lists
{
    @SuppressWarnings("rawtypes")
    public static boolean isNotEmpty(List list)
    {
        return list != null && !list.isEmpty();
    }


    @SuppressWarnings("rawtypes")
    public static boolean isNullOrEmpty(List list)
    {
        return list == null || list.isEmpty();
    }


    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(List list)
    {
        return list != null && list.isEmpty();
    }


    public static boolean isValidSize(int size)
    {
        return size >= 0;
    }


    public static boolean isValidIndex(int index)
    {
        return index >= 0;
    }


    public static boolean isValidIndex(int size, int index)
    {
        return isValidSize(size) && isValidIndex(index) && index < size;
    }


    public static boolean isValidIndexInclusive(int size, int index)
    {
        return isValidSize(size) && isValidIndex(index) && index <= size;
    }


    public static boolean areIndicesWithinRange(int size, int startIndex, int endIndex)
    {
        return isValidIndex(size, startIndex)
                        && isValidIndex(size, endIndex)
                        && startIndex <= endIndex;
    }


    public static boolean areIndicesWithinRangeInclusive(int size, int startIndex, int endIndex)
    {
        return isValidIndex(size, startIndex)
                        && isValidIndexInclusive(size, endIndex)
                        && startIndex <= endIndex;
    }


    public static boolean areIndicesNotWithinRange(int size, int startIndex, int endIndex)
    {
        return !areIndicesWithinRange(size, startIndex, endIndex);
    }


    public static boolean areIndicesNotWithinRangeInclusive(int size, int startIndex, int endIndex)
    {
        return !areIndicesWithinRangeInclusive(size, startIndex, endIndex);
    }
}