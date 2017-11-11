package net.ukr.kaminskiy;

public class Main {

    public static void main(String[] args) {

        Group group = new Group();

        try {

            group.addStudentInteractive();
            group.addStudent( new Student("Petr", "Kam", true, 21, 175, "Brown", "Blue", "IT", "Java", 10));
            group.addStudent( new Student("Alex", "Iarosh", true, 20, 170, "Brown", "Blue", "IT", "Java", 11));
            group.addStudent( new Student("Dima", "Drem", true, 17, 185, "Brown", "Blue", "IT", "Java", 9));
            group.addStudent( new Student("Olia", "Vhgchg", false, 20, 170, "Brown", "Blue", "IT", "QA", 12));
            group.addStudent( new Student("Lena", "Gyuguyg", false, 21, 172, "Brown", "Blue", "IT", "QA", 15));

        } catch (ExceedingTheSizeOfTheArrayException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(group);
        group.sortByParametr(1, true);
        System.out.println(group);
        group.sortByParametr(2, false);
        System.out.println(group);
        group.sortByParametr(5, true);
        System.out.println(group);

        System.out.println(group.getRecruterToString());

        group.saveGroup(new GroupDAOOverraid("groupLoad.txt"));

        Group groupLoad = Group.loadGroup(new GroupDAOOverraid("groupLoad.txt"));
        System.out.println(groupLoad);


    }
}
