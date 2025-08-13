package LinkedList;

public class LinkedList {
    private Node first;
    private Node last;

    public LinkedList() {
        first = null;
        last = null;
    }

    public void addFirst(int value){
        Node newNode = new Node(value);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            newNode.setNext(first);
            first = newNode;
        }
    }

    public void addLast(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.setNext(newNode);
            last = newNode;
        } 
    }

    public void deleteFirst() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        if (first == last) {
            first = last = null;
            return;
        }

        var second = first.getNext();
        first.setNext(null);
        first = second;
    }

    public void deleteLast() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        if (first == last) {
            first = null;
            last = null;
            return;
        }

        var previous = getPrevious(last);
        last = previous;
        last.setNext(null);
    }

    public int indexOf(int value){
        int index = 0;
        Node current = first;
        while (current != null) {
            if (current.getValue() == value) return index;
            current = current.getNext();
            index++;
        }
        return -1;
    }

    private boolean isEmpty() {
        return first == null;
    }

    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    private Node getPrevious(Node node) {
        Node current = first;
        while (current != null) {
            if (current.getNext() == node) return current;
            current = current.getNext();
        }
        return null;
    }

}
