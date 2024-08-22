package io.github.orionlibs.orion_data_structure.map.type;

import io.github.orionlibs.orion_data_structure.list.OrionList;
import io.github.orionlibs.orion_data_structure.map.OrionMap;
import io.github.orionlibs.orion_object.CloningService;
import java.util.Map;
import java.util.function.Function;

public class OrionSingletonHashMap<T1, T2> extends OrionUnmodifiableHashMap<T1, T2>
{
    public OrionSingletonHashMap(T1 key, T2 value)
    {
        super(key, value);
    }


    public static <T1, T2> OrionSingletonHashMap<T1, T2> of(T1 key, T2 value)
    {
        return new OrionSingletonHashMap<T1, T2>(key, value);
    }


    @Override
    public OrionList<Entry<T1, T2>>[] getSubmapsAsOrionList(int numberOfSubmaps)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public OrionMap<T1, T2>[] splitMapIntoSubmaps(int numberOfSubmaps)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public OrionMap<T1, T2>[] split(int numberOfSubstructures)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public OrionMap<T1, T2>[] splitGET(int numberOfSubstructures)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public OrionMap<T1, T2>[] splitInHalf()
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public OrionMap<T1, T2>[] splitInHalfGET()
    {
        throw new UnsupportedOperationException();
    }


    public OrionMap<T1, T2>[] splitMapInHalf()
    {
        throw new UnsupportedOperationException();
    }


    public OrionMap<T1, T2>[] splitMapInHalfGET()
    {
        throw new UnsupportedOperationException();
    }


    public OrionMap<T1, T2>[] splitMapIntoSubmaps(int numberOfSubmaps, Function<OrionList<Map.Entry<T1, T2>>, OrionMap<T1, T2>> constructorOfMapImplementationToUse)
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
    public OrionSingletonHashMap<T1, T2> clone()
    {
        return (OrionSingletonHashMap<T1, T2>)CloningService.clone(this);
    }


    @Override
    public OrionSingletonHashMap<T1, T2> getCopy()
    {
        return this.clone();
    }
}