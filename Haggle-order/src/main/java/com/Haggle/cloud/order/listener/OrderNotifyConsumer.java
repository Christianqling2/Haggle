package com.Haggle.cloud.order.listener;

import com.Haggle.cloud.common.exception.HaggleException;
import com.Haggle.cloud.common.order.bo.PayNotifyBO;
import com.Haggle.cloud.common.response.ResponseEnum;
import com.Haggle.cloud.common.rocketmq.config.RocketMqConstant;
import com.Haggle.cloud.common.util.Json;
import com.Haggle.cloud.order.service.OrderService;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import java.util.Objects;


@Component
@RocketMQMessageListener(topic = RocketMqConstant.ORDER_NOTIFY_TOPIC,consumerGroup = RocketMqConstant.ORDER_NOTIFY_TOPIC)
public class OrderNotifyConsumer implements RocketMQListener<PayNotifyBO> {

    @Autowired
    private OrderService orderService;
    @Autowired
    private RocketMQTemplate orderNotifyStockTemplate;

    private static final Logger LOG = LoggerFactory.getLogger(OrderNotifyConsumer.class);

    @Override
    public void onMessage(PayNotifyBO message) {
        LOG.info("订单回调开始... message: " + Json.toJsonString(message));
        orderService.updateByToPaySuccess(message.getOrderIds());
        // 发送消息，订单支付成功 通知库存扣减
        SendStatus sendStockStatus = orderNotifyStockTemplate.syncSend(RocketMqConstant.ORDER_NOTIFY_STOCK_TOPIC, new GenericMessage<>(message)).getSendStatus();
        if (!Objects.equals(sendStockStatus,SendStatus.SEND_OK)) {
            throw new HaggleException(ResponseEnum.EXCEPTION);
        }
    }
}
