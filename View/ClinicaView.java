package View;

import javax.swing.*;

public class ClinicaView {
    private JFrame frame;
    private JTabbedPane tabbedPane;

    public ClinicaView() {
        frame = new JFrame("Sistema de Gerenciamento de Clínica");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        tabbedPane = new JTabbedPane();

        // Adiciona as abas para cada tipo de gestão
        tabbedPane.addTab("Psicólogos", new PsicologoPanel());
        tabbedPane.addTab("Médicos", new MedicoPanel());
        tabbedPane.addTab("Pacientes", new PacientePanel());

        frame.getContentPane().add(tabbedPane);
        frame.setVisible(true);
    }

    // Classes internas para cada painel
    class PsicologoPanel extends JPanel {
        public PsicologoPanel() {
            // Adicione aqui os componentes para gerenciar psicólogos
            // Você pode reutilizar grande parte da lógica da classe View.PsicologoView existente
        }
    }

    class MedicoPanel extends JPanel {
        public MedicoPanel() {
            // Adicione aqui os componentes para gerenciar médicos
            // Será similar ao painel de psicólogos, mas com campos específicos para médicos
        }
    }

    class PacientePanel extends JPanel {
        public PacientePanel() {
            // Adicione aqui os componentes para gerenciar pacientes
            // Inclua campos como nome, data de nascimento, CPF, telefone, etc.
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ClinicaView());
    }
}