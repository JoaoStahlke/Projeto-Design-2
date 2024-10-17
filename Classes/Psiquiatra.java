package Classes;

import EspecializacaoBridge.Especializacao;

public class Psiquiatra extends ProfissionalSaude {
    private String crm;

    public Psiquiatra(int id, String nome, String email, String crm, Especializacao especializacao) {
        super(id, nome, email, especializacao);
        this.crm = crm;
    }

    @Override
    public String getTipo() {
        return "Classes.Psiquiatra";
    }

    public String getCrm() { return crm; }
    public void setCrm(String crm) { this.crm = crm; }
}