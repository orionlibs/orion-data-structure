package io.github.orionlibs.orion_data_structure.set;

import io.github.orionlibs.orion_data_structure.list.ListService;
import io.github.orionlibs.orion_data_structure.list.OrionList;
import io.github.orionlibs.orion_data_structure.list.type.OrionArrayList;
import io.github.orionlibs.orion_data_structure.set.tasks.AreSetsTheSameTask;
import io.github.orionlibs.orion_data_structure.set.tasks.GetDifferenceOfMultiSetsTask;
import io.github.orionlibs.orion_data_structure.set.tasks.GetDifferenceTask;
import io.github.orionlibs.orion_data_structure.set.tasks.GetIntersectionOfMultiSetsTask;
import io.github.orionlibs.orion_data_structure.set.tasks.GetIntersectionTask;
import io.github.orionlibs.orion_data_structure.set.tasks.GetSumOfMultiSetsTask;
import io.github.orionlibs.orion_data_structure.set.tasks.GetUnionOfMultiSetsTask;
import io.github.orionlibs.orion_data_structure.set.tasks.GetUnionTask;
import io.github.orionlibs.orion_data_structure.set.tasks.IsSubsetOfTask;
import io.github.orionlibs.orion_data_structure.set.tasks.SubSetTask;
import io.github.orionlibs.orion_data_structure.set.type.OrionHashMultiSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class OrionSetService<T>
{
    @SuppressWarnings("unchecked")
    public static <T> boolean doesElementExistInAllSets(T element, Set<T>... sets)
    {
        if(sets != null)
        {
            return doesElementExistInAllLists(element, Arrays.asList(sets));
        }
        else
        {
            return false;
        }
    }


    public static <T> boolean doesElementExistInAllLists(T element, List<Set<T>> sets)
    {
        if(sets != null && !sets.isEmpty())
        {
            List<List<T>> lists = new ArrayList<List<T>>();
            sets.stream().forEach(set -> lists.add(new ArrayList<T>(set)));
            return ListService.doesElementExistInAllLists(element, lists);
        }
        else
        {
            return false;
        }
    }


    @SuppressWarnings("unchecked")
    public static <T> boolean doListsSizesMatch(Set<T>... sets)
    {
        if(sets != null)
        {
            return doListsSizesMatch(Arrays.asList(sets));
        }
        else
        {
            return false;
        }
    }


    public static <T> boolean doListsSizesMatch(List<Set<T>> sets)
    {
        if(sets != null && !sets.isEmpty())
        {
            List<List<T>> lists = new ArrayList<List<T>>();
            sets.stream().forEach(set -> lists.add(new ArrayList<T>(set)));
            return ListService.doListsSizesMatch(lists);
        }
        else
        {
            return false;
        }
    }


    @SuppressWarnings("unchecked")
    public static <T> boolean areSetsTheSame(Set<T>... sets)
    {
        return AreSetsTheSameTask.run(sets);
    }


    public static <T> boolean areSetsTheSame(List<Set<T>> sets)
    {
        return AreSetsTheSameTask.run(sets);
    }


    public static <T> OrionSet<T> subSet(OrionSet<T> set, Predicate<T> filterToApply)
    {
        return SubSetTask.run(set, filterToApply);
    }


    @SafeVarargs
    public static <T> OrionSet<T> getUnion(OrionSet<T>... sets)
    {
        return GetUnionTask.run(sets);
    }


    public static <T> OrionSet<T> getUnion(OrionHashMultiSet<T> set1, OrionHashMultiSet<T> set2)
    {
        return GetUnionOfMultiSetsTask.run(set1, set2);
    }


    public static <T> OrionSet<T> getUnion(List<OrionSet<T>> sets)
    {
        return GetUnionTask.run(sets);
    }


    public static <T> OrionSet<T> getIntersection(OrionHashMultiSet<T> set1, OrionHashMultiSet<T> set2)
    {
        return GetIntersectionOfMultiSetsTask.run(set1, set2);
    }


    @SuppressWarnings("unchecked")
    public static <T> OrionSet<T> getIntersection(OrionSet<T>... sets)
    {
        return GetIntersectionTask.run(sets);
    }


    public static <T> OrionSet<T> getIntersection(List<OrionSet<T>> sets)
    {
        return GetIntersectionTask.run(sets);
    }


    @SuppressWarnings("unchecked")
    public static <T> OrionList<T> getIntersectionAsList(OrionSet<T>... sets)
    {
        return new OrionArrayList<T>(getIntersection(sets));
    }


    public static <T> OrionList<T> getIntersectionAsList(List<OrionSet<T>> sets)
    {
        return new OrionArrayList<T>(getIntersection(sets));
    }


    public static <T> OrionSet<T> getDifference(OrionSet<T> set1, OrionSet<T> set2)
    {
        return GetDifferenceTask.run(set1, set2);
    }


    public static <T> OrionList<T> getDifferenceAsList(OrionSet<T> set1, OrionSet<T> set2)
    {
        return new OrionArrayList<T>(getDifference(set1, set2));
    }


    public static <T> OrionSet<T> getDifference(OrionHashMultiSet<T> set1, OrionHashMultiSet<T> set2)
    {
        return GetDifferenceOfMultiSetsTask.run(set1, set2);
    }


    @SuppressWarnings("unchecked")
    public static <T> OrionSet<T> getSymmetricDifference(OrionSet<T> set1, OrionSet<T> set2)
    {
        OrionSet<T> union = getUnion(set1, set2);
        union.delete(getIntersection(set1, set2));
        return union;
    }


    public static <T> OrionSet<T> getSum(OrionHashMultiSet<T> set1, OrionHashMultiSet<T> set2)
    {
        return GetSumOfMultiSetsTask.run(set1, set2);
    }


    public static <T> boolean isSubsetOf(OrionSet<T> set1, OrionSet<T> set2)
    {
        return IsSubsetOfTask.run(set1, set2);
    }


    public static <T> boolean isProperSubsetOf(OrionSet<T> set1, OrionSet<T> set2)
    {
        return IsSubsetOfTask.run(set1, set2) && set1.getSize() < set2.getSize();
    }
}