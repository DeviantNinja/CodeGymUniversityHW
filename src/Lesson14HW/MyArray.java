package Lesson14HW;

import java.util.Arrays;

public class MyArray {
    private String[] elements; // 11
    private int nextIndex;

    public MyArray(){
        elements = new String[10];
        nextIndex = 0;
    }

    public void add(String element) {
        if(nextIndex == elements.length) {
            enlarge();
        }
        elements[nextIndex++] = element;
    }

    public void remove(int index){
        if(index < 0 || index >= nextIndex) throw new IndexOutOfBoundsException("Must be between 0 and " + (elements.length - 1));
        String[] newElements = new String[--nextIndex];
        for (int i = 0; i < elements.length -1; i++) {
            if(i >= index) {
                newElements[i] = elements[i+1];
            } else {
                newElements[i] = elements[i];
            }
        }
        elements = newElements;
    }

    private void enlarge(){
        String[] newElements = new String[elements.length +1];
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    public String get(int index) {
        if(index < 0 || index >= nextIndex) throw new IndexOutOfBoundsException("Must be between 0 and " + (elements.length - 1));
        return elements[index];
    }

    public int size() {
        return nextIndex;
    }

    @Override
    public String toString() {
        return  "elements=" + Arrays.toString(elements) +
                ", last element index = " + (nextIndex - 1) +
                ", length =" + nextIndex;

    }
}