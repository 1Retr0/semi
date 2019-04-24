package cn.edu.zucc;

import cn.edu.zucc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class springTask {

    @Autowired
    UserService userService;
    @Async
    @Scheduled(cron = "0/5 * * * * *")
    public void scheduled() throws InterruptedException {
        System.out.println(LocalDateTime.now()+"\tTom的邮箱是"+userService.getUser("Tom").getEmail());
    }

}
