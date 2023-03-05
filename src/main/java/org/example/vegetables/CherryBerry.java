package org.example.vegetables;

public class CherryBerry extends BaseVegetable {
    private static final int DEFAULT_POWER = 0;
    private static final int DEFAULT_STAMINA = 10;
    private static final int DEFAULT_REGROW_TIME = 5;
    private static final char DEFAULT_CHAR_VALUE='C';

    public CherryBerry() {
        super(DEFAULT_POWER,DEFAULT_STAMINA,DEFAULT_REGROW_TIME,DEFAULT_CHAR_VALUE );
    }
}
