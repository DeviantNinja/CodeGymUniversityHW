package Lesson15HW;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> test = new MyLinkedList<>();
        test.add("Banana");
        test.add("Shoe");
        test.add("kelsey");
        test.output();
        System.out.println("---");
        test.add("test",2);
        test.output();


    }
}
