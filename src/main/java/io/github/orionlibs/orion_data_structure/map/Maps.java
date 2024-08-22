package io.github.orionlibs.orion_data_structure.map;

import java.util.Map;

public class Maps
{
    @SuppressWarnings("rawtypes")
    public static boolean isNotEmpty(Map map)
    {
        return map != null && !map.isEmpty();
    }


    @SuppressWarnings("rawtypes")
    public static boolean isNullOrEmpty(Map map)
    {
        return map == null || map.isEmpty();
    }
}