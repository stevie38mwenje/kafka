package com.notification.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
class KafkaListeners {
    Logger LOG = LoggerFactory.getLogger(KafkaListeners.class);

    @KafkaListener(
            topics = "new_notification",
            groupId = "notification-group-2")
     void listener(String data) {
        LOG.info("Listener recived: "+ data);
    }

    @KafkaListener(
            topics = "new_notification",
            groupId = "notification-group-2")
    void commonListenerForMultipleTopics(String message) {
        LOG.info("MultipleTopicListener - {}", message);
    }
}