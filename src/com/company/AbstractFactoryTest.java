package com.company;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class AbstractFactoryTest {


    @Test
    public void testFactory() throws Exception {
        String name = "Hans";
        String address = "Reutlingen";
        Receiver receiver = new Receiver(name, address);
        InvoiceHeaderFactory fac = new InvoiceHeaderFactory();

        InvoiceHeader ihDef1 = fac.createDefaultInvoiceHeader(receiver);
        InvoiceHeader ihDef2 = fac.createDefaultInvoiceHeader(receiver);
        assertEquals(LocalDate.now()+" 0 Receiver{name='"+name+"', address='"+address+"'}", ""+ ihDef1.getBillDate() + " " + ihDef1.getBillNo() + " " + ihDef1.getBillRec());
        assertEquals(LocalDate.now()+" 1 Receiver{name='"+name+"', address='"+address+"'}", ""+ ihDef2.getBillDate() + " " + ihDef2.getBillNo() + " " + ihDef2.getBillRec());
        System.out.println(""+ ihDef1.getBillDate() + " " + ihDef1.getBillNo() + " " + ihDef1.getBillRec());
        System.out.println(""+ ihDef2.getBillDate() + " " + ihDef2.getBillNo() + " " + ihDef2.getBillRec());

        InvoiceHeader ihBack1 = fac.createBackdateInvoiceHeader(receiver);
        InvoiceHeader ihBack2 = fac.createBackdateInvoiceHeader(receiver);
        assertEquals(LocalDate.now().minusDays(10)+" 0 Receiver{name='"+name+"', address='"+address+"'}", ""+ ihBack1.getBillDate() + " " + ihBack1.getBillNo() + " " + ihBack1.getBillRec());
        assertEquals(LocalDate.now().minusDays(10)+" 1 Receiver{name='"+name+"', address='"+address+"'}", ""+ ihBack2.getBillDate() + " " + ihBack2.getBillNo() + " " + ihBack2.getBillRec());
        System.out.println(""+ ihBack1.getBillDate() + " " + ihBack1.getBillNo() + " " + ihBack1.getBillRec());
        System.out.println(""+ ihBack2.getBillDate() + " " + ihBack2.getBillNo() + " " + ihBack2.getBillRec());

    }

}
