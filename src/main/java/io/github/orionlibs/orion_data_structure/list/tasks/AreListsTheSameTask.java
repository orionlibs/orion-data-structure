package io.github.orionlibs.orion_data_structure.list.tasks;

import java.util.Arrays;
import java.util.List;

public class AreListsTheSameTask<T>
{
    @SuppressWarnings("unchecked")
    public static <T> boolean run(List<T>... lists)
    {
        if((lists != null && lists.length > 0))
        {
            return run(Arrays.asList(lists));
        }
        return true;
    }


    public static <T> boolean run(List<List<T>> lists)
    {
        if((lists != null && !lists.isEmpty()))
        {
            int listSize = lists.get(0).size();
            for(int i = 1; i < lists.size(); i++)
            {
                if(listSize != lists.get(i).size())
                {
                    return false;
                }
                for(int j = 0; j < listSize; j++)
                {
                    if(!lists.get(0).get(j).equals(lists.get(i).get(j)))
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}