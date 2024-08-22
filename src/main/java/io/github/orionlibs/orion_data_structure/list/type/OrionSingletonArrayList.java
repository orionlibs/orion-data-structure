package io.github.orionlibs.orion_data_structure.list.type;

import io.github.orionlibs.orion_data_structure.list.OrionList;
import io.github.orionlibs.orion_object.CloningService;

public class OrionSingletonArrayList<T> extends OrionUnmodifiableArrayList<T>
{
    @SuppressWarnings("unchecked")
    public OrionSingletonArrayList(T element)
    {
        super(element);
    }


    public static <T> OrionSingletonArrayList<T> of(T element)
    {
        return new OrionSingletonArrayList<T>(element);
    }


    @Override
    public OrionList<T> getSublist(int startIndex, int endIndex)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public OrionList<T> getSublistInclusive(int startIndex, int endIndex)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public OrionList<T> getSublistAsOrionList(int startIndex, int endIndex)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public OrionList<T> getSublistInclusiveAsOrionList(int startIndex, int endIndex)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public OrionList<T> getSubstructure(int startIndex, int endIndex)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public OrionList<T>[] split(int numberOfSublists)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public OrionList<T>[] splitGET(int numberOfSublists)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public OrionList<T>[] splitInHalf()
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public OrionList<T>[] splitInHalfGET()
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public int getSize()
    {
        return 1;
    }


    @Override
    public boolean isEmpty()
    {
        return false;
    }


    @Override
    public boolean isNotEmpty()
    {
        return !isEmpty();
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
    public OrionSingletonArrayList<T> clone()
    {
        return (OrionSingletonArrayList<T>)CloningService.clone(this);
    }


    @Override
    public OrionSingletonArrayList<T> getCopy()
    {
        return this.clone();
    }
}