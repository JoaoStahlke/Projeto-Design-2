package Classes;

public class PagamentoBoleto implements PagamentoStrategy {
    @Override
    public void pagar() {
        System.out.println("Pagamento realizado via boleto.");
    }
}