package Adapter;

import Classes.Psicologo;
import Controller.PsicologoController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/psicologos")
public class PsicologoRestAdapter {

    private final PsicologoController psicologoController;

    public PsicologoRestAdapter() {
        this.psicologoController = new PsicologoController(); // Controller já utiliza o DAO
    }

    // Adapter para adicionar um psicólogo
    @PostMapping
    public ResponseEntity<String> adicionarPsicologo(@RequestBody Psicologo psicologo) {
        psicologoController.adicionarPsicologo(psicologo);
        return ResponseEntity.ok("Psicólogo adicionado com sucesso.");
    }

    // Adapter para listar todos os psicólogos
    @GetMapping
    public ResponseEntity<List<Psicologo>> listarPsicologos() {
        List<Psicologo> psicologos = psicologoController.listarPsicologos();
        return ResponseEntity.ok(psicologos);
    }

    // Adapter para atualizar um psicólogo
    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarPsicologo(@PathVariable int id, @RequestBody Psicologo psicologo) {
        psicologo.setId(id); // Certifica-se de que o ID está correto
        psicologoController.atualizarPsicologo(psicologo);
        return ResponseEntity.ok("Psicólogo atualizado com sucesso.");
    }

    // Adapter para deletar um psicólogo
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarPsicologo(@PathVariable int id) {
        psicologoController.deletarPsicologo(id);
        return ResponseEntity.ok("Psicólogo deletado com sucesso.");
    }
}
