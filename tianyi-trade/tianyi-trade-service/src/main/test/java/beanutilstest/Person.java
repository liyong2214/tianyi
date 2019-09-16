package beanutilstest;

/**
 * @author : Hens
 * @date : 2019/9/8 21:06
 */
public class Person {

    private Integer personId;

    private String type;

    private Integer age;

    public Person() {
    }

    public Person(Integer personId, String type, Integer age) {
        this.personId = personId;
        this.type = type;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", type='" + type + '\'' +
                ", age=" + age +
                '}';
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
