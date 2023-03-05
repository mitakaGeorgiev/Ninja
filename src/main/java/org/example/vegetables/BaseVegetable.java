package org.example.vegetables;

public abstract class BaseVegetable implements Vegetable{
    private int power;
    private int stamina;

    private int regrowTime;
    private  int currentGrowth;
    private char charValue;
    public BaseVegetable(int power, int stamina, int regrowTime, char charValue) {
        this.setPower( power);
        this.setStamina(stamina);
        this.setRegrowTime(regrowTime);
        this.setCharValue(charValue);
        this.setCurrentGrowth(this.getRegrowTime());
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getRegrowTime() {
        return regrowTime;
    }

    public int getCurrentGrowth() {
        return currentGrowth;
    }

    public void setCurrentGrowth(int currentGrowth) {
        this.currentGrowth = currentGrowth;
    }

    public void setRegrowTime(int regrowTime) {
        this.regrowTime = regrowTime;
    }

    public char getCharValue() {
        return charValue;
    }

    public void setCharValue(char charValue) {
        this.charValue = charValue;
    }


    public boolean isGrown(){
        return this.getCurrentGrowth()==this.getRegrowTime();
    }
    public void growIfNotGrown(){
        if(!isGrown())
        this.setCurrentGrowth(this.getCurrentGrowth()+1);

    }
}
