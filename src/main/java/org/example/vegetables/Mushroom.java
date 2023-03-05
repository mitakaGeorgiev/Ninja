package org.example.vegetables;

public class Mushroom extends BaseVegetable {
    public static final int DEFAULT_MUSHROOM_POWER = -10;
    public static final int DEFAULT_MUSHROOM_STAMINA = -10;
    private static final int DEFAULT_MUSHROOM_REGROW_TIME = 5;
    private static final char DEFAULT_MUSHROOM_CHAR_VALUE='M';

    public Mushroom() {
        super(DEFAULT_MUSHROOM_POWER, DEFAULT_MUSHROOM_STAMINA,DEFAULT_MUSHROOM_REGROW_TIME,DEFAULT_MUSHROOM_CHAR_VALUE);

    }
}
