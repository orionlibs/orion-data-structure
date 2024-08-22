package io.github.orionlibs.orion_data_structure.tasks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetIteratorAsListTask
{
    public static <T> List<T> run(Iterator<T> iterator)
    {
        List<T> list = new ArrayList<>();
        if(iterator != null)
        {
            iterator.forEachRemaining(e -> list.add(e));
        }
        return list;
    }
}