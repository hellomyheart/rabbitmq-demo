package cn.hellomyheart.rabbitmq.demo.controller;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

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
        template.convertAndSend("","workdemo",msg);
        return "ok";
    }
    @GetMapping("/api/mq/sendworkmsg.do")
    public String sendWorkMsg(String msg){
        template.convertAndSend("","workdemo",msg);
        return "ok";
    }

    @GetMapping("/api/mq/senddirectmsg.do")
    public String sendDirecttMsg(String type,String msg){
        template.convertAndSend("exdirectdemo",type,msg);
        return "ok";
    }

    @GetMapping("/api/mq/sendtopicmsg.do")
    public String sendTopicMsg(String type,String msg){
        template.convertAndSend("extopicdemo",type,msg);
        return "ok";
    }

    @GetMapping("/api/mq/sendheadermsg.do")
    public String sendHeaderMsg(String type,String msg){
        template.convertAndSend("exheadersdemo","",msg, (message) -> {
            MessageProperties messageProperties = message.getMessageProperties();
            messageProperties.getHeaders().put(type,"100");
            return message;
        },new CorrelationData(UUID.randomUUID().toString()));
        return "ok";

//        template.convertAndSend("exheadersdemo","", msg,
//                new MessagePostProcessor() {
//                    @Override
//                    public Message postProcessMessage(Message message) throws AmqpException {
//                        MessageProperties properties=message.getMessageProperties();
//                        properties.getHeaders().put(t,"222");
//                        return message;
//                    }
//                },new CorrelationData(UUID.randomUUID().toString()));
    }


}
