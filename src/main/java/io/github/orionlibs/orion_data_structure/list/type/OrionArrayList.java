package io.github.orionlibs.orion_data_structure.list.type;

import io.github.orionlibs.orion_data_structure.DataStructureService;
import io.github.orionlibs.orion_data_structure.list.OrionList;
import io.github.orionlibs.orion_object.CloningService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;

public class OrionArrayList<T> extends ArrayList<T> implements OrionList<T>
{
    public OrionArrayList()
    {
        super();
    }


    public OrionArrayList(int size)
    {
        super(size);
    }


    public OrionArrayList(Collection<T> collection)
    {
        super(collection);
    }


    public OrionArrayList(Enumeration<T> enumeration)
    {
        this(enumeration.asIterator());
    }


    public OrionArrayList(Iterator<T> iterator)
    {
        super(DataStructureService.getIteratorAsList(iterator));
    }


    @SuppressWarnings("unchecked")
    public OrionArrayList(T... collection)
    {
        super(Arrays.asList(collection));
    }


    @SuppressWarnings("unchecked")
    public OrionArrayList(Collection<T> collection, Collection<T>... collections)
    {
        super(collection);
        if(collections != null && collections.length > 0)
        {
            Arrays.stream(collections).forEach(c -> addAll(c));
        }
    }


    public static <T> OrionArrayList<T> of()
    {
        return new OrionArrayList<T>();
    }


    @SuppressWarnings("unchecked")
    public static <T> OrionArrayList<T> of(T... collection)
    {
        return new OrionArrayList<T>(collection);
    }


    public static <T> OrionArrayList<T> of(int size)
    {
        return new OrionArrayList<T>(size);
    }


    public static <T> OrionArrayList<T> of(Collection<T> collection)
    {
        return new OrionArrayList<T>(collection);
    }


    public static <T> OrionArrayList<T> of(Enumeration<T> enumeration)
    {
        return new OrionArrayList<T>(enumeration);
    }


    public static <T> OrionArrayList<T> of(Iterator<T> iterator)
    {
        return new OrionArrayList<T>(iterator);
    }


    @SuppressWarnings("unchecked")
    public static <T> OrionArrayList<T> of(Collection<T> collection, Collection<T>... collections)
    {
        return new OrionArrayList<T>(collection, collections);
    }


    @Override
    public void deleteRange(int startIndex, int endIndex)
    {
        removeRange(startIndex, endIndex);
    }


    public OrionConcurrentArrayList<T> getAsConcurrentList()
    {
        if(isEmpty())
        {
            return OrionConcurrentArrayList.<T>of();
        }
        else
        {
            return OrionConcurrentArrayList.<T>of(this);
        }
    }


    @Override
    public OrionList<T> getSublistAsOrionList(int startIndex, int endIndex)
    {
        return OrionArrayList.<T>of(getSublist(startIndex, endIndex));
    }


    @Override
    public OrionList<T> getSublistInclusiveAsOrionList(int startIndex, int endIndex)
    {
        return OrionArrayList.<T>of(getSublistInclusive(startIndex, endIndex));
    }


    @Override
    public void reduceCapacityToMatchSize()
    {
        trimToSize();
    }


    @Override
    public OrionList<T> getAsUnmodifiableOrionList()
    {
        return OrionUnmodifiableArrayList.<T>of(getAsUnmodifiableList());
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
    public OrionArrayList<T> clone()
    {
        return (OrionArrayList<T>)CloningService.clone(this);
    }


    @SuppressWarnings("unchecked")
    public OrionArrayList<T> cloneIgnoreUnserialisableException()
    {
        return (OrionArrayList<T>)CloningService.cloneIgnoreUnserialisableException(this);
    }


    @Override
    public OrionArrayList<T> getCopy()
    {
        return this.clone();
    }


    @Override
    public OrionArrayList<T> getCopyIgnoreUnserialisableException()
    {
        return this.cloneIgnoreUnserialisableException();
    }
}