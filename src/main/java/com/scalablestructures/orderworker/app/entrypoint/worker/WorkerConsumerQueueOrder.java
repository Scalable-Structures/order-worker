package com.scalablestructures.orderworker.app.entrypoint.worker;

import com.google.gson.Gson;
import com.scalablestructures.orderworker.app.provider.queue.message.OrderMessage;
import com.scalablestructures.orderworker.domain.order.interactor.OrderCreateInteractor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class WorkerConsumerQueueOrder {
    @Value("${application.rabbitmq.queue.name}")
    private String queueName;

    private final OrderCreateInteractor orderCreateInteractor;

    public WorkerConsumerQueueOrder(final OrderCreateInteractor orderCreateInteractor) {
        this.orderCreateInteractor = orderCreateInteractor;
    }

    @RabbitListener(
        queues = "${application.rabbitmq.queue.name}",
        containerFactory = "prefetchRabbitListenerContainerFactory"
    )
    public void execute(@Payload String body) {
        OrderMessage orderMessage = new Gson().fromJson(body, OrderMessage.class);

        this.orderCreateInteractor.execute(new OrderMessage().toDomain(orderMessage));
    }
}
