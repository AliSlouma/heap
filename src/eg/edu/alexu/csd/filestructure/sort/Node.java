package eg.edu.alexu.csd.filestructure.sort;

import eg.edu.alexu.csd.filestructure.sort.IHeap;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

public class Node<T extends Comparable<T>> implements INode {
    T value;
    int indx;
    ArrayList<IHeap> nodes;

    public <T extends Comparable<T>> Node(int indx , ArrayList<IHeap> nodes) {
        this.indx = indx;
        this.nodes = nodes;
    }
    public INode<T> getLeftChild() {
        if(indx*2+1 >= nodes.size())
            return null;

       // if(nodes)
        return (INode<T>) nodes.get(indx*2+1);
    }

    @Override
    public INode<T> getRightChild() {
        if(indx*2+2 >= nodes.size())
            return null;
        return (INode<T>) nodes.get(indx*2+2);
    }

    @Override
    public INode<T> getParent() {
        if(nodes.size()==1)
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
