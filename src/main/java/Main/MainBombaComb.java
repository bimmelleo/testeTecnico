package Main;

import model.bombaComb;
import service.BombaCombService;
import java.util.List;

public class MainBombaComb {

    public static void main(String[] args) {

        BombaCombService service = new BombaCombService();

        // =========================
        // 1. INSERT
        // =========================
        System.out.println("=== INSERINDO ===");

        bombaComb b1 = new bombaComb("Bomba A", "Gasolina");
        boolean inserido = service.adicionar(b1);

        System.out.println(inserido ? "Inserido!" : "Falha ao inserir");

        // =========================
        // 2. LISTAR
        // =========================
        System.out.println("\n=== LISTANDO ===");

        List<bombaComb> lista = service.listar();

        for (bombaComb b : lista) {
            System.out.println(b);
        }

        // =========================
        // 3. BUSCAR
        // =========================
        System.out.println("\n=== BUSCANDO ===");

        bombaComb buscado = service.buscar("Bomba A");

        if (buscado != null) {
            System.out.println("Encontrado: " + buscado);
        } else {
            System.out.println("Não encontrado");
        }

        // =========================
        // 4. UPDATE
        // =========================
        System.out.println("\n=== ATUALIZANDO ===");

        if (buscado != null) {
            buscado.setCombAbast("Etanol");

            boolean atualizado = service.atualizar(buscado);
            System.out.println(atualizado ? "Atualizado!" : "Falha ao atualizar");
        }

        // =========================
        // 5. LISTAR NOVAMENTE
        // =========================
        System.out.println("\n=== LISTA ATUALIZADA ===");

        lista = service.listar();

        for (bombaComb b : lista) {
            System.out.println(b);
        }

        // =========================
        // 6. DELETE
        // =========================
//        System.out.println("\n=== REMOVENDO ===");
//
//        boolean removido = service.remover("Bomba A");
//
//        System.out.println(removido ? "Removido!" : "Falha ao remover");

        // =========================
        // 7. LISTA FINAL
        // =========================
        System.out.println("\n=== LISTA FINAL ===");

        lista = service.listar();

        for (bombaComb b : lista) {
            System.out.println(b);
        }

        System.out.println("\n=== TESTE FINALIZADO ===");
    }
}