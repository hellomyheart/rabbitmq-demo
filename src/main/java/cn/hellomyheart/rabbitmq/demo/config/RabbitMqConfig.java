package cn.hellomyheart.rabbitmq.demo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description
 * @className: RabbitMqConfig
 * @package: cn.hellomyheart.rabbitmq.demo.config
 * @author: Stephen Shen
 * @date: 2020/10/27 下午2:22
 */
@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue createQueue(){
        return new Queue("demo");
    }
}
