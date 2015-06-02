package fr.utbm.web.controller;
 
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
 
//import fr.utbm.core.entity.User;
 
/**
 * Handles requests for User.
 */
@Controller
public class UserController {

    public static final String USER_INFO = "/rest/user/info";
    
    //@RequestMapping(value = USER_INFO, method = RequestMethod.GET)
    /*public @ResponseBody User getUser() {
        User u = new User();
        u.setEnabled(true);
        u.setId(1);
        u.setUsername("test");
        return u;
    }*/
}