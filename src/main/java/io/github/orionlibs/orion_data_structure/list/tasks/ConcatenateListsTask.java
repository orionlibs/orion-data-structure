package io.github.orionlibs.orion_data_structure.list.tasks;

import io.github.orionlibs.orion_data_structure.list.OrionList;
import io.github.orionlibs.orion_data_structure.list.type.OrionArrayList;
import java.util.Arrays;
import java.util.List;

public class ConcatenateListsTask<T>
{
    @SafeVarargs
    public static <T> OrionList<T> run(OrionList<T>... lists)
    {
        if(lists != null)
        {
            return run(Arrays.asList(lists));
        }
        return null;
    }


    public static <T> OrionList<T> run(List<OrionList<T>> lists)
    {
        if(lists != null)
        {
            if(lists.size() == 1)
            {
                return OrionArrayList.<T>of(lists.get(0));
            }
            else
            {
                int totalSize = lists.stream().mapToInt(list -> list.size()).sum();
                OrionList<T> result = OrionArrayList.of(totalSize);
                lists.forEach(list -> result.addAll(list));
                return result;
            }
        }
        return null;
    }
}