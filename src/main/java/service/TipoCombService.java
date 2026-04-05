package service;

import dao.tipoCombDAO;
import model.tipoComb;
import java.util.List;

public class TipoCombService {

    private tipoCombDAO dao = new tipoCombDAO();


    public boolean adicionar(tipoComb newTipoComb) {

        if (newTipoComb == null) {
            System.out.println("Objeto inválido");
            return false;
        }

        if (newTipoComb.getName() == null || newTipoComb.getName().isEmpty()) {
            System.out.println("Bomba inválida");
            return false;
        }

        if (newTipoComb.getPrecoComb() <= 0) {
            System.out.println("Valor deve ser maior que zero");
            return false;
        }

        return dao.inserir(newTipoComb);
    }


    public List<tipoComb> listar() {
        return dao.listar();
    }


    public tipoComb buscar(String name) {
        if (name == null || name.isEmpty()) {
            System.out.println("Nome inválido");
            return null;
        }
        return dao.buscarPorName(name);
    }


    public boolean atualizar(tipoComb newBomba) {

        if (newBomba == null || newBomba.getName().isEmpty()) {
            System.out.println("Objeto inválido");
            return false;
        }
        return dao.atualizar(newBomba);
    }


    public boolean remover(String name) {
        if (name == null || name.isEmpty()) {
            System.out.println("Nome inválido");
            return false;
        }
        return dao.deletar(name);
    }
}