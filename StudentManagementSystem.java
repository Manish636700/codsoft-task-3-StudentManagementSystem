package StudentManagementSystem;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class StudentManagementSystem {
    private List<Student> students;
    private String dataFilePath;
    public StudentManagementSystem(String dataFilePath){
        students = new ArrayList<>();
        this.dataFilePath = dataFilePath;
    }

    public void addStudent(Student student){
        students.add(student);
    }
    public void removeStudent(int rollNumber){
        for(int i=0; i<students.size(); i++){
            Student student = students.get(i);
            if(student.getRollNumber() == rollNumber){
                students.remove(i);
                break;
            }
        }
    }

    public Student searchStudent(int rollNumber) {
        for(Student student : students){
            if(student.getRollNumber()==rollNumber){
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents(){
        System.out.println("\n List of students:");
        for(Student student : students){
            System.out.println("Name of tha Student: " + student.getName());
            System.out.println("Name of the Father: " + student.getFatherName());
            System.out.println("Roll Number: " + student.getRollNumber());
            System.out.println("Email ID: " + student.getEmail());
            System.out.println("Student grade: " + student.getGrade());
            System.out.println("Student Address: " + student.getAddress());
            System.out.println("Gender: " + student.getGender());
            System.out.println("nationality: " + student.getNationality());
            System.out.println("--------------------------------------------");
        }
    }
    public void writeDataToFile(){
        try(PrintWriter writer = new PrintWriter(new FileWriter(dataFilePath))){
            for(Student student : students){
                writer.println(student.getName());
                writer.println(student.getFatherName());
                writer.println(student.getRollNumber());
                writer.println(student.getEmail());
                writer.println(student.getGender());
                writer.println(student.getAddress());
                writer.println(student.getGrade());
                writer.println(student.getNationality());
                writer.println();
            }
            System.out.println("Student data written to file Successfully.\n");
        }catch(IOException e){
            System.out.println("Error writing student data to file.\n");
        }
    }
    public void readDataFromFile(String fileName){
        students.clear();
        try(Scanner scanner = new Scanner(new File(fileName))){
            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                String[] parts=line.split(",");
                if(parts.length == 8)
                {
                    String name = parts[0];
                    String fatherName = parts[1];
                    int rollNumber = Integer.parseInt(parts[3]);
                    String address = parts[2];

                    String grade = parts[4];
                    String email = parts[5];
                    String gender = parts[6];
                    String nationality = parts[7];
                    Student student = new Student(name,fatherName,rollNumber,address,email,gender,nationality, grade);
                    students.add(student);
                }
            }
            System.out.println("Student data loaded from file successfully.");
        }catch(FileNotFoundException e){
            System.out.println("Error : File not found. ");
        }catch(NumberFormatException e){
            System.out.println("Error : Invalid format Exception");
        }
    }

}
