package org.example;

import java.util.Date;

public class abastecer {
    private int idAbast;
    private String bomba;
    private Date date;
    private double valor;
    private double quant;
    private static int contagem = 1;

    public abastecer (String bomba, Date date, double valor, double quant) {

        if (bomba == null || bomba.isEmpty()) {
            throw new IllegalArgumentException("Bomba Inválida!");
        }

        if (date == null) {
            throw new IllegalArgumentException("Data Inválida!");
        }

        if (valor <= 0) {
            throw new IllegalArgumentException("Valor DEVE ser maior que zero!");
        }

        if (quant <= 0) {
            throw new IllegalArgumentException("Quantidade abastecida DEVE " +
                    "ser maior que zero!");
        }

        this.idAbast = contagem++;
        this.bomba = bomba;
        this.date = new Date(date.getTime());
        this.valor = valor;
        this.quant = quant;
    }

    public int getIdAbast() {
        return idAbast;
    }

    public String getBomba() {
        return bomba;
    }

    public void setBomba(String bomba) {
        if (bomba == null || bomba.trim().isEmpty()) {
        throw new IllegalArgumentException("Bomba Inválida!");
        } else {
            this.bomba = bomba;
        }
    }

    public Date getDate() {
        return new Date(date.getTime());
    }

    public void setDate(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("Data Inválida!");
        } else {
            this.date = new Date(date.getTime());
        }
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor DEVE ser maior que zero!");
        } else {
            this.valor = valor;
        }
    }

    public double getQuant() {
        return quant;
    }

    public void setQuant(double quant) {
        if (quant <= 0) {
            throw new IllegalArgumentException("Quantidade abastecida DEVE " +
                    "ser maior que zero!");
        } else {
            this.quant = quant;
        }
    }

    @Override
    public String toString() {
        return "Abastecimento: " + idAbast + "\nBomba: " + bomba + " | Abasteceu: " +
                valor + "(" + quant + " litros)" + "\n" + "No dia: " + date;
    }
}
