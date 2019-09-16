package beanutilstest;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
/**
 * @author : Hens
 * @date : 2019/9/8 21:09
 */
public class BeanUtilsTest {

    public static void main(String[] args) {

        Person person = new Person(1,"人",18);
        Person person1 = new Person(2,"人",19);
        List<Person> personList = new ArrayList<>();
        personList.add(person);
        personList.add(person1);
        List<Person> personList1 = new ArrayList<>();
        Group group = new Group(1,"人",personList);
//        Class clazz = new Class();
//        BeanUtils.copyProperties(group,clazz);
//        clazz.setGroup(group);
//        System.out.println(clazz);
        //classId=null, type='人', group=Group{groupId=1, type='人', persons=[Person{personId=1, type='人', age=18}, Person{personId=2, type='人', age=19}]}
    }
}
