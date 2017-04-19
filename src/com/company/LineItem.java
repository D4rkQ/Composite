package com.company;

/**
 * Project: Strategy
 * Created by sailerm on 31.03.2017.
 */
public class LineItem implements Component {

    private final int amount;
    private final Article article;

    public LineItem(int amount, Article article) {
        this.amount = amount;
        this.article = article;
    }

    Money sum()  {
        return article.getMoney().mult(amount);

    }

    @Override
    public String toString() {
        return "LineItem{" +
                "description='" + article.getDescription() + '\'' +
                ", money=" + article.getMoney() +
                ", amount=" + amount +
                '}';
    }

    String getDescription() {
        return article.getDescription();
    }

    public Money getMoney() {
        return article.getMoney();
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public Money evaluate() {
        return this.sum();
    }
}
