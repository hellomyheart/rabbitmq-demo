package cn.hellomyheart.rabbitmq.demo.work.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @description
 * @className: RabbitMqlistener
 * @package: cn.hellomyheart.rabbitmq.demo.work.listener
 * @author: Stephen Shen
 * @date: 2020/10/28 下午2:15
 */
@Component
@RabbitListener(queues = "workdemo")
public class RabbitMqlistener2 {

    @RabbitHandler
    public void msg(String msg){
        System.out.println("消费者02："+msg);
    }

}
