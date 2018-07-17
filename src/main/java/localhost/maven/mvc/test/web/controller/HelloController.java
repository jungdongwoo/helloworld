package localhost.maven.mvc.test.web.controller;

import localhost.maven.mvc.test.web.config.AppConfig;
import localhost.maven.mvc.test.web.model.Hello;
import localhost.maven.mvc.test.web.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller()
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(Model model) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);



        HelloService helloService = context.getBean(HelloService.class);

        logger.info("before Hello dao:: ");

        List<Hello> hellos = helloService.listHello();
        for (Hello hello : hellos) {
            logger.info("name :: " + hello.getName());
        }

        logger.info("after Hello dao:: ");


        model.addAttribute("message", "Hello world");
        logger.info("Hello logger test:: ");
        logger.trace("logger trace :: ");
        return "hello";
    }

    @RequestMapping(value = "/hello/{name:/.+}", method = RequestMethod.GET)
    public ModelAndView hello(@PathVariable("name") String name) {
        ModelAndView model = new ModelAndView();
        model.setViewName("hello");
        model.addObject("msg", name);

        return model;

    }

    //test db connection here
}
