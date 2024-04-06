package ru.spring.rest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import ru.spring.rest.configuration.MyConfig;
import ru.spring.rest.model.User;

import java.util.List;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication", Communication.class);

        List<User> allUsers = communication.getAllUsers();
        System.out.println(allUsers);

        String cookie = communication.getCookie();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Cookie", cookie);

        User user = new User(3L, "James", "Brown", (byte)24);
        HttpEntity<User> httpEntity = new HttpEntity<>(user, headers);
        communication.saveUser(httpEntity);

        User user1 = new User(3L, "Thomas", "Shelby", (byte)24);
        HttpEntity<User> httpEntity2 = new HttpEntity<>(user1, headers);
        communication.updateUser(httpEntity2);

        HttpEntity<User> httpEntity3 = new HttpEntity<>(user1, headers);
        communication.deleteUser(3L, httpEntity3);

    }
}
