package pl.solutions.software.sokolik.bartosz.event.correlation.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.solutions.software.sokolik.bartosz.event.correlation.base.ThreadCorrelationId;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Slf4j
@Component
public class CorrelationIdFilter implements Filter {

    private final ThreadCorrelationId threadCorrelationId;

    public CorrelationIdFilter(ThreadCorrelationId threadCorrelationId) {
        this.threadCorrelationId = threadCorrelationId;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        setCorrelationIdHeader(res, extractCorrelationId(req));
        chain.doFilter(req, res);
    }

    private void setCorrelationIdHeader(ServletResponse response, String correlationId) {
        HttpServletResponse res = (HttpServletResponse) response;
        if (res.containsHeader(ThreadCorrelationId.CORRLEATION_ID_HEADER)) {
            res.setHeader(ThreadCorrelationId.CORRLEATION_ID_HEADER, correlationId);
        } else {
            res.addHeader(ThreadCorrelationId.CORRLEATION_ID_HEADER, correlationId);
        }
    }

    private String extractCorrelationId(ServletRequest request) {
        HttpServletRequest req = (HttpServletRequest) request;
        String correlationId = req.getHeader(ThreadCorrelationId.CORRLEATION_ID_HEADER);
        if (!isCurrentRequestAsyncDispatcher(req)) {
            if (Objects.isNull(correlationId)) {
                correlationId = threadCorrelationId.createNewCorrelationId();
            } else {
                threadCorrelationId.setCorrelationId(correlationId);
            }
        }
        return correlationId;
    }

    private boolean isCurrentRequestAsyncDispatcher(HttpServletRequest request) {
        return request.getDispatcherType().equals(DispatcherType.ASYNC);
    }
}
