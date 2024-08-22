package io.github.orionlibs.orion_data_structure;

import io.github.orionlibs.orion_assert.Assert;
import io.github.orionlibs.orion_data_structure.tasks.GetIteratorAsListTask;
import io.github.orionlibs.orion_data_structure.tasks.GetIteratorAsSetTask;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DataStructureService
{
    public static boolean isCollectionDataTypeOfInstance(Collection<?> collection, Object objectToCheck)
    {
        return objectToCheck != null && collection.toArray()[0].getClass().isInstance(objectToCheck);
    }


    public static boolean isDataStructureDataTypeOfInstance(DataStructure dataStructure, Object objectToCheck)
    {
        return objectToCheck != null && dataStructure.getAsArrayOfObjects()[0].getClass().isInstance(objectToCheck);
    }


    public static Object[] getIteratorAsArrayOfObjects(Iterator<?> iterator)
    {
        return getIteratorAsList(iterator).toArray();
    }


    public static <T> List<T> getEnumerationAsList(Enumeration<T> enumeration)
    {
        return getIteratorAsList(enumeration.asIterator());
    }


    public static <T> List<T> getIteratorAsList(Iterator<T> iterator)
    {
        return GetIteratorAsListTask.run(iterator);
    }


    public static <T> Set<T> getEnumerationAsSet(Enumeration<T> enumeration)
    {
        Assert.notNull(enumeration, "The given enumeration cannot be null.");
        return getIteratorAsSet(enumeration.asIterator());
    }


    public static <T> Set<T> getIteratorAsSet(Iterator<T> iterator)
    {
        return GetIteratorAsSetTask.run(iterator);
    }
}