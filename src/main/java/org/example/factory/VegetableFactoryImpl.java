package org.example.factory;

import org.example.vegetables.*;

public class VegetableFactoryImpl implements VegetableFactory{
    public Vegetable createVegetable(char currentChar){
        switch (currentChar) {
            case 'A':
                return new Asparagus();

            case 'B':
                return new Broccoli();

            case 'C':
                return new CherryBerry();

            case 'M':
                return new Mushroom();
            case 'R':
                return new Royal();
            case '*':
                return new MeloLemonMelon();
            default:
                return null;

        }

    }
}
