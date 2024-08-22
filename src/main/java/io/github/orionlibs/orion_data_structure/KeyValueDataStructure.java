package io.github.orionlibs.orion_data_structure;

import io.github.orionlibs.orion_data_structure.list.OrionList;
import io.github.orionlibs.orion_data_structure.set.OrionSet;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Predicate;

public interface KeyValueDataStructure<T1, T2> extends DataStructure
{
    public Class<T1> getKeyDataType();


    public Class<T2> getValueDataType();


    public Object getRandomElement();


    public boolean containsKeys(T1[] keysToCheck);


    public boolean containsKeys(Collection<T1> keysToCheck);


    public boolean containsKeys(DataStructure keysToCheck);


    public boolean notContainsKeys(T1[] keysToCheck);


    public boolean notContainsKey(T1 keyToCheck);


    public boolean notContainsKeys(Collection<T1> keyToCheck);


    public boolean notContainsKeys(DataStructure keyToCheck);


    public boolean containsValues(T2[] valuesToCheck);


    public boolean containsValues(Collection<T2> valuesToCheck);


    public boolean containsValues(DataStructure valuesToCheck);


    public boolean notContainsValues(T2[] valuesToCheck);


    public boolean notContainsValue(T2 valueToCheck);


    public boolean notContainsValues(Collection<T2> valuesToCheck);


    public boolean notContainsValues(DataStructure valuesToCheck);


    public boolean deleteKey(T1 key);


    public void delete(T1[] keys);


    public void delete(Collection<T1> keys);


    public void deleteKeys(T1[] keys);


    public void deleteKeysIf(Predicate<T1> filterToApply);


    public void deleteValue(T2 value);


    public void deleteValueIf(Predicate<T2> filterToApply);


    public void nullifyValueForKey(T1 key);


    public void nullifyValueForKeys(T1[] keys);


    public void nullifyValueForKeys(Collection<T1> keys);


    public OrionList<Entry<T1, T2>> getAsUnmodifiableOrionList();


    public OrionList<Map.Entry<T1, T2>> getAsOrionList();


    public Set<Map.Entry<T1, T2>> getAsUnmodifiableSet();


    public OrionSet<Entry<T1, T2>> getAsUnmodifiableOrionSet();


    public void putAll(Collection<Map.Entry<T1, T2>> entries);


    public void putAll(OrionList<Map.Entry<T1, T2>> entries);
}