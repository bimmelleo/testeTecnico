package service;

import dao.bombaCombDAO;
import model.bombaComb;
import java.util.List;

public class BombaCombService {

    private bombaCombDAO dao = new bombaCombDAO();


    public boolean adicionar(bombaComb newBomba) {

        if (newBomba == null) {
            System.out.println("Objeto inválido");
            return false;
        }

        if (newBomba.getName() == null || newBomba.getName().isEmpty()) {
            System.out.println("Bomba inválida");
            return false;
        }

        if (newBomba.getCombAbast() == null || newBomba.getCombAbast().isEmpty()) {
            System.out.println("Combustível inválido");
            return false;
        }

        return dao.inserir(newBomba);
    }


    public List<bombaComb> listar() {
        return dao.listar();
    }


    public bombaComb buscar(String name) {
        if (name == null || name.isEmpty()) {
            System.out.println("Nome inválido");
            return null;
        }
        return dao.buscarPorName(name);
    }


    public boolean atualizar(bombaComb newBomba) {

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