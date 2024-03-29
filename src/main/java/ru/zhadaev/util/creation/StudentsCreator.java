package ru.zhadaev.util.creation;

import ru.zhadaev.dao.entities.Student;

import java.util.*;

public class StudentsCreator {
    private Random rnd;

    public List<Student> createStudents(int numberStudents, List<String> firstNames, List<String> lastNames) {
        requiredNotNull(firstNames);
        requiredNotNull(lastNames);
        requiredNumberRowsNotZero(firstNames);
        requiredNumberRowsNotZero(lastNames);
        requiredEqualityNumberRows(firstNames, lastNames);

        List<Student> students = new ArrayList<>();
        rnd = new Random();
        for (int i = 0; i < numberStudents; i++) {
            String firstName = firstNames.get(rnd.nextInt(lastNames.size()));
            String lastName = lastNames.get(rnd.nextInt(lastNames.size()));
            Student student = new Student();
            student.setFirstName(firstName);
            student.setLastName(lastName);

            students.add(student);
        }

        return students;
    }

    private void requiredNotNull(List<String> list) {
        if (list == null) {
            throw new IllegalArgumentException("Requires a non-null argument");
        }
    }

    private void requiredNumberRowsNotZero(List<String> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("The number of rows not equal to zero is required");
        }
    }

    private void requiredEqualityNumberRows(List<String> list1, List<String> list2) {
        if (list1.size() != list2.size()) {
            throw new IllegalArgumentException("The number of lines in the files is not equal");
        }
    }
}
