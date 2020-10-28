package cn.hellomyheart.rabbitmq.demo.headers;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @description
 * @className: HeadListener01
 * @package: cn.hellomyheart.rabbitmq.demo.headers
 * @author: Stephen Shen
 * @date: 2020/10/28 下午4:21
 */
@Component
@RabbitListener(queues = "headerdemo01")
public class HeadListener01 {
    @RabbitHandler
    public void rabbitHandler(String msg){
        System.out.println("header-消费者01："+msg);
    }
}
