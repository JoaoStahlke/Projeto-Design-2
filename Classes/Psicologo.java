package Classes;

import Classes.Especializacao;
import Classes.ProfissionalSaude;

public class Psicologo extends ProfissionalSaude {
    private String crp;

    public Psicologo(){
        super(0,"","",null);
    }

    public Psicologo(int id, String nome, String email, String crp, Especializacao especializacao) {
        super(id, nome, email, especializacao);
        this.crp = crp;
    }

    @Override
    public String getTipo() {
        return "Psicólogo";
    }

    public String getCrp() { return crp; }
    public void setCrp(String crp) { this.crp = crp; }
}