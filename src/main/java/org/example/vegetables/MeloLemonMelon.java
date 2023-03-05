package org.example.vegetables;

public class MeloLemonMelon extends BaseVegetable{
    private static final int DEFAULT_POWER = 0;
    private static final int DEFAULT_STAMINA = 0;
    private static final int DEFAULT_REGROW_TIME = 0;
    private static final char DEFAULT_CHAR_VALUE='*';

    public MeloLemonMelon() {
        super(DEFAULT_POWER,DEFAULT_STAMINA,DEFAULT_REGROW_TIME, DEFAULT_CHAR_VALUE);
    }
}
