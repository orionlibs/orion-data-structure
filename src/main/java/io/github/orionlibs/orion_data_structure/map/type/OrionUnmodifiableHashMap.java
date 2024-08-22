package io.github.orionlibs.orion_data_structure.map.type;

import io.github.orionlibs.orion_data_structure.DataStructureRules;
import io.github.orionlibs.orion_data_structure.list.OrionList;
import io.github.orionlibs.orion_data_structure.map.OrionMap;
import io.github.orionlibs.orion_object.CloningService;
import java.util.Collection;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class OrionUnmodifiableHashMap<T1, T2> extends OrionHashMap<T1, T2>
{
    public OrionUnmodifiableHashMap()
    {
        super();
    }


    public OrionUnmodifiableHashMap(T1 key, T2 value)
    {
        super(OrionHashMap.<T1, T2>of(key, value));
    }


    public OrionUnmodifiableHashMap(Map<T1, T2> other)
    {
        super(other);
    }


    public OrionUnmodifiableHashMap(OrionList<Entry<T1, T2>> other)
    {
        super();
        DataStructureRules.isNotEmpty((Collection<Map.Entry<T1, T2>>)other);
        other.forAll(mapEntry -> put(mapEntry.getKey(), mapEntry.getValue()));
    }


    public static <T1, T2> OrionUnmodifiableHashMap<T1, T2> empty()
    {
        return new OrionUnmodifiableHashMap<T1, T2>();
    }


    public static <T1, T2> OrionUnmodifiableHashMap<T1, T2> of()
    {
        return new OrionUnmodifiableHashMap<T1, T2>();
    }


    public static <T1, T2> OrionUnmodifiableHashMap<T1, T2> of(T1 key, T2 value)
    {
        return new OrionUnmodifiableHashMap<T1, T2>(key, value);
    }


    public static <T1, T2> OrionUnmodifiableHashMap<T1, T2> of(Map<T1, T2> other)
    {
        return new OrionUnmodifiableHashMap<T1, T2>(other);
    }


    public static <T1, T2> OrionUnmodifiableHashMap<T1, T2> of(OrionList<Map.Entry<T1, T2>> other)
    {
        return new OrionUnmodifiableHashMap<T1, T2>(other);
    }


    @Override
    public OrionMap<T1, T2>[] splitMapIntoSubmaps(int numberOfSubmaps)
    {
        return splitMapIntoSubmaps(numberOfSubmaps, OrionUnmodifiableHashMap::new);
    }


    @Override
    public void clear()
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public boolean delete(Object key)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void delete(Collection<T1> elementsToDelete)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void delete(T1[] elementsToDelete)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void deleteAll()
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void deleteAllOccurencesOf(Object keyToDelete)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void deleteIf(Predicate<?> filterToApply)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public boolean deleteKey(T1 key)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void deleteKeys(T1[] keys)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void deleteKeysIf(Predicate<T1> filterToApply)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void deleteValue(T2 value)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void deleteValueIf(Predicate<T2> filterToApply)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public T2 merge(T1 key, T2 value, BiFunction<? super T2, ? super T2, ? extends T2> remappingFunction)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void nullifyValueForKey(T1 key)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void nullifyValueForKeys(Collection<T1> keys)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void nullifyValueForKeys(T1[] keys)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public T2 put(T1 key, T2 value)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void putAll(Collection<Map.Entry<T1, T2>> entries)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void putAll(OrionList<Map.Entry<T1, T2>> entries)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void putAll(Map<? extends T1, ? extends T2> entries)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public T2 putIfAbsent(T1 key, T2 value)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public T2 remove(Object key)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public boolean remove(Object key, Object value)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public T2 replace(T1 key, T2 value)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public boolean replace(T1 key, T2 oldValue, T2 newValue)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void replaceAll(BiFunction<? super T1, ? super T2, ? extends T2> function)
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
    public OrionUnmodifiableHashMap<T1, T2> clone()
    {
        return (OrionUnmodifiableHashMap<T1, T2>)CloningService.clone(this);
    }


    @Override
    public OrionUnmodifiableHashMap<T1, T2> getCopy()
    {
        return this.clone();
    }
}