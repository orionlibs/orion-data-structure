package io.github.orionlibs.orion_data_structure.list.tasks;

import java.util.Arrays;
import java.util.List;

public class DoesElementExistInAllListsTask<T>
{
    @SuppressWarnings("unchecked")
    public static <T> boolean run(T element, List<T>... lists)
    {
        if((lists != null && lists.length > 0))
        {
            return run(element, Arrays.asList(lists));
        }
        return true;
    }


    public static <T> boolean run(T element, List<List<T>> lists)
    {
        int numberOfListsThatIncludeElement = 1;
        for(int j = 1; j < lists.size(); j++)
        {
            for(int k = 0; k < lists.get(j).size(); k++)
            {
                if(element.equals(lists.get(j).get(k)))
                {
                    ++numberOfListsThatIncludeElement;
                    break;
                }
            }
        }
        return numberOfListsThatIncludeElement == lists.size();
    }
}