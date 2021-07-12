package cn.wayan.one.test;

import cn.wayan.one.learn.Person;
import org.junit.Test;

import java.io.*;
import java.util.Properties;

public class PersonTest {

    @Test
    public void test() throws Exception{
        Person person = Person.class.getDeclaredConstructor().newInstance();
        Person person2 = Person.class.getDeclaredConstructor().newInstance();
        System.out.println(person);
        System.out.println("合并分支");
        System.out.println("master test");
        System.out.println("hot-fix test");
    }
}
