package org.example;

import java.util.Date;

public class abastecer {
    private int idAbast;
    private String bomba;
    private Date date;
    private double valor;
    private double quant;

    public abastecer (String bomba, Date date, double valor, double quant) {
        this.bomba = bomba;
        this.date = date;
        this.valor = valor;
        this.quant = quant;
    }

    public int getIdAbast() {
        return idAbast;
    }

    public void setIdAbast() {
        this.idAbast = idAbast;
    }

    public String getBomba() {
        return bomba;
    }

    public void setBomba(String bomba) {
        this.bomba = bomba;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getQuant() {
        return quant;
    }

    public void setQuant(double quant) {
        this.quant = quant;
    }

    @Override
    public String toString() {
        return "Abastecimento: " + idAbast + "\nBomba: " + bomba + " | Abasteceu: " +
                valor + "(" + quant + " litros)" + "\n" + "No dia: " + date;
    }
}
