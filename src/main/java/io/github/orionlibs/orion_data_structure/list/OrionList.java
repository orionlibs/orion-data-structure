package io.github.orionlibs.orion_data_structure.list;

import io.github.orionlibs.orion_assert.InvalidArgumentException;
import io.github.orionlibs.orion_comparator.ElementComparator;
import io.github.orionlibs.orion_comparator.ReverseElementComparator;
import io.github.orionlibs.orion_data_structure.DataStructure;
import io.github.orionlibs.orion_data_structure.DataStructureRules;
import io.github.orionlibs.orion_data_structure.IndexedDataStructure;
import io.github.orionlibs.orion_data_structure.SingleArgumentDataStructure;
import io.github.orionlibs.orion_data_structure.SingleArgumentOrderedIndexedDataStructure;
import io.github.orionlibs.orion_data_structure.array.ArrayRules;
import io.github.orionlibs.orion_data_structure.queue.OrionQueue;
import io.github.orionlibs.orion_data_structure.queue.type.OrionSimpleQueue;
import io.github.orionlibs.orion_data_structure.set.OrionSet;
import io.github.orionlibs.orion_data_structure.set.type.OrionHashSet;
import io.github.orionlibs.orion_simple_math.RandomNumberGenerationService;
import io.github.orionlibs.orion_tuple.Pair;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public interface OrionList<T> extends List<T>, SingleArgumentOrderedIndexedDataStructure<T>
{
    @Override
    public default boolean contains(Object[] elementsToCheck)
    {
        ArrayRules.isValid(elementsToCheck);
        return containsAll(Arrays.asList(elementsToCheck));
    }


    @SuppressWarnings("unchecked")
    @Override
    public default boolean contains(Collection<Object> elementsToCheck)
    {
        DataStructureRules.isNotNull(elementsToCheck);
        return !elementsToCheck.stream().anyMatch(e -> !contains((T)e));
    }


    @Override
    public default boolean contains(DataStructure elementsToCheck)
    {
        DataStructureRules.isNotNull(elementsToCheck);
        return containsAll(elementsToCheck.getAsUnmodifiableList());
    }


    @Override
    public default boolean notContains(Object[] elements)
    {
        return !contains(elements);
    }


    @Override
    public default boolean notContains(Object elementToCheck)
    {
        return !contains(elementToCheck);
    }


    @Override
    public default boolean notContains(Collection<Object> elements)
    {
        return !containsAll(elements);
    }


    @Override
    public default boolean notContains(DataStructure elements)
    {
        return notContains(elements.getAsArrayOfObjects());
    }


    @Override
    public default void deleteAllOccurencesOf(Object elementToDelete)
    {
        while(contains(elementToDelete))
        {
            remove(elementToDelete);
        }
    }


    @Override
    public default void delete(int index)
    {
        DataStructureRules.isValidIndex(index);
        remove(index);
    }


    @Override
    public default void delete(int[] indices)
    {
        DataStructureRules.areValidIndices(size(), indices);
        List<T> elementsToDelete = new ArrayList<T>(indices.length);
        Arrays.stream(indices).forEach(index -> elementsToDelete.add(get(index)));
        elementsToDelete.forEach(element -> delete(element));
    }


    @Override
    public default void deleteAllOccurencesOf(int[] indices)
    {
        DataStructureRules.areValidIndices(size(), indices);
        List<T> elementsToDelete = new ArrayList<T>(indices.length);
        Arrays.stream(indices).forEach(index -> elementsToDelete.add(get(index)));
        elementsToDelete.forEach(element -> deleteAllOccurencesOf(element));
    }


    @Override
    public default void delete(List<Integer> indices)
    {
        DataStructureRules.areValidIndices(size(), indices);
        List<T> elementsToDelete = new ArrayList<T>(indices.size());
        indices.forEach(index -> elementsToDelete.add(get(index)));
        elementsToDelete.forEach(element -> delete(element));
    }


    @Override
    public default boolean deleteAll(List<?> elementsToDelete)
    {
        DataStructureRules.isNotNull(elementsToDelete);
        elementsToDelete.forEach(element -> delete(element));
        return true;
    }


    @Override
    public default void deleteAllOccurencesOf(List<Integer> indices)
    {
        DataStructureRules.areValidIndices(size(), indices);
        List<T> elementsToDelete = new ArrayList<T>(indices.size());
        indices.forEach(index -> elementsToDelete.add(get(index)));
        elementsToDelete.forEach(element -> deleteAllOccurencesOf(element));
    }


    @Override
    public default void deleteRange(int startIndex, int endIndex)
    {
        DataStructureRules.areValidIndices(getSize(), startIndex, endIndex);
        int numberOfElementsToDelete = endIndex - startIndex;
        List<T> elementsToDelete = new ArrayList<T>(numberOfElementsToDelete);
        IntStream.range(startIndex, endIndex).forEach(i -> elementsToDelete.add(get(i)));
        elementsToDelete.forEach(element -> delete(element));
    }


    @SuppressWarnings("unchecked")
    @Override
    public default OrionList<T>[] split(int numberOfSublists)
    {
        DataStructureRules.isNotEmpty(getSize());
        DataStructureRules.isValidDivisorOfSize(numberOfSublists);
        OrionList<T>[] sublists = new OrionList[numberOfSublists];
        int sizeOfEachSublist = (int)Math.round(getSize() / (double)numberOfSublists);
        int startIndex = 0;
        int endIndex = 0;
        for(int i = 0; i < numberOfSublists; i++)
        {
            endIndex = startIndex + sizeOfEachSublist - 1;
            DataStructureRules.isValidIndexInclusive(getSize(), endIndex);
            int endIndexTemp = (i == numberOfSublists - 1) ? getSize() - 1 : endIndex;
            sublists[i] = getSublistInclusiveAsOrionList(startIndex, endIndexTemp).getCopyIgnoreUnserialisableException();
            if(i != numberOfSublists - 1)
            {
                startIndex = endIndex + 1;
            }
        }
        return sublists;
    }


    @Override
    public default OrionList<T>[] splitGET(int numberOfSublists)
    {
        return getCopy().split(numberOfSublists);
    }


    @Override
    public default OrionList<T>[] splitInHalf()
    {
        return split(2);
    }


    @Override
    public default OrionList<T>[] splitInHalfGET()
    {
        return getCopy().splitInHalf();
    }


    @SuppressWarnings("unchecked")
    @Override
    public default int getLastIndexOf(Object element)
    {
        return lastIndexOf((T)element);
    }


    @SuppressWarnings("unchecked")
    @Override
    public default List<Integer> getIndicesOf(Object element)
    {
        List<Integer> indices = new ArrayList<>();
        IntStream.range(0, getSize())
                        .filter(i -> get(i).equals((T)element))
                        .forEach(i -> indices.add(i));
        return indices;
    }


    @Override
    public default T getFirst()
    {
        return get(0);
    }


    @Override
    public default T getLast()
    {
        return get(this.size() - 1);
    }


    @Override
    public default IndexedDataStructure getSubstructure(int startIndex, int endIndex)
    {
        return (IndexedDataStructure)getSublist(startIndex, endIndex);
    }


    public default List<T> getSublist(int startIndex, int endIndex)
    {
        return subList(startIndex, endIndex);
    }


    public OrionList<T> getSublistAsOrionList(int startIndex, int endIndex);


    public default List<T> getSublistInclusive(int startIndex, int endIndex)
    {
        return getSublist(startIndex, endIndex + 1);
    }


    public OrionList<T> getSublistInclusiveAsOrionList(int startIndex, int endIndex);


    @Override
    public default boolean findAnyInPairsCountedOnce(BiPredicate<Integer, Integer> filterToApply)
    {
        for(int i = 0; i < size() - 1; i++)
        {
            for(int j = i + 1; j < size(); j++)
            {
                if(filterToApply.test(i, j))
                {
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public default void forAllConsequtivePairs(BiConsumer<Integer, Integer> action)
    {
        int i = 0;
        do
        {
            int j = (i + 1) % size();
            action.accept(i, j);
            i = j;
        }
        while(i != 0);
    }


    public default Stream<Pair<T, T>> forAllConsequtivePairsFilter(BiPredicate<Integer, Integer> filterToApply)
    {
        List<Pair<T, T>> values = new ArrayList<>();
        int i = 0;
        do
        {
            int j = (i + 1) % size();
            if(filterToApply.test(i, j))
            {
                values.add(Pair.<T, T>of(get(i), get(j)));
            }
            i = j;
        }
        while(i != 0);
        Pair<T, T>[] pairs = ListService.<Pair<T, T>>getAsArray(values);
        return Stream.<Pair<T, T>>of(pairs);
    }


    @Override
    public default void forAllPairsCountedOnce(BiConsumer<Integer, Integer> action)
    {
        for(int i = 0; i < size() - 1; i++)
        {
            for(int j = i + 1; j < size(); j++)
            {
                action.accept(i, j);
            }
        }
    }


    public default Stream<Pair<T, T>> forAllPairsCountedOnceFilter(BiPredicate<Integer, Integer> filterToApply)
    {
        List<Pair<T, T>> values = new ArrayList<>();
        for(int i = 0; i < size() - 1; i++)
        {
            for(int j = i + 1; j < size(); j++)
            {
                if(filterToApply.test(i, j))
                {
                    values.add(Pair.<T, T>of(get(i), get(j)));
                }
            }
        }
        Pair<T, T>[] pairs = ListService.<Pair<T, T>>getAsArray(values);
        return Stream.<Pair<T, T>>of(pairs);
    }


    public default List<Pair<T, T>> getAllPairsCountedOnce()
    {
        List<Pair<T, T>> list = new ArrayList<>();
        for(int i = 0; i < size() - 1; i++)
        {
            for(int j = i + 1; j < size(); j++)
            {
                list.add(Pair.<T, T>of(get(i), get(j)));
            }
        }
        return list;
    }


    public default long getNumberOfAllPairsCountedOnce()
    {
        if(isEmpty() || getSize() == 1)
        {
            return 0L;
        }
        else
        {
            return 3 * getSize() - IntStream.range(1, getSize()).sum();
        }
    }


    @Override
    public default void forAllPairs(BiConsumer<Integer, Integer> action)
    {
        for(int i = 0; i < size(); i++)
        {
            for(int j = 0; j < size(); j++)
            {
                action.accept(i, j);
                action.accept(j, i);
            }
        }
    }


    public default Stream<Pair<T, T>> forAllPairsFilter(BiPredicate<Integer, Integer> filterToApply)
    {
        List<Pair<T, T>> values = new ArrayList<>();
        for(int i = 0; i < size(); i++)
        {
            for(int j = 0; j < size(); j++)
            {
                if(filterToApply.test(i, j))
                {
                    values.add(Pair.<T, T>of(get(i), get(j)));
                }
            }
        }
        Pair<T, T>[] pairs = ListService.<Pair<T, T>>getAsArray(values);
        return Stream.<Pair<T, T>>of(pairs);
    }


    @Override
    public default void forAllPairsExceptSelf(BiConsumer<Integer, Integer> action)
    {
        for(int i = 0; i < size(); i++)
        {
            for(int j = 0; j < size(); j++)
            {
                if(i != j)
                {
                    action.accept(i, j);
                    action.accept(j, i);
                }
            }
        }
    }


    public default Stream<Pair<T, T>> forAllPairsExceptSelfFilter(BiPredicate<Integer, Integer> filterToApply)
    {
        List<Pair<T, T>> values = new ArrayList<>();
        for(int i = 0; i < size(); i++)
        {
            for(int j = 0; j < size(); j++)
            {
                if(i != j && filterToApply.test(i, j))
                {
                    values.add(Pair.<T, T>of(get(i), get(j)));
                }
            }
        }
        Pair<T, T>[] pairs = ListService.<Pair<T, T>>getAsArray(values);
        return Stream.<Pair<T, T>>of(pairs);
    }


    public default void sort()
    {
        Collections.sort(this, new ElementComparator<T>());
    }


    public default OrionList<T> sortGET()
    {
        OrionList<T> copy = getCopy();
        copy.sort();
        return copy;
    }


    public default OrionList<T> sortGET(Comparator<T> comparator)
    {
        OrionList<T> copy = getCopy();
        copy.sort(comparator);
        return copy;
    }


    public default void sortReverse()
    {
        Collections.sort(this, new ReverseElementComparator<T>());
    }


    public default OrionList<T> sortReverseGET()
    {
        OrionList<T> copy = getCopy();
        copy.sortReverse();
        return copy;
    }


    public default void shuffle()
    {
        Collections.shuffle(this);
    }


    public default OrionList<T> shuffleGET()
    {
        OrionList<T> copy = getCopy();
        copy.shuffle();
        return copy;
    }


    @Override
    public default void prepend(T element)
    {
        List<T> temp = new ArrayList<>(this);
        clear();
        add(element);
        addAll(temp);
    }


    @Override
    public default void prependIf(T element, Predicate<T> filterToApply)
    {
        if(filterToApply.test(element))
        {
            prepend(element);
        }
    }


    @Override
    public default void prepend(T[] elements)
    {
        prepend(Arrays.asList(elements));
    }


    @Override
    public default void prepend(Collection<T> elements)
    {
        List<T> temp = new ArrayList<>(this);
        clear();
        addAll(elements);
        addAll(temp);
    }


    @Override
    public default void reverse()
    {
        Collections.reverse(this);
    }


    @Override
    public default OrionList<T> reverseGET()
    {
        OrionList<T> temp = getCopy();
        temp.reverse();
        return temp;
    }


    @Override
    public default int getIndexOf(T element)
    {
        return indexOf(element);
    }


    @Override
    public default int getIndexOfElementWithinRangeOfInclusive(T element, int startIndex, int endIndex)
    {
        for(int i = startIndex; i <= endIndex; i++)
        {
            if(element == null)
            {
                if(get(i) == null)
                {
                    return i;
                }
            }
            else if(element.equals(get(i)))
            {
                return i;
            }
        }
        return -1;
    }


    @Override
    public default int getLastIndexOfElementWithinRangeOfInclusive(T element, int startIndex, int endIndex)
    {
        for(int i = endIndex; i >= startIndex; i--)
        {
            if(element == null)
            {
                if(get(i) == null)
                {
                    return i;
                }
            }
            else if(element.equals(get(i)))
            {
                return i;
            }
        }
        return -1;
    }


    @Override
    public default boolean keepCommonElementsWith(Collection<T> collection)
    {
        return retainAll(collection);
    }


    @Override
    public default boolean keepCommonElementsWith(SingleArgumentDataStructure<T> collection)
    {
        return keepCommonElementsWith(collection.getAsList());
    }


    @Override
    public default OrionList<T> keepCommonElementsWithGET(Collection<T> collection)
    {
        OrionList<T> copy = getCopy();
        copy.keepCommonElementsWith(collection);
        return copy;
    }


    @Override
    public default OrionList<T> keepCommonElementsWithGET(SingleArgumentDataStructure<T> collection)
    {
        return keepCommonElementsWithGET(collection.getAsList());
    }


    @SuppressWarnings("unchecked")
    @Override
    public default T[] getAsArray()
    {
        if(isEmpty())
        {
            return (T[])Array.newInstance(getDataType(), getSize());
        }
        else
        {
            T[] array = (T[])Array.newInstance(getDataType(), getSize());
            IntStream.range(0, getSize()).forEach(i -> array[i] = get(i));
            return array;
        }
    }


    @Override
    public default Object[] getAsArrayOfObjects()
    {
        return toArray();
    }


    @Override
    public default Set<T> getAsSet()
    {
        return (isEmpty()) ? new HashSet<T>() : new HashSet<T>(this);
    }


    public default OrionSet<T> getAsOrionSet()
    {
        return (isEmpty()) ? OrionHashSet.<T>of() : OrionHashSet.<T>of(this);
    }


    public default OrionQueue<T> getAsOrionArrayQueue()
    {
        return (isEmpty()) ? OrionSimpleQueue.<T>of() : OrionSimpleQueue.<T>of(this);
    }


    public void reduceCapacityToMatchSize();


    @Override
    public default void swap(int index1, int index2)
    {
        ListService.<T>swapIndices(this, index1, index2);
    }


    @Override
    public default void fill(T element, int startIndex, int endIndex)
    {
        DataStructureRules.areValidIndices(getSize(), startIndex, endIndex);
        IntStream.range(startIndex, endIndex).forEach(i -> set(i, element));
    }


    @Override
    public default void fillWithEndIndexInclusive(T element, int startIndex, int endIndex)
    {
        DataStructureRules.areValidIndicesInclusive(getSize(), startIndex, endIndex);
        IntStream.range(startIndex, endIndex + 1).forEach(i -> set(i, element));
    }


    @Override
    public default void setAll(IntFunction<? extends T> generatorFunction)
    {
        Objects.requireNonNull(generatorFunction);
        IntStream.range(0, getSize()).forEach(i -> set(i, generatorFunction.apply(i)));
    }


    @Override
    public default void setAllParallel(IntFunction<? extends T> generatorFunction)
    {
        Objects.requireNonNull(generatorFunction);
        IntStream.range(0, getSize()).parallel().forEach(i -> set(i, generatorFunction.apply(i)));
    }


    @Override
    public default int getIndexOfFirstMismatch(SingleArgumentOrderedIndexedDataStructure<T> other)
    {
        if(other == null)
        {
            return -1;
        }
        else
        {
            List<T> otherAsList = other.getAsList();
            for(int i = 0; i < Math.min(getSize(), otherAsList.size()); i++)
            {
                if(get(i) != otherAsList.get(i) && !get(i).equals(otherAsList.get(i)))
                {
                    return i;
                }
            }
        }
        return -1;
    }


    @SuppressWarnings("unchecked")
    @Override
    public default T getMinimum()
    {
        T minimum = getFirst();
        if(minimum instanceof Comparable)
        {
            if(getSize() > 1)
            {
                for(int i = 1; i < getSize(); i++)
                {
                    if(((Comparable<T>)get(i)).compareTo(minimum) < 0)
                    {
                        minimum = get(i);
                    }
                }
            }
        }
        else
        {
            throw new InvalidArgumentException("The data type of the elements has to implement java.lang.Comparable");
        }
        return minimum;
    }


    @Override
    public default T getMinimum(Comparator<? super T> comparator)
    {
        T minimum = getFirst();
        if(getSize() > 1)
        {
            for(int i = 1; i < getSize(); i++)
            {
                if(comparator.compare(get(i), minimum) < 0)
                {
                    minimum = get(i);
                }
            }
        }
        return minimum;
    }


    @SuppressWarnings("unchecked")
    @Override
    public default T getMaximum()
    {
        T maximum = getFirst();
        if(maximum instanceof Comparable)
        {
            if(getSize() > 1)
            {
                for(int i = 1; i < getSize(); i++)
                {
                    if(((Comparable<T>)get(i)).compareTo(maximum) > 0)
                    {
                        maximum = get(i);
                    }
                }
            }
        }
        else
        {
            throw new InvalidArgumentException("The data type of the elements has to implement java.lang.Comparable");
        }
        return maximum;
    }


    @Override
    public default T getMaximum(Comparator<? super T> comparator)
    {
        T maximum = getFirst();
        if(getSize() > 1)
        {
            for(int i = 1; i < getSize(); i++)
            {
                if(comparator.compare(get(i), maximum) > 0)
                {
                    maximum = get(i);
                }
            }
        }
        return maximum;
    }


    @Override
    public default void rotate(int shift)
    {
        Collections.rotate(this, shift);
    }


    @Override
    public default OrionList<T> rotateGET(int shift)
    {
        OrionList<T> temp = getCopy();
        temp.rotate(shift);
        return temp;
    }


    @Override
    public default void replaceAll(T oldElement, T newElement)
    {
        Collections.replaceAll(this, oldElement, newElement);
    }


    @Override
    public default OrionList<T> replaceAllGET(T oldElement, T newElement)
    {
        OrionList<T> temp = getCopy();
        temp.replaceAll(oldElement, newElement);
        return temp;
    }


    public default int getIndexOfSubList(List<T> other)
    {
        return Collections.indexOfSubList(this, other);
    }


    public default int getLastIndexOfSubList(List<T> other)
    {
        return Collections.lastIndexOfSubList(this, other);
    }


    @Override
    public default List<T> getAsUnmodifiableList()
    {
        return Collections.unmodifiableList(this);
    }


    public OrionList<T> getAsUnmodifiableOrionList();


    @SuppressWarnings(
                    {"unchecked"})
    @Override
    public default Class<T> getDataType()
    {
        return (Class<T>)get(0).getClass();
    }


    @Override
    public default T getRandomElement()
    {
        int randomIndex = RandomNumberGenerationService.getRandomInteger(getSize());
        return get(randomIndex);
    }


    public OrionList<T> getCopy();


    public OrionList<T> getCopyIgnoreUnserialisableException();
}