package Classes;

import EspecializacaoBridge.EspecializacaoAdulto;
import EspecializacaoBridge.EspecializacaoInfantil;
import Facade.SistemaFacade;
import View.ClinicaView;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        AgendamentoConsulta agendamentoConsulta = new AgendamentoConsulta();
        SistemaFacade sistemaFacade = new SistemaFacade();

        // Criando e registrando alguns profissionais de saúde como observadores
        Medico medico1 = new Medico(1, "Dr. João", "joao@clinica.com", "CRM12345", new EspecializacaoInfantil());
        Medico medico2 = new Medico(2, "Dra. Maria", "maria@clinica.com", "CRM67890", new EspecializacaoAdulto());
        Medico medico3 = new Medico(3, "Dr. Carlos", "carlos@clinica.com", "CRM54321", null);

        agendamentoConsulta.registerObserver(medico1);
        agendamentoConsulta.registerObserver(medico2);
        agendamentoConsulta.registerObserver(medico3);

        // Iniciando a interface gráfica
        SwingUtilities.invokeLater(() -> new ClinicaView(agendamentoConsulta, sistemaFacade));
    }
}