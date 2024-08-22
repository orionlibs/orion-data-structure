package io.github.orionlibs.orion_data_structure.set;

import java.util.Set;

public class Sets
{
    @SuppressWarnings("rawtypes")
    public static boolean isNotEmpty(Set set)
    {
        return set != null && !set.isEmpty();
    }


    @SuppressWarnings("rawtypes")
    public static boolean isNullOrEmpty(Set set)
    {
        return set == null || set.isEmpty();
    }
}