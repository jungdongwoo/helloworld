package localhost.maven.mvc.test.web.service;

import localhost.maven.mvc.test.web.model.Hello;

import java.util.List;

public interface HelloService {
    void add(Hello hello);
    List<Hello> listHello();
}
