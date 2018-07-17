package localhost.maven.mvc.test.web.dao;

import localhost.maven.mvc.test.web.model.Hello;

import java.util.List;

public interface HelloDao {
    public void save(Hello p);

    public List<Hello> list();
}
