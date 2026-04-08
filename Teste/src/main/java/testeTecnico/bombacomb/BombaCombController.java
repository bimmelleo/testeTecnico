package testeTecnico.bombacomb;

import org.springframework.web.bind.annotation.*;
import testeTecnico.dto.*;
import testeTecnico.tipocomb.TipoComb;
import testeTecnico.tipocomb.TipoCombRepository;

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

    //metodo de criação das bombas
    @PostMapping
    public BombaCombOutputDTO criar(@RequestBody BombaCombInputDTO dto) {

        if (dto.getTipoCombId() == null) {
            throw new RuntimeException("TipoComb é obrigatório");
        }

        TipoComb tipo = tipoRepo.findById(dto.getTipoCombId())
                .orElseThrow(() -> new RuntimeException("TipoComb não encontrado"));

        BombaComb bomba = new BombaComb();
        bomba.setName(dto.getName());
        bomba.setTipoComb(tipo);

        return mapToOutputDTO(bombaRepo.save(bomba));
    }

    //metodo para listagem das bombas
    @GetMapping
    public List<BombaCombOutputDTO> listar() {
        return bombaRepo.findAll()
                .stream()
                .map(this::mapToOutputDTO)
                .collect(Collectors.toList());
    }

    //metodo para atualização das bombas
    @PutMapping("/{id}")
    public BombaCombOutputDTO atualizar(@PathVariable Long id,
                                        @RequestBody BombaCombInputDTO dto) {

        BombaComb bomba = bombaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Bomba não encontrada"));

        bomba.setName(dto.getName());

        if (dto.getTipoCombId() != null) {
            TipoComb tipo = tipoRepo.findById(dto.getTipoCombId())
                    .orElseThrow(() -> new RuntimeException("Tipo não encontrado"));
            bomba.setTipoComb(tipo);
        }

        return mapToOutputDTO(bombaRepo.save(bomba));
    }

    //metodo para deletar bombas pelo ID
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        bombaRepo.deleteById(id);
    }

    //metodo mapper para conversão de tipos dos objetos e evitar
    //erros na relação entre as classes principais
    private BombaCombOutputDTO mapToOutputDTO(BombaComb bomba) {
        BombaCombOutputDTO dto = new BombaCombOutputDTO();
        dto.setId(bomba.getId());
        dto.setName(bomba.getName());

        if (bomba.getTipoComb() != null) {
            TipoComb tipo = bomba.getTipoComb();

            TipoCombDTO tipoDTO = new TipoCombDTO();
            tipoDTO.setId(tipo.getId());
            tipoDTO.setName(tipo.getName());
            tipoDTO.setPrecoComb(tipo.getPrecoComb());

            dto.setTipoComb(tipoDTO);
        }

        return dto;
    }
}