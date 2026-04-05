package service;

import dao.abastecerDAO;
import model.abastecer;
import java.util.List;

public class AbastecerService {

    private abastecerDAO dao = new abastecerDAO();

    // CREATE
    public boolean adicionar(abastecer abastecimento) {

        if (abastecimento == null) {
            System.out.println("Objeto inválido");
            return false;
        }

        if (abastecimento.getBomba() == null || abastecimento.getBomba().isEmpty()) {
            System.out.println("Bomba inválida");
            return false;
        }

        if (abastecimento.getValor() <= 0) {
            System.out.println("Valor deve ser maior que zero");
            return false;
        }

        if (abastecimento.getQuant() <= 0) {
            System.out.println("Quantidade deve ser maior que zero");
            return false;
        }

        if (abastecimento.getDate() == null) {
            System.out.println("Data inválida");
            return false;
        }

        return dao.inserir(abastecimento);
    }

    // READ (listar todos)
    public List<abastecer> listar() {
        return dao.listar();
    }

    // READ (buscar por ID)
    public abastecer buscar(int idAbast) {
        if (idAbast <= 0) {
            System.out.println("ID inválido");
            return null;
        }
        return dao.buscarPorId(idAbast);
    }

    // UPDATE (geral - recomendado)
    public boolean atualizar(abastecer abastecimento) {

        if (abastecimento == null || abastecimento.getIdAbast() <= 0) {
            System.out.println("Objeto inválido");
            return false;
        }

        return dao.atualizar(abastecimento);
    }

    // DELETE
    public boolean remover(int idAbast) {
        if (idAbast <= 0) {
            System.out.println("ID inválido");
            return false;
        }
        return dao.deletar(idAbast);
    }
}