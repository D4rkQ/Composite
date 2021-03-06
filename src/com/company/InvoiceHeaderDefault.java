package com.company;

import java.time.LocalDate;

/**
 * Project: Strategy
 * Created by SAILMA on 06.04.2017.
 */
public class InvoiceHeaderDefault implements InvoiceHeader {

    private final LocalDate billDate;
    private final int billNo;
    private final Receiver billRec;
    private static int t;

    InvoiceHeaderDefault(Receiver billRec) {
        this.billDate = LocalDate.now();
        this.billNo = num();
        this.billRec = billRec;

    }

    @Override
    public LocalDate getBillDate() {
        return billDate;
    }

    @Override
    public int getBillNo() {
        return billNo;
    }

    @Override
    public Receiver getBillRec() {
        return billRec;
    }

    private int num() {
        return t++;
    }

    @Override
    public String toString() {
        return "InvoiceHeaderDefault{" +
                "billDate=" + billDate +
                ", billNo=" + billNo +
                ", billRec=" + billRec +
                '}';
    }

}
