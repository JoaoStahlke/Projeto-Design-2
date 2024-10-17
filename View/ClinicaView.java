package View;

import Classes.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClinicaView {
    private JFrame frame;
    private JTabbedPane tabbedPane;

    public ClinicaView() {
        frame = new JFrame("Sistema de Gerenciamento de Clínica");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        tabbedPane = new JTabbedPane();

        // Adiciona a aba para marcar consulta
        tabbedPane.addTab("Marcar Consulta", new MarcarConsultaPanel());

        frame.getContentPane().add(tabbedPane);
        frame.setVisible(true);
    }

    class MarcarConsultaPanel extends JPanel {
        private JComboBox<String> pagamentoDropdown;
        private JComboBox<String> horarioDropdown;
        private JComboBox<String> medicoDropdown;

        public MarcarConsultaPanel() {
            setLayout(null);

            // Drop-down para escolher o método de pagamento
            JLabel pagamentoLabel = new JLabel("Método de Pagamento:");
            pagamentoLabel.setBounds(10, 20, 150, 25);
            add(pagamentoLabel);

            String[] metodosPagamento = {"Cartão de Crédito", "Boleto", "Pix"};
            pagamentoDropdown = new JComboBox<>(metodosPagamento);
            pagamentoDropdown.setBounds(180, 20, 150, 25);
            add(pagamentoDropdown);

            // Drop-down para escolher o horário
            JLabel horarioLabel = new JLabel("Horário:");
            horarioLabel.setBounds(10, 60, 150, 25);
            add(horarioLabel);

            String[] horariosDisponiveis = {"10:00", "14:00", "16:00"};
            horarioDropdown = new JComboBox<>(horariosDisponiveis);
            horarioDropdown.setBounds(180, 60, 150, 25);
            add(horarioDropdown);

            // Drop-down para escolher o médico
            JLabel medicoLabel = new JLabel("Médico:");
            medicoLabel.setBounds(10, 100, 150, 25);
            add(medicoLabel);

            String[] medicosDisponiveis = {"Dr. João", "Dr. Maria", "Dr. Carlos"};
            medicoDropdown = new JComboBox<>(medicosDisponiveis);
            medicoDropdown.setBounds(180, 100, 150, 25);
            add(medicoDropdown);

            // Botão para marcar a consulta
            JButton marcarConsultaButton = new JButton("Marcar Consulta");
            marcarConsultaButton.setBounds(10, 150, 150, 25);
            add(marcarConsultaButton);

            marcarConsultaButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String metodoPagamento = (String) pagamentoDropdown.getSelectedItem();
                    String horario = (String) horarioDropdown.getSelectedItem();
                    String medico = (String) medicoDropdown.getSelectedItem();

                    // Estratégia de pagamento
                    PagamentoStrategy estrategia = getPagamentoStrategy(metodoPagamento);
                    estrategia.pagar();

                    // Informações da consulta
                    System.out.println("Consulta marcada com " + medico + " às " + horario + ".");
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
        SwingUtilities.invokeLater(() -> new ClinicaView());
    }
}
