package EspecializacaoBridge;

import EspecializacaoBridge.Especializacao;

public class EspecializacaoAdulto implements Especializacao {
    @Override
    public String getDescricao() {
        return "Especialização em atendimento a adultos";
    }
}