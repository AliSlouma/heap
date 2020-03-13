package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.junit.Assert;
import org.junit.Test;


public class Heap <T extends Comparable<T>> implements IHeap<T>,Cloneable{
    ArrayList<INode<T>> nodes;
    int size;
    public Heap() {
        this.nodes = new ArrayList<>();
        int size = nodes.size()-1;
    }
    public INode<T> getRoot(){
        return this.nodes.get(0);
    }
    public int size(){
        return this.nodes.size();
    }
    public void swap(INode<T> node1, INode<T> node2){
        T temp = node1.getValue();
        node1.setValue(node2.getValue());
        node2.setValue(temp);
    }
    public void heapify(INode<T> node) {

        if(node.getLeftChild() != null && node.getRightChild()!= null) {
            if (node.getValue().compareTo(node.getLeftChild().getValue()) < 0 || node.getValue().compareTo(node.getRightChild().getValue()) < 0) {
                if (node.getLeftChild().getValue().compareTo(node.getRightChild().getValue()) < 0) {
                    swap(node, node.getRightChild());
                    heapify(node.getRightChild());

                } else {
                    swap(node, node.getLeftChild());
                    heapify(node.getLeftChild());
                }
            }
        }

    }
    public T extract() {
        T root = (T) getRoot().getValue();
        if(nodes.size()!=1){
        swap(getRoot(),nodes.get(size()-1));
        nodes.remove(size()-1);
        heapify(getRoot());
        }
        return root;
    }

    public void insert(T element) {
        INode tmep = new Node(nodes.size(),nodes);
        tmep.setValue(element);
        nodes.add(tmep);
        int pos =nodes.size();
        int parent = pos/2;
        while (nodes.get(pos).getValue().compareTo(nodes.get(parent).getValue()) >0){
            swap(nodes.get(pos),nodes.get(parent));
            pos =parent;
            parent = pos/2;
        }
    }

    public void build(Collection<T> unordered){
        nodes.clear();
        Iterator iterator = unordered.iterator();
        int size = unordered.size();
        for (int i=0;iterator.hasNext();i++){
            INode<T> node= new Node(i,nodes);
            node.setValue((T) iterator.next());
            this.nodes.add(node);
        }
        int pos = size/2-1;
        for(int i =pos; i>=0;i--){
            heapify(nodes.get(i));
        }
    }
}
