package org.example.vegetables;

public class Broccoli extends BaseVegetable {
    private static final int DEFAULT_POWER = 10;
    private static final int DEFAULT_STAMINA = 0;
    private static final int DEFAULT_REGROW_TIME = 3;
    private static final char DEFAULT_CHAR_VALUE='B';
    public Broccoli() {
        super(DEFAULT_POWER,DEFAULT_STAMINA, DEFAULT_REGROW_TIME,DEFAULT_CHAR_VALUE);
    }
}
