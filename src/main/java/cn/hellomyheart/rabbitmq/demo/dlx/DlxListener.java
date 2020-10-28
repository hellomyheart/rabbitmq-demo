package cn.hellomyheart.rabbitmq.demo.dlx;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @description
 * @className: DlxListener
 * @package: cn.hellomyheart.rabbitmq.demo.dlx
 * @author: Stephen Shen
 * @date: 2020/10/28 下午5:58
 */
@Component
@RabbitListener(queues = "dlxdemo1")
public class DlxListener {
    @RabbitHandler
    public void rabbitHandler(String msg){
        System.out.println("延迟消息："+msg+"  -- "+System.currentTimeMillis()/1000);
        //业务逻辑
    }
}
