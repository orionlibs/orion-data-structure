package io.github.orionlibs.orion_data_structure.set.tasks;

import io.github.orionlibs.orion_data_structure.set.OrionSet;

public class IsSubsetOfTask<T>
{
    public static <T> boolean run(OrionSet<T> set1, OrionSet<T> set2)
    {
        OrionSet<T> set2Copy = set2.getCopy();
        set2Copy.retainAll(set1);
        return set2Copy.equals(set1);
    }
}