package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StrategyTest {



    @Test
    public void strategyTestSevenComplex() {

        InvoiceBuilder ib = new InvoiceBuilder();
        //Papier2 und Schere2 enthalten in Ihrer "description" den String "seven" also werden Sie mit 7% Mehrwertsteuer berechnet.
        ib.addLineItem(new LineItem(13, new Article("Papier2seven",new Money(1210))));
        ib.addLineItem(new LineItem(3, new Article("Schere2seven",new Money(588))));
        //Da in der "address" der Invoice der String "complex" vorkommt wird die RechenStrategý aus ComplexTaxStrategy.java verwendet
        Invoice invoice1 = ib.createDefault(new Receiver("Hans", "Reutlingencomplex"));

        assertEquals(187.18, invoice1.grossValue().asDouble(), 0);
        System.out.println("RechnungsbetragBrutto = " + invoice1.grossValue());
    }

    @Test
    public void strategyTestNineteenComplex() {

        InvoiceBuilder ib = new InvoiceBuilder();
        //Papier2 und Schere2 enthalten in Ihrer "description" NICHT den String "seven" also werden Sie mit 19% Mehrwertsteuer berechnet.
        ib.addLineItem(new LineItem(13, new Article("Papier2",new Money(1210))));
        ib.addLineItem(new LineItem(3, new Article("Schere2",new Money(588))));
        //Da in der "address" der Invoice der String "complex" vorkommt wird die RechenStrategý aus ComplexTaxStrategy.java verwendet
        Invoice invoice1 = ib.createDefault(new Receiver("Hans", "Reutlingencomplex"));

        assertEquals(208.18, invoice1.grossValue().asDouble(),0);
        System.out.println("RechnungsbetragBrutto = " + invoice1.grossValue());
    }

    @Test
    public void strategyTestSevenNineteenComplex() {

        InvoiceBuilder ib = new InvoiceBuilder();
        //Papier2 enthält in Ihrer "description" den String "seven" also wird NUR Sie mit 7% Mehrwertsteuer berechnet der Rest mit 19%.
        ib.addLineItem(new LineItem(13, new Article("Papier2seven",new Money(1210))));
        ib.addLineItem(new LineItem(3, new Article("Schere2",new Money(588))));
        //Da in der "address" der Invoice der String "complex" vorkommt wird die RechenStrategý aus ComplexTaxStrategy.java verwendet
        Invoice invoice1 = ib.createDefault(new Receiver("Hans", "Reutlingencomplex"));

        assertEquals(189.30, invoice1.grossValue().asDouble(),0);
        System.out.println("RechnungsbetragBrutto = " + invoice1.grossValue());
    }

    @Test
    public void strategyTestSevenNineteenSimple() {

        InvoiceBuilder ib = new InvoiceBuilder();
        //Bei der Simple Strategy hat die "description" keinen Einfluss auf die Mehrwertsteuer
        ib.addLineItem(new LineItem(13, new Article("Papier2",new Money(1210))));
        ib.addLineItem(new LineItem(3, new Article("Schere2",new Money(588))));
        //Da in der "address" der Invoice der String "simple" vorkommt wird die RechenStrategy aus SimpleTaxStrategy.java verwendet
        Invoice invoice1 = ib.createDefault(new Receiver("Hans", "Reutlingensimple"));

        assertEquals(208.18, invoice1.grossValue().asDouble(),0);
        System.out.println("RechnungsbetragBrutto = " + invoice1.grossValue());
    }

}
