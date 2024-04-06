package ru.spring.rest.model;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private String lastName;
    private Byte age;

    public User(){
    }

    public User(Long id, String name, String lastName, Byte age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
