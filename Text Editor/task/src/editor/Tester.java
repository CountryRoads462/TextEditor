package editor;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        String str = "{].?";
        System.out.println(TextEditor.convertRegexToWord(str));
    }
}
