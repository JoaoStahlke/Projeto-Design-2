package View;

import Facade.SistemaFacade;
import Classes.Medico;
import Classes.Paciente;
import Classes.Psicologo;
import EspecializacaoBridge.Especializacao;
import EspecializacaoBridge.EspecializacaoAdulto;
import EspecializacaoBridge.EspecializacaoInfantil;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class FacadePanel extends JPanel {
    private SistemaFacade facade;

    // Componentes de Psicologo
    private JTextField nomePsicologoField;
    private JTextField emailPsicologoField;
    private JTextField crpPsicologoField;
    private JComboBox<Especializacao> especializacaoPsicologoComboBox;
    private JButton adicionarPsicologoButton;
    private JButton listarPsicologosButton;

    // Componentes de Paciente
    private JTextField nomePacienteField;
    private JTextField cpfPacienteField;
    private JButton adicionarPacienteButton;
    private JButton listarPacientesButton;

    // Componentes de Medico
    private JTextField nomeMedicoField;
    private JTextField emailMedicoField;
    private JTextField crmMedicoField;
    private JComboBox<Especializacao> especializacaoMedicoComboBox;
    private JButton adicionarMedicoButton;
    private JButton listarMedicosButton;

    private JTextArea outputArea;

    private List<Especializacao> especializacoes;

    public FacadePanel(SistemaFacade facade) {
        this.facade = facade;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        initEspecializacoes();
        initComponents();
        addComponents(gbc);
        setupButtonActions();
    }

    private void initEspecializacoes() {
        especializacoes = new ArrayList<>();
        especializacoes.add(new EspecializacaoAdulto());
        especializacoes.add(new EspecializacaoInfantil());
        // Adicione novas especializações aqui quando necessário
    }

    private void initComponents() {
        nomePsicologoField = new JTextField(20);
        emailPsicologoField = new JTextField(20);
        crpPsicologoField = new JTextField(20);
        especializacaoPsicologoComboBox = new JComboBox<>(especializacoes.toArray(new Especializacao[0]));
        adicionarPsicologoButton = new JButton("Adicionar Psicólogo");
        listarPsicologosButton = new JButton("Listar Psicólogos");

        nomePacienteField = new JTextField(20);
        cpfPacienteField = new JTextField(20);
        adicionarPacienteButton = new JButton("Adicionar Paciente");
        listarPacientesButton = new JButton("Listar Pacientes");

        nomeMedicoField = new JTextField(20);
        emailMedicoField = new JTextField(20);
        crmMedicoField = new JTextField(20);
        especializacaoMedicoComboBox = new JComboBox<>(especializacoes.toArray(new Especializacao[0]));
        adicionarMedicoButton = new JButton("Adicionar Médico");
        listarMedicosButton = new JButton("Listar Médicos");

        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);
    }

    private void addComponents(GridBagConstraints gbc) {
        // Psicólogo
        gbc.gridx = 0; gbc.gridy = 0; add(new JLabel("Psicólogo Nome:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0; add(nomePsicologoField, gbc);

        gbc.gridx = 0; gbc.gridy = 1; add(new JLabel("Email:"), gbc);
        gbc.gridx = 1; gbc.gridy = 1; add(emailPsicologoField, gbc);

        gbc.gridx = 0; gbc.gridy = 2; add(new JLabel("CRP:"), gbc);
        gbc.gridx = 1; gbc.gridy = 2; add(crpPsicologoField, gbc);

        gbc.gridx = 0; gbc.gridy = 3; add(new JLabel("Especialização:"), gbc);
        gbc.gridx = 1; gbc.gridy = 3; add(especializacaoPsicologoComboBox, gbc);

        gbc.gridx = 0; gbc.gridy = 4; add(adicionarPsicologoButton, gbc);
        gbc.gridx = 1; gbc.gridy = 4; add(listarPsicologosButton, gbc);

        // Paciente
        gbc.gridx = 0; gbc.gridy = 5; add(new JLabel("Paciente Nome:"), gbc);
        gbc.gridx = 1; gbc.gridy = 5; add(nomePacienteField, gbc);

        gbc.gridx = 0; gbc.gridy = 6; add(new JLabel("CPF:"), gbc);
        gbc.gridx = 1; gbc.gridy = 6; add(cpfPacienteField, gbc);

        gbc.gridx = 0; gbc.gridy = 7; add(adicionarPacienteButton, gbc);
        gbc.gridx = 1; gbc.gridy = 7; add(listarPacientesButton, gbc);

        // Médico
        gbc.gridx = 0; gbc.gridy = 8; add(new JLabel("Médico Nome:"), gbc);
        gbc.gridx = 1; gbc.gridy = 8; add(nomeMedicoField, gbc);

        gbc.gridx = 0; gbc.gridy = 9; add(new JLabel("Email:"), gbc);
        gbc.gridx = 1; gbc.gridy = 9; add(emailMedicoField, gbc);

        gbc.gridx = 0; gbc.gridy = 10; add(new JLabel("CRM:"), gbc);
        gbc.gridx = 1; gbc.gridy = 10; add(crmMedicoField, gbc);

        gbc.gridx = 0; gbc.gridy = 11; add(new JLabel("Especialização:"), gbc);
        gbc.gridx = 1; gbc.gridy = 11; add(especializacaoMedicoComboBox, gbc);

        gbc.gridx = 0; gbc.gridy = 12; add(adicionarMedicoButton, gbc);
        gbc.gridx = 1; gbc.gridy = 12; add(listarMedicosButton, gbc);

        // Área de saída
        gbc.gridx = 0; gbc.gridy = 13; gbc.gridwidth = 2;
        add(new JScrollPane(outputArea), gbc);
    }

    private void setupButtonActions() {
        adicionarPsicologoButton.addActionListener(e -> {
            Psicologo novoPsicologo = new Psicologo(
                    0, // O id será gerado pelo sistema
                    nomePsicologoField.getText(),
                    emailPsicologoField.getText(),
                    crpPsicologoField.getText(),
                    (Especializacao) especializacaoPsicologoComboBox.getSelectedItem()
            );
            facade.adicionarPsicologo(novoPsicologo);
            outputArea.append("Psicólogo adicionado!\n");
        });

        listarPsicologosButton.addActionListener(e -> {
            List<Psicologo> psicologos = facade.listarPsicologos();
            outputArea.setText("");
            for (Psicologo psicologo : psicologos) {
                outputArea.append(psicologo.getNome() + " - CRP: " + psicologo.getCrp() + " - " + psicologo.getDescricaoEspecializacao() + "\n");
            }
        });

        adicionarPacienteButton.addActionListener(e -> {
            Paciente novoPaciente = new Paciente(
                    nomePacienteField.getText(),
                    cpfPacienteField.getText()
            );
            facade.adicionarPaciente(novoPaciente);
            outputArea.append("Paciente adicionado!\n");
        });

        listarPacientesButton.addActionListener(e -> {
            List<Paciente> pacientes = facade.listarPacientes();
            outputArea.setText("");
            for (Paciente paciente : pacientes) {
                outputArea.append(paciente.getNome() + " - CPF: " + paciente.getCpf() + "\n");
            }
        });

        adicionarMedicoButton.addActionListener(e -> {
            Medico novoMedico = new Medico(
                    0, // O id será gerado pelo sistema
                    nomeMedicoField.getText(),
                    emailMedicoField.getText(),
                    crmMedicoField.getText(),
                    (Especializacao) especializacaoMedicoComboBox.getSelectedItem()
            );
            facade.adicionarMedico(novoMedico);
            outputArea.append("Médico adicionado!\n");
        });

        listarMedicosButton.addActionListener(e -> {
            List<Medico> medicos = facade.listarMedicos();
            outputArea.setText("");
            for (Medico medico : medicos) {
                outputArea.append(medico.getNome() + " - CRM: " + medico.getCrm() + " - " + medico.getDescricaoEspecializacao() + "\n");
            }
        });
    }
}