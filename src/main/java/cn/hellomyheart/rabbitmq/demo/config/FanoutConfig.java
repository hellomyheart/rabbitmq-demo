package cn.hellomyheart.rabbitmq.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description
 * @className: FanoutConfig
 * @package: cn.hellomyheart.rabbitmq.demo.config
 * @author: Stephen Shen
 * @date: 2020/10/28 下午2:40
 */
@Configuration
public class FanoutConfig {

    //一个交换器，两个队列
    //两次绑定，把两个队列都绑定到这个交换器上
    //创建队列SpringBean
    @Bean
    public Queue createQ1(){
        return new Queue("fanout01");
    }

    @Bean
    public Queue  createQ2(){
        return new Queue("fanout02");
    }

    //交换器
    @Bean
    public FanoutExchange createFanoutExchange(){
        return new FanoutExchange("exFanoutdemo");
    }

    //绑定
    @Bean
    public Binding createBinding01(FanoutExchange fanoutExchange){
        return BindingBuilder.bind(createQ1()).to(fanoutExchange);
    }

    @Bean
    public Binding createBinding02(FanoutExchange fanoutExchange){
        return BindingBuilder.bind(createQ2()).to(fanoutExchange);
    }
}
