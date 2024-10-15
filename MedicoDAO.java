import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicoDAO extends AbstractDAO implements DAO<Medico> {

    @Override
    protected String getTableName() {
        return "medicos";
    }

    @Override
    public void adicionar(Medico medico) {
        String sql = "INSERT INTO " + getTableName() + " (nome, especialidade, crm, email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, medico.getNome());
            stmt.setString(2, medico.getDescricaoEspecializacao());  // Usando a descrição da especialização
            stmt.setString(3, medico.getCrm());
            stmt.setString(4, medico.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Medico> listar() {
        List<Medico> medicos = new ArrayList<>();
        String sql = "SELECT * FROM " + getTableName();
        try (Statement stmt = conexao.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String crm = rs.getString("crm");
                String email = rs.getString("email");
                String especializacaoDescricao = rs.getString("especialidade");

                // Decisão da especialização baseada na descrição
                Especializacao especializacao;
                if (especializacaoDescricao.equals("Especialização em atendimento a adultos")) {
                    especializacao = new EspecializacaoAdulto();
                } else if (especializacaoDescricao.equals("Especialização em atendimento infantil")) {
                    especializacao = new EspecializacaoInfantil();
                } else {
                    especializacao = null; // Tratamento para especializações desconhecidas
                }

                // Criação do objeto Medico com os dados recuperados
                Medico medico = new Medico(id, nome, email, crm, especializacao);
                medicos.add(medico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicos;
    }


    @Override
    public void atualizar(Medico medico) {
        String sql = "UPDATE " + getTableName() + " SET nome = ?, especialidade = ?, crm = ?, email = ? WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, medico.getNome());
            stmt.setString(2, medico.getDescricaoEspecializacao());  // Atualizando a especialização
            stmt.setString(3, medico.getCrm());
            stmt.setString(4, medico.getEmail());
            stmt.setInt(5, medico.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void deletar(int id) {
        String sql = "DELETE FROM " + getTableName() + " WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}