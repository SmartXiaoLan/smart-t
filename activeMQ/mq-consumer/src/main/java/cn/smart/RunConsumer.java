package cn.smart;

public class RunConsumer {
    public static void main(String[] args) {
        /*HelloWorldConsumer consumer = new HelloWorldConsumer();
        consumer.receiveHelloWorldActiveMQ();*/
        /*HelloWorldConsumerForObject consumer = new HelloWorldConsumerForObject();
        consumer.receiveHelloWorldActiveMQ();*/
        /*HelloWorldConsumerListener listener = new HelloWorldConsumerListener();
        listener.receiveHelloWorldActiveMQ();*/

        HelloWorldConsumerTopic1 topic1 = new HelloWorldConsumerTopic1();
        new Thread(topic1).start();
        HelloWorldConsumerTopic2 topic2 = new HelloWorldConsumerTopic2();
        new Thread(topic2).start();
        HelloWorldConsumerTopic3 topic3 = new HelloWorldConsumerTopic3();
        new Thread(topic3).start();
    }
}
