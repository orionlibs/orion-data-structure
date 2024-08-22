package io.github.orionlibs.orion_data_structure.set.type;

import io.github.orionlibs.orion_data_structure.set.OrionSet;
import io.github.orionlibs.orion_object.CloningService;

public class OrionSingletonHashSet<T> extends OrionUnmodifiableHashSet<T>
{
    @SuppressWarnings("unchecked")
    public OrionSingletonHashSet(T element)
    {
        super(element);
    }


    public static <T> OrionSingletonHashSet<T> of(T element)
    {
        return new OrionSingletonHashSet<T>(element);
    }


    @Override
    public T getRandomElement()
    {
        return getAsList().get(0);
    }


    @Override
    public OrionSet<T>[] split(int numberOfSubstructures)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public OrionSet<T>[] splitGET(int numberOfSubstructures)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public OrionSet<T>[] splitInHalf()
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public OrionSet<T>[] splitInHalfGET()
    {
        throw new UnsupportedOperationException();
    }


    public OrionSet<T>[] splitSetInHalf()
    {
        throw new UnsupportedOperationException();
    }


    public OrionSet<T>[] splitSetInHalfGET()
    {
        throw new UnsupportedOperationException();
    }


    public OrionSet<T>[] splitSetIntoSubsets(int numberOfSubsets)
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
    public OrionSingletonHashSet<T> clone()
    {
        return (OrionSingletonHashSet<T>)CloningService.clone(this);
    }


    @Override
    public OrionSingletonHashSet<T> getCopy()
    {
        return this.clone();
    }
}