package View;

import Strategy.PagamentoBoleto;
import Strategy.PagamentoCartaoCredito;
import Strategy.PagamentoPix;
import Strategy.PagamentoStrategy;
import Classes.AgendamentoConsulta;
import Classes.Consulta;
import Classes.Paciente;
import Classes.ProfissionalSaude;
import Classes.Medico;
import Facade.SistemaFacade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class ClinicaView {
    private JFrame frame;
    private JTabbedPane tabbedPane;
    private AgendamentoConsulta agendamentoConsulta;
    private SistemaFacade sistemaFacade;

    public ClinicaView(AgendamentoConsulta agendamentoConsulta, SistemaFacade sistemaFacade) {
        this.agendamentoConsulta = agendamentoConsulta;
        this.sistemaFacade = sistemaFacade;

        frame = new JFrame("Sistema de Gerenciamento de Clínica");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        tabbedPane = new JTabbedPane();

        // Adiciona a aba para marcar consulta
        tabbedPane.addTab("Marcar Consulta", new MarcarConsultaPanel());

        // Adiciona a nova aba do Facade
        tabbedPane.addTab("Gestão de Pessoas", new FacadePanel(sistemaFacade));

        frame.getContentPane().add(tabbedPane);
        frame.setVisible(true);
    }

    class MarcarConsultaPanel extends JPanel {
        private JComboBox<String> pagamentoDropdown;
        private JComboBox<String> horarioDropdown;
        private JComboBox<ProfissionalSaude> medicoDropdown;

        public MarcarConsultaPanel() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(5, 5, 5, 5);

            // Drop-down para escolher o método de pagamento
            JLabel pagamentoLabel = new JLabel("Método de Pagamento:");
            gbc.gridx = 0; gbc.gridy = 0;
            add(pagamentoLabel, gbc);

            String[] metodosPagamento = {"Cartão de Crédito", "Boleto", "Pix"};
            pagamentoDropdown = new JComboBox<>(metodosPagamento);
            gbc.gridx = 1; gbc.gridy = 0;
            add(pagamentoDropdown, gbc);

            // Drop-down para escolher o horário
            JLabel horarioLabel = new JLabel("Horário:");
            gbc.gridx = 0; gbc.gridy = 1;
            add(horarioLabel, gbc);

            String[] horariosDisponiveis = {"10:00", "14:00", "16:00"};
            horarioDropdown = new JComboBox<>(horariosDisponiveis);
            gbc.gridx = 1; gbc.gridy = 1;
            add(horarioDropdown, gbc);

            // Drop-down para escolher o médico
            JLabel medicoLabel = new JLabel("Médico:");
            gbc.gridx = 0; gbc.gridy = 2;
            add(medicoLabel, gbc);

            // Aqui você deve preencher com os médicos disponíveis
            ProfissionalSaude[] medicosDisponiveis = {
                    new Medico(1, "Dr. João", "joao@clinica.com", "CRM12345", null),
                    new Medico(2, "Dra. Maria", "maria@clinica.com", "CRM67890", null),
                    new Medico(3, "Dr. Carlos", "carlos@clinica.com", "CRM54321", null)
            };
            medicoDropdown = new JComboBox<>(medicosDisponiveis);
            gbc.gridx = 1; gbc.gridy = 2;
            add(medicoDropdown, gbc);

            // Botão para marcar a consulta
            JButton marcarConsultaButton = new JButton("Marcar Consulta");
            gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
            add(marcarConsultaButton, gbc);

            marcarConsultaButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String metodoPagamento = (String) pagamentoDropdown.getSelectedItem();
                    String horario = (String) horarioDropdown.getSelectedItem();
                    ProfissionalSaude medico = (ProfissionalSaude) medicoDropdown.getSelectedItem();

                    // Estratégia de pagamento
                    PagamentoStrategy estrategia = getPagamentoStrategy(metodoPagamento);
                    estrategia.pagar();

                    // Criando um paciente de exemplo (em uma aplicação real, você pegaria isso de um formulário ou banco de dados)
                    Paciente paciente = new Paciente(1, "Paciente Exemplo", "1990-01-01", "123.456.789-00", "1234-5678", "paciente@email.com");

                    // Criando a consulta
                    LocalDateTime dataHoraConsulta = LocalDateTime.now().withHour(Integer.parseInt(horario.split(":")[0])).withMinute(0);
                    Consulta novaConsulta = new Consulta(1, paciente, medico, dataHoraConsulta);

                    // Agendando a consulta e notificando os observadores
                    agendamentoConsulta.agendarConsulta(novaConsulta);

                    // Informações da consulta
                    JOptionPane.showMessageDialog(frame, "Consulta marcada com " + medico.getNome() + " às " + horario + ".");
                }
            });
        }

        private PagamentoStrategy getPagamentoStrategy(String metodoPagamento) {
            switch (metodoPagamento) {
                case "Cartão de Crédito":
                    return new PagamentoCartaoCredito();
                case "Boleto":
                    return new PagamentoBoleto();
                case "Pix":
                    return new PagamentoPix();
                default:
                    throw new IllegalArgumentException("Método de pagamento desconhecido.");
            }
        }
    }

    public static void main(String[] args) {
        AgendamentoConsulta agendamentoConsulta = new AgendamentoConsulta();
        SistemaFacade sistemaFacade = new SistemaFacade();
        SwingUtilities.invokeLater(() -> new ClinicaView(agendamentoConsulta, sistemaFacade));
    }
}