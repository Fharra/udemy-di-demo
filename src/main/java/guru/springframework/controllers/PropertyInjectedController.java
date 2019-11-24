package guru.springframework.controllers;

import guru.springframework.services.GreetingService;
import guru.springframework.services.GreetingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;


/**
 * Created by jt on 5/24/17.
 */
@Controller
public class PropertyInjectedController {

    @Qualifier("greetingServiceImpl")
    @Autowired
    public GreetingService greetingService;

    public String sayHello(){
        return greetingService.sayGreeting();
    }

}
