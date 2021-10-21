package NetflixProject;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringSearcher {
    private static final SpringSearcher searcher = new SpringSearcher();
    private static final String springXml = "spring.xml";
    private static final ApplicationContext baseContext = configs();

    private static ApplicationContext configs(){
        ApplicationContext applicationContext = null;
        try{
            applicationContext = new ClassPathXmlApplicationContext(SpringSearcher.springXml);
        } catch (BeansException e) {
            e.printStackTrace();
            System.out.println("error in loading config file: " + SpringSearcher.springXml);
        }
        return applicationContext;
    }

    public Object lookUp(String name){
        return baseContext.getBean(name);
    }

    public static SpringSearcher getInstance(){
        return searcher;
    }
}
