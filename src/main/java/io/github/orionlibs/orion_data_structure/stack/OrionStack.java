package io.github.orionlibs.orion_data_structure.stack;

import io.github.orionlibs.orion_data_structure.DataStructure;
import io.github.orionlibs.orion_data_structure.DataStructureRules;
import io.github.orionlibs.orion_data_structure.DataStructureService;
import io.github.orionlibs.orion_data_structure.SingleArgumentDataStructure;
import io.github.orionlibs.orion_data_structure.list.OrionList;
import io.github.orionlibs.orion_data_structure.list.type.OrionUnmodifiableArrayList;
import io.github.orionlibs.orion_object.CloningService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

@SuppressWarnings("serial")
public class OrionStack<T> extends Stack<T> implements OrionList<T>
{
    public OrionStack()
    {
        super();
    }


    public OrionStack(Enumeration<T> enumeration)
    {
        this(enumeration.asIterator());
    }


    public OrionStack(Iterator<T> iterator)
    {
        this(DataStructureService.getIteratorAsList(iterator));
    }


    public OrionStack(Collection<T> elements)
    {
        super();
        DataStructureRules.isNotEmpty(elements);
        List<T> temp = new ArrayList<T>(elements);
        IntStream.range(0, elements.size()).forEach(i -> push(temp.get(i)));
    }


    public OrionStack(SingleArgumentDataStructure<T> elements)
    {
        super();
        DataStructureRules.isNotEmpty((DataStructure)elements);
        List<T> temp = elements.getAsList();
        IntStream.range(0, elements.getSize()).forEach(i -> push(temp.get(i)));
    }


    public static <T> OrionStack<T> of()
    {
        return new OrionStack<T>();
    }


    public static <T> OrionStack<T> of(Collection<T> elements)
    {
        return new OrionStack<T>(elements);
    }


    public static <T> OrionStack<T> of(Enumeration<T> enumeration)
    {
        return new OrionStack<T>(enumeration);
    }


    public static <T> OrionStack<T> of(Iterator<T> iterator)
    {
        return new OrionStack<T>(iterator);
    }


    public static <T> OrionStack<T> of(SingleArgumentDataStructure<T> elements)
    {
        return new OrionStack<T>(elements);
    }


    public int getElementIndexDistanceFromFirstElement(T element)
    {
        return search(element);
    }


    @Override
    public OrionStack<T>[] split(int numberOfSubstructures)
    {
        return splitStackIntoSubstacks(numberOfSubstructures);
    }


    @Override
    public OrionStack<T>[] splitGET(int numberOfSubstructures)
    {
        return getCopy().split(numberOfSubstructures);
    }


    @SuppressWarnings("unchecked")
    public OrionStack<T>[] splitStackIntoSubstacks(int numberOfSubstacks)
    {
        DataStructureRules.isNotEmpty(getSize());
        OrionList<T>[] sublists = ((OrionList<T>)this).split(numberOfSubstacks);
        OrionStack<T>[] substacks = new OrionStack[numberOfSubstacks];
        IntStream.range(0, sublists.length).forEach(i -> substacks[i] = OrionStack.<T>of(sublists[i]));
        return substacks;
    }


    @Override
    public OrionList<T> getSublistAsOrionList(int startIndex, int endIndex)
    {
        return ((OrionList<T>)this).getSublistAsOrionList(startIndex, endIndex);
    }


    public OrionList<T> getSubstackAsOrionList(int startIndex, int endIndex)
    {
        return getSublistAsOrionList(startIndex, endIndex);
    }


    @Override
    public OrionList<T> getSublistInclusiveAsOrionList(int startIndex, int endIndex)
    {
        return ((OrionList<T>)this).getSublistInclusiveAsOrionList(startIndex, endIndex);
    }


    public OrionList<T> getSubstackInclusiveAsOrionList(int startIndex, int endIndex)
    {
        return getSublistInclusiveAsOrionList(startIndex, endIndex);
    }


    @Override
    public void reduceCapacityToMatchSize()
    {
        trimToSize();
    }


    @Override
    public OrionList<T> getAsUnmodifiableOrionList()
    {
        return OrionUnmodifiableArrayList.<T>of(getAsUnmodifiableList());
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
    public OrionStack<T> clone()
    {
        return (OrionStack<T>)CloningService.clone(this);
    }


    @SuppressWarnings("unchecked")
    public OrionStack<T> cloneIgnoreUnserialisableException()
    {
        return (OrionStack<T>)CloningService.cloneIgnoreUnserialisableException(this);
    }


    @Override
    public OrionStack<T> getCopy()
    {
        return this.clone();
    }


    @Override
    public OrionStack<T> getCopyIgnoreUnserialisableException()
    {
        return this.cloneIgnoreUnserialisableException();
    }
}