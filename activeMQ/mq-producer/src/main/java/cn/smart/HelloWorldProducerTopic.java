package cn.smart;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class HelloWorldProducerTopic {

    /**
     * 生产消息
     * @param msg
     */
    public void sendHelloWorldActiveMQ(String msg){
        //定义链接工厂
        ConnectionFactory connectionFactory = null;

        //定义链接对象
        Connection connection = null;

        //定义绘画
        Session session = null;

        //目的地
        Destination destination = null;

        //消息的发送者
        MessageProducer producer = null;

        //定义消息
        Message message = null;

        try {
            /**
             * username:访问ActiveMQ服务的用户名。用户密码。默认admin。用户名可以通过jetty-ream.properties文件修改
             * password:访问ActiveMQ服务的用户名。用户密码。默认admin。用户名可以通过jetty-ream.properties文件修改
             * brokerURL:访问ActiveMQ服务的路径地址:协议名://主机地址:端口号
             */
            connectionFactory = new ActiveMQConnectionFactory("admin","admin","tcp://192.168.66.186:61616");
            //创建链接对象
            connection = connectionFactory.createConnection();

            //启动链接
            connection.start();

            /**
             * transacted:是否使用事务:Boolean
             *      true表示使用事务,Session.SESSION_TRANSACTED
             *      false不使用事务,是指此变量acknowledgeMode参数必须设置
             * acknowledgeMode:
             *      Session.AUTO_ACKNOWLEDGE:表示自动确认机制
             *      Session.CLIENT_ACKNOWLEDGE:客户端确认机制
             *      Session.DUPS_OK_ACKNOWLEDGE:有副本的客户端确认消息机制
             */
            session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

            //创建目的地:目的地名称即队列的名称。消息的消费者需要通过消息名称访问对应队列
            destination = session.createTopic("test-topic");

            //创建消息生产者
            producer = session.createProducer(destination);

            //创建消息对象
            message = session.createTextMessage(msg);

            //发送消息
            producer.send(message);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (producer != null){
                try {
                    producer.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }

            if (session != null){
                try {
                    session.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null){
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
