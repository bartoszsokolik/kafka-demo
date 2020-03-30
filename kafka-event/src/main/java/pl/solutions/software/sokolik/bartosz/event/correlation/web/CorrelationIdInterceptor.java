package pl.solutions.software.sokolik.bartosz.event.correlation.web;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import pl.solutions.software.sokolik.bartosz.event.correlation.base.ThreadCorrelationId;

import java.io.IOException;

@Component
public class CorrelationIdInterceptor implements ClientHttpRequestInterceptor {

    private final ThreadCorrelationId threadCorrelationId;

    public CorrelationIdInterceptor(ThreadCorrelationId threadCorrelationId) {
        this.threadCorrelationId = threadCorrelationId;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest req, byte[] bytes, ClientHttpRequestExecution execution) throws IOException {
        req.getHeaders().add(ThreadCorrelationId.CORRLEATION_ID_HEADER, threadCorrelationId.getOrCreateCorrelationId());
        return execution.execute(req, bytes);
    }
}
