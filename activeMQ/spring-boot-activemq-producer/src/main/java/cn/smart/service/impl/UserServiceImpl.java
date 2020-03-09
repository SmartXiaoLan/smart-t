package cn.smart.service.impl;

import cn.smart.pojo.User;
import cn.smart.service.UserService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Service
public class UserServiceImpl implements UserService {

    private final JmsTemplate jmsTemplate;

    @Autowired
    public UserServiceImpl(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void addUser(final User user) {
//        this.jmsTemplate.setDefaultDestinationName("修改默认队列");
        //发送消息
        this.jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(user);
            }
        });

    }
}
