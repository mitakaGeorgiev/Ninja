package org.example.io;

import java.util.Scanner;

public class ConsoleInputReader implements InputReader{
    private Scanner scanner=new Scanner(System.in);
    @Override
    public String readline() {
        return this.scanner.nextLine();
    }
}
