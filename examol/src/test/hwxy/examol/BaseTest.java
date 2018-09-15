package hwxy.examol;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 整合Spring Junit Junit启动时加载Spring IOC容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
//Spring 配置文件位置
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class BaseTest
{

}
