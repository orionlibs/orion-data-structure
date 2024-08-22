package io.github.orionlibs.orion_data_structure.set.type;

import io.github.orionlibs.orion_data_structure.DataStructureService;
import io.github.orionlibs.orion_data_structure.UnindexedDataStructure;
import io.github.orionlibs.orion_data_structure.UnorderedDataStructure;
import io.github.orionlibs.orion_data_structure.set.OrionSet;
import io.github.orionlibs.orion_object.CloningService;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;

public class OrionHashSet<T> extends HashSet<T> implements OrionSet<T>, UnorderedDataStructure, UnindexedDataStructure
{
    public OrionHashSet()
    {
        super();
    }


    public OrionHashSet(int size)
    {
        super(size);
    }


    public OrionHashSet(int size, float loadFactor)
    {
        super(size, loadFactor);
    }


    public OrionHashSet(Enumeration<T> enumeration)
    {
        this(enumeration.asIterator());
    }


    public OrionHashSet(Iterator<T> iterator)
    {
        super(DataStructureService.getIteratorAsList(iterator));
    }


    public OrionHashSet(Collection<T> collection)
    {
        super(collection);
    }


    @SuppressWarnings("unchecked")
    public OrionHashSet(T... collection)
    {
        super(Arrays.asList(collection));
    }


    @SuppressWarnings("unchecked")
    public OrionHashSet(Collection<T> collection, Collection<T>... collections)
    {
        super(collection);
        if(collections != null && collections.length > 0)
        {
            Arrays.stream(collections).forEach(c -> addAll(c));
        }
    }


    public static <T> OrionHashSet<T> of()
    {
        return new OrionHashSet<T>();
    }


    public static <T> OrionHashSet<T> of(int size)
    {
        return new OrionHashSet<T>(size);
    }


    public static <T> OrionHashSet<T> of(int size, float loadFactor)
    {
        return new OrionHashSet<T>(size, loadFactor);
    }


    public static <T> OrionHashSet<T> of(Collection<T> collection)
    {
        return new OrionHashSet<T>(collection);
    }


    public static <T> OrionHashSet<T> of(Enumeration<T> enumeration)
    {
        return new OrionHashSet<T>(enumeration);
    }


    public static <T> OrionHashSet<T> of(Iterator<T> iterator)
    {
        return new OrionHashSet<T>(iterator);
    }


    @SuppressWarnings("unchecked")
    public static <T> OrionHashSet<T> of(T... collection)
    {
        return new OrionHashSet<T>(collection);
    }


    @SuppressWarnings("unchecked")
    public static <T> OrionHashSet<T> of(Collection<T> collection, Collection<T>... collections)
    {
        return new OrionHashSet<T>(collection, collections);
    }


    @Override
    public T getRandomElement()
    {
        return getAsList().get(0);
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
    public OrionHashSet<T> clone()
    {
        return (OrionHashSet<T>)CloningService.clone(this);
    }


    @Override
    public OrionHashSet<T> getCopy()
    {
        return this.clone();
    }
}