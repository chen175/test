package com.example.po;

public class Detall {
    private Integer txDetallId;

    private String adress;

    private Double amount;

    private Byte type;

    private String txhash;

    public Integer getTxDetallId() {
        return txDetallId;
    }

    public void setTxDetallId(Integer txDetallId) {
        this.txDetallId = txDetallId;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress == null ? null : adress.trim();
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getTxhash() {
        return txhash;
    }

    public void setTxhash(String txhash) {
        this.txhash = txhash == null ? null : txhash.trim();
    }
}