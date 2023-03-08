package tutorial.advanced.app.v5;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tutorial.advanced.app.trace.callback.TraceTemplate;
import tutorial.advanced.app.trace.logtrace.LogTrace;
import tutorial.advanced.app.trace.template.AbstractTemplate;


@Service
public class OrderServiceV5 {

    private final OrderRepositoryV5 orderRepository;
    private final TraceTemplate template;

    public OrderServiceV5(OrderRepositoryV5 orderRepository, LogTrace trace) {
        this.orderRepository = orderRepository;
        this.template = new TraceTemplate(trace); }

    public void orderItem(String itemId) {
        template.execute("OrderService.orderItem()", () -> {
            orderRepository.save(itemId);
            return null;
        });
    }
}
