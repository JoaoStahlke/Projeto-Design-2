package Facade;

import Controller.MedicoController;
import Controller.PacienteController;
import Controller.PsicologoController;
import Classes.Medico;
import Classes.Paciente;
import Classes.Psicologo;

import java.util.List;

public class SistemaFacade {
    private PsicologoController psicologoController;
    private PacienteController pacienteController;
    private MedicoController medicoController;

    public SistemaFacade() {
        this.psicologoController = new PsicologoController();
        this.pacienteController = new PacienteController();
        this.medicoController = new MedicoController();
    }

    // Métodos para Psicologos
    public void adicionarPsicologo(Psicologo psicologo) {
        psicologoController.adicionarPsicologo(psicologo);
    }

    public List<Psicologo> listarPsicologos() {
        return psicologoController.listarPsicologos();
    }

    // Métodos para Pacientes
    public void adicionarPaciente(Paciente paciente) {
        pacienteController.adicionarPaciente(paciente);
    }

    public List<Paciente> listarPacientes() {
        return pacienteController.listarPacientes();
    }

    // Métodos para Médicos
    public void adicionarMedico(Medico medico) {
        medicoController.adicionarMedico(medico);
    }

    public List<Medico> listarMedicos() {
        return medicoController.listarMedicos();
    }
}
