import java.util.ArrayList;
import java.util.List;

public class AgendamentoConsulta implements Subject {
    private List<Observer> observers;
    private List<Consulta> consultas;

    public AgendamentoConsulta() {
        observers = new ArrayList<>();
        consultas = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(consultas.get(consultas.size() - 1));
        }
    }

    public void agendarConsulta(Consulta consulta) {
        consultas.add(consulta);
        notifyObservers();
    }
}