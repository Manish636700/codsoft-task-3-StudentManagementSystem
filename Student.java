package StudentManagementSystem;

public class Student {
    private String name ;
    private String fatherName;
    private int rollNumber;
    private String grade;
    private String email;
    private String address;
    private String gender;
    private String nationality;

    public Student(String name, String fatherName, int rollNumber, String grade, String email, String address, String gender, String nationality){
        this.name = name;
        this.fatherName = fatherName;
        this.rollNumber = rollNumber;
        this.grade = grade;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.nationality =nationality;
    }
    public String getName() {
        return name;
    }
    public String getFatherName(){
        return fatherName;
    }
    public int getRollNumber(){
        return rollNumber;
    }
    public String getGrade() {
        return grade;
    }
    public String getEmail() {
        return email;
    }
    public String getAddress() {
        return address;
    }
    public String getGender(){
        return gender;
    }
    public String getNationality(){
        return nationality;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setFatherName(String fatherName){
        this.fatherName = fatherName;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public void setNationality(String nationality){
        this.nationality = nationality;
    }
    public static boolean validateRollNumber(int rollNumber){
            return rollNumber > 0;
    }
    public static boolean validateGrade(String grade) {
        return grade.matches("[A-F]") && grade.length() == 1; // Grade should be a single letter from A to F
    }
    public static boolean validateName(String name) {
        return name.matches("[A-Za-z ]+") && !name.matches(".*\\d.*"); // Name should contain only alphabets and spaces and should not contain any numbers
    }
}
