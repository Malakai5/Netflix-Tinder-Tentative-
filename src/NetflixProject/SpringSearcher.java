package NetflixProject;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringSearcher {
    private static SpringSearcher searcher = new SpringSearcher();
    private static String springXml = "Spring.xml";
    private static ApplicationContext baseContext = configs(springXml);

    private static ApplicationContext configs(String fileName){
        ApplicationContext applicationContext = null;
        try{
            applicationContext = new ClassPathXmlApplicationContext(fileName);
        } catch (BeansException e) {
            e.printStackTrace();
            System.out.println("error in loading config file: " + fileName);
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
