package beanutilstest;

import java.util.List;

/**
 * @author : Hens
 * @date : 2019/9/9 21:04
 */
public class Group2 {
    private Integer groupId;

    private String type;

    private List<Person> persons;

    public Group2() {
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", type='" + type + '\'' +
                ", persons=" + persons +
                '}';
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Group2(Integer groupId, String type, List<Person> persons) {
        this.groupId = groupId;
        this.type = type;
        this.persons = persons;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
