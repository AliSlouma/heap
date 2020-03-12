public class Node<T extends Comparable<T>> implements INode {

    Node leftChild;
    Node rightChild;
    Node parent;
    T value;

    public Node(Node leftChild, Node rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public INode <T>getLeftChild() {
        return this.leftChild;
    }

    @Override
    public INode <T> getRightChild() {
        return this.rightChild;
    }

    @Override
    public INode <T>getParent() {
        return this.parent;
    }

    @Override
    public T getValue() {
        return this.value;
    }


    public void setValue(Comparable value) {
        this.value = (T) value;
    }
}
