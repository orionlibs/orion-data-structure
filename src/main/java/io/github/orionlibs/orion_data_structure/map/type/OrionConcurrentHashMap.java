package io.github.orionlibs.orion_data_structure.map.type;

import io.github.orionlibs.orion_data_structure.DataStructureRules;
import io.github.orionlibs.orion_data_structure.DataStructureService;
import io.github.orionlibs.orion_data_structure.UnindexedDataStructure;
import io.github.orionlibs.orion_data_structure.UnorderedDataStructure;
import io.github.orionlibs.orion_data_structure.list.OrionList;
import io.github.orionlibs.orion_data_structure.map.OrionMap;
import io.github.orionlibs.orion_object.CloningService;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OrionConcurrentHashMap<T1, T2> extends ConcurrentHashMap<T1, T2> implements OrionMap<T1, T2>, Cloneable, UnorderedDataStructure, UnindexedDataStructure
{
    public OrionConcurrentHashMap()
    {
        super();
    }


    public OrionConcurrentHashMap(int size)
    {
        super(size);
    }


    public OrionConcurrentHashMap(int size, float loadFactor)
    {
        super(size, loadFactor);
    }


    public OrionConcurrentHashMap(int size, float loadFactor, int numberOfThreadsToUse)
    {
        super(size, loadFactor, numberOfThreadsToUse);
    }


    public OrionConcurrentHashMap(T1 key, T2 value)
    {
        super();
        put(key, value);
    }


    public OrionConcurrentHashMap(Map<T1, T2> other)
    {
        super(other);
    }


    public OrionConcurrentHashMap(List<Map.Entry<T1, T2>> other)
    {
        super();
        DataStructureRules.isNotEmpty((Collection<Map.Entry<T1, T2>>)other);
        other.forEach(mapEntry -> put(mapEntry.getKey(), mapEntry.getValue()));
    }


    public OrionConcurrentHashMap(OrionList<Entry<T1, T2>> other)
    {
        this((List<Map.Entry<T1, T2>>)other);
    }


    public OrionConcurrentHashMap(Enumeration<Map.Entry<T1, T2>> enumeration)
    {
        this(enumeration.asIterator());
    }


    public OrionConcurrentHashMap(Iterator<Map.Entry<T1, T2>> iterator)
    {
        this(DataStructureService.getIteratorAsList(iterator));
    }


    public static <T1, T2> OrionConcurrentHashMap<T1, T2> of()
    {
        return new OrionConcurrentHashMap<T1, T2>();
    }


    public static <T1, T2> OrionConcurrentHashMap<T1, T2> of(int size)
    {
        return new OrionConcurrentHashMap<T1, T2>(size);
    }


    public static <T1, T2> OrionConcurrentHashMap<T1, T2> of(int size, float loadFactor)
    {
        return new OrionConcurrentHashMap<T1, T2>(size, loadFactor);
    }


    public static <T1, T2> OrionConcurrentHashMap<T1, T2> of(int size, float loadFactor, int numberOfThreadsToUse)
    {
        return new OrionConcurrentHashMap<T1, T2>(size, loadFactor, numberOfThreadsToUse);
    }


    public static <T1, T2> OrionConcurrentHashMap<T1, T2> of(T1 key, T2 value)
    {
        return new OrionConcurrentHashMap<T1, T2>(key, value);
    }


    public static <T1, T2> OrionConcurrentHashMap<T1, T2> of(Map<T1, T2> other)
    {
        return new OrionConcurrentHashMap<T1, T2>(other);
    }


    public static <T1, T2> OrionConcurrentHashMap<T1, T2> of(OrionList<Map.Entry<T1, T2>> other)
    {
        return new OrionConcurrentHashMap<T1, T2>(other);
    }


    public static <T1, T2> OrionConcurrentHashMap<T1, T2> of(Enumeration<Map.Entry<T1, T2>> enumeration)
    {
        return new OrionConcurrentHashMap<T1, T2>(enumeration);
    }


    public static <T1, T2> OrionConcurrentHashMap<T1, T2> of(Iterator<Map.Entry<T1, T2>> iterator)
    {
        return new OrionConcurrentHashMap<T1, T2>(iterator);
    }


    @Override
    public OrionMap<T1, T2>[] splitMapIntoSubmaps(int numberOfSubmaps)
    {
        return splitMapIntoSubmaps(numberOfSubmaps, OrionConcurrentHashMap::new);
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
    public OrionConcurrentHashMap<T1, T2> clone() throws CloneNotSupportedException
    {
        return (OrionConcurrentHashMap<T1, T2>)CloningService.clone(this);
    }


    @Override
    public OrionConcurrentHashMap<T1, T2> getCopy()
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