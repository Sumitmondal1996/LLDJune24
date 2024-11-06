package com.scaler.lldjun24.parkinglot.models;

import javax.xml.crypto.Data;
import java.util.List;

public class Bill extends BaseModel{
    private Ticket ticket;
    private Data exit_time;
    private Gate gate;
    private BillStatus billStatus;
    private int amount;
    private List<Payment> paymentList;
    private FeeCalculaltionStrategyType feeCalculaltionStrategyType;

    public FeeCalculaltionStrategyType getFeeCalucaltionStrategyType() {
        return feeCalculaltionStrategyType;
    }

    public void setFeeCalucaltionStrategyType(FeeCalculaltionStrategyType feeCalculaltionStrategyType) {
        this.feeCalculaltionStrategyType = feeCalculaltionStrategyType;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public BillStatus getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public Data getExit_time() {
        return exit_time;
    }

    public void setExit_time(Data exit_time) {
        this.exit_time = exit_time;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
