package cn.edu.zucc.service;

import cn.edu.zucc.domain.entity.User;
import cn.edu.zucc.StudioDemoApplicationTests;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.hamcrest.core.Is.is;

public class UserServiceTest extends StudioDemoApplicationTests {

    @Autowired
    UserService userService;
    @Test
    public void testAcreate() {
        User user1 = new User();
        user1.setName("Tom");
        user1.setAge(20);
        User user2 = new User();
        user2.setName("Jerry");
        user2.setAge(20);
        userService.create(user1);
        userService.create(user2);
        Assert.assertThat(user1.getId(), is(1l));
        Assert.assertThat(user2.getId(), is(2l));
    }
 /*   @Test
    public void testBgetUser() {
        User user=userService.getUser(1l);
        Assert.assertThat(1l, is(user.getId()));
    }
    @Test
    public void testCupdate() {
        User user1 = new User();
        user1.setName("TomCat");
        user1.setAge(20);
        user1.setId(1l);
        userService.update(user1);
        User user=userService.getUser(1l);
        Assert.assertThat(user.getName(), is(user1.getName()));
    } */
    @Test
    public void testDdeleteById() {
        int n = userService.getAllUsers().size();
        userService.deleteById(2l);
        int m = userService.getAllUsers().size();
        Assert.assertThat(m, is(n-1));
    }
}