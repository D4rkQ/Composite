package com.company;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by SAILMA on 19.04.2017.
 */
public class CompositeTest {

    @Test
    public void JournalSumTest(){

        InvoiceBuilder ib = new InvoiceBuilder();
        ib.addLineItem(new LineItem(13, new Article("Papier2",new Money(1210))));
        ib.addLineItem(new LineItem(3, new Article("Schere2",new Money(588))));

        Invoice invoice1 = ib.createDefault(new Receiver("Hans", "Reutlingencomplex"));

        assertEquals(174.94, invoice1.evaluate().asDouble(), 0);
        System.out.println("Rechnungsbetrag = " + invoice1.evaluate());


        ib.addLineItem(new LineItem(5, new Article("Papier3",new Money(810))));
        ib.addLineItem(new LineItem(8, new Article("Schere3",new Money(488))));

        Invoice invoice2 = ib.createDefault(new Receiver("Hans2", "Reutlingencomplex2"));

        assertEquals(254.48, invoice2.evaluate().asDouble(), 0);
        System.out.println("Rechnungsbetrag = " + invoice2.evaluate());


        List<Invoice> listOfInvoices = new ArrayList<>();
        listOfInvoices.add(invoice1);
        listOfInvoices.add(invoice2);
        Journal journal = new Journal(listOfInvoices);

        assertEquals(429.42, journal.evaluate().asDouble(), 0);
        System.out.println(journal.evaluate());
    }
}
