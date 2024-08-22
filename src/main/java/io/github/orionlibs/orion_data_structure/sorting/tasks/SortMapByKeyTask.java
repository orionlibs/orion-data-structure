package io.github.orionlibs.orion_data_structure.sorting.tasks;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortMapByKeyTask
{
    public static List<Entry<?, ?>> run(Map<?, ?> map)
    {
        List<Map.Entry<?, ?>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<?, ?>>()
        {
            public int compare(Map.Entry<?, ?> o1, Map.Entry<?, ?> o2)
            {
                if(o1.getKey() instanceof Number && o2.getKey() instanceof Number)
                {
                    BigDecimal number1 = new BigDecimal(o1.getKey().toString());
                    BigDecimal number2 = new BigDecimal(o2.getKey().toString());
                    return (number1).compareTo(number2);
                }
                else
                {
                    return 0;
                }
            }
        });
        return list;
    }
}