import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PsicologoView {
    private PsicologoController controller;

    public PsicologoView() {
        this.controller = new PsicologoController();
        criarInterface();
    }

    private void criarInterface() {
        JFrame frame = new JFrame("CRUD de Psicólogos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(10, 20, 80, 25);
        panel.add(nomeLabel);

        JTextField nomeText = new JTextField(20);
        nomeText.setBounds(100, 20, 165, 25);
        panel.add(nomeText);

        JLabel espLabel = new JLabel("Especialidade:");
        espLabel.setBounds(10, 50, 80, 25);
        panel.add(espLabel);

        JTextField espText = new JTextField(20);
        espText.setBounds(100, 50, 165, 25);
        panel.add(espText);

        JLabel crpLabel = new JLabel("CRP:");
        crpLabel.setBounds(10, 80, 80, 25);
        panel.add(crpLabel);

        JTextField crpText = new JTextField(20);
        crpText.setBounds(100, 80, 165, 25);
        panel.add(crpText);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 110, 80, 25);
        panel.add(emailLabel);

        JTextField emailText = new JTextField(20);
        emailText.setBounds(100, 110, 165, 25);
        panel.add(emailText);

        JButton addButton = new JButton("Adicionar");
        addButton.setBounds(10, 140, 150, 25);
        panel.add(addButton);

        JButton listButton = new JButton("Listar");
        listButton.setBounds(170, 140, 150, 25);
        panel.add(listButton);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(10, 170, 560, 220);
        panel.add(textArea);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(10, 400, 80, 25);
        panel.add(idLabel);

        JTextField idText = new JTextField(20);
        idText.setBounds(100, 400, 165, 25);
        panel.add(idText);

        JButton updateButton = new JButton("Atualizar");
        updateButton.setBounds(10, 430, 150, 25);
        panel.add(updateButton);

        JButton deleteButton = new JButton("Deletar");
        deleteButton.setBounds(170, 430, 150, 25);
        panel.add(deleteButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeText.getText();
                String especialidade = espText.getText();
                String crp = crpText.getText();
                String email = emailText.getText();

                if (validarEntrada(nome, especialidade, crp, email)) {
                    Psicologo psicologo = new Psicologo();
                    psicologo.setNome(nome);
                    psicologo.setEspecialidade(especialidade);
                    psicologo.setCrp(crp);
                    psicologo.setEmail(email);
                    controller.adicionarPsicologo(psicologo);
                    nomeText.setText("");
                    espText.setText("");
                    crpText.setText("");
                    emailText.setText("");
                    JOptionPane.showMessageDialog(panel, "Psicólogo adicionado com sucesso!");
                }
            }
        });

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Psicologo> psicologos = controller.listarPsicologos();
                textArea.setText("");
                for (Psicologo psicologo : psicologos) {
                    textArea.append("ID: " + psicologo.getId() + ", Nome: " + psicologo.getNome() +
                            ", Especialidade: " + psicologo.getEspecialidade() + ", CRP: " + psicologo.getCrp() +
                            ", Email: " + psicologo.getEmail() + "\n");
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idText.getText());
                    String nome = nomeText.getText();
                    String especialidade = espText.getText();
                    String crp = crpText.getText();
                    String email = emailText.getText();

                    if (validarEntrada(nome, especialidade, crp, email)) {
                        Psicologo psicologo = new Psicologo();
                        psicologo.setId(id);
                        psicologo.setNome(nome);
                        psicologo.setEspecialidade(especialidade);
                        psicologo.setCrp(crp);
                        psicologo.setEmail(email);
                        controller.atualizarPsicologo(psicologo);
                        JOptionPane.showMessageDialog(panel, "Psicólogo atualizado com sucesso!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "ID inválido!");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idText.getText());
                    controller.deletarPsicologo(id);
                    JOptionPane.showMessageDialog(panel, "Psicólogo deletado com sucesso!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "ID inválido!");
                }
            }
        });
    }

    private boolean validarEntrada(String nome, String especialidade, String crp, String email) {
        if (nome.length() < 3) {
            JOptionPane.showMessageDialog(null, "Nome deve ter mais de 2 caracteres.");
            return false;
        }
        if (especialidade.length() < 5) {
            JOptionPane.showMessageDialog(null, "Especialidade deve ter mais de 4 caracteres.");
            return false;
        }
        if (!crp.matches("\\d{4,6}/\\d{2}")) {
            JOptionPane.showMessageDialog(null, "CRP inválido. Deve seguir o formato 123456/12.");
            return false;
        }
        if (!email.contains("@")) {
            JOptionPane.showMessageDialog(null, "Email inválido. Deve conter '@'.");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new PsicologoView();
    }
}
