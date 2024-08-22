package io.github.orionlibs.orion_data_structure.set.type;

import io.github.orionlibs.orion_data_structure.SingleArgumentDataStructure;
import io.github.orionlibs.orion_object.CloningService;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;

public class OrionUnmodifiableHashSet<T> extends OrionHashSet<T>
{
    public OrionUnmodifiableHashSet()
    {
        super();
    }


    public OrionUnmodifiableHashSet(Collection<T> collection)
    {
        super(collection);
    }


    @SuppressWarnings("unchecked")
    public OrionUnmodifiableHashSet(T... collection)
    {
        super(Arrays.asList(collection));
    }


    @SuppressWarnings("unchecked")
    public OrionUnmodifiableHashSet(Collection<T> collection, Collection<T>... collections)
    {
        super(collection);
        if(collections != null && collections.length > 0)
        {
            Arrays.stream(collections).forEach(c -> addAll(c));
        }
    }


    public static <T> OrionUnmodifiableHashSet<T> empty()
    {
        return new OrionUnmodifiableHashSet<T>();
    }


    public static <T> OrionUnmodifiableHashSet<T> of()
    {
        return new OrionUnmodifiableHashSet<T>();
    }


    public static <T> OrionUnmodifiableHashSet<T> of(Collection<T> collection)
    {
        return new OrionUnmodifiableHashSet<T>(collection);
    }


    @SuppressWarnings("unchecked")
    public static <T> OrionUnmodifiableHashSet<T> of(T... collection)
    {
        return new OrionUnmodifiableHashSet<T>(collection);
    }


    @SuppressWarnings("unchecked")
    public static <T> OrionUnmodifiableHashSet<T> of(Collection<T> collection, Collection<T>... collections)
    {
        return new OrionUnmodifiableHashSet<T>(collection, collections);
    }


    @Override
    public T getRandomElement()
    {
        return getAsList().get(0);
    }


    @Override
    public boolean add(T element)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public boolean addAll(Collection<? extends T> elements)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void append(T element)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void append(Collection<T> elements)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void append(T[] elements)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void appendIfNotNull(T element)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void clear()
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public boolean delete(Object element)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void deleteAll()
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void deleteAllOccurencesOf(Object element)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void deleteIf(Predicate<?> filterToApply)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void fill(T element)
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
    public boolean remove(Object element)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public boolean removeAll(Collection<?> elements)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public boolean removeIf(Predicate<? super T> filterToApply)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void replaceAll(T oldElement, T newElement)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public boolean retainAll(Collection<?> other)
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
    public OrionUnmodifiableHashSet<T> clone()
    {
        return (OrionUnmodifiableHashSet<T>)CloningService.clone(this);
    }


    @Override
    public OrionUnmodifiableHashSet<T> getCopy()
    {
        return this.clone();
    }
}