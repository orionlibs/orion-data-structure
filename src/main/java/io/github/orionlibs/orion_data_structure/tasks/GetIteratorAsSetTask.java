package io.github.orionlibs.orion_data_structure.tasks;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GetIteratorAsSetTask
{
    public static <T> Set<T> run(Iterator<T> iterator)
    {
        Set<T> set = new HashSet<>();
        if(iterator != null)
        {
            iterator.forEachRemaining(e -> set.add(e));
        }
        return set;
    }
}