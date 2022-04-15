import com.aop.service.User;
import com.aop.service.UserService;
import com.aop.service.impl.SpringConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class SpringEnableAspectJAutoProxyTest {

    public static void main(String[] args) {
        //1.创建容器
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.获取对象
        UserService userService = ac.getBean("userService",UserService.class);
        //3.执行方法
        User user = new User();
        user.setId("1");
        user.setUsername("test");
        List<User> users = new ArrayList<>();
        users.add(user);

        userService.saveAllUser(users);
    }
}