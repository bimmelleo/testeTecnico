package org.example;

import java.util.ArrayList;
import java.util.List;

public class BombaCombService {

    private List<bombaComb> listaBomb = new ArrayList<>();

    public void adicionar(bombaComb bomba) {
        listaBomb.add(bomba);
    }

    public List<bombaComb> listar() {
        return listaBomb;
    }

    public bombaComb buscar(String name) {
        for (bombaComb t : listaBomb) {
            if (t.getName() != null && t.getName().equalsIgnoreCase(name)) {
                return t;
            }
        }
        return null;
    }

    public boolean atualizar(String name, String newComb) {
        bombaComb t = buscar(name);
        if (t != null) {
            t.setCombAbast(newComb);
            return true;
        }
        return false;
    }

    public boolean remover(String name) {
        bombaComb t = buscar(name);
        if (t != null) {
            listaBomb.remove(t);
            return true;
        }
        return false;
    }
}
