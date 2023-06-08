package com.Haggle.cloud.search.listener;

import cn.throwx.canal.gule.CanalGlue;
import com.Haggle.cloud.common.rocketmq.config.RocketMqConstant;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@RocketMQMessageListener(topic = RocketMqConstant.CANAL_TOPIC,consumerGroup = RocketMqConstant.CANAL_TOPIC)
public class CanalListener implements RocketMQListener<String> {

    @Autowired
    private CanalGlue canalGlue;

    @Override
    public void onMessage(String message) {
        canalGlue.process(message);
    }
}