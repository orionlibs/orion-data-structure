package io.github.orionlibs.orion_data_structure;

import java.util.Collection;
import java.util.function.IntFunction;
import java.util.function.Predicate;

public interface SingleArgumentOrderedIndexedDataStructure<T> extends SingleArgumentDataStructure<T>, OrderedDataStructure, IndexedDataStructure
{
    public void prepend(T element);


    public void prependIf(T element, Predicate<T> filterToApply);


    public default void prependIfNotNull(T element)
    {
        if(element != null)
        {
            prepend(element);
        }
    }


    public void prepend(T[] elements);


    public void prepend(Collection<T> elements);


    public int getIndexOf(T element);


    public default int getIndexOfElementWithinRangeOf(T element, int startIndex, int endIndex)
    {
        return getIndexOfElementWithinRangeOfInclusive(element, startIndex, endIndex - 1);
    }


    public int getIndexOfElementWithinRangeOfInclusive(T element, int startIndex, int endIndex);


    public default int getLastIndexOfElementWithinRangeOf(T element, int startIndex, int endIndex)
    {
        return getLastIndexOfElementWithinRangeOfInclusive(element, startIndex, endIndex - 1);
    }


    public int getLastIndexOfElementWithinRangeOfInclusive(T element, int startIndex, int endIndex);


    public default int getNumberOfElementsBefore(T element)
    {
        return getIndexOf(element);
    }


    public default int getNumberOfElementsAfter(T element) throws InvalidDataStructureException
    {
        return getNumberOfElementsAfter(getIndexOf(element));
    }


    public void fill(T element, int startIndex, int endIndex);


    public void fillWithEndIndexInclusive(T element, int startIndex, int endIndex);


    public void setAll(IntFunction<? extends T> generatorFunction);


    public void setAllParallel(IntFunction<? extends T> generatorFunction);


    public int getIndexOfFirstMismatch(SingleArgumentOrderedIndexedDataStructure<T> other);
}