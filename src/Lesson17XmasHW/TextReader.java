package Lesson17XmasHW;

public class TextReader {
    private String inputText = "Programming, often referred to as coding, is the process of creating instructions for computers to follow. These instructions, known as code, allow us to develop software applications that perform a wide range of tasks—from simple calculations to complex data processing. The importance of programming in today's digital world cannot be overstated. It powers everything from our smartphones to the internet, and it drives innovation in fields like artificial intelligence and biotechnology.\n" +
            "\n" +
            "The evolution of programming languages has been remarkable. From the early days of machine code and assembly language to the development of high-level languages like FORTRAN and COBOL, and finally to modern languages like Python and JavaScript, programming has continuously adapted to meet the needs of both developers and the industries they serve.\n" +
            "\n" +
            "Programmers play a crucial role in modern society. They are the architects of the digital age, creating the software that powers our daily lives, enables scientific breakthroughs, and drives economic growth. As technology continues to advance, the demand for skilled programmers will only increase.";

    public String[] getWordList(){
        String test = inputText.toLowerCase().replaceAll("/[^a-zA-Z-&#39;]/g", "")
                .replaceAll("\r", "")
                .replaceAll("\n","")
                .replaceAll("  "," ")
                .replaceAll("\\.", " ")
                .replaceAll(",", " ")
                .replaceAll("-", " ");
        String[] test2 = test.split(" ");
        return test2;
    }
}
