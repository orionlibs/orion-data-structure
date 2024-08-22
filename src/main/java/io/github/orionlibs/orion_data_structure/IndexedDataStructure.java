package io.github.orionlibs.orion_data_structure;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

public interface IndexedDataStructure extends DataStructure
{
    public void delete(int index);


    public void delete(int[] indices);


    public void delete(List<Integer> indices);


    public void deleteAllOccurencesOf(int[] indices);


    public void deleteAllOccurencesOf(List<Integer> indices);


    public void deleteRange(int startIndex, int endIndex);


    public int getLastIndexOf(Object element);


    public List<Integer> getIndicesOf(Object element);


    public Object getFirst();


    public Object getLast();


    public IndexedDataStructure getSubstructure(int startIndex, int endIndex);


    public boolean findAnyInPairsCountedOnce(BiPredicate<Integer, Integer> filterToApply);


    public void forAllConsequtivePairs(BiConsumer<Integer, Integer> action);


    public void forAllPairsCountedOnce(BiConsumer<Integer, Integer> action);


    public void forAllPairs(BiConsumer<Integer, Integer> action);


    public void forAllPairsExceptSelf(BiConsumer<Integer, Integer> action);


    public default int getNumberOfElementsBefore(int index) throws InvalidDataStructureException
    {
        DataStructureRules.isValidIndex(getSize(), index);
        return index;
    }


    public default int getNumberOfElementsAfter(int index) throws InvalidDataStructureException
    {
        DataStructureRules.isValidIndex(getSize(), index);
        return getSize() - index - 1;
    }


    public void swap(int index1, int index2);
}