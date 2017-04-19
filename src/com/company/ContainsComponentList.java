package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SAILMA on 19.04.2017. d
 */
public abstract class ContainsComponentList implements Component {

    List<Component> listOfComponents = new ArrayList<>();

    @Override
    public Money evaluate() {
        Money tmp = new Money(0);
        for (Component x : listOfComponents) {
            tmp = tmp.add(x.evaluate());
        }
        return tmp;
    }
}
