package cn.hellomyheart.rabbitmq.demo.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @description
 * @className: FanListener01
 * @package: cn.hellomyheart.rabbitmq.demo.fanout
 * @author: Stephen Shen
 * @date: 2020/10/28 下午2:49
 */
@Component
@RabbitListener(queues = "fanout01")
public class FanListener01 {
    @RabbitHandler
    public void rabbitHandler(String msg){
        System.out.println("fanout-消费者01"+msg);
    }
}
