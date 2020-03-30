package pl.solutions.software.sokolik.bartosz.event.correlation.base;

public interface CorrelationIdListener {

    void notify(String correlationId);

    void clear();
}
