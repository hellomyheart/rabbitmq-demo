package cn.hellomyheart.rabbitmq.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description
 * @className: HeadersConfig
 * @package: cn.hellomyheart.rabbitmq.demo.config
 * @author: Stephen Shen
 * @date: 2020/10/28 下午4:14
 */
@Configuration
public class HeadersConfig {

    //队列
    @Bean
    public Queue createHeadersQ1(){
        return new Queue("headerdemo01");
    }

    @Bean
    public Queue createHeadersQ2(){
        return new Queue("headerdemo02");
    }

    //交换器
    @Bean
    public HeadersExchange createHeadersExchange(){
        return new HeadersExchange("exheadersdemo");
    }

    //绑定
    @Bean
    public Binding createHeaderBd1(HeadersExchange headersExchange){
        // ||
        return BindingBuilder.bind(createHeadersQ1()).to(headersExchange).whereAny("ctime","cdate").exist();
    }

    @Bean
    public Binding createHeaderBd2(HeadersExchange headersExchange){
        // &&
        return BindingBuilder.bind(createHeadersQ2()).to(headersExchange).whereAll("version","author").exist();
    }




}
