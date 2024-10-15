import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PsicologoDAO extends AbstractDAO implements DAO<Psicologo> {

    @Override
    protected String getTableName() {
        System.out.println("Table Accessed Successfully!");
        return "psicologos";
    }

    @Override
    public void adicionar(Psicologo psicologo) {
        String sql = "INSERT INTO " + getTableName() + " (nome, especialidade, crp, email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, psicologo.getNome());
            stmt.setString(2, psicologo.getEspecialidade());
            stmt.setString(3, psicologo.getCrp());
            stmt.setString(4, psicologo.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Psicologo> listar() {
        List<Psicologo> psicologos = new ArrayList<>();
        String sql = "SELECT * FROM " + getTableName();
        try (Statement stmt = conexao.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Psicologo psicologo = new Psicologo();
                psicologo.setId(rs.getInt("id"));
                psicologo.setNome(rs.getString("nome"));
                psicologo.setEspecialidade(rs.getString("especialidade"));
                psicologo.setCrp(rs.getString("crp"));
                psicologo.setEmail(rs.getString("email"));
                psicologos.add(psicologo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return psicologos;
    }

    @Override
    public void atualizar(Psicologo psicologo) {
        String sql = "UPDATE " + getTableName() + " SET nome = ?, especialidade = ?, crp = ?, email = ? WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, psicologo.getNome());
            stmt.setString(2, psicologo.getEspecialidade());
            stmt.setString(3, psicologo.getCrp());
            stmt.setString(4, psicologo.getEmail());
            stmt.setInt(5, psicologo.getId());
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
