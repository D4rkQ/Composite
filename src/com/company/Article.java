package com.company;

/**
 * Created by SAILMA on 19.04.2017.
 */
public class Article implements Component {

    private final String description;
    private final Money money;

    public Article(String description, Money money) {
        this.description = description;
        this.money = money;
    }

    public String getDescription() {
        return description;
    }

    public Money getMoney() {
        return money;
    }

    @Override
    public Money evaluate() {
        return money;
    }
}
