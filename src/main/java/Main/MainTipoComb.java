package Main;

import model.tipoComb;
import service.TipoCombService;
import java.util.List;

public class MainTipoComb {

    public static void main(String[] args) {

        TipoCombService service = new TipoCombService();

        System.out.println("=== INSERINDO ===");

        tipoComb t1 = new tipoComb("Gasolina", 5.99);
        boolean inserido = service.adicionar(t1);

        System.out.println(inserido ? "Inserido!" : "Falha ao inserir");


        System.out.println("\n=== LISTANDO ===");

        List<tipoComb> lista = service.listar();

        for (tipoComb t : lista) {
            System.out.println(t);
        }


        System.out.println("\n=== BUSCANDO ===");

        tipoComb buscado = service.buscar("Gasolina");

        if (buscado != null) {
            System.out.println("Encontrado: " + buscado);
        } else {
            System.out.println("Não encontrado");
        }


        System.out.println("\n=== ATUALIZANDO ===");

        if (buscado != null) {
            buscado.setPrecoComb(6.49);

            boolean atualizado = service.atualizar(buscado);
            System.out.println(atualizado ? "Atualizado!" : "Falha ao atualizar");
        }


        System.out.println("\n=== LISTA ATUALIZADA ===");

        lista = service.listar();

        for (tipoComb t : lista) {
            System.out.println(t);
        }


//        System.out.println("\n=== REMOVENDO ===");
//
//        boolean removido = service.remover("Gasolina");
//
//        System.out.println(removido ? "Removido!" : "Falha ao remover");


        System.out.println("\n=== LISTA FINAL ===");

        lista = service.listar();

        for (tipoComb t : lista) {
            System.out.println(t);
        }

        System.out.println("\n=== TESTE FINALIZADO ===");
    }
}