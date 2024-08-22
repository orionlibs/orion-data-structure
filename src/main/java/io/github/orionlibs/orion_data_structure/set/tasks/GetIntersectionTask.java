package io.github.orionlibs.orion_data_structure.set.tasks;

import io.github.orionlibs.orion_data_structure.list.ListService;
import io.github.orionlibs.orion_data_structure.list.OrionList;
import io.github.orionlibs.orion_data_structure.set.OrionSet;
import io.github.orionlibs.orion_data_structure.set.type.OrionHashSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetIntersectionTask
{
    @SuppressWarnings("unchecked")
    public static <T> OrionSet<T> run(OrionSet<T>... sets)
    {
        if((sets != null))
        {
            List<OrionList<T>> lists = new ArrayList<OrionList<T>>();
            Arrays.stream(sets).forEach(set -> lists.add(set.getAsOrionList()));
            return OrionHashSet.<T>of(ListService.getIntersection(lists));
        }
        return null;
    }


    @SuppressWarnings("unchecked")
    public static <T> OrionSet<T> run(List<OrionSet<T>> sets)
    {
        if((sets != null && !sets.isEmpty()))
        {
            return run(sets.toArray(new OrionSet[0]));
        }
        return null;
    }
}