package org.example.ninjas;

import org.example.core.NinjaNotifierObserver;
import org.example.vegetables.Vegetable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.example.vegetables.Mushroom.DEFAULT_MUSHROOM_POWER;
import static org.example.vegetables.Mushroom.DEFAULT_MUSHROOM_STAMINA;

public class Ninja implements NinjaNotifierObserver {
    private static final int DEFAULT_POWER = 1;
    private static final int DEFAULT_STAMINA = 1;
    private static final int DEFAULT_ROW_POSITION = 0;
    private static final int DEFAULT_COLUMN_POSITION = 0;
    private String name;
    private int power;
    private int stamina;
    private int rowPosition;
    private int columnPosition;
    private List<Vegetable> bag;

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        if (power < 0) power = 0;
        this.power = power;

    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        if (stamina < 0) stamina = 0;
        this.stamina = stamina;

    }

    public Ninja(String name) {
        this.setName(name);
        this.setPower(DEFAULT_POWER);
        this.setStamina(DEFAULT_STAMINA);
        this.setColumnPosition(DEFAULT_COLUMN_POSITION);
        this.setRowPosition(DEFAULT_ROW_POSITION);
        bag = new ArrayList<>();
    }

    public int getRowPosition() {
        return rowPosition;
    }

    public void setRowPosition(int rowPosition) {
        this.rowPosition = rowPosition;
    }

    public int getColumnPosition() {
        return columnPosition;
    }

    public void setColumnPosition(int columnPosition) {
        this.columnPosition = columnPosition;
    }

    public List<Vegetable> getBag() {
        return Collections.unmodifiableList(bag);
    }

    public void setBag(List<Vegetable> bag) {
        this.bag = bag;
    }

    public void eatFromBackpack() {
        for (Vegetable veggie : bag
        ) {
            int veggiePower = veggie.getPower();
            int veggieStamina = veggie.getStamina();
            this.setStamina(this.getStamina() + veggieStamina);
            this.setPower(this.getPower() + veggiePower);
        }

        clearBag();
    }

    public void clearBag() {
        this.bag = new ArrayList<>();
    }

    public void addVegetableToBag(Vegetable vegetable) {
        bag.add(vegetable);
    }

    @Override
    public String toString() {
        return "Winner: " + this.getName() + System.lineSeparator() +
                "Power: " + this.getPower() + System.lineSeparator() +
                "Stamina: " + this.getStamina();
    }

    @Override
    public void onMessage(Ninja sender, int numberOfMeloLemonMelons) {
        if (!sender.equals(this)) {
            this.setPower(this.getPower() + (numberOfMeloLemonMelons * 5 * DEFAULT_MUSHROOM_POWER));
            this.setStamina(this.getStamina() + (numberOfMeloLemonMelons * 5 * DEFAULT_MUSHROOM_STAMINA));
        }
    }
}
