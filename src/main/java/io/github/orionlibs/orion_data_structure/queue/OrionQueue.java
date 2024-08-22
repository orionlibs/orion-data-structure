package io.github.orionlibs.orion_data_structure.queue;

import io.github.orionlibs.orion_data_structure.DataStructure;
import io.github.orionlibs.orion_data_structure.DataStructureRules;
import io.github.orionlibs.orion_data_structure.SingleArgumentDataStructure;
import io.github.orionlibs.orion_data_structure.array.ArrayRules;
import io.github.orionlibs.orion_data_structure.list.OrionList;
import io.github.orionlibs.orion_data_structure.list.type.OrionArrayList;
import io.github.orionlibs.orion_data_structure.set.OrionSet;
import io.github.orionlibs.orion_data_structure.set.type.OrionHashSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.IntStream;

public interface OrionQueue<T> extends Queue<T>, SingleArgumentDataStructure<T>
{
    public default T get()
    {
        return peek();
    }


    public default T getAndDelete()
    {
        return poll();
    }


    public default T delete()
    {
        return remove();
    }


    @Override
    public default boolean deleteAll(List<?> elementsToDelete)
    {
        throw new UnsupportedOperationException();
    }


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


    @SuppressWarnings("unchecked")
    @Override
    public default OrionQueue<T>[] split(int numberOfSubqueues)
    {
        OrionList<T>[] subqueuesAsLists = OrionArrayList.<T>of(getAsList()).split(numberOfSubqueues);
        OrionQueue<T>[] subqueues = new OrionQueue[numberOfSubqueues];
        IntStream.range(0, numberOfSubqueues).forEach(i -> subqueues[i] = subqueuesAsLists[i].getAsOrionArrayQueue());
        return subqueues;
    }


    @Override
    public default OrionQueue<T>[] splitGET(int numberOfSubqueues)
    {
        return getCopy().split(numberOfSubqueues);
    }


    @Override
    public default OrionQueue<T>[] splitInHalf()
    {
        return split(2);
    }


    @Override
    public default OrionQueue<T>[] splitInHalfGET()
    {
        return getCopy().splitInHalf();
    }


    public default Queue<T> getSubqueue(int startIndex, int endIndex)
    {
        return OrionArrayList.<T>of(getAsList())
                        .getSublistAsOrionList(startIndex, endIndex)
                        .getAsOrionArrayQueue();
    }


    public OrionQueue<T> getSubqueueAsOrionQueue(int startIndex, int endIndex);


    public default Queue<T> getSubqueueInclusive(int startIndex, int endIndex)
    {
        return getSubqueue(startIndex, endIndex + 1);
    }


    public OrionQueue<T> getSubqueueInclusiveAsOrionQueue(int startIndex, int endIndex);


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
    public default OrionQueue<T> keepCommonElementsWithGET(Collection<T> collection)
    {
        OrionQueue<T> copy = getCopy();
        copy.keepCommonElementsWith(collection);
        return copy;
    }


    @Override
    public default OrionQueue<T> keepCommonElementsWithGET(SingleArgumentDataStructure<T> collection)
    {
        return keepCommonElementsWithGET(collection.getAsList());
    }


    @Override
    public default void fill(T element)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void append(T element);


    @Override
    public T[] getAsArray();


    @Override
    public default Object[] getAsArrayOfObjects()
    {
        return toArray();
    }


    @Override
    public default Set<T> getAsSet()
    {
        if(isEmpty())
        {
            return new HashSet<T>();
        }
        else
        {
            return new HashSet<T>(this);
        }
    }


    public default OrionSet<T> getAsOrionSet()
    {
        if(isEmpty())
        {
            return OrionHashSet.<T>of();
        }
        else
        {
            return OrionHashSet.<T>of(this);
        }
    }


    public default OrionList<T> getAsOrionList()
    {
        if(isEmpty())
        {
            return OrionArrayList.<T>of();
        }
        else
        {
            return OrionArrayList.<T>of(this);
        }
    }


    @Override
    public default T getMinimum()
    {
        return getAsOrionList().getMinimum();
    }


    @Override
    public default T getMinimum(Comparator<? super T> comparator)
    {
        return getAsOrionList().getMinimum(comparator);
    }


    @Override
    public default T getMaximum()
    {
        return getAsOrionList().getMaximum();
    }


    @Override
    public default T getMaximum(Comparator<? super T> comparator)
    {
        return getAsOrionList().getMaximum(comparator);
    }


    @Override
    public default void replaceAll(T oldElement, T newElement)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public default OrionQueue<T> replaceAllGET(T oldElement, T newElement)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public default List<T> getAsUnmodifiableList()
    {
        return getAsOrionList().getAsUnmodifiableList();
    }


    public OrionList<T> getAsUnmodifiableOrionList();


    @Override
    public default Class<T> getDataType()
    {
        return getAsOrionList().getDataType();
    }


    @Override
    public default T getRandomElement()
    {
        return getAsOrionList().getRandomElement();
    }


    public OrionQueue<T> getCopy();


    public OrionQueue<T> getCopyIgnoreUnserialisableException();
}