import java.util.List;

public class PsicologoController {
    private DAO<Psicologo> dao;

    public PsicologoController() {
        this.dao = new PsicologoDAO();
    }

    public void adicionarPsicologo(Psicologo psicologo) {
        dao.adicionar(psicologo);
    }

    public List<Psicologo> listarPsicologos() {
        return dao.listar();
    }

    public void atualizarPsicologo(Psicologo psicologo) {
        dao.atualizar(psicologo);
    }

    public void deletarPsicologo(int id) {
        dao.deletar(id);
    }
}
