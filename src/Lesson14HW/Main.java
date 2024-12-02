package Lesson14HW;

public class Main {
    public static void main(String[] args) {
        MyArray array = new MyArray();

        for (int i = 0; i < 15; i++) {
            if(i % 2 == 0) {
                array.add("Michael");
            } else {
                array.add("Rue");
            }
        }
        array.remove(0);
        array.remove(1);
        array.remove(2);
        array.add("Michael");
        array.add("Michael");
        array.add("Michael");



    }
}
