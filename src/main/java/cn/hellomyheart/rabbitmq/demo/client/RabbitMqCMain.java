package cn.hellomyheart.rabbitmq.demo.client;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @description
 * @className: RabbitMqCMain
 * @package: cn.hellomyheart.rabbitmq.demo.client
 * @author: Stephen Shen
 * @date: 2020/10/27 下午2:26
 */
public class RabbitMqCMain {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setVirtualHost("/");//虚拟路径
        factory.setUsername("root");
        factory.setPassword("root");

        //实例化连接对象
        Connection connection = factory.newConnection();
        //通道对象
        Channel channel =connection.createChannel();
        channel.basicConsume("demo",new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者:"+new String(body));
                //应答 确认
                channel.basicAck(envelope.getDeliveryTag(),true);
            }
        });




    }
}
