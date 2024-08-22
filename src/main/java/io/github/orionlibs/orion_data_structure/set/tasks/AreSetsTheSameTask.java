package io.github.orionlibs.orion_data_structure.set.tasks;

import io.github.orionlibs.orion_data_structure.list.ListService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class AreSetsTheSameTask<T>
{
    @SuppressWarnings("unchecked")
    public static <T> boolean run(Set<T>... sets)
    {
        if(sets != null)
        {
            return run(Arrays.asList(sets));
        }
        else
        {
            return false;
        }
    }


    public static <T> boolean run(List<Set<T>> sets)
    {
        if((sets != null && !sets.isEmpty()))
        {
            List<List<T>> lists = new ArrayList<List<T>>();
            sets.stream().forEach(set -> lists.add(new ArrayList<T>(set)));
            return ListService.areListsTheSame(lists);
        }
        return true;
    }
}