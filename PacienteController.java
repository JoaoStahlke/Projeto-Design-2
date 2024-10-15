import java.util.List;

public class PacienteController {
    private DAO<Paciente> dao;

    public PacienteController() {
        this.dao = new PacienteDAO();
    }

    public void adicionarPaciente(Paciente paciente) {
        dao.adicionar(paciente);
    }

    public List<Paciente> listarPacientes() {
        return dao.listar();
    }

    public void atualizarPaciente(Paciente paciente) {
        dao.atualizar(paciente);
    }

    public void deletarPaciente(int id) {
        dao.deletar(id);
    }
}