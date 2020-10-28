package cn.hellomyheart.rabbitmq.demo.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @description
 * @className: DLXConfig
 * @package: cn.hellomyheart.rabbitmq.demo.config
 * @author: Stephen Shen
 * @date: 2020/10/28 下午5:23
 */
@Configuration
public class DLXConfig {

    @Resource
    DirectExchange createDireExchange2;

    //队列
    //创建死信队列 存储死信消息
    @Bean
    public Queue createDLXQ1(){
        return new Queue("dlxdemo1");
    }

    //队列
    //创建队列 具备有效期
    @Bean
    public Queue createXQ2(){
        Map<String,Object> params =new HashMap<>();
        //1.消息的有效期 10秒  单位毫秒
        params.put("x-message-ttl",10000);
        //2.设置死信交换器
        params.put("x-dead-letter-exchange","dlxexdemo");
        //3.设置转发的匹配路由
        params.put("x-dead-letter-routing-key","ttl-test");
        //建造者模式
        return QueueBuilder.durable("ttlqdemo").withArguments(params).build();
    }

    @Bean
    public DirectExchange createDireExchange2(){
        return new DirectExchange("dlxexdemo");
    }
    //绑定
    @Bean
    public Binding createDLXBd(){
        return BindingBuilder.bind(createDLXQ1()).to(createDireExchange2).with("ttl-test");
    }

}
