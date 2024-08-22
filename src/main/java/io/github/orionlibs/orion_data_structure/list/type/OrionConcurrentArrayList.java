package io.github.orionlibs.orion_data_structure.list.type;

import io.github.orionlibs.orion_data_structure.DataStructureService;
import io.github.orionlibs.orion_data_structure.list.OrionList;
import io.github.orionlibs.orion_object.CloningService;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class OrionConcurrentArrayList<T> extends CopyOnWriteArrayList<T> implements OrionList<T>, Cloneable
{
    public OrionConcurrentArrayList()
    {
        super();
    }


    public OrionConcurrentArrayList(Collection<T> collection)
    {
        super(collection);
    }


    public OrionConcurrentArrayList(Enumeration<T> enumeration)
    {
        this(enumeration.asIterator());
    }


    public OrionConcurrentArrayList(Iterator<T> iterator)
    {
        super(DataStructureService.getIteratorAsList(iterator));
    }


    public OrionConcurrentArrayList(T[] collection)
    {
        super(collection);
    }


    @SuppressWarnings("unchecked")
    public OrionConcurrentArrayList(Collection<T> collection, Collection<T>... collections)
    {
        super(collection);
        if(collections != null && collections.length > 0)
        {
            Arrays.stream(collections).forEach(c -> addAll(c));
        }
    }


    public static <T> OrionConcurrentArrayList<T> of()
    {
        return new OrionConcurrentArrayList<T>();
    }


    public static <T> OrionConcurrentArrayList<T> of(T[] collection)
    {
        return new OrionConcurrentArrayList<T>(collection);
    }


    @SuppressWarnings("unchecked")
    public static <T> OrionConcurrentArrayList<T> of(Collection<T> collection, Collection<T>... collections)
    {
        return new OrionConcurrentArrayList<T>(collection, collections);
    }


    public static <T> OrionConcurrentArrayList<T> of(Collection<T> collection)
    {
        return new OrionConcurrentArrayList<T>(collection);
    }


    public static <T> OrionConcurrentArrayList<T> of(Enumeration<T> enumeration)
    {
        return new OrionConcurrentArrayList<T>(enumeration);
    }


    public static <T> OrionConcurrentArrayList<T> of(Iterator<T> iterator)
    {
        return new OrionConcurrentArrayList<T>(iterator);
    }


    @Override
    public OrionList<T> getSublistAsOrionList(int startIndex, int endIndex)
    {
        return OrionConcurrentArrayList.<T>of(getSublist(startIndex, endIndex));
    }


    @Override
    public OrionList<T> getSublistInclusiveAsOrionList(int startIndex, int endIndex)
    {
        return OrionConcurrentArrayList.<T>of(getSublistInclusive(startIndex, endIndex));
    }


    @Override
    public void reduceCapacityToMatchSize()
    {
        throw new UnsupportedOperationException("This method is not applicable to concurrent data structures");
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
    public OrionConcurrentArrayList<T> clone()
    {
        return (OrionConcurrentArrayList<T>)CloningService.clone(this);
    }


    @SuppressWarnings("unchecked")
    public OrionConcurrentArrayList<T> cloneIgnoreUnserialisableException()
    {
        return (OrionConcurrentArrayList<T>)CloningService.cloneIgnoreUnserialisableException(this);
    }


    @Override
    public OrionConcurrentArrayList<T> getCopy()
    {
        return this.clone();
    }


    @Override
    public OrionConcurrentArrayList<T> getCopyIgnoreUnserialisableException()
    {
        return this.cloneIgnoreUnserialisableException();
    }
}