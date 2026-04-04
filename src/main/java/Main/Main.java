package Main;

import model.abastecer;
import service.AbastecerService;

import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        AbastecerService service = new AbastecerService();

        // =========================
        // 1. INSERT
        // =========================
        System.out.println("=== INSERINDO ===");

        abastecer novo = new abastecer(
                "Bomba 1",
                new Date(),
                200.0,
                40.0
        );

        boolean inserido = service.adicionar(novo);

        System.out.println(inserido ? "✔ Inserido com sucesso!" : "Falha ao inserir");

        // =========================
        // 2. LISTAR
        // =========================
        System.out.println("\n=== LISTANDO ===");

        List<abastecer> lista = service.listar();

        for (abastecer a : lista) {
            System.out.println("----------------------------");
            System.out.println("ID: " + a.getIdAbast());
            System.out.println("Bomba: " + a.getBomba());
            System.out.println("Data: " + a.getDate());
            System.out.println("Valor: " + a.getValor());
            System.out.println("Quantidade: " + a.getQuant());
        }

        // =========================
        // 3. UPDATE (completo)
        // =========================
        System.out.println("\n=== ATUALIZANDO ===");

        if (!lista.isEmpty()) {

            // pega o último inserido (mais seguro que usar ID fixo)
            abastecer a = lista.get(lista.size() - 1);

            a.setBomba("Bomba 3");
            a.setValor(999.99);
            a.setQuant(99.0);
            a.setDate(new Date());

            boolean atualizado = service.atualizar(a);

            System.out.println(atualizado ? "Atualizado com sucesso!" : "Falha ao atualizar");

        } else {
            System.out.println("Nenhum registro para atualizar.");
        }

        // =========================
        // 4. LISTAR NOVAMENTE
        // =========================
        System.out.println("\n=== LISTANDO APÓS UPDATE ===");

        lista = service.listar();

        for (abastecer a : lista) {
            System.out.println("----------------------------");
            System.out.println("ID: " + a.getIdAbast());
            System.out.println("Bomba: " + a.getBomba());
            System.out.println("Valor: " + a.getValor());
        }

        // =========================
        // 5. DELETE
        // =========================


        // =========================
        // 6. LISTAR FINAL
        // =========================
        System.out.println("\n=== LISTA FINAL ===");

        lista = service.listar();

        for (abastecer a : lista) {
            System.out.println("----------------------------");
            System.out.println("ID: " + a.getIdAbast());
            System.out.println("Bomba: " + a.getBomba());
        }

        System.out.println("\n=== TESTE FINALIZADO ===");
    }
}