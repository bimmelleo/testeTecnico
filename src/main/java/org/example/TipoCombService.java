package org.example;

import java.util.ArrayList;
import java.util.List;

public class TipoCombService {

    private List<tipoComb> listaComb = new ArrayList<>();

    public void adicionar(tipoComb tipo) {
        listaComb.add(tipo);
    }

    public List<tipoComb> listar() {
        return listaComb;
    }

    //utilizando o for para buscar objetos tipoComb dentro da 'listaComb'
    //com a variável t e comparando eles com o name solicitado
    //irá printar oq for equal ao t, caso não exista, será null
    public tipoComb buscar(String name) {
        for (tipoComb t : listaComb) {
            if (t.getName() != null && t.getName().equalsIgnoreCase(name)) {
                //"!= null &&" compara se o t.getName() e define que ambos precisam
                //ser cumpridos com o "&&"
                return t;
            }
        }
        return null;
    }

    //utilizando boolean para definir que podem sair dois tipos de respostas
    //caso a gasolina exista e o preço seja atualizado com sucesso
    //ou se a gasolina nao existir e for um null
    //retornar que é um item 'false'
    public boolean atualizar(String name, double novoPreco) {
        tipoComb t = buscar(name);
        if (t != null) {
            t.setPrecoComb(novoPreco);
            return true;
        }
        return false;
    }

    //utilizando boolean para definir que podem sair dois tipos de respostas
    //caso a gasolina exista ela será removida com sucesso
    //ou se a gasolina nao existir e for um null
    //retornar que é um item 'false'
    public boolean remover(String name) {
        tipoComb t = buscar(name);
        if (t != null) {
            listaComb.remove(t);
            return true;
        }
        return false;
    }
}