package io.github.orionlibs.orion_data_structure.queue.type;

import io.github.orionlibs.orion_data_structure.DataStructure;
import io.github.orionlibs.orion_data_structure.DataStructureRules;
import io.github.orionlibs.orion_data_structure.DataStructureService;
import io.github.orionlibs.orion_data_structure.SingleArgumentDataStructure;
import io.github.orionlibs.orion_data_structure.list.OrionList;
import io.github.orionlibs.orion_data_structure.list.type.OrionArrayList;
import io.github.orionlibs.orion_data_structure.list.type.OrionUnmodifiableArrayList;
import io.github.orionlibs.orion_data_structure.queue.OrionQueue;
import io.github.orionlibs.orion_object.CloningService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

@SuppressWarnings("serial")
public class OrionSimpleQueue<T> implements OrionQueue<T>
{
    private static final Object NULL = null;
    private List<T> elements;
    private int cursor;
    private int size;


    public OrionSimpleQueue()
    {
        this.elements = new ArrayList<T>(0);
    }


    public OrionSimpleQueue(Enumeration<T> enumeration)
    {
        this(enumeration.asIterator());
    }


    public OrionSimpleQueue(Iterator<T> iterator)
    {
        this(DataStructureService.getIteratorAsList(iterator));
    }


    public OrionSimpleQueue(Collection<T> elements)
    {
        DataStructureRules.isNotEmpty(elements);
        this.elements = new ArrayList<T>(elements);
        this.size = elements.size();
    }


    public OrionSimpleQueue(SingleArgumentDataStructure<T> elements)
    {
        DataStructureRules.isNotEmpty((DataStructure)elements);
        this.elements = elements.getAsList();
        this.size = elements.size();
    }


    public static <T> OrionSimpleQueue<T> of()
    {
        return new OrionSimpleQueue<T>();
    }


    public static <T> OrionSimpleQueue<T> of(Collection<T> elements)
    {
        return new OrionSimpleQueue<T>(elements);
    }


    public static <T> OrionSimpleQueue<T> of(Enumeration<T> enumeration)
    {
        return new OrionSimpleQueue<T>(enumeration);
    }


    public static <T> OrionSimpleQueue<T> of(Iterator<T> iterator)
    {
        return new OrionSimpleQueue<T>(iterator);
    }


    public static <T> OrionSimpleQueue<T> of(SingleArgumentDataStructure<T> elements)
    {
        return new OrionSimpleQueue<T>(elements);
    }


    @Override
    public boolean add(T element)
    {
        elements.add(element);
        this.size++;
        return true;
    }


    @Override
    public void append(T element)
    {
        add(element);
    }


    @SuppressWarnings("unchecked")
    @Override
    public T remove()
    {
        if(isEmpty())
        {
            throw new NullPointerException();
        }
        else
        {
            T element = elements.get(cursor);
            elements.set(cursor, (T)NULL);
            cursor++;
            this.size--;
            return element;
        }
    }


    @Override
    public T element()
    {
        if(isEmpty())
        {
            throw new NullPointerException();
        }
        else
        {
            return elements.get(cursor);
        }
    }


    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }


    @Override
    public boolean contains(Object o)
    {
        return elements.contains(o);
    }


    @Override
    public Object[] toArray()
    {
        return elements.toArray();
    }


    @Override
    public <T1> T1[] toArray(T1[] a)
    {
        return elements.toArray(a);
    }


    @Override
    public boolean remove(Object o)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public boolean containsAll(Collection<?> c)
    {
        return elements.containsAll(c);
    }


    @Override
    public boolean addAll(Collection<? extends T> c)
    {
        boolean result = elements.addAll(c);
        size = (result) ? size + c.size() : size;
        return result;
    }


    @Override
    public boolean removeAll(Collection<?> c)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public boolean retainAll(Collection<?> c)
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public void clear()
    {
        elements.clear();
        size = 0;
        cursor = 0;
    }


    @Override
    public boolean offer(T element)
    {
        return add(element);
    }


    @Override
    public T poll()
    {
        return (isEmpty()) ? null : remove();
    }


    @Override
    public T peek()
    {
        return (isEmpty()) ? null : elements.get(cursor);
    }


    @Override
    public OrionQueue<T> getSubqueueAsOrionQueue(int startIndex, int endIndex)
    {
        List<T> sublist = getAsOrionList().getSublist(startIndex, endIndex);
        return OrionSimpleQueue.<T>of(sublist);
    }


    @Override
    public OrionQueue<T> getSubqueueInclusiveAsOrionQueue(int startIndex, int endIndex)
    {
        List<T> sublist = getAsOrionList().getSublistInclusive(startIndex, endIndex);
        return OrionSimpleQueue.<T>of(sublist);
    }


    @Override
    public boolean delete(Object element)
    {
        throw new UnsupportedOperationException();
    }


    @SuppressWarnings("unchecked")
    @Override
    public void deleteIf(Predicate<?> filterToApply)
    {
        if(((Predicate<? super T>)filterToApply).test(get()))
        {
            remove();
        }
    }


    @Override
    public T[] getAsArray()
    {
        return OrionArrayList.<T>of(elements).getAsArray();
    }


    @Override
    public OrionList<T> getAsUnmodifiableOrionList()
    {
        return OrionUnmodifiableArrayList.<T>of(elements);
    }


    @Override
    public Iterator<T> iterator()
    {
        return getAsList().iterator();
    }


    @Override
    public int size()
    {
        return this.size;
    }


    @Override
    public String toString()
    {
        if(isEmpty())
        {
            this.elements = new ArrayList<T>(0);
        }
        return elements.toString();
    }


    @Override
    public int hashCode()
    {
        return super.hashCode();
    }


    @Override
    public boolean equals(Object object)
    {
        return super.equals(object);
    }


    @SuppressWarnings("unchecked")
    @Override
    public OrionSimpleQueue<T> clone()
    {
        return (OrionSimpleQueue<T>)CloningService.clone(this);
    }


    @SuppressWarnings("unchecked")
    public OrionSimpleQueue<T> cloneIgnoreUnserialisableException()
    {
        return (OrionSimpleQueue<T>)CloningService.cloneIgnoreUnserialisableException(this);
    }


    @Override
    public OrionSimpleQueue<T> getCopy()
    {
        return this.clone();
    }


    @Override
    public OrionSimpleQueue<T> getCopyIgnoreUnserialisableException()
    {
        return this.cloneIgnoreUnserialisableException();
    }
}