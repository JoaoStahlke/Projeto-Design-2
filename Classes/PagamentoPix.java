package Classes;

public class PagamentoPix implements PagamentoStrategy {
    @Override
    public void pagar() {
        System.out.println("Pagamento realizado via Pix.");
    }
}