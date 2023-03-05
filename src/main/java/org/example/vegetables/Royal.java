package org.example.vegetables;

public class Royal extends BaseVegetable {
    private static final int DEFAULT_POWER = 20;
    private static final int DEFAULT_STAMINA = 10;
    private static final int DEFAULT_REGROW_TIME = 5;
    private static final char DEFAULT_CHAR_VALUE='R';
    public Royal() {
        super(DEFAULT_POWER,DEFAULT_STAMINA,DEFAULT_REGROW_TIME,DEFAULT_CHAR_VALUE );
    }
}
