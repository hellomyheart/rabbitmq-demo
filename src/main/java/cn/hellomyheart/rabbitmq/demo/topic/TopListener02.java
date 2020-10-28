package cn.hellomyheart.rabbitmq.demo.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @description
 * @className: TopListener01
 * @package: cn.hellomyheart.rabbitmq.demo.topic
 * @author: Stephen Shen
 * @date: 2020/10/28 下午3:56
 */
@Component
@RabbitListener(queues = "topicdemo02")
public class TopListener02 {
    @RabbitHandler
    public void rabbitHadler(String msg){
        System.out.println("topic - 消费者02："+ msg);
        //下面可以写业务逻辑
    }
}
