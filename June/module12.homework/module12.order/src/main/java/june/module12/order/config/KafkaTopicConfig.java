package june.module12.order.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic orderCreatedTopic() {
        return new NewTopic("order_created", 1, (short) 1);
    }
    @Bean
    public NewTopic orderStatusTopic() {
        return new NewTopic("order_status_updated", 1, (short) 1);
    }
}