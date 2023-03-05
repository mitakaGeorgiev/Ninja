package org.example.io;

public class ConsoleOutputWriter implements OutputWriter{
    @Override
    public void writeLine(String output) {
        System.out.println(output);
    }
}
