package io.github.orionlibs.orion_data_structure.list.tasks;

import io.github.orionlibs.orion_data_structure.list.ListService;
import io.github.orionlibs.orion_data_structure.list.OrionList;
import io.github.orionlibs.orion_data_structure.list.type.OrionArrayList;
import java.util.List;

public class GetIntersectionTask<T>
{
    @SuppressWarnings("unchecked")
    public OrionList<T> run(List<OrionList<T>> lists)
    {
        if((lists != null && !lists.isEmpty()))
        {
            return run(lists.toArray(new OrionArrayList[0]));
        }
        return null;
    }


    @SuppressWarnings("unchecked")
    public OrionList<T> run(OrionList<T>... lists)
    {
        if((lists != null))
        {
            if(lists.length == 1)
            {
                return OrionArrayList.<T>of(lists[0]);
            }
            else if(lists.length > 1)
            {
                OrionList<T> result = OrionArrayList.of();
                lists[0].stream()
                                .filter(element -> ListService.doesElementExistInAllLists(element, lists))
                                .forEach(element -> result.append(element));
                return result;
            }
        }
        return null;
    }
}