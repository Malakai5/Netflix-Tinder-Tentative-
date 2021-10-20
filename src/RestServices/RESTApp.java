package RestServices;

import com.mysql.cj.log.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (scanBasePackageClasses = {Controller.class})

public class RESTApp {
    private static final Log log = (Log) LogFactory.getLog(RESTApp.class);

    public static void main(String[] args) {

    }
}
