package RestServices;

import NetflixProject.Connections.DatabaseOperations.DatabaseOperator;
import NetflixProject.Record;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/just-a-like")
public class Controller {

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    @RequestMapping(value = "/getOriginalRecordList", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE)
    public List<Record> getOriginalRecordList(){
        return DatabaseOperator.getOriginalRecordList();
    }
}
