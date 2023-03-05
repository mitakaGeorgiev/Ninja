package org.example.vegetables;

public interface Vegetable {
    int getPower();

    void setPower(int power);

    int getStamina();

    void setStamina(int stamina);

    int getRegrowTime();

    int getCurrentGrowth();

    void setCurrentGrowth(int currentGrowth);

    void setRegrowTime(int regrowTime);

    char getCharValue();

    void setCharValue(char charValue);

    boolean isGrown();

    void growIfNotGrown();
}
