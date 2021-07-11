package cn.wayan.one.test;

import cn.wayan.one.learn.Person;
import org.junit.Test;

import java.io.*;
import java.util.Properties;

public class PersonTest {

    @Test
    public void test() throws Exception{
        Person person = Person.class.getDeclaredConstructor().newInstance();
        System.out.println(person);
    }
}
