package cn.hellomyheart.rabbitmq.demo.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @description
 * @className: DIrListener01
 * @package: cn.hellomyheart.rabbitmq.demo.direct
 * @author: Stephen Shen
 * @date: 2020/10/28 下午3:06
 */
@Component
@RabbitListener(queues = "directdemo01")
public class DIrListener01 {
    @RabbitHandler
    public void rabbitHandler(String msg){
        System.out.println("direct-消费者01："+msg);
    }
}
