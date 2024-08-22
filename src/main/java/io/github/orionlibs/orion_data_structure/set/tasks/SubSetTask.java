package io.github.orionlibs.orion_data_structure.set.tasks;

import io.github.orionlibs.orion_data_structure.set.OrionSet;
import io.github.orionlibs.orion_data_structure.set.type.OrionHashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SubSetTask<T>
{
    public static <T> OrionSet<T> run(OrionSet<T> set, Predicate<T> filterToApply)
    {
        if(set != null)
        {
            Set<T> subset = set.filter(filterToApply).collect(Collectors.toSet());
            return OrionHashSet.<T>of(subset);
        }
        return null;
    }
}