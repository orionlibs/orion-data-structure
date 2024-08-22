package io.github.orionlibs.orion_data_structure.list.type;

import io.github.orionlibs.orion_data_structure.SingleArgumentDataStructure;
import io.github.orionlibs.orion_data_structure.list.OrionList;
import io.github.orionlibs.orion_object.CloningService;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class OrionUnmodifiableArrayList<T> extends OrionArrayList<T>
{
    public OrionUnmodifiableArrayList()
    {
        super();
    }


    public OrionUnmodifiableArrayList(Collection<T> collection)
    {
        super(collection);
    }


    @SuppressWarnings("unchecked")
    public OrionUnmodifiableArrayList(T... collection)
    {
        super(Arrays.asList(collection));
    }


    @SuppressWarnings("unchecked")
    public OrionUnmodifiableArrayList(Collection<T> collection, Collection<T>... collections)
    {
        super(collection);
        if(collections != null && collections.length > 0)
        {
            Arrays.stream(collections).forEach(c -> addAll(c));
        }
    }


    public static <T> OrionUnmodifiableArrayList<T> empty()
    {
        return new OrionUnmodifiableArrayList<T>();
    }


    public static <T> OrionUnmodifiableArrayList<T> of()
    {
        return new OrionUnmodifiableArrayList<T>();
    }


    @SuppressWarnings("unchecked")
    public static <T> OrionUnmodifiableArrayList<T> of(T... collection)
    {
        return new OrionUnmodifiableArrayList<T>(collection);
    }


    public static <T> OrionUnmodifiableArrayList<T> of(Collection<T> collection)
    {
        return new OrionUnmodifiableArrayList<T>(collection);
    }


    public static <T> OrionUnmodifiableArrayList<T> of(Collection<T> collection, Collection<T>... collections)
    {
        return new OrionUnmodifiableArrayList<T>(collection, collections);
    }


    @Override
    public void deleteAll()
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public T remove(int index)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public boolean remove(Object elementToDelete)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public boolean removeAll(Collection<?> elementsToDelete)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public boolean removeIf(Predicate<? super T> filterToApply)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void deleteRange(int startIndex, int endIndex)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void removeRange(int startIndex, int endIndex)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void reduceCapacityToMatchSize()
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public OrionList<T> getAsUnmodifiableOrionList()
    {
        return OrionUnmodifiableArrayList.<T>of(getAsUnmodifiableList());
    }


    @Override
    public void delete(int index)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void delete(int[] indices)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void delete(List<Integer> indices)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public boolean delete(Object element)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void deleteAllOccurencesOf(Object elementToDelete)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void deleteIf(Predicate<?> filterToApply)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void sort()
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void sort(Comparator<? super T> comparator)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void shuffle()
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void sortReverse()
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void append(T element)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public boolean add(T element)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void add(int index, T element)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public boolean addAll(Collection<? extends T> elementsToAdd)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public boolean addAll(int index, Collection<? extends T> elementsToAdd)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void appendIfNotNull(T element)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void append(T[] elements)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void append(Collection<T> elements)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void prepend(T element)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void prependIfNotNull(T element)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void prepend(T[] elements)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void prepend(Collection<T> elements)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void reverse()
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public boolean keepCommonElementsWith(Collection<T> collection)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public boolean keepCommonElementsWith(SingleArgumentDataStructure<T> collection)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void swap(int index1, int index2)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void fill(T element)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void fill(T element, int startIndex, int endIndex)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void fillWithEndIndexInclusive(T element, int startIndex, int endIndex)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void setAll(IntFunction<? extends T> generatorFunction)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void setAllParallel(IntFunction<? extends T> generatorFunction)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void rotate(int shift)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void replaceAll(T oldElement, T newElement)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void replaceAll(UnaryOperator<T> operator)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public boolean retainAll(Collection<?> other)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public T set(int index, T element)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void clear()
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void trimToSize()
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public int hashCode()
    {
        return super.hashCode();
    }


    @Override
    public boolean equals(Object object)
    {
        return super.equals(object);
    }


    @SuppressWarnings("unchecked")
    @Override
    public OrionUnmodifiableArrayList<T> clone()
    {
        return (OrionUnmodifiableArrayList<T>)CloningService.clone(this);
    }


    @Override
    public OrionUnmodifiableArrayList<T> getCopy()
    {
        return this.clone();
    }
}