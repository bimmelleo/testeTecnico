package testeTecnico.abastecer;

import org.springframework.web.bind.annotation.*;
import testeTecnico.dto.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/abastecimentos")
public class AbastecerController {

    private final AbastecerService service;

    public AbastecerController(AbastecerService service) {
        this.service = service;
    }

    //metodo de criação dos abastecimentos
    @PostMapping("/bomba/{bombaId}")
    public AbastecerOutputDTO criar(@PathVariable Long bombaId,
                                    @RequestBody AbastecerInputDTO dto) {

        Abastecer a = service.criar(bombaId, dto);
        return mapToOutputDTO(a);
    }

    //metodo para listagem dos abastecimentos
    @GetMapping
    public List<AbastecerOutputDTO> listar() {
        return service.listar()
                .stream()
                .map(this::mapToOutputDTO)
                .collect(Collectors.toList());
    }

    //metodo para atualizaçao dos abastecimentos
    @PutMapping("/{id}")
    public AbastecerOutputDTO atualizar(@PathVariable Long id,
                                        @RequestBody AbastecerInputDTO dto) {

        Abastecer a = service.atualizar(id, dto);
        return mapToOutputDTO(a);
    }

    //metodo deletar os abastecimentos
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    //metodo mapper para conversão de tipos dos objetos e evitar
    //erros na relação entre as classes principais
    private AbastecerOutputDTO mapToOutputDTO(Abastecer a) {
        AbastecerOutputDTO dto = new AbastecerOutputDTO();

        dto.setId(a.getId());
        dto.setQuant(a.getQuant());
        dto.setValor(a.getValor());
        dto.setDate(a.getDate());

        BombaCombOutputDTO bombaDTO = new BombaCombOutputDTO();
        bombaDTO.setId(a.getBomba().getId());
        bombaDTO.setName(a.getBomba().getName());

        TipoCombDTO tipoDTO = new TipoCombDTO();
        tipoDTO.setId(a.getBomba().getTipoComb().getId());
        tipoDTO.setName(a.getBomba().getTipoComb().getName());
        tipoDTO.setPrecoComb(a.getBomba().getTipoComb().getPrecoComb());

        bombaDTO.setTipoComb(tipoDTO);
        dto.setBomba(bombaDTO);

        return dto;
    }
}