import java.util.ArrayList;
import java.util.Collection;

public class Heap <T extends Comparable<T>> implements IHeap<T> {

    ArrayList<IHeap> nodes ;

    public Heap(ArrayList<IHeap> nodes) {
        this.nodes = nodes;
    }

    public INode<T> getRoot() {


        return (INode<T>) this.nodes.get(0);
    }

    public int size() {
        return this.nodes.size();
    }

    public void heapify(INode<T> node) {

    }

    public T extract() {
        return null;
    }

    public void insert(T element) {

    }

    public void build(Collection<T> unordered) {

    }
}
