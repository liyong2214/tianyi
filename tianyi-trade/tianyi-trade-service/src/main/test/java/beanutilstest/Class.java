package beanutilstest;

/**
 * @author : Hens
 * @date : 2019/9/8 21:10
 */
public class Class {

    private Integer classId;

    private String type;

    private Group group;

    public Class() {

    }

    public Class(Integer classId, String type) {
        this.classId = classId;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Class{" +
                "classId=" + classId +
                ", type='" + type + '\'' +
                ", group=" + group +
                '}';
    }

    public Class(Integer classId, String type, Group group) {
        this.classId = classId;
        this.type = type;
        this.group = group;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
