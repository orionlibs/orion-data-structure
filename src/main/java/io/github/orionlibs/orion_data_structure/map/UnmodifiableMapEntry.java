package io.github.orionlibs.orion_data_structure.map;

import io.github.orionlibs.orion_object.CloningService;
import java.util.Map;
import java.util.Objects;

public class UnmodifiableMapEntry<T1, T2> implements Map.Entry<T1, T2>
{
    private final T1 key;
    private final T2 value;


    public UnmodifiableMapEntry(T1 key, T2 value)
    {
        this.key = key;
        this.value = value;
    }


    public UnmodifiableMapEntry(Map.Entry<T1, T2> entry)
    {
        Objects.requireNonNull(entry);
        this.key = entry.getKey();
        this.value = entry.getValue();
    }


    public static <T1, T2> UnmodifiableMapEntry<T1, T2> of(T1 key, T2 value)
    {
        return new UnmodifiableMapEntry<T1, T2>(key, value);
    }


    public static <T1, T2> UnmodifiableMapEntry<T1, T2> of(Map.Entry<T1, T2> entry)
    {
        return new UnmodifiableMapEntry<T1, T2>(entry);
    }


    public T1 getKey()
    {
        return this.key;
    }


    public T2 getValue()
    {
        return this.value;
    }


    @Override
    public T2 setValue(T2 value)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public int hashCode()
    {
        int hash = (key == null ? 0 : key.hashCode());
        hash += (value == null ? 0 : value.hashCode());
        return hash;
    }


    @Override
    public boolean equals(Object object)
    {
        if(object instanceof Map.Entry<?, ?>)
        {
            Map.Entry<?, ?> other = (Map.Entry<?, ?>)object;
            return Objects.equals(key, other.getKey()) && Objects.equals(value, other.getValue());
        }
        else
        {
            return false;
        }
    }


    @SuppressWarnings("unchecked")
    @Override
    public UnmodifiableMapEntry<T1, T2> clone()
    {
        return (UnmodifiableMapEntry<T1, T2>)CloningService.clone(this);
    }


    public UnmodifiableMapEntry<T1, T2> getCopy()
    {
        return this.clone();
    }
}