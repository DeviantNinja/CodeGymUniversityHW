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
        System.out.println(array.toString());
        array.remove(0);
        array.remove(1);
        array.remove(2);
        System.out.println(array.toString());
        array.add("Michael");
        array.add("Michael");
        array.add("Michael");
        System.out.println(array.toString());


    }
}
