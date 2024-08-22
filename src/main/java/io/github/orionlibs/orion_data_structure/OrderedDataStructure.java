package io.github.orionlibs.orion_data_structure;

public interface OrderedDataStructure extends DataStructure
{
    public void reverse();


    public OrderedDataStructure reverseGET();


    public void rotate(int shift);


    public OrderedDataStructure rotateGET(int shift);
}