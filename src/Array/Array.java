package Array;

public class Array {
    private int[] elements;

    public Array(int size) {
        elements = new int[size];
    }

    public void print() {
        for (int i = 0; i < elements.length; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }

    public void insert(int element) {
        elements[elements.length - 1] = element;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= elements.length) {
            System.out.println("Index out of bounds");
            return;
        }
        // remove the element at the specified index
        // then shift elements to the left
        for (int i = index; i < elements.length - 1; i++) {
            elements[i] = elements[i + 1];
        }
        
    }

}
