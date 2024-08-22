package io.github.orionlibs.orion_data_structure.list;

import io.github.orionlibs.orion_data_structure.list.tasks.AreListsTheSameTask;
import io.github.orionlibs.orion_data_structure.list.tasks.ConcatenateListsTask;
import io.github.orionlibs.orion_data_structure.list.tasks.DoListsSizesMatchTask;
import io.github.orionlibs.orion_data_structure.list.tasks.DoesElementExistInAllListsTask;
import io.github.orionlibs.orion_data_structure.list.tasks.GetIntersectionTask;
import io.github.orionlibs.orion_data_structure.list.tasks.GetListAsArrayTask;
import io.github.orionlibs.orion_data_structure.list.tasks.SubListTask;
import io.github.orionlibs.orion_data_structure.list.tasks.SwapIndicesTask;
import io.github.orionlibs.orion_data_structure.list.type.OrionArrayList;
import java.util.List;

public class ListService<T>
{
    @SuppressWarnings("unchecked")
    public static <T> boolean doesElementExistInAllLists(T element, List<T>... lists)
    {
        return DoesElementExistInAllListsTask.run(element, lists);
    }


    public static <T> boolean doesElementExistInAllLists(T element, List<List<T>> lists)
    {
        return DoesElementExistInAllListsTask.run(element, lists);
    }


    @SuppressWarnings("unchecked")
    public static <T> boolean doListsSizesMatch(List<T>... lists)
    {
        return DoListsSizesMatchTask.run(lists);
    }


    public static <T> boolean doListsSizesMatch(List<List<T>> lists)
    {
        return DoListsSizesMatchTask.run(lists);
    }


    @SuppressWarnings("unchecked")
    public static <T> boolean areListsTheSame(List<T>... lists)
    {
        return AreListsTheSameTask.run(lists);
    }


    public static <T> boolean areListsTheSame(List<List<T>> lists)
    {
        return AreListsTheSameTask.run(lists);
    }


    public static <T> OrionList<T> subList(OrionList<T> list, int startIndex, int endIndex)
    {
        if(startIndex >= 0 && endIndex < list.getSize() && startIndex <= endIndex)
        {
            return SubListTask.run(list, startIndex, endIndex);
        }
        return null;
    }


    public static <T> void swapIndices(OrionList<T> list, int index1, int index2)
    {
        new SwapIndicesTask<T>().run(list, index1, index2);
    }


    @SafeVarargs
    public static <T> OrionList<T> concatenateLists(OrionList<T>... lists)
    {
        return ConcatenateListsTask.run(lists);
    }


    public static <T> OrionList<T> concatenateLists(List<OrionList<T>> lists)
    {
        return ConcatenateListsTask.run(lists);
    }


    @SuppressWarnings("unchecked")
    public static <T> OrionList<T> getIntersection(OrionList<T>... lists)
    {
        return new GetIntersectionTask<T>().run(lists);
    }


    public static <T> OrionList<T> getIntersection(List<OrionList<T>> lists)
    {
        return new GetIntersectionTask<T>().run(lists);
    }


    public static <T> T[] getAsArray(OrionList<T> list)
    {
        return GetListAsArrayTask.<T>run(list);
    }


    public static <T> T[] getAsArray(List<T> list)
    {
        return GetListAsArrayTask.<T>run(OrionArrayList.<T>of(list));
    }
}