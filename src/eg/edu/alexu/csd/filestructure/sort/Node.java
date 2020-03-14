package eg.edu.alexu.csd.filestructure.sort;

import eg.edu.alexu.csd.filestructure.sort.IHeap;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

public class Node<T extends Comparable<T>> implements INode {
    T value;
    int indx;
    ArrayList<INode> nodes;
    ArrayList <Integer> mysize ;

    public <T extends Comparable<T>> Node(int indx ,  ArrayList<INode> nodes,ArrayList <Integer> mysize) {
        this.indx = indx;
        this.nodes = nodes;
        this.mysize =mysize;
    }


    public INode<T> getLeftChild() {
        if(indx*2+1 >= mysize.get(0))
            return null;

        //nodes.size() - mySize;
        return (INode<T>) nodes.get(indx*2+1);
    }

    @Override
    public INode<T> getRightChild() {
        if(indx*2+2 >= mysize.get(0))
            return null;
        return (INode<T>) nodes.get(indx*2+2);
    }

    @Override
    public INode<T> getParent() {
        if(mysize.get(0)==1)
            return null;
        return(INode<T>) nodes.get((indx-1)/2);
    }

    @Override
    public T getValue() {
        return this.value;
    }


    public void setValue(Comparable value) {
        this.value = (T) value;
    }
}
