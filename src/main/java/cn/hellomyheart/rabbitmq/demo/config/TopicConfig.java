package cn.hellomyheart.rabbitmq.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description
 * @className: TopicConfig
 * @package: cn.hellomyheart.rabbitmq.demo.config
 * @author: Stephen Shen
 * @date: 2020/10/28 下午4:01
 */
@Configuration
public class TopicConfig {
    //队列
    @Bean
    public Queue createTopicQ1(){
        return new Queue("topicdemo01");
    }

    @Bean
    public Queue createTopicQ2(){
        return new Queue("topicdemo02");
    }
    //交换器
    @Bean
    public TopicExchange createTopicExchange(){
        return new TopicExchange("extopicdemo");
    }

    @Bean
    public Binding createTopicBd1(TopicExchange topicExchange){
        //# 1-n 任意单词匹配
        return BindingBuilder.bind(createTopicQ1()).to(topicExchange).with("info.#");
    }

    @Bean
    public Binding createTopicBd2(TopicExchange topicExchange){
        //* 1个单词匹配
        return BindingBuilder.bind(createTopicQ2()).to(topicExchange).with("error.*");
    }

}
