package Classes;

import Classes.Consulta;
import Classes.Especializacao;
import Classes.Observer;

public abstract class ProfissionalSaude implements Observer {
    protected int id;
    protected String nome;
    protected String email;
    protected Especializacao especializacao;

    public ProfissionalSaude(int id, String nome, String email, Especializacao especializacao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.especializacao = especializacao;
    }

    public abstract String getTipo();

    @Override
    public void update(Consulta consulta) {
        if (consulta.getProfissional().getId() == this.id) {
            System.out.println("Notificação para " + nome + " (" + getTipo() + "): Nova consulta agendada para " + consulta.getDataHora());
        }
    }

    // Getters e setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Especializacao getEspecializacao() { return especializacao; }
    public void setEspecializacao(Especializacao especializacao) { this.especializacao = especializacao; }

    public String getDescricaoEspecializacao() {
        return especializacao.getDescricao();
    }
}