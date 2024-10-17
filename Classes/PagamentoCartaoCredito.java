package Classes;

public class PagamentoCartaoCredito implements PagamentoStrategy {
    @Override
    public void pagar() {
        System.out.println("Pagamento realizado com cartão de crédito.");
    }
}
