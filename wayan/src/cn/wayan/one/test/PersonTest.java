package cn.wayan.one.test;

import org.junit.Test;

public class PersonTest {

    @Test
    public void test() throws Exception{
        Person person = Person.class.getDeclaredConstructor().newInstance();
        Person person2 = Person.class.getDeclaredConstructor().newInstance();
        System.out.println(person);
        System.out.println("测试完毕");
        System.out.println("ssh pull");
    }
}
