public class Psicologo {
    private int id;
    private String nome;
    private String especialidade;
    private String crp;
    private String email;

    // Construtores, getters e setters
    public Psicologo() {}

    public Psicologo(int id, String nome, String especialidade, String crp, String email) {
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
        this.crp = crp;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getCrp() {
        return crp;
    }

    public void setCrp(String crp) {
        this.crp = crp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
