import java.util.ArrayList;

public class Node<T extends Comparable<T>> implements INode {

    INode leftChild =null;
    INode rightChild = null;
    INode parent = null;
    T value;
    int indx;
    ArrayList<IHeap> nodes;

    public <T extends Comparable<T>> Node(int indx , ArrayList<IHeap> nodes) {
        this.indx = indx;
        this.nodes = nodes;
    }
    public INode <T>getLeftChild() {
        return (INode<T>) nodes.get(indx*2+1);
    }

    @Override
    public INode <T> getRightChild() {
        return (INode<T>) nodes.get(indx*2+2);
    }

    @Override
    public INode <T>getParent() {
        return(INode<T>) nodes.get(indx/2);
    }

    @Override
    public T getValue() {
        return this.value;
    }


    public void setValue(Comparable value) {
        this.value = (T) value;
    }
}
