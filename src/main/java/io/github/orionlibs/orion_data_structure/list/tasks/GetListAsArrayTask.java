package io.github.orionlibs.orion_data_structure.list.tasks;

import io.github.orionlibs.orion_data_structure.list.ListRules;
import io.github.orionlibs.orion_data_structure.list.OrionList;
import java.lang.reflect.Array;
import java.util.stream.IntStream;

public class GetListAsArrayTask<T>
{
    @SuppressWarnings("unchecked")
    public static <T> T[] run(OrionList<T> list)
    {
        ListRules.notEmpty(list);
        T[] array = (T[])Array.newInstance(list.getDataType(), list.size());
        if(list.isNotEmpty())
        {
            IntStream.range(0, list.size()).forEach(i -> array[i] = list.get(i));
        }
        return array;
    }
}