package Classes;

import EspecializacaoBridge.Especializacao;

public class Medico extends ProfissionalSaude {
    private String crm;

    public Medico() {
        super(0, "", "", null);
        this.crm = ""; // Inicializa crm como uma string vazia
    }

    public Medico(int id, String nome, String email, String crm, Especializacao especializacao) {
        super(id, nome, email, especializacao);
        this.crm = crm;
    }

    public Medico(String text, String text1) {
        super();
    }

    @Override
    public String getTipo() {
        return "Médico";
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }
}
