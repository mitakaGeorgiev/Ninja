package org.example.ninjas;

public enum Directions {
    UP,
    DOWN,
    LEFT,
    RIGHT;


    public static Directions getDirection(char currentChar) {
        if (currentChar == ('U')) return Directions.UP;
        if (currentChar == ('D')) return Directions.DOWN;
        if (currentChar == ('L')) return Directions.LEFT;
        if (currentChar == ('R')) return Directions.RIGHT;
        return null;
    }
}
