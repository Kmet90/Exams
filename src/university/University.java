package university;

import java.util.ArrayList;
import java.util.List;

public class University {
    private int capacity;
    private List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        StringBuilder sb = new StringBuilder();
        if (capacity > this.students.size()) {
            if (this.students.contains(student)) {
                sb.append("Student is already in the university");
            } else {
                this.students.add(student);
                sb.append("Added student ")
                        .append(student.firstName)
                        .append(" ")
                        .append(student.lastName);
            }
        } else {
            sb.append("No seats in the university");
        }
        return sb.toString();
    }

    public String dismissStudent(Student student) {
        StringBuilder sb = new StringBuilder();
        if (this.students.contains(student)) {
            sb.append("Removed student ")
                    .append(student.firstName)
                    .append(" ")
                    .append(student.lastName);
            this.students.remove(student);
        } else {
            sb.append("Student not found");
        }
        return sb.toString();
    }

    public Student getStudent(String firstName, String lastName) {
//        for (Student student : students) {
//            if (student.firstName.equals(firstName) && student.lastName.equals(lastName)) {
//                return student;
//            }
//        }
//        return null;
        return this.students
                .stream()
                .filter(student -> student.firstName.equals(firstName) && student.lastName.equals(lastName))
                .findFirst()
                .orElse(null);
    }

    public String getStatistics() {
//        StringBuilder sb = new StringBuilder();
//        for (Student student : students) {
//            sb.append("==Student: ")
//                    .append("First Name = ")
//                    .append(student.firstName)
//                    .append(", Last Name = ")
//                    .append(student.lastName)
//                    .append(", Best Subject = ")
//                    .append(student.bestSubject)
//                    .append(System.lineSeparator());
//        }
//        return sb.toString().trim();
        StringBuilder output = new StringBuilder();
        this.students
                .forEach(student -> output
                        .append("==Student: First Name = ")
                        .append(student.firstName)
                        .append(", Last Name = ")
                        .append(student.lastName)
                        .append(", Best Subject = ")
                        .append(student.bestSubject)
                        .append(System.lineSeparator()));
        return output.toString().trim();
    }

}
