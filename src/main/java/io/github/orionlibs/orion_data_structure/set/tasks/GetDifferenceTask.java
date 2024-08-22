package io.github.orionlibs.orion_data_structure.set.tasks;

import io.github.orionlibs.orion_data_structure.list.OrionList;
import io.github.orionlibs.orion_data_structure.list.type.OrionArrayList;
import io.github.orionlibs.orion_data_structure.set.OrionSet;
import io.github.orionlibs.orion_data_structure.set.type.OrionHashSet;

public class GetDifferenceTask<T>
{
    @SuppressWarnings("unchecked")
    public static <T> OrionSet<T> run(OrionSet<T> set1, OrionSet<T> set2)
    {
        OrionList<T> result = OrionArrayList.of(set1);
        OrionList<T> intersection = new OrionArrayList<>(GetIntersectionTask.run(set1, set2));
        result.removeAll(intersection);
        return new OrionHashSet<T>(result);
    }
}