package io.github.orionlibs.orion_data_structure.set;

import io.github.orionlibs.orion_data_structure.DataStructure;
import io.github.orionlibs.orion_data_structure.DataStructureRules;
import io.github.orionlibs.orion_data_structure.SingleArgumentDataStructure;
import io.github.orionlibs.orion_data_structure.array.ArrayRules;
import io.github.orionlibs.orion_data_structure.list.OrionList;
import io.github.orionlibs.orion_data_structure.list.type.OrionArrayList;
import io.github.orionlibs.orion_data_structure.list.type.OrionUnmodifiableArrayList;
import io.github.orionlibs.orion_simple_math.RandomNumberGenerationService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public interface OrionSet<T> extends Set<T>, SingleArgumentDataStructure<T>
{
    public default void addIf(T element, Predicate<T> filterToApply)
    {
        if(filterToApply.test(element))
        {
            add(element);
        }
    }


    @Override
    public default boolean contains(Object[] elementsToCheck)
    {
        ArrayRules.isValid(elementsToCheck);
        return containsAll(Arrays.asList(elementsToCheck));
    }


    @SuppressWarnings("unchecked")
    @Override
    public default boolean contains(Collection<Object> keysToCheck)
    {
        DataStructureRules.isNotNull(keysToCheck);
        return !keysToCheck.stream().anyMatch(key -> !contains((T)key));
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
        delete(elementToDelete);
    }


    @Override
    public default boolean deleteAll(List<?> elementsToDelete)
    {
        DataStructureRules.isNotNull(elementsToDelete);
        elementsToDelete.forEach(element -> delete(element));
        return true;
    }


    public default OrionList<T> getAsOrionList()
    {
        return OrionArrayList.<T>of(this);
    }


    public default boolean isSubsetOf(OrionSet<T> other)
    {
        return OrionSetService.isSubsetOf(this, other);
    }


    public default boolean isProperSubsetOf(OrionSet<T> other)
    {
        return OrionSetService.isProperSubsetOf(this, other);
    }


    public default OrionSet<T> getDifference(OrionSet<T> other)
    {
        return OrionSetService.getDifference(this, other);
    }


    public default OrionSet<T> getSymmetricDifference(OrionSet<T> other)
    {
        return OrionSetService.getSymmetricDifference(this, other);
    }


    @SuppressWarnings("unchecked")
    public default OrionSet<T> getIntersection(OrionSet<T>... others)
    {
        if(others != null)
        {
            OrionSet<T>[] sets = new OrionSet[others.length + 1];
            sets[0] = this;
            IntStream.range(1, others.length + 1).forEach(i -> sets[i] = others[i - 1]);
            return OrionSetService.getIntersection(sets);
        }
        else
        {
            return this;
        }
    }


    public default OrionSet<T> getIntersection(List<OrionSet<T>> others)
    {
        if(others != null)
        {
            List<OrionSet<T>> sets = new ArrayList<>();
            sets.add(this);
            sets.addAll(others);
            return OrionSetService.getIntersection(sets);
        }
        else
        {
            return this;
        }
    }


    @SuppressWarnings("unchecked")
    public default OrionSet<T> getUnion(OrionSet<T>... others)
    {
        if(others != null)
        {
            OrionSet<T>[] sets = new OrionSet[others.length + 1];
            sets[0] = this;
            IntStream.range(1, others.length + 1).forEach(i -> sets[i] = others[i - 1]);
            return OrionSetService.getUnion(sets);
        }
        else
        {
            return this;
        }
    }


    public default OrionSet<T> getUnion(List<OrionSet<T>> others)
    {
        if(others != null)
        {
            List<OrionSet<T>> sets = new ArrayList<>();
            sets.add(this);
            sets.addAll(others);
            return OrionSetService.getUnion(sets);
        }
        else
        {
            return this;
        }
    }


    @Override
    public default OrionSet<T>[] split(int numberOfSubstructures)
    {
        return splitSetIntoSubsets(numberOfSubstructures);
    }


    @Override
    public default OrionSet<T>[] splitGET(int numberOfSubstructures)
    {
        return getCopy().split(numberOfSubstructures);
    }


    @Override
    public default OrionSet<T>[] splitInHalf()
    {
        return splitSetInHalf();
    }


    @Override
    public default OrionSet<T>[] splitInHalfGET()
    {
        return splitSetInHalfGET();
    }


    public default OrionSet<T>[] splitSetInHalf()
    {
        return splitSetIntoSubsets(2);
    }


    public default OrionSet<T>[] splitSetInHalfGET()
    {
        return getCopy().splitSetInHalf();
    }


    @SuppressWarnings("unchecked")
    public default OrionSet<T>[] splitSetIntoSubsets(int numberOfSubsets)
    {
        DataStructureRules.isNotEmpty(getSize());
        OrionList<T>[] sublists = getAsOrionList().split(numberOfSubsets);
        OrionSet<T>[] subsets = new OrionSet[numberOfSubsets];
        IntStream.range(0, sublists.length).forEach(i -> subsets[i] = sublists[i].getAsOrionSet());
        return subsets;
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
    public default OrionSet<T> keepCommonElementsWithGET(Collection<T> collection)
    {
        OrionSet<T> copy = getCopy();
        copy.keepCommonElementsWith(collection);
        return copy;
    }


    @Override
    public default OrionSet<T> keepCommonElementsWithGET(SingleArgumentDataStructure<T> collection)
    {
        return keepCommonElementsWithGET(collection.getAsList());
    }


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


    @Override
    public default List<T> getAsUnmodifiableList()
    {
        return Collections.unmodifiableList(getAsList());
    }


    public default OrionList<T> getAsUnmodifiableOrionList()
    {
        return OrionUnmodifiableArrayList.<T>of(getAsList());
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
        if(remove(oldElement))
        {
            append(newElement);
        }
    }


    @Override
    public default OrionSet<T> replaceAllGET(T oldElement, T newElement)
    {
        OrionList<T> temp = getCopy().getAsOrionList();
        temp.replaceAll(oldElement, newElement);
        return temp.getAsOrionSet();
    }


    @Override
    public default T getRandomElement()
    {
        int randomIndex = RandomNumberGenerationService.getRandomInteger(getSize());
        return getAsList().get(randomIndex);
    }


    @Override
    public default T[] getAsArray()
    {
        return getAsOrionList().getAsArray();
    }


    public OrionSet<T> getCopy();
}