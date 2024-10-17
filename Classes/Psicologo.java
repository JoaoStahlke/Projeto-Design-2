package Classes;

import EspecializacaoBridge.Especializacao;

public class Psicologo extends ProfissionalSaude {
    private String crp;

    public Psicologo() {
        super(0, "", "", null);
        this.crp = ""; // Inicializa crp como uma string vazia
    }

    public Psicologo(int id, String nome, String email, String crp, Especializacao especializacao) {
        super(id, nome, email, especializacao);
        this.crp = crp;
    }

    public Psicologo(String text, String text1, String text2) {
        super();
    }

    @Override
    public String getTipo() {
        return "Psicólogo";
    }

    public String getCrp() {
        return crp;
    }

    public void setCrp(String crp) {
        this.crp = crp;
    }
}
