package net.ukr.kaminskiy;

public class Student extends Human {

    private String group;
    private String course;
    private int progress;

    public Student(String name, String surname, boolean sex, int age, int height, String hairColor, String eyeColor, String group, String course, int progress) {
        super(name, surname, sex, age, height, hairColor, eyeColor);
        this.group = group;
        this.course = course;
        this.progress = progress;
    }

    public Student() {
        super();
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    @Override
    public String toString() {
        return "Student{" +
                "group='" + group + '\'' +
                ", course='" + course + '\'' +
                ", progress=" + progress +" , " +
                super.toString();
    }
}
