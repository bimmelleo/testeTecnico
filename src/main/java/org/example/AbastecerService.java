package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AbastecerService {

    private List<abastecer> listaAbast = new ArrayList<>();

    public void adicionar(abastecer abastecimento) {
        listaAbast.add(abastecimento);
    }

    public List<abastecer> listar() {
        return listaAbast;
    }

    public abastecer buscar(int idAbast) {
        for (abastecer t : listaAbast) {
            if (t.getIdAbast() == idAbast) {
                return t;
            }
        }
        return null;
    }

    public boolean atualizarBomb(int idAbast, String newBomba) {
        abastecer t = buscar(idAbast);
        if (t != null) {
            t.setBomba(newBomba);
            return true;
        }
        return false;
    }

    public boolean atualizarDate(int idAbast, Date newDate) {
        abastecer t = buscar(idAbast);
        if (t != null) {
            t.setDate(newDate);
            return true;
        }
        return false;
    }

    public boolean atualizarValor(int idAbast, double newValor) {
        abastecer t = buscar(idAbast);
        if (t != null) {
            t.setValor(newValor);
            return true;
        }
        return false;
    }

    public boolean atualizarQuant(int idAbast, double newQuant) {
        abastecer t = buscar(idAbast);
        if (t != null) {
            t.setQuant(newQuant);
            return true;
        }
        return false;
    }

    public boolean remover(int idAbast) {
        abastecer t = buscar(idAbast);
        if (t != null) {
            listaAbast.remove(t);
            return true;
        }
        return false;
    }

}

//bimmelleo