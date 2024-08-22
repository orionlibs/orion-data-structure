package io.github.orionlibs.orion_data_structure.set.tasks;

import io.github.orionlibs.orion_data_structure.set.OrionSet;
import io.github.orionlibs.orion_data_structure.set.type.OrionHashMultiSet;

public class GetIntersectionOfMultiSetsTask<T>
{
    public static <T> OrionSet<T> run(OrionHashMultiSet<T> set1, OrionHashMultiSet<T> set2)
    {
        if(set1 == null || set2 == null)
        {
            return OrionHashMultiSet.<T>of();
        }
        else
        {
            OrionSet<T> result = OrionHashMultiSet.<T>of();
            for(T elementInSet1 : set1.getAsArray())
            {
                if(result.notContains(elementInSet1))
                {
                    if(set2.contains(elementInSet1))
                    {
                        long multiplicityOfElement = Math.min(set1.getMultiplicityOfElement(elementInSet1), set2.getMultiplicityOfElement(elementInSet1));
                        for(long i = 0L; i < multiplicityOfElement; i++)
                        {
                            result.append(elementInSet1);
                        }
                    }
                    else
                    {
                        result.append(elementInSet1);
                    }
                }
            }
            for(T elementInSet2 : set2.getAsArray())
            {
                if(result.notContains(elementInSet2))
                {
                    if(set1.contains(elementInSet2))
                    {
                        long multiplicityOfElement = Math.min(set1.getMultiplicityOfElement(elementInSet2), set2.getMultiplicityOfElement(elementInSet2));
                        for(long i = 0L; i < multiplicityOfElement; i++)
                        {
                            result.append(elementInSet2);
                        }
                    }
                    else
                    {
                        result.append(elementInSet2);
                    }
                }
            }
            return result;
        }
    }
}