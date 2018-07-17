package localhost.maven.mvc.test.web.service;

import localhost.maven.mvc.test.web.dao.HelloDao;
import localhost.maven.mvc.test.web.model.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    private HelloDao helloDao;

    @Transactional
    @Override
    public void add(Hello hello) {
        helloDao.save(hello);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Hello> listHello() {
        return helloDao.list();
    }
}
