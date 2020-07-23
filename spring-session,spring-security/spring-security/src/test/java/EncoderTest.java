import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@SpringBootTest
public class EncoderTest {

    @Test
    public void encoderTest(){
        PasswordEncoder pe = new BCryptPasswordEncoder();
        //加密
        String encode = pe.encode("guests");
        System.out.println(encode);

        //传入密码是否匹配
        boolean matches = pe.matches("guests", encode);
        System.out.println(matches);
    }

}
