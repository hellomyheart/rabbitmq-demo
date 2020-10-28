package cn.hellomyheart.rabbitmq.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @description
 * @className: DirectConfig
 * @package: cn.hellomyheart.rabbitmq.demo.config
 * @author: Stephen Shen
 * @date: 2020/10/28 下午3:08
 */
@Configuration
public class DirectConfig {

    @Resource
    DirectExchange createDireExchange;

    //队列
    @Bean
    public Queue createDirectQ1(){
        return new Queue("directdemo01");
    }

    @Bean
    public Queue createDirectQ2(){
        return new Queue("directdemo02");
    }

    //交换机
    @Bean
    public DirectExchange createDirectExchange(){
        return new DirectExchange("exdirectdemo");
    }

    @Bean
    public Binding createBindingDirect01(){
        return BindingBuilder.bind(createDirectQ1()).to(createDireExchange).with("info");
    }

    @Bean
    public Binding createBindingDirect02(){
        return BindingBuilder.bind(createDirectQ2()).to(createDireExchange).with("error");
    }

}
