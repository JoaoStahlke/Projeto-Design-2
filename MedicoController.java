import java.util.List;

public class MedicoController {
    private DAO<Medico> dao;

    public MedicoController() {
        this.dao = new MedicoDAO();
    }

    public void adicionarMedico(Medico medico) {
        dao.adicionar(medico);
    }

    public List<Medico> listarMedicos() {
        return dao.listar();
    }

    public void atualizarMedico(Medico medico) {
        dao.atualizar(medico);
    }

    public void deletarMedico(int id) {
        dao.deletar(id);
    }
}