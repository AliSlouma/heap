import java.util.ArrayList;
import java.util.Collection;

public class Heap <T extends Comparable<T>> implements IHeap<T> ,Cloneable{

    ArrayList<INode> nodes;

    public Heap() {
        this.nodes = new ArrayList<>();
    }

    public INode<T> getRoot() {
        return this.nodes.get(0);
    }

    public int size() {
        return this.nodes.size();
    }

    public void swap(INode<T> node1,INode<T> node2){
        T temp = node1.getValue();
        node1.setValue(node2.getValue());
        node2.setValue(node1.getValue());
    }

    public void heapify(INode<T> node) {

        if(node.getValue().compareTo(node.getLeftChild().getValue()) < 0 || node.getValue().compareTo(node.getRightChild().getValue() ) <0 ){
            if(node.getLeftChild().getValue().compareTo(node.getRightChild().getValue())<0){
                swap(node,node.getRightChild());
                heapify(node.getRightChild());

            }else {
                swap(node,node.getLeftChild());
                heapify(node.getLeftChild());
            }

        }

    }

    public T extract() {
        return null;
    }

    public void insert(T element) {
        INode tmep = new Node(nodes.size(),nodes);
        nodes.add(tmep);
        int pos =nodes.size();
        int parent = pos/2;
        while (nodes.get(pos).getValue().compareTo(nodes.get(parent).getValue()) >0){
            swap(nodes.get(pos),nodes.get(parent));
            pos =parent;
            parent = pos/2;
        }

    }

    public void build(Collection<T> unordered) {





    }
}
