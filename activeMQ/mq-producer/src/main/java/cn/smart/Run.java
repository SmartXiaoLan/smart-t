package cn.smart;

public class Run {
    public static void main(String[] args) {
        /*HelloWorldProducer producer = new HelloWorldProducer();
        producer.sendHelloWorldActiveMQ("ActiveMQ");*/
        /*HelloWorldProducerForObject producer = new HelloWorldProducerForObject();
        User user = new User();
        user.setUserid(123);
        user.setUsername("张三");
        user.setUserage(23);
        producer.sendHelloWorldActiveMQ(user);*/

        /*HelloWorldProducerListener listener = new HelloWorldProducerListener();
        listener.sendHelloWorldActiveMQ(Math.random()+"");*/

        HelloWorldProducerTopic topic = new HelloWorldProducerTopic();
        topic.sendHelloWorldActiveMQ(Math.random() + "");
    }
}
