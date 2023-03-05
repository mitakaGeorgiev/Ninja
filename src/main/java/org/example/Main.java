package org.example;

import org.example.core.GameManager;
import org.example.core.NinjaNotifier;
import org.example.factory.VegetableFactory;
import org.example.factory.VegetableFactoryImpl;
import org.example.io.ConsoleInputReader;
import org.example.io.ConsoleOutputWriter;
import org.example.io.InputReader;
import org.example.io.OutputWriter;

public class Main {
    public static void main(String[] args) {

        VegetableFactory vegetableFactory = new VegetableFactoryImpl();
        InputReader inputReader = new ConsoleInputReader();
        OutputWriter outputWriter = new ConsoleOutputWriter();
        NinjaNotifier ninjaNotifier = new NinjaNotifier();

        GameManager gameManager = new GameManager(vegetableFactory, inputReader, outputWriter, ninjaNotifier);
        gameManager.run();

        // System.out.println("powera na purvata ninja e " + firstNinja.getPower());
        // System.out.println("staminata na purvata ninja e " + firstNinja.getStamina());
        // System.out.println("pozociqta e " + firstNinja.getRowPosition());
        // System.out.println("poziciqta e " + firstNinja.getColumnPosition());
        // System.out.println();
        // System.out.println("powera na vtorata ninja e " + secondNinja.getPower());
        //System.out.println("staminata na vtorata ninja e " + secondNinja.getStamina());


    }
}