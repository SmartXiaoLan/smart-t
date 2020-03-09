package cn.smart.config;

import cn.smart.pojo.User;
import cn.smart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;

@Component
public class ActiveMq {

    @Autowired
    private UserService userService;

    @JmsListener(destination = "test-spring")
    public void receiveMassage(Message message) {
        try {
            ObjectMessage objectMessage =(ObjectMessage)message;
            User user = (User) objectMessage.getObject();
            this.userService.showUser(user);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
