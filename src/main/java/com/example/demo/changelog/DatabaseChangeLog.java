package com.example.demo.changelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.github.cloudyrock.mongock.driver.mongodb.springdata.v3.decorator.impl.MongockTemplate;
import com.example.demo.entity.User;

import java.util.ArrayList;
import java.util.List;

@ChangeLog
public class DatabaseChangeLog {

    @ChangeSet(order = "001", id = "seedDataBaseWithUsers", author = "me")
    public void seedDataBase(MongockTemplate mongockTemplate){
        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setName("Petr");
        user1.setEmail("petr@gmail.com");
        User user2 = new User();
        user2.setName("Fedor");
        user2.setEmail("fedor@gmail.com");
        userList.add(user1);
        userList.add(user2);
        mongockTemplate.insert(userList, "users");
    }
}
