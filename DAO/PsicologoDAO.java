package DAO;

import EspecializacaoBridge.Especializacao;
import EspecializacaoBridge.EspecializacaoAdulto;
import EspecializacaoBridge.EspecializacaoInfantil;
import Classes.Psicologo;

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
        String sql = "INSERT INTO " + getTableName() + " (nome, email, crp, especializacao) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, psicologo.getNome());
            stmt.setString(2, psicologo.getEmail());
            stmt.setString(3, psicologo.getCrp());
            stmt.setString(4, psicologo.getDescricaoEspecializacao());

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
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String crp = rs.getString("crp");
                String especializacaoDescricao = rs.getString("especializacao");

                // Aqui você decide qual especialização criar com base na descrição
                Especializacao especializacao;
                if (especializacaoDescricao.equals("Especialização em atendimento a adultos")) {
                    especializacao = new EspecializacaoAdulto();
                } else if (especializacaoDescricao.equals("Especialização em atendimento infantil")) {
                    especializacao = new EspecializacaoInfantil();
                } else {
                    especializacao = null; // Caso deseje tratar especializações indefinidas
                }

                Psicologo psicologo = new Psicologo(id, nome, email, crp, especializacao);
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
            stmt.setString(2, psicologo.getDescricaoEspecializacao());
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
