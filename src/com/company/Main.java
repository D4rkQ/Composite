package com.company;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws Exception {

       Money m0 = new Money(1525);
       Money m1 = new Money(1211);
       Money m2;

        m2 = m0.add(m1);
        System.out.println(m2);
        m2 = m2.subtract(m1);
        System.out.println(m2);
        m2 = m2.mult(5);
        System.out.println(m2);

        InvoiceBuilder ib = new InvoiceBuilder();

        ib.addLineItem(new LineItem(13, new Article("Papier",new Money(1210))));
        ib.addLineItem(new LineItem(3, new Article("Schere",new Money(588))));
        ib.clearLineItems();
        ib.addLineItem(new LineItem(3, new Article("Papier2",new Money(588))));
        ib.addLineItem(new LineItem(3, new Article("Schere2",new Money(588))));
        Invoice invoice1 = ib.createDefault(new Receiver("Hans", "Reutlingen"));

        System.out.println(invoice1.evaluate());

        for (LineItem x: invoice1.getLineItems()) {
            System.out.println(x);
        }

        LocalDate date = LocalDate.now();
        System.out.println(date.plusDays(35));
        System.out.println(date.minusDays(40));

        System.out.println(invoice1);

    }
}
