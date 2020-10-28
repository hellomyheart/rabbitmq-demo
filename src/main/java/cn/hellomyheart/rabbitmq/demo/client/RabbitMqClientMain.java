package cn.hellomyheart.rabbitmq.demo.client;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @description
 * @className: RabbitMqClientMain
 * @package: cn.hellomyheart.rabbitmq.demo.client
 * @author: Stephen Shen
 * @date: 2020/10/27 下午2:36
 */
public class RabbitMqClientMain {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setVirtualHost("/");//虚拟路径
        factory.setUsername("root");
        factory.setPassword("root");

        //实例化连接对象
        Connection connection = factory.newConnection();
        //通道对象
        Channel channel = connection.createChannel();

        channel.queueDeclare("demo", true, false, false, null);
        channel.basicPublish("", "demo", null, "test".getBytes());
        channel.clearConfirmListeners();
        connection.close();


    }
}
