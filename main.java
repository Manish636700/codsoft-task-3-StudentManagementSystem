package StudentManagementSystem;
import java.util.Scanner;
public class main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String dataFilePath = "student.txt";
        StudentManagementSystem managementSystem = new StudentManagementSystem(dataFilePath);
        boolean running = true;
        while(running){
            System.out.println("Student Management System");
            System.out.println("1. Add a Student");
            System.out.println("2. Remove a Student");
            System.out.println("3. Search for a Student");
            System.out.println("4. Display all Student");
            System.out.println("5. Write data to file");
            System.out.println("6. Read data from File");
            System.out.println("7. Edit student information");
            System.out.println("8. Exit");
            System.out.print("Enter Your Choice:");
            int choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.print("Enter student name: ");
                    sc.nextLine();
                    String name = sc.nextLine().trim();
                    System.out.print("Enter father  name: ");
                    String fathername = sc.nextLine().trim();
                    int rollNumber;
                    while(true){
                        System.out.print("Enter Roll Number: ");
                        try {
                            rollNumber = Integer.parseInt(sc.nextLine());
                            if (Student.validateRollNumber(rollNumber)) {
                                break;
                            } else {
                                System.out.println("Invalid roll number");
                            }
                        }catch(NumberFormatException e){
                            System.out.println("Invalid roll number");
                            }
                        }
                    String grade;
                    while (true) {
                        System.out.print("Enter grade: ");
                        grade = sc.nextLine();
                        if (Student.validateGrade(grade)) {
                            break;
                        } else {
                            System.out.println("Invalid grade. Please enter a single letter from A to F.");
                        }
                    }
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter the address: ");
                    String address = sc.nextLine();
                    System.out.print("Enter Gender Male/female: ");
                    String gender = sc.nextLine();
                    System.out.print("enter nationality: ");
                    String nationality = sc.nextLine();

                    Student student = new Student(name,fathername,rollNumber,grade,email,address,grade,nationality);
                    managementSystem.addStudent(student);

                    System.out.println("Student added Successfully.\n");
                    break;

                case 2:
                    System.out.println("\n Enter roll number of the Student to remove :");
                    int rollToRemove = sc.nextInt();
                    managementSystem.removeStudent(rollToRemove);
                    System.out.println("Student removed successfully.");
                    break;

                case 3:
                    System.out.println("\n Enter roll number of the student to search. ");
                    int rollToSearch = sc.nextInt();
                    Student foundStudent = managementSystem.searchStudent(rollToSearch);
                    if(foundStudent != null)
                    {
                        System.out.println("Student found:");
                        System.out.println("Name: " + foundStudent.getName());
                        System.out.println("Father name: " + foundStudent.getFatherName());
                        System.out.println("Roll Number :" + foundStudent.getRollNumber());
                        System.out.println("Grade: " + foundStudent.getGrade());
                        System.out.println("Email: "+ foundStudent.getEmail());
                        System.out.println("Address: "+foundStudent.getAddress());
                        System.out.println("Gender: "+ foundStudent.getGender());
                        System.out.println("nationality: "+foundStudent.getNationality());

                        System.out.println("\n");
                    }else {
                        System.out.println("Student Not Found.");
                    }
                    break;
                case 4:
                    managementSystem.displayAllStudents();
                    break;
                case 5:
                    managementSystem.writeDataToFile();
                    System.out.println("\nData saved to file Successfully.");
                    break;
                case 6:
                    managementSystem.readDataFromFile(dataFilePath);
                    System.out.println("Data read from file SuccessFully.");
                    break;
                case 7:
                    System.out.println("\n Enter Roll number of the student to edit:");
                    int rollToEdit = sc.nextInt();
                    sc.nextLine();

                    Student existingStudent = managementSystem.searchStudent(rollToEdit);
                    if(existingStudent !=null)
                    {
                        System.out.println("Current Student Information");
                        System.out.println("Name: " + existingStudent.getName());
                        System.out.println("Father name: " + existingStudent.getFatherName());
                        System.out.println("Roll Number :" + existingStudent.getRollNumber());
                        System.out.println("Grade: " + existingStudent.getGrade());
                        System.out.println("Email: "+ existingStudent.getEmail());
                        System.out.println("Address: "+existingStudent.getAddress());
                        System.out.println("Gender: "+ existingStudent.getGender());
                        System.out.println("nationality: "+existingStudent.getNationality());

                        System.out.println("\n Enter new Information: ");

                        System.out.print("Enter student name: ");
                        sc.nextLine();
                        String newname = sc.nextLine().trim();
                        System.out.print("Enter father  name: ");
                        String newfathername = sc.nextLine().trim();

                        String newgrade;
                        while(true){
                            System.out.print("Enter Grade: ");
                            newgrade = sc.nextLine();
                            if(Student.validateGrade(newgrade)){
                                break;
                            }else{
                                System.out.println("Student added SuccessFully.\n");
                                break;
                            }
                        }
                        System.out.print("Enter Email : ");
                        String newemail = sc.nextLine();
                        System.out.print("Enter the address: ");
                        String newaddress = sc.nextLine();
                        System.out.print("Enter Gender Male/female : ");
                        String newgender = sc.nextLine();
                        System.out.print("enter nationality: ");
                        sc.nextLine();
                        String newnationality = sc.nextLine();

                        existingStudent.setName(newname);
                        existingStudent.setFatherName(newfathername);
                        existingStudent.setGrade(newgrade);
                        existingStudent.setEmail(newemail);
                        existingStudent.setAddress(newaddress);
                        existingStudent.setGender(newgender);
                        existingStudent.setNationality(newnationality);

                        System.out.println("Student information updated Successfully.\n");
                    }else{
                        System.out.println("Student not found.");
                    }
                    break;
                case 8:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
