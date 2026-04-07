package testeTecnico.abastecer;

import org.springframework.web.bind.annotation.*;
import testeTecnico.dto.AbastecerInputDTO;
import testeTecnico.dto.AbastecerOutputDTO;
import testeTecnico.dto.BombaCombOutputDTO;
import testeTecnico.dto.TipoCombDTO;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/abastecimentos")
public class AbastecerController {

    private final AbastecerService service;

    public AbastecerController(AbastecerService service) {
        this.service = service;
    }

    @PostMapping("/bomba/{bombaId}")
    public AbastecerOutputDTO criar(@PathVariable Long bombaId,
                                    @RequestBody AbastecerInputDTO dto) {
        Abastecer a = service.criar(bombaId, dto);

        AbastecerOutputDTO output = new AbastecerOutputDTO();
        output.setId(a.getId());
        output.setQuant(a.getQuant());
        output.setValor(a.getValor());
        output.setDate(a.getDate());

        // Mapeia Bomba
        BombaCombOutputDTO bombaDTO = new BombaCombOutputDTO();
        bombaDTO.setId(a.getBomba().getId());
        bombaDTO.setName(a.getBomba().getName());

        // Mapeia TipoComb
        TipoCombDTO tipoDTO = new TipoCombDTO();
        tipoDTO.setId(a.getBomba().getTipoComb().getId());
        tipoDTO.setName(a.getBomba().getTipoComb().getName());
        tipoDTO.setPrecoComb(a.getBomba().getTipoComb().getPrecoComb());

        bombaDTO.setTipoComb(tipoDTO);
        output.setBomba(bombaDTO);

        return output;
    }

    // Metodo de conversão Abastecer -> DTO
    private AbastecerOutputDTO mapToOutputDTO(Abastecer a) {
        AbastecerOutputDTO dto = new AbastecerOutputDTO();
        dto.setId(a.getId());
        dto.setQuant(a.getQuant());
        dto.setValor(a.getValor());
        dto.setDate(a.getDate());

        // Mapear bomba para DTO
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

    @GetMapping
    public List<Abastecer> listar() {
        return service.listar();
    }
}