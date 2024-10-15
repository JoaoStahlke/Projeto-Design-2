public class Medico extends ProfissionalSaude {
    private String crm;

    public Medico(int id, String nome, String email, String crm, Especializacao especializacao) {
        super(id, nome, email, especializacao);
        this.crm = crm;
    }

    @Override
    public String getTipo() {
        return "Médico";
    }

    public String getCrm() { return crm; }
    public void setCrm(String crm) { this.crm = crm; }
}