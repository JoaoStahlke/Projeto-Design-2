package Classes;

import java.time.LocalDateTime;

public class Consulta {
    private int id;
    private Paciente paciente;
    private ProfissionalSaude profissional;
    private LocalDateTime dataHora;

    public Consulta(int id, Paciente paciente, ProfissionalSaude profissional, LocalDateTime dataHora) {
        this.id = id;
        this.paciente = paciente;
        this.profissional = profissional;
        this.dataHora = dataHora;
    }

    // Getters e setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }
    public ProfissionalSaude getProfissional() { return profissional; }
    public void setProfissional(ProfissionalSaude profissional) { this.profissional = profissional; }
    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }

    @Override
    public String toString() {
        return "Classes.Consulta{" +
                "id=" + id +
                ", paciente=" + paciente.getNome() +
                ", profissional=" + profissional.getNome() +
                ", dataHora=" + dataHora +
                '}';
    }
}