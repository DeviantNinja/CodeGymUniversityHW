package Lesson21HW.AutoCorrect;

public class Main {
    public static void main(String[] args) {
        AutoCorrect ac = new AutoCorrect();

        System.out.println(ac.checkWord("help",3));
        System.out.println(ac.checkWord("hels", 3));
        System.out.println((ac.checkWord("rennt",3)));
    }
}
