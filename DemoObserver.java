import java.time.LocalDateTime;

public class DemoObserver {
    public static void main(String[] args) {
        AgendamentoConsulta agendamento = new AgendamentoConsulta();

        // Criando instâncias de profissionais com diferentes especializações
        Medico medicoAdulto = new Medico(1, "Dr. Silva", "silva@clinica.com", "CRM12345", new EspecializacaoAdulto());
        Psicologo psicologoInfantil = new Psicologo(2, "Dra. Santos", "santos@clinica.com", "CRP67890", new EspecializacaoInfantil());
        Psiquiatra psiquiatraAdulto = new Psiquiatra(3, "Dr. Oliveira", "oliveira@clinica.com", "CRM54321", new EspecializacaoAdulto());

        // Registrando os profissionais como observadores
        agendamento.registerObserver(medicoAdulto);
        agendamento.registerObserver(psicologoInfantil);
        agendamento.registerObserver(psiquiatraAdulto);

        // Criando pacientes
        Paciente pacienteAdulto = new Paciente(1, "João", "1990-05-15", "123.456.789-00", "1234-5678", "joao@email.com");
        Paciente pacienteInfantil = new Paciente(2, "Maria", "2015-10-20", "987.654.321-00", "8765-4321", "responsavel_maria@email.com");

        // Criando e agendando consultas
        Consulta consultaMedico = new Consulta(1, pacienteAdulto, medicoAdulto, LocalDateTime.now().plusDays(1));
        Consulta consultaPsicologo = new Consulta(2, pacienteInfantil, psicologoInfantil, LocalDateTime.now().plusDays(2));
        Consulta consultaPsiquiatra = new Consulta(3, pacienteAdulto, psiquiatraAdulto, LocalDateTime.now().plusDays(3));

        System.out.println("Agendando consultas:");
        agendamento.agendarConsulta(consultaMedico);
        agendamento.agendarConsulta(consultaPsicologo);
        agendamento.agendarConsulta(consultaPsiquiatra);

        // Demonstrando acesso às informações dos profissionais
        System.out.println("\nInformações dos profissionais:");
        mostrarInfoProfissional(medicoAdulto);
        mostrarInfoProfissional(psicologoInfantil);
        mostrarInfoProfissional(psiquiatraAdulto);
    }

    private static void mostrarInfoProfissional(ProfissionalSaude profissional) {
        System.out.println(profissional.getTipo() + ": " + profissional.getNome());
        System.out.println("Especialização: " + profissional.getDescricaoEspecializacao());
        if (profissional instanceof Medico) {
            System.out.println("CRM: " + ((Medico) profissional).getCrm());
        } else if (profissional instanceof Psicologo) {
            System.out.println("CRP: " + ((Psicologo) profissional).getCrp());
        } else if (profissional instanceof Psiquiatra) {
            System.out.println("CRM: " + ((Psiquiatra) profissional).getCrm());
        }
        System.out.println();
    }
}