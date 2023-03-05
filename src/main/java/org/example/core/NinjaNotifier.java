package org.example.core;

import org.example.ninjas.Ninja;
import org.example.vegetables.Vegetable;

import java.util.LinkedHashSet;
import java.util.Set;

public class NinjaNotifier {
    private static final char DEFAULT_MELOLEMONMELON_CHAR_VALUE = '*';
    private Set<Ninja> observerNinjas;

    public NinjaNotifier() {
        observerNinjas = new LinkedHashSet<>();
    }
public void addNinjaObserver(Ninja currentNinja){
this.observerNinjas.add(currentNinja);
}
    public void Notify(Ninja notifier) {
        int numberOfMeloLemonMelons = 0;
        for (Vegetable currentVegetable : notifier.getBag()) {
            if (currentVegetable.getCharValue() == DEFAULT_MELOLEMONMELON_CHAR_VALUE)
                numberOfMeloLemonMelons++;
        }
        for (Ninja observerNinja:observerNinjas) {
            observerNinja.onMessage(notifier,numberOfMeloLemonMelons);

        }
    }

}
