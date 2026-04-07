package testeTecnico.bombacomb;

import org.springframework.web.bind.annotation.*;
import testeTecnico.tipocomb.TipoComb;
import testeTecnico.tipocomb.TipoCombRepository;
import testeTecnico.dto.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bombas")
@CrossOrigin(origins = "*")
public class BombaCombController {

    private final BombaCombRepository bombaRepo;
    private final TipoCombRepository tipoRepo;

    public BombaCombController(BombaCombRepository bombaRepo, TipoCombRepository tipoRepo) {
        this.bombaRepo = bombaRepo;
        this.tipoRepo = tipoRepo;
    }

    // POST
    @PostMapping
    public BombaCombOutputDTO criar(@RequestBody BombaCombInputDTO dto) {
        if (dto.getTipoCombId() == null) {
            throw new RuntimeException("tipoCombId não pode ser null");
        }

        // Busca TipoComb completo
        TipoComb tipo = tipoRepo.findById(dto.getTipoCombId())
                .orElseThrow(() -> new RuntimeException("TipoComb não encontrado"));

        // Cria BombaComb
        BombaComb bomba = new BombaComb();
        bomba.setName(dto.getName());
        bomba.setTipoComb(tipo);

        // Salva no banco
        BombaComb salvo = bombaRepo.save(bomba);

        return mapToOutputDTO(salvo);
    }

    // GET
    @GetMapping
    public List<BombaCombOutputDTO> listar() {
        return bombaRepo.findAll()
                .stream()
                .map(this::mapToOutputDTO)
                .collect(Collectors.toList());
    }

    // Mapeia entidade para DTO
    private BombaCombOutputDTO mapToOutputDTO(BombaComb bomba) {
        BombaCombOutputDTO dto = new BombaCombOutputDTO();
        dto.setId(bomba.getId());
        dto.setName(bomba.getName());

        TipoComb tipo = bomba.getTipoComb();
        TipoCombDTO tipoDTO = new TipoCombDTO();
        tipoDTO.setId(tipo.getId());
        tipoDTO.setName(tipo.getName());
        tipoDTO.setPrecoComb(tipo.getPrecoComb());

        dto.setTipoComb(tipoDTO);
        return dto;
    }
}