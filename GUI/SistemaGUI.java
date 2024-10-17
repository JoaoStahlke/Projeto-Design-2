package GUI;

import Facade.SistemaFacade;
import Classes.Medico;
import Classes.Paciente;
import Classes.Psicologo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SistemaGUI extends JFrame {
    private SistemaFacade facade;

    // Componentes de Psicologo
    private JTextField nomePsicologoField;
    private JTextField emailPsicologoField;
    private JTextField crmPsicologoField;
    private JButton adicionarPsicologoButton;
    private JButton listarPsicologosButton;

    // Componentes de Paciente
    private JTextField nomePacienteField;
    private JTextField cpfPacienteField;
    private JButton adicionarPacienteButton;
    private JButton listarPacientesButton;

    // Componentes de Medico
    private JTextField nomeMedicoField;
    private JTextField crmMedicoField;
    private JButton adicionarMedicoButton;
    private JButton listarMedicosButton;

    private JTextArea outputArea;

    public SistemaGUI() {
        facade = new SistemaFacade();
        setTitle("Sistema de Gestão");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5); // Espaçamento entre os componentes

        // Campos e botões para Psicólogos
        nomePsicologoField = new JTextField(20);
        emailPsicologoField = new JTextField(20);
        crmPsicologoField = new JTextField(20);
        adicionarPsicologoButton = new JButton("Adicionar Psicólogo");
        listarPsicologosButton = new JButton("Listar Psicólogos");

        // Campos e botões para Pacientes
        nomePacienteField = new JTextField(20);
        cpfPacienteField = new JTextField(20);
        adicionarPacienteButton = new JButton("Adicionar Paciente");
        listarPacientesButton = new JButton("Listar Pacientes");

        // Campos e botões para Médicos
        nomeMedicoField = new JTextField(20);
        crmMedicoField = new JTextField(20);
        adicionarMedicoButton = new JButton("Adicionar Médico");
        listarMedicosButton = new JButton("Listar Médicos");

        // Área de saída
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Adicionando componentes ao painel
        // Psicólogo
        gbc.gridx = 0; gbc.gridy = 0; add(new JLabel("Psicólogo Nome:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0; add(nomePsicologoField, gbc);

        gbc.gridx = 0; gbc.gridy = 1; add(new JLabel("Email:"), gbc);
        gbc.gridx = 1; gbc.gridy = 1; add(emailPsicologoField, gbc);

        gbc.gridx = 0; gbc.gridy = 2; add(new JLabel("CRM:"), gbc);
        gbc.gridx = 1; gbc.gridy = 2; add(crmPsicologoField, gbc);

        gbc.gridx = 0; gbc.gridy = 3; add(adicionarPsicologoButton, gbc);
        gbc.gridx = 1; gbc.gridy = 3; add(listarPsicologosButton, gbc);

        // Paciente
        gbc.gridx = 0; gbc.gridy = 4; add(new JLabel("Paciente Nome:"), gbc);
        gbc.gridx = 1; gbc.gridy = 4; add(nomePacienteField, gbc);

        gbc.gridx = 0; gbc.gridy = 5; add(new JLabel("CPF:"), gbc);
        gbc.gridx = 1; gbc.gridy = 5; add(cpfPacienteField, gbc);

        gbc.gridx = 0; gbc.gridy = 6; add(adicionarPacienteButton, gbc);
        gbc.gridx = 1; gbc.gridy = 6; add(listarPacientesButton, gbc);

        // Médico
        gbc.gridx = 0; gbc.gridy = 7; add(new JLabel("Médico Nome:"), gbc);
        gbc.gridx = 1; gbc.gridy = 7; add(nomeMedicoField, gbc);

        gbc.gridx = 0; gbc.gridy = 8; add(new JLabel("CRM:"), gbc);
        gbc.gridx = 1; gbc.gridy = 8; add(crmMedicoField, gbc);

        gbc.gridx = 0; gbc.gridy = 9; add(adicionarMedicoButton, gbc);
        gbc.gridx = 1; gbc.gridy = 9; add(listarMedicosButton, gbc);

        // Área de saída
        gbc.gridx = 0; gbc.gridy = 10; gbc.gridwidth = 2; // Ocupa duas colunas
        add(scrollPane, gbc);

        // Ações dos botões
        adicionarPsicologoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Psicologo novoPsicologo = new Psicologo(
                        nomePsicologoField.getText(),
                        emailPsicologoField.getText(),
                        crmPsicologoField.getText()
                );
                facade.adicionarPsicologo(novoPsicologo);
                outputArea.append("Psicólogo adicionado!\n");
            }
        });

        listarPsicologosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Psicologo> psicologos = facade.listarPsicologos();
                outputArea.setText(""); // Limpar área de saída
                for (Psicologo psicologo : psicologos) {
                    outputArea.append(psicologo.getNome() + "\n");
                }
            }
        });

        // Ações para Pacientes
        adicionarPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Paciente novoPaciente = new Paciente(
                        nomePacienteField.getText(),
                        cpfPacienteField.getText()
                );
                facade.adicionarPaciente(novoPaciente);
                outputArea.append("Paciente adicionado!\n");
            }
        });

        listarPacientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Paciente> pacientes = facade.listarPacientes();
                outputArea.setText(""); // Limpar área de saída
                for (Paciente paciente : pacientes) {
                    outputArea.append(paciente.getNome() + "\n");
                }
            }
        });

        // Ações para Médicos
        adicionarMedicoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Medico novoMedico = new Medico(
                        nomeMedicoField.getText(),
                        crmMedicoField.getText()
                );
                facade.adicionarMedico(novoMedico);
                outputArea.append("Médico adicionado!\n");
            }
        });

        listarMedicosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Medico> medicos = facade.listarMedicos();
                outputArea.setText(""); // Limpar área de saída
                for (Medico medico : medicos) {
                    outputArea.append(medico.getNome() + "\n");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SistemaGUI gui = new SistemaGUI();
            gui.setVisible(true);
        });
    }
}
