package io.github.orionlibs.orion_data_structure;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public interface DataStructure
{
    public int getSize();


    public long getSizeOfNonNull();


    public boolean isEmpty();


    public boolean isNotEmpty();


    public void deleteAll();


    public boolean delete(Object element);


    public boolean deleteAll(List<?> elements);


    public void deleteAllOccurencesOf(Object elementToDelete);


    public void deleteIf(Predicate<?> filterToApply);


    public boolean contains(Object[] elementsToCheck);


    public boolean contains(Collection<Object> elementsToCheck);


    public boolean contains(DataStructure elementsToCheck);


    public boolean notContains(Object[] elements);


    public boolean notContains(Object elementToCheck);


    public boolean notContains(Collection<Object> elements);


    public boolean notContains(DataStructure elements);


    public Object[] getAsArrayOfObjects();


    @SuppressWarnings(
                    {"unchecked"})
    public default <T> Collection<T> getAsUnmodifiableCollection()
    {
        if(this instanceof Collection)
        {
            return Collections.unmodifiableCollection((Collection<T>)this);
        }
        else
        {
            return Collections.unmodifiableCollection((List<T>)getAsUnmodifiableList());
        }
    }


    public DataStructure[] split(int numberOfSubstructures);


    public DataStructure[] splitGET(int numberOfSubstructures);


    public DataStructure[] splitInHalf();


    public DataStructure[] splitInHalfGET();


    public List<?> getAsUnmodifiableList();
}