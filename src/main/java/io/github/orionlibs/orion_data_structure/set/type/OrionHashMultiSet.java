package io.github.orionlibs.orion_data_structure.set.type;

import io.github.orionlibs.orion_data_structure.DataStructureService;
import io.github.orionlibs.orion_data_structure.UnindexedDataStructure;
import io.github.orionlibs.orion_data_structure.UnorderedDataStructure;
import io.github.orionlibs.orion_data_structure.list.OrionList;
import io.github.orionlibs.orion_data_structure.list.type.OrionArrayList;
import io.github.orionlibs.orion_data_structure.set.OrionSet;
import io.github.orionlibs.orion_data_structure.set.OrionSetService;
import io.github.orionlibs.orion_object.CloningService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class OrionHashMultiSet<T> implements OrionSet<T>, UnorderedDataStructure, UnindexedDataStructure
{
    private Map<T, Integer> elements;


    public OrionHashMultiSet()
    {
        this.elements = new HashMap<T, Integer>();
    }


    public OrionHashMultiSet(int size)
    {
        this.elements = new HashMap<T, Integer>(size);
    }


    public OrionHashMultiSet(int size, float loadFactor)
    {
        this.elements = new HashMap<T, Integer>(size, loadFactor);
    }


    public OrionHashMultiSet(Enumeration<T> enumeration)
    {
        this(enumeration.asIterator());
    }


    public OrionHashMultiSet(Iterator<T> iterator)
    {
        this(DataStructureService.getIteratorAsList(iterator));
    }


    public OrionHashMultiSet(Collection<T> collection)
    {
        Map<T, Integer> elementsTemp = new HashMap<T, Integer>();
        for(T element : collection)
        {
            if(elementsTemp.get(element) != null)
            {
                elementsTemp.put(element, elementsTemp.get(element) + 1);
            }
            else
            {
                elementsTemp.put(element, 1);
            }
        }
        this.elements = elementsTemp;
    }


    @SuppressWarnings("unchecked")
    public OrionHashMultiSet(T... collection)
    {
        this(Arrays.asList(collection));
    }


    @SuppressWarnings("unchecked")
    public OrionHashMultiSet(Collection<T> collection, Collection<T>... collections)
    {
        this(collection);
        if(collections != null && collections.length > 0)
        {
            Arrays.stream(collections).forEach(c -> addAll(c));
        }
    }


    public static <T> OrionHashMultiSet<T> of()
    {
        return new OrionHashMultiSet<T>();
    }


    public static <T> OrionHashMultiSet<T> of(int size)
    {
        return new OrionHashMultiSet<T>(size);
    }


    public static <T> OrionHashMultiSet<T> of(int size, float loadFactor)
    {
        return new OrionHashMultiSet<T>(size, loadFactor);
    }


    public static <T> OrionHashMultiSet<T> of(Collection<T> collection)
    {
        return new OrionHashMultiSet<T>(collection);
    }


    public static <T> OrionHashMultiSet<T> of(Enumeration<T> enumeration)
    {
        return new OrionHashMultiSet<T>(enumeration);
    }


    public static <T> OrionHashMultiSet<T> of(Iterator<T> iterator)
    {
        return new OrionHashMultiSet<T>(iterator);
    }


    @SuppressWarnings("unchecked")
    public static <T> OrionHashMultiSet<T> of(T... collection)
    {
        return new OrionHashMultiSet<T>(collection);
    }


    @SuppressWarnings("unchecked")
    public static <T> OrionHashMultiSet<T> of(Collection<T> collection, Collection<T>... collections)
    {
        return new OrionHashMultiSet<T>(collection, collections);
    }


    public OrionSet<T> getUnion(OrionHashMultiSet<T> other)
    {
        return OrionSetService.getUnion(this, other);
    }


    public OrionSet<T> getIntersection(OrionHashMultiSet<T> other)
    {
        return OrionSetService.getIntersection(this, other);
    }


    public OrionSet<T> getDifference(OrionHashMultiSet<T> other)
    {
        return OrionSetService.getDifference(this, other);
    }


    public OrionSet<T> getSum(OrionHashMultiSet<T> other)
    {
        return OrionSetService.getSum(this, other);
    }


    @Override
    public long getMultiplicityOfElement(T element)
    {
        return (getElements().get(element) != null) ? getElements().get(element) : 0L;
    }


    @Override
    public List<T> getAsList()
    {
        List<T> list = new ArrayList<T>();
        for(Map.Entry<T, Integer> entry : getElements().entrySet())
        {
            IntStream.range(0, entry.getValue()).forEach(i -> list.add(entry.getKey()));
        }
        return list;
    }


    public OrionList<T> getAsOrionList()
    {
        return OrionArrayList.<T>of(getAsList());
    }


    @Override
    public T getRandomElement()
    {
        return getAsList().get(0);
    }


    @Override
    public int size()
    {
        return getElements().values().stream().reduce(0, (size1, size2) -> size1 + size2);
    }


    @Override
    public boolean isEmpty()
    {
        return size() == 0;
    }


    @Override
    public boolean contains(Object element)
    {
        return getElements().containsKey(element);
    }


    @Override
    public Iterator<T> iterator()
    {
        return getAsList().iterator();
    }


    @Override
    public Object[] toArray()
    {
        return getAsList().toArray();
    }


    public T[] toArrayOf(T[] a)
    {
        return getAsOrionList().getAsArray();
    }


    @Override
    public <T> T[] toArray(T[] a)
    {
        throw new UnsupportedOperationException("Please use OrionHashMultiSet.toArrayOf()");
    }


    @Override
    public boolean add(T element)
    {
        if(elements.get(element) != null)
        {
            elements.put(element, elements.get(element) + 1);
        }
        else
        {
            elements.put(element, 1);
        }
        return true;
    }


    @SuppressWarnings("unchecked")
    @Override
    public boolean remove(Object element)
    {
        if(!elements.remove((T)element, 1))
        {
            elements.put((T)element, elements.get((T)element) - 1);
        }
        return true;
    }


    @SuppressWarnings("unchecked")
    @Override
    public boolean containsAll(Collection<?> collection)
    {
        for(Object element : collection)
        {
            if(!contains((T)element))
            {
                return false;
            }
        }
        return true;
    }


    @Override
    public boolean addAll(Collection<? extends T> collection)
    {
        collection.forEach(e -> add(e));
        return true;
    }


    @SuppressWarnings("unchecked")
    @Override
    public boolean retainAll(Collection<?> collection)
    {
        Map<T, Integer> newElements = new HashMap<T, Integer>();
        for(Object element : collection)
        {
            if(contains(element))
            {
                if(newElements.get(element) != null)
                {
                    newElements.put((T)element, newElements.get(element) + 1);
                }
                else
                {
                    newElements.put((T)element, 1);
                }
            }
        }
        this.elements = newElements;
        return true;
    }


    @Override
    public boolean removeAll(Collection<?> collection)
    {
        collection.forEach(e -> remove(e));
        return false;
    }


    @Override
    public void clear()
    {
        this.elements = new HashMap<T, Integer>();
    }


    @Override
    public int hashCode()
    {
        return getElements().hashCode();
    }


    @SuppressWarnings(
                    {"rawtypes", "unchecked"})
    @Override
    public boolean equals(Object object)
    {
        if(object instanceof OrionHashMultiSet)
        {
            OrionHashMultiSet other = (OrionHashMultiSet)object;
            return getElements().keySet().equals(other.getElements().keySet())
                            && new ArrayList(getElements().values()).equals(new ArrayList(other.getElements().values()));
        }
        else
        {
            return false;
        }
    }


    @SuppressWarnings("unchecked")
    @Override
    public OrionHashMultiSet<T> clone()
    {
        return (OrionHashMultiSet<T>)CloningService.clone(this);
    }


    @Override
    public OrionHashMultiSet<T> getCopy()
    {
        return this.clone();
    }


    public Map<T, Integer> getElements()
    {
        return this.elements;
    }
}