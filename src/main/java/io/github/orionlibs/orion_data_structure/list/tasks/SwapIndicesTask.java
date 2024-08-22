package io.github.orionlibs.orion_data_structure.list.tasks;

import io.github.orionlibs.orion_data_structure.list.OrionList;

public class SwapIndicesTask<T>
{
    public void run(OrionList<T> list, int index1, int index2)
    {
        if(list != null)
        {
            T element1 = list.get(index1);
            list.set(index1, list.get(index2));
            list.set(index2, element1);
        }
    }
}