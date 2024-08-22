package io.github.orionlibs.orion_data_structure.list;

import io.github.orionlibs.orion_assert.Assert;
import java.util.List;

public class ListRules
{
    @SuppressWarnings("rawtypes")
    public static void notEmpty(List list)
    {
        Assert.notNull(list, "The given list cannot be null.");
    }
}