package cn.hellomyheart.rabbitmq.demo.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description
 * @className: MqController
 * @package: cn.hellomyheart.rabbitmq.demo.controller
 * @author: Stephen Shen
 * @date: 2020/10/27 下午2:40
 */
@RestController
public class MqController {
    @Autowired
    private RabbitTemplate template;

    @GetMapping("/api/mq/sendmsg.do")
    public String sendMsg(String msg){
        template.convertAndSend("","demo",msg);
        return "ok";
    }
}
