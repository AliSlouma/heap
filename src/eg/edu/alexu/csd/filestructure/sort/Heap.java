package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class Heap <T extends Comparable<T>> implements IHeap<T>,Cloneable{
    ArrayList<INode<T>> nodes;
    public Heap() {
        this.nodes = new ArrayList<>();
    }
    public INode<T> getRoot(){
        if(nodes.size()!=0)
         return this.nodes.get(0);

        int k=0;
        return null;
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
        if(node!=null) {
           INode <T> help =node ;
              if(node.getLeftChild()!=null){
                  if(node.getRightChild() !=null && node.getLeftChild().getValue().compareTo(node.getRightChild().getValue()) >0){
                      if(node.getValue().compareTo(node.getLeftChild().getValue())<0) {
                          swap(node, node.getLeftChild());
                          node = node.getLeftChild();
                          heapify(node);
                      }
                  }else if(node.getRightChild() !=null){
                      if(node.getValue().compareTo(node.getRightChild().getValue())<0) {
                          swap(node, node.getRightChild());
                          node = node.getRightChild();
                          heapify(node);
                      }
                  }else if(node.getRightChild() ==null){
                      if(node.getValue().compareTo(node.getLeftChild().getValue())<0) {
                          swap(node, node.getLeftChild());
                          node = node.getLeftChild();
                          heapify(node);
                      }
                  }
              }else
                  return;
        }
    }
    public T extract() {
        if(nodes.size()==0){
            return null;
        }

        T root = (T) getRoot().getValue();
        if(nodes.size()!=1){
            swap(getRoot(),nodes.get(size()-1));
        }
        nodes.remove(size()-1);
        heapify(getRoot());
        return root;
    }

    public void insert(T element) {
        if(element != null) {
            INode tmep = new Node(nodes.size(), nodes);
            tmep.setValue(element);
            nodes.add(tmep);
            int pos = nodes.size()-1;
            int parent = (pos-1) / 2;
            while (nodes.get(pos).getValue().compareTo(nodes.get(parent).getValue()) > 0) {
                swap(nodes.get(pos), nodes.get(parent));
                pos = parent;
                parent = (pos-1) / 2;
            }
        }
    }

    public void build(Collection<T> unordered){

        if(unordered != null){
        nodes.clear();
        Iterator<T> iterator = unordered.iterator();
        int size = unordered.size();

        for (int i=0;iterator.hasNext();i++){
            INode<T> node= new Node(i,nodes);
            node.setValue(iterator.next());
            this.nodes.add(node);
        }

        int pos = (size/2) -1 ;
        for(int j =pos; j>=0;j--){ heapify(nodes.get(j)); }


        }
    }


    public static void main (String[] args){

        Heap h = new Heap();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(4);
        arr.add(3);
        arr.add(5);
        arr.add(1);

        h.insert(5);
        h.insert(1);
        h.insert(3);
        h.insert(2);
        h.insert(9);

        h.extract();
        h.extract();
        h.extract();
        h.extract();
        h.extract();

        int d = 2;
    }
}
