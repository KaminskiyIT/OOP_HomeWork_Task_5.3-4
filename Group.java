package net.ukr.kaminskiy;

import javax.swing.*;
import java.util.Arrays;

public class Group implements Voencom {

    Student[] groupOfStudentsArray = new Student[10];

    public Group() {
        super();
    }

    public void addStudentInteractive() throws ExceedingTheSizeOfTheArrayException {
        Student student = null;
        try {
            String name = getName("Input student name");
            String surname = getName("Input student lastname");
            boolean sex = getSex("Input sex -> man or women");
            int age = getAge("Input student age");
            int height = getAge("Input student height");
            String hairColor = getName("Input student hairColor");
            String eyeColor = getName("Input student eyeColor");
            String group = getName("Input group name");
            String course = getName("Input course");
            int progress = getProgress("Input student's progress");
            Student st = new Student(name, surname, sex, age, height, hairColor, eyeColor, group, course, progress);
            this.addStudent(st);
        } catch (NullPointerException e) {
            System.out.println("Canceled");
            return;
        }
    }

    public void addStudent(Student student) throws ExceedingTheSizeOfTheArrayException {

        if (student == null) {
            throw new IllegalArgumentException("Value - Null");
        }

        for (int i = 0; i < groupOfStudentsArray.length; i++) {
            if (groupOfStudentsArray[i] == null) {
                groupOfStudentsArray[i] = student;
                return;
            }
        }
        throw new ExceedingTheSizeOfTheArrayException();
    }

    public void deleteStudentByIndex(int index) {

        if (!(index >= 0 && index < groupOfStudentsArray.length)) {
            System.out.println("Error index");
            return;
        }
        groupOfStudentsArray[index] = null;

    }

    public Student searchForStudentByName(String name) {
        for (Student student : groupOfStudentsArray) {
            if (student != null && student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }

    private void sort() {
        for (int i = 0; i < groupOfStudentsArray.length - 1; i++) {
            for (int j = i + 1; j < groupOfStudentsArray.length; j++) {
                if (compareStudent(groupOfStudentsArray[i], groupOfStudentsArray[j]) > 0) {
                    Student temp = groupOfStudentsArray[i];
                    groupOfStudentsArray[i] = groupOfStudentsArray[j];
                    groupOfStudentsArray[j] = temp;
                }
            }
        }
    }

    public Student[] getGroupOfStudentsArray() {
        Student[] temp = new Student[this.groupOfStudentsArray.length];
        System.arraycopy(groupOfStudentsArray, 0, temp, 0, temp.length);
        return temp;
    }

    private int compareStudent(Student one, Student two) {
        if (one != null && two == null) {
            return 1;
        }
        if (one == null && two != null) {
            return -1;
        }
        if (one == null && two == null) {
            return 0;
        }
        return one.getName().compareTo(two.getName());

    }

    private int getAge(String message) throws NullPointerException {
        boolean done = false;
        int age = 0;
        for (; !done; ) {
            try {
                age = Integer.valueOf(JOptionPane.showInputDialog(message));
                done = true;
            } catch (NumberFormatException e) {
                JOptionPane.showInternalMessageDialog(null, "Invalid ");
            }
        }
        return age;
    }

    private String getName(String message) throws NullPointerException {
        boolean done = false;
        String name = "";
        for (; !done; ) {
            try {
                name = JOptionPane.showInputDialog(message);
                done = true;
            } catch (NumberFormatException e) {
                JOptionPane.showInternalMessageDialog(null, "Invalid format");
            }
        }
        return name;
    }

    private boolean getSex(String message) throws NullPointerException {
        boolean done = false;
        boolean name = false;
        for (; !done; ) {
            try {
                name = JOptionPane.showInputDialog(message).equals("man");
                done = true;
            } catch (NumberFormatException e) {
                JOptionPane.showInternalMessageDialog(null, "Invalid format");
            }
        }
        return name;
    }

    private int getProgress(String message) throws NullPointerException {
        boolean done = false;
        int name = 0;
        for (; !done; ) {
            try {
                name = Integer.valueOf(JOptionPane.showInputDialog(message));
                done = true;
            } catch (NumberFormatException e) {
                JOptionPane.showInternalMessageDialog(null, "Invalid format");
            }
        }
        return name;
    }

    public void sortByParametr(int i) {
        Arrays.sort(this.groupOfStudentsArray, new StudentComparator(i));
    }

    public void sortByParametr(int i, boolean forward) {
        Arrays.sort(this.groupOfStudentsArray, new StudentComparator(i, forward));
    }

    @Override
    public String toString() {

        return arrayToString(groupOfStudentsArray);
    }

    @Override
    public Student[] getRecruter() {

        int n = 0;

        for (Student student : groupOfStudentsArray) {
            if (student != null && student.isSex() && student.getAge() >= 18) {
                n += 1;
            }
        }

        Student[] groupOfStudentsArrayVoencom = new Student[n];

        int i = 0;
        for (Student student : groupOfStudentsArray) {
            if (student != null && student.isSex() && student.getAge() >= 18) {
                groupOfStudentsArrayVoencom[i++] = student;
            }
        }
        return groupOfStudentsArrayVoencom;
    }

    public String getRecruterToString() {

        return arrayToString(getRecruter());
    }

    public String arrayToString(Student[] arrayStudents) {
        StringBuilder sb = new StringBuilder();

        int i = 0;

        for (Student student : arrayStudents) {
            if (student != null) {
                sb.append((++i) + ") ").append(student);
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public void saveGroup(GroupDAO groupdao) {
        groupdao.saveGroup(this);
    }

    public static Group loadGroup(GroupDAO groupdao) {
        return groupdao.loadGroup();
    }

}
