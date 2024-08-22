package io.github.orionlibs.orion_data_structure;

import io.github.orionlibs.orion_data_structure.set.OrionSet;
import io.github.orionlibs.orion_data_structure.set.type.OrionHashMultiSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public interface SingleArgumentDataStructure<T> extends DataStructure, Collection<T>
{
    public default long getMultiplicityOfElement(T element)
    {
        return stream().filter(e -> e.equals(element)).count();
    }


    @Override
    public default boolean delete(Object element)
    {
        return remove(element);
    }


    public default boolean deleteDuplicates()
    {
        boolean anyElementsDeleted = false;
        for(T element : this)
        {
            long multiplicityOfElement = getMultiplicityOfElement(element);
            if(multiplicityOfElement > 1)
            {
                for(long i = 0; i < multiplicityOfElement - 1; i++)
                {
                    remove(element);
                    anyElementsDeleted = true;
                }
            }
        }
        return anyElementsDeleted;
    }


    @Override
    public default void deleteAll()
    {
        clear();
    }


    @SuppressWarnings("unchecked")
    @Override
    public default void deleteIf(Predicate<?> filterToApply)
    {
        removeIf((Predicate<? super T>)filterToApply);
    }


    public default <T1> List<T1> mapToList(Function<T, T1> action)
    {
        return stream().map(action).collect(Collectors.toList());
    }


    public default <T1> Set<T1> mapToSet(Function<T, T1> action)
    {
        return stream().map(action).collect(Collectors.toSet());
    }


    public default Stream<T> filter(Predicate<T> filterToApply)
    {
        return stream().filter(filterToApply);
    }


    public default boolean findAny(Predicate<T> filterToApply)
    {
        return stream().anyMatch(filterToApply);
    }


    public default boolean findNone(Predicate<T> filterToApply)
    {
        return stream().noneMatch(filterToApply);
    }


    public default void forAll(Consumer<T> action)
    {
        forEach(action);
    }


    public default void forAll(Stream<T> stream, Consumer<T> action)
    {
        stream.forEach(action);
    }


    public default void filterAndLoop(Predicate<T> filterToApply, Consumer<T> action)
    {
        forAll(filter(filterToApply), action);
    }


    public default void append(T element)
    {
        add(element);
    }


    public default void appendIf(T element, Predicate<T> filterToApply)
    {
        if(filterToApply.test(element))
        {
            append(element);
        }
    }


    public default void appendIfNotNull(T element)
    {
        if(element != null)
        {
            append(element);
        }
    }


    public default void append(T[] elements)
    {
        addAll(Arrays.asList(elements));
    }


    public default void append(Collection<T> elements)
    {
        addAll(elements);
    }


    public boolean keepCommonElementsWith(Collection<T> collection);


    public boolean keepCommonElementsWith(SingleArgumentDataStructure<T> collection);


    public SingleArgumentDataStructure<T> keepCommonElementsWithGET(Collection<T> collection);


    public SingleArgumentDataStructure<T> keepCommonElementsWithGET(SingleArgumentDataStructure<T> collection);


    public T[] getAsArray();


    public Set<T> getAsSet();


    public default List<T> getAsList()
    {
        return new ArrayList<T>(this);
    }


    public default void fill(T element)
    {
        IntStream.range(0, getSize()).forEach(i -> append(element));
    }


    public T getMinimum();


    public T getMinimum(Comparator<? super T> comparator);


    public T getMaximum();


    public T getMaximum(Comparator<? super T> comparator);


    public void replaceAll(T oldElement, T newElement);


    public SingleArgumentDataStructure<T> replaceAllGET(T oldElement, T newElement);


    @SuppressWarnings(
                    {"unchecked"})
    public default Class<T> getDataType()
    {
        return (Class<T>)getAsList().get(0).getClass();
    }


    public T getRandomElement();


    public default boolean isSubstructureOf(SingleArgumentDataStructure<T> other)
    {
        DataStructureRules.isNotNullAndNotEmpty(other);
        return other.contains(getAsArrayOfObjects());
    }


    @Override
    public default int getSize()
    {
        return this.size();
    }


    @Override
    public default long getSizeOfNonNull()
    {
        return stream().filter(e -> e != null).count();
    }


    @Override
    public default boolean isNotEmpty()
    {
        return !isEmpty();
    }


    public default long getFrequencyOfElement(Object element)
    {
        return Collections.frequency(this, element);
    }


    public default boolean isDisjointWith(Collection<T> other)
    {
        return Collections.disjoint(this, other);
    }


    @SuppressWarnings("unchecked")
    public default List<T> getRepeatedElements()
    {
        OrionSet<?> set = OrionHashMultiSet.of(getAsUnmodifiableList());
        return (List<T>)set.filter(element -> set.getFrequencyOfElement(element) > 1).collect(Collectors.toList());
    }
}