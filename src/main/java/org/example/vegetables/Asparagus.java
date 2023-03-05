package org.example.vegetables;

public class Asparagus extends BaseVegetable {
    private static final int DEFAULT_POWER = 5;
    private static final int DEFAULT_STAMINA = -5;
    private static final int DEFAULT_REGROW_TIME = 2;
    private static final char DEFAULT_CHAR_VALUE='A';

    public Asparagus() {
        super(DEFAULT_POWER,DEFAULT_STAMINA,DEFAULT_REGROW_TIME, DEFAULT_CHAR_VALUE);
    }

}
