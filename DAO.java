import java.util.List;

public interface DAO<T> {
    void adicionar(T t);
    List<T> listar();
    void atualizar(T t);
    void deletar(int id);
}
