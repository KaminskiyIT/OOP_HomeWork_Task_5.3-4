package net.ukr.kaminskiy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class GroupDAOOverraid implements GroupDAO {

    private String fileadress;

    public GroupDAOOverraid(String fileadress) {
        super();
        this.fileadress = fileadress;
    }

    public GroupDAOOverraid() {
        super();
    }

    public String getFileadress() {
        return fileadress;
    }

    public void setFileadress(String fileadress) {
        this.fileadress = fileadress;
    }

    @Override
    public void saveGroup(Group group) {
        try (PrintWriter pw = new PrintWriter(this.fileadress)) {
            for (Student student : group.getGroupOfStudentsArray()) {
                if (student != null) {
                    pw.println(student.getName() + ";" + student.getSurname() + ";" + student.isSex() + ";" + student.getAge() + ";"
                            + student.getHeight() + ";" + student.getHairColor() + ";" + student.getEyeColor() + ";" + student.getGroup() + ";"
                            + student.getCourse() + ";" + student.getProgress());
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public Group loadGroup() {
        Group groupL = new Group();
        try (BufferedReader br = new BufferedReader(new FileReader(this.fileadress))) {
            String text = "";
            for (; (text = br.readLine()) != null; ) {
                String[] studentDate = text.split(";");

                String name = studentDate[0];
                String surname = studentDate[1];
                boolean sex = (studentDate[2].equals("true"));
                int age = Integer.valueOf(studentDate[3]);
                int height = Integer.valueOf(studentDate[4]);
                String hairColor = studentDate[5];
                String eyeColor = studentDate[6];
                String group = studentDate[7];
                String course = studentDate[8];
                int progress = Integer.valueOf(studentDate[9]);

                Student student = new Student(name, surname, sex, age, height, hairColor, eyeColor, group, course, progress);
                groupL.addStudent(student);

            }
        } catch (IOException | ExceedingTheSizeOfTheArrayException e) {
            System.out.println(e);
        }
        return groupL;
    }
}
