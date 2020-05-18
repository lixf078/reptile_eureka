package com.migoo.demoproducers.repository;

import com.migoo.demoproducers.DemoProducersApplicationTests;
import com.migoo.demoproducers.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryTest extends DemoProducersApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveUser() {
        User user = new User();
        user.setAge(18);
        user.setName("test");
        this.userRepository.save(user);
    }

    @Test
    public void findByName() {
        User test = this.userRepository.findByName("test");
        Assert.assertEquals("18", test.getAge().toString());
    }
}
