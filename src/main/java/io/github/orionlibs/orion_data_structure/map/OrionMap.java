package io.github.orionlibs.orion_data_structure.map;

import io.github.orionlibs.orion_data_structure.DataStructure;
import io.github.orionlibs.orion_data_structure.DataStructureRules;
import io.github.orionlibs.orion_data_structure.KeyValueDataStructure;
import io.github.orionlibs.orion_data_structure.array.ArrayRules;
import io.github.orionlibs.orion_data_structure.list.OrionList;
import io.github.orionlibs.orion_data_structure.list.type.OrionArrayList;
import io.github.orionlibs.orion_data_structure.list.type.OrionUnmodifiableArrayList;
import io.github.orionlibs.orion_data_structure.set.OrionSet;
import io.github.orionlibs.orion_data_structure.set.type.OrionHashSet;
import io.github.orionlibs.orion_data_structure.set.type.OrionUnmodifiableHashSet;
import io.github.orionlibs.orion_simple_math.RandomNumberGenerationService;
import io.github.orionlibs.orion_stream.OrionStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public interface OrionMap<T1, T2> extends Map<T1, T2>, KeyValueDataStructure<T1, T2>
{
    public static <T1, T2> Map.Entry<T1, T2> getMapEntry(T1 key, T2 value)
    {
        return Map.entry(key, value);
    }


    @SuppressWarnings("unchecked")
    @Override
    public default boolean contains(Object[] keysToCheck)
    {
        ArrayRules.isValid(keysToCheck);
        return !OrionStream.findAny(keysToCheck, (Object key) -> !containsKey((T1)key));
    }


    @Override
    public default boolean containsKeys(T1[] keysToCheck)
    {
        ArrayRules.isValid(keysToCheck);
        return !OrionStream.findAny(keysToCheck, (T1 key) -> !containsKey(key));
    }


    @SuppressWarnings("unchecked")
    @Override
    public default boolean contains(Collection<Object> keysToCheck)
    {
        DataStructureRules.isNotNull(keysToCheck);
        return !keysToCheck.stream().anyMatch(key -> !containsKey((T1)key));
    }


    @Override
    public default boolean containsKeys(Collection<T1> keysToCheck)
    {
        DataStructureRules.isNotNull(keysToCheck);
        return !keysToCheck.stream().anyMatch(key -> !containsKey(key));
    }


    @Override
    public default boolean contains(DataStructure keysToCheck)
    {
        DataStructureRules.isNotNull(keysToCheck);
        return contains(keysToCheck.getAsArrayOfObjects());
    }


    @Override
    public default boolean containsKeys(DataStructure keysToCheck)
    {
        return contains(keysToCheck);
    }


    @Override
    public default boolean notContains(Object[] keysToCheck)
    {
        return !contains(keysToCheck);
    }


    @Override
    public default boolean notContainsKeys(T1[] keysToCheck)
    {
        return notContains(keysToCheck);
    }


    @SuppressWarnings("unchecked")
    @Override
    public default boolean notContains(Object keyToCheck)
    {
        return !containsKey((T1)keyToCheck);
    }


    @Override
    public default boolean notContainsKey(T1 keyToCheck)
    {
        return !containsKey(keyToCheck);
    }


    @Override
    public default boolean notContains(Collection<Object> keyToCheck)
    {
        return !contains(keyToCheck.toArray());
    }


    @Override
    public default boolean notContainsKeys(Collection<T1> keyToCheck)
    {
        return !notContains(keyToCheck.toArray());
    }


    @Override
    public default boolean notContains(DataStructure keyToCheck)
    {
        return notContains((Collection<?>)keyToCheck.getAsUnmodifiableList());
    }


    @Override
    public default boolean notContainsKeys(DataStructure keyToCheck)
    {
        return notContains(keyToCheck);
    }


    @Override
    public default boolean containsValues(T2[] valuesToCheck)
    {
        ArrayRules.isValid(valuesToCheck);
        return !OrionStream.findAny(valuesToCheck, (T2 value) -> !containsValue(value));
    }


    @Override
    public default boolean containsValues(Collection<T2> valuesToCheck)
    {
        DataStructureRules.isNotNull(valuesToCheck);
        return !valuesToCheck.stream().anyMatch(value -> !containsValue(value));
    }


    @Override
    public default boolean containsValues(DataStructure valuesToCheck)
    {
        DataStructureRules.isNotNull(valuesToCheck);
        return containsValues(valuesToCheck.getAsUnmodifiableCollection());
    }


    @Override
    public default boolean notContainsValues(T2[] valuesToCheck)
    {
        return !containsValues(valuesToCheck);
    }


    @Override
    public default boolean notContainsValue(T2 valueToCheck)
    {
        return !containsValue(valueToCheck);
    }


    @Override
    public default boolean notContainsValues(Collection<T2> valuesToCheck)
    {
        return !containsValues(valuesToCheck);
    }


    @Override
    public default boolean notContainsValues(DataStructure valuesToCheck)
    {
        return notContainsValues(valuesToCheck.getAsUnmodifiableCollection());
    }


    @Override
    public default boolean delete(Object key)
    {
        return remove(key) != null;
    }


    @Override
    public default boolean deleteKey(T1 key)
    {
        return delete(key);
    }


    @Override
    public default void delete(T1[] keys)
    {
        ArrayRules.isValid(keys);
        Arrays.stream(keys).forEach(key -> delete(key));
    }


    @Override
    public default void deleteKeys(T1[] keys)
    {
        delete(keys);
    }


    @SuppressWarnings("unchecked")
    @Override
    public default boolean deleteAll(List<?> elementsToDelete)
    {
        DataStructureRules.isNotNull(elementsToDelete);
        elementsToDelete.forEach(element -> deleteKey((T1)element));
        return true;
    }


    @Override
    public default void delete(Collection<T1> keys)
    {
        DataStructureRules.isNotEmpty(keys);
        keys.stream().forEach(key -> delete(key));
    }


    @SuppressWarnings("unchecked")
    @Override
    public default void deleteIf(Predicate<?> filterToApply)
    {
        Objects.requireNonNull(filterToApply);
        for(T1 key : keySet())
        {
            if(((Predicate<? super T1>)filterToApply).test(key))
            {
                delete(key);
            }
        }
    }


    @Override
    public default void deleteKeysIf(Predicate<T1> filterToApply)
    {
        deleteIf(filterToApply);
    }


    @Override
    public default void deleteValue(T2 value)
    {
        Stream<Map.Entry<T1, T2>> stream = entrySet().stream();
        if(value == null)
        {
            stream = stream.filter(pair -> pair.getValue() == null);
        }
        else
        {
            stream = stream.filter(pair -> pair.getValue().equals(value));
        }
        stream.forEach(pair -> delete(pair.getKey()));
    }


    @Override
    public default void deleteValueIf(Predicate<T2> filterToApply)
    {
        Objects.requireNonNull(filterToApply);
        for(T2 value : values())
        {
            if(((Predicate<? super T2>)filterToApply).test(value))
            {
                deleteValue(value);
            }
        }
    }


    @Override
    public default void nullifyValueForKey(T1 key)
    {
        put(key, null);
    }


    @Override
    public default void nullifyValueForKeys(T1[] keys)
    {
        ArrayRules.isValid(keys);
        Arrays.stream(keys).forEach(key -> nullifyValueForKey(key));
    }


    @Override
    public default void nullifyValueForKeys(Collection<T1> keys)
    {
        DataStructureRules.isNotEmpty(keys);
        keys.forEach(key -> nullifyValueForKey(key));
    }


    @Override
    public default OrionMap<T1, T2>[] split(int numberOfSubstructures)
    {
        return splitMapIntoSubmaps(numberOfSubstructures);
    }


    @Override
    public default OrionMap<T1, T2>[] splitGET(int numberOfSubstructures)
    {
        return getCopy().split(numberOfSubstructures);
    }


    @Override
    public default OrionMap<T1, T2>[] splitInHalf()
    {
        return splitMapInHalf();
    }


    @Override
    public default OrionMap<T1, T2>[] splitInHalfGET()
    {
        return splitMapInHalfGET();
    }


    public default OrionMap<T1, T2>[] splitMapInHalf()
    {
        return splitMapIntoSubmaps(2);
    }


    public default OrionMap<T1, T2>[] splitMapInHalfGET()
    {
        return getCopy().splitMapInHalf();
    }


    public OrionMap<T1, T2>[] splitMapIntoSubmaps(int numberOfSubmaps);


    @SuppressWarnings("unchecked")
    public default OrionMap<T1, T2>[] splitMapIntoSubmaps(int numberOfSubmaps, Function<OrionList<Entry<T1, T2>>, OrionMap<T1, T2>> constructorOfMapImplementationToUse)
    {
        OrionList<Map.Entry<T1, T2>>[] sublists = getSubmapsAsOrionList(numberOfSubmaps);
        OrionMap<T1, T2>[] submaps = new OrionMap[numberOfSubmaps];
        IntStream.range(0, sublists.length)
                        .forEach(i -> submaps[i] = constructorOfMapImplementationToUse.apply(sublists[i]));
        return submaps;
    }


    @Override
    public default List<Map.Entry<T1, T2>> getAsUnmodifiableList()
    {
        return Collections.unmodifiableList(new ArrayList<Map.Entry<T1, T2>>(entrySet()));
    }


    @Override
    public default OrionList<Map.Entry<T1, T2>> getAsUnmodifiableOrionList()
    {
        return OrionUnmodifiableArrayList.<Map.Entry<T1, T2>>of(entrySet());
    }


    public default OrionList<Map.Entry<T1, T2>> getAsOrionList()
    {
        return OrionArrayList.<Map.Entry<T1, T2>>of(entrySet());
    }


    @Override
    public default Set<Map.Entry<T1, T2>> getAsUnmodifiableSet()
    {
        return Collections.unmodifiableSet(entrySet());
    }


    @Override
    public default OrionSet<Entry<T1, T2>> getAsUnmodifiableOrionSet()
    {
        return OrionUnmodifiableHashSet.<Map.Entry<T1, T2>>of(entrySet());
    }


    public default Map<T1, T2> getAsUnmodifiableMap()
    {
        return Collections.unmodifiableMap((Map<T1, T2>)this);
    }


    @Override
    public default Object[] getAsArrayOfObjects()
    {
        return entrySet().toArray();
    }


    @SuppressWarnings(
                    {"unchecked"})
    @Override
    public default Class<T1> getKeyDataType()
    {
        return (Class<T1>)getRandomElement().getKey().getClass();
    }


    @SuppressWarnings(
                    {"unchecked"})
    @Override
    public default Class<T2> getValueDataType()
    {
        return (Class<T2>)get(0).getClass();
    }


    @Override
    public default Map.Entry<T1, T2> getRandomElement()
    {
        int randomIndex = RandomNumberGenerationService.getRandomInteger(getSize());
        return getAsUnmodifiableList().get(randomIndex);
    }


    @Override
    public default void deleteAllOccurencesOf(Object keyToDelete)
    {
        delete(keyToDelete);
    }


    @Override
    public default long getSizeOfNonNull()
    {
        return keySet().stream().filter(e -> e != null).count();
    }


    @Override
    public default int getSize()
    {
        return this.size();
    }


    @Override
    public default void deleteAll()
    {
        this.clear();
    }


    @Override
    public default boolean isNotEmpty()
    {
        return !isEmpty();
    }


    @Override
    public default void putAll(Collection<Map.Entry<T1, T2>> entries)
    {
        DataStructureRules.isNotEmpty(entries);
        entries.forEach(entry -> put(entry.getKey(), entry.getValue()));
    }


    @Override
    public default void putAll(OrionList<Map.Entry<T1, T2>> entries)
    {
        putAll((Collection<Map.Entry<T1, T2>>)entries);
    }


    public default OrionList<Map.Entry<T1, T2>>[] getSubmapsAsOrionList(int numberOfSubmaps)
    {
        DataStructureRules.isNotEmpty(getSize());
        return getAsOrionList().split(numberOfSubmaps);
    }


    public OrionMap<T1, T2> getCopy();


    public default long getFrequencyOfValue(Object value)
    {
        return Collections.frequency(values(), value);
    }


    public default boolean isEntrySetDisjointWith(Map<T1, T2> other)
    {
        return Collections.disjoint(entrySet(), other.entrySet());
    }


    public default boolean isKeySetDisjointWith(Map<T1, T2> other)
    {
        return Collections.disjoint(keySet(), other.keySet());
    }


    public default boolean isValueSetDisjointWith(Map<T1, T2> other)
    {
        return Collections.disjoint(values(), other.values());
    }


    public default T2 putIfAbsent(T1 key, Function<? super T1, ? extends T2> mappingFunction)
    {
        return computeIfAbsent(key, mappingFunction);
    }


    public default T2 putIfPresent(T1 key, BiFunction<? super T1, ? super T2, ? extends T2> remappingFunction)
    {
        return computeIfPresent(key, remappingFunction);
    }


    public default OrionList<T1> getKeysAsOrionList()
    {
        return OrionArrayList.<T1>of(keySet());
    }


    public default OrionSet<T1> getKeysAsOrionSet()
    {
        return OrionHashSet.<T1>of(keySet());
    }


    public default OrionList<T2> getValuesAsOrionList()
    {
        return OrionArrayList.<T2>of(values());
    }


    public default OrionSet<T2> getValuesAsOrionSet()
    {
        return OrionHashSet.<T2>of(values());
    }


    public default void putIf(T1 key, T2 value, BiPredicate<T1, T2> filterToApply)
    {
        if(filterToApply.test(key, value))
        {
            put(key, value);
        }
    }
}