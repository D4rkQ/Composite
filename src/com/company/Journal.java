package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SAILMA on 19.04.2017. d
 */
public class Journal implements Component {

    private List<Invoice> listOfInvoices = new ArrayList<>();

    public Journal(List<Invoice> listOfInvoices) {
        this.listOfInvoices = listOfInvoices;
    }

    @Override
    public Money evaluate() {
        Money tmp = new Money(0);
        for (Invoice x: listOfInvoices) {
            tmp = tmp.add(x.evaluate());
        }
        return tmp;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "listOfInvoices=" + listOfInvoices +
                '}';
    }
}
