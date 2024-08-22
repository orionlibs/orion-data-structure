package io.github.orionlibs.orion_data_structure.set.type;

import io.github.orionlibs.orion_data_structure.DataStructureService;
import io.github.orionlibs.orion_data_structure.UnindexedDataStructure;
import io.github.orionlibs.orion_data_structure.UnorderedDataStructure;
import io.github.orionlibs.orion_data_structure.set.OrionSet;
import io.github.orionlibs.orion_object.CloningService;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class OrionConcurrentSet<T> extends CopyOnWriteArraySet<T> implements OrionSet<T>, Cloneable, UnorderedDataStructure, UnindexedDataStructure
{
    public OrionConcurrentSet()
    {
        super();
    }


    public OrionConcurrentSet(Enumeration<T> enumeration)
    {
        this(enumeration.asIterator());
    }


    public OrionConcurrentSet(Iterator<T> iterator)
    {
        super(DataStructureService.getIteratorAsList(iterator));
    }


    public OrionConcurrentSet(Collection<T> collection)
    {
        super(collection);
    }


    public OrionConcurrentSet(T[] collection)
    {
        super(Arrays.asList(collection));
    }


    @SuppressWarnings("unchecked")
    public OrionConcurrentSet(Collection<T> collection, Collection<T>... collections)
    {
        super(collection);
        if(collections != null && collections.length > 0)
        {
            Arrays.stream(collections).forEach(c -> addAll(c));
        }
    }


    public static <T> OrionConcurrentSet<T> of()
    {
        return new OrionConcurrentSet<T>();
    }


    @SuppressWarnings("unchecked")
    public static <T> OrionConcurrentSet<T> of(Collection<T> collection, Collection<T>... collections)
    {
        return new OrionConcurrentSet<T>(collection, collections);
    }


    public static <T> OrionConcurrentSet<T> of(Collection<T> collection)
    {
        return new OrionConcurrentSet<T>(collection);
    }


    public static <T> OrionConcurrentSet<T> of(Enumeration<T> enumeration)
    {
        return new OrionConcurrentSet<T>(enumeration);
    }


    public static <T> OrionConcurrentSet<T> of(Iterator<T> iterator)
    {
        return new OrionConcurrentSet<T>(iterator);
    }


    public static <T> OrionConcurrentSet<T> of(T[] collection)
    {
        return new OrionConcurrentSet<T>(collection);
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
    public OrionConcurrentSet<T> clone() throws CloneNotSupportedException
    {
        return (OrionConcurrentSet<T>)CloningService.clone(this);
    }


    @Override
    public OrionConcurrentSet<T> getCopy()
    {
        try
        {
            return this.clone();
        }
        catch(CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}