package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class Heap <T extends Comparable<T>> implements IHeap<T>,Cloneable{
    ArrayList<INode<T>> nodes;
    int mySize =0;
    ArrayList <Integer> mysize = new ArrayList<>();
    public Heap() {
        this.nodes = new ArrayList<>();
        this.mysize.add(0);
    }
    public INode<T> getRoot(){
        if(mySize!=0)
         return this.nodes.get(0);
        return null;
    }
    public int size(){
        return this.mySize;
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
        if(mySize==0){
            return null;
        }
        T root = (T) getRoot().getValue();
        if(mySize!=1){
            swap(getRoot(),nodes.get(mySize-1));
        }
        //nodes.remove(mySize-1);
        mySize--;
        mysize.set(0,mySize);
        heapify(getRoot());
        return root;
    }

    public void insert(T element) {
        if (element != null) {
        if (element.equals(-1)) {
            mysize.set(0, nodes.size());
            mySize =nodes.size();
        } else {
                mySize++;
                mysize.set(0, mySize);
                INode tmep = new Node(mySize - 1, nodes, mysize);
                tmep.setValue(element);
                nodes.add(mySize-1,tmep);
                int pos = mySize - 1;
                int parent = (pos - 1) / 2;
                while (nodes.get(pos).getValue().compareTo(nodes.get(parent).getValue()) > 0) {
                    swap(nodes.get(pos), nodes.get(parent));
                    pos = parent;
                    parent = (pos - 1) / 2;
                }
            }
        }
    }
    public void build(Collection<T> unordered) {

        if (unordered != null) {
            nodes.clear();
            Iterator<T> iterator = unordered.iterator();
            mySize = unordered.size();
            mysize.set(0, mySize);

            for (int i = 0; iterator.hasNext(); i++) {
                INode<T> node = new Node(i, nodes, mysize);
                node.setValue(iterator.next());
                this.nodes.add(node);
            }

            int pos = (mySize / 2) - 1;
            for (int j = pos; j >= 0; j--) {
                heapify(nodes.get(j));
            }


        }
    }
}

