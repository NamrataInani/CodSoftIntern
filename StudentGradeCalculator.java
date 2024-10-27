import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Student{
    String name;
    int rollNo;
    String grade;
    double marks;
    String address;

    Student(String name,int rollNo,String grade,double marks,String address){
          this.name=name;
          this.rollNo=rollNo;
             this.grade=grade;
             this.marks=marks;
             this.address=address;
    }
    public String getName(){
        return name;
    }
    public void setName(String name)
       {
           this.name=name;
         }
         public int getRollNo(){
            return rollNo;
         }
         public String getGrade() {
            return grade;
        }
    
        public void setGrade(String grade) {
            this.grade = grade;
        }
    
        public double getMarks() {
            return marks;
        }
    
        public void setMarks(double marks) {
            this.marks = marks;
        }
    
        public String getAddress() {
            return address;
        }
    
        public void setEmail(String address) {
            this.address = address;
        }
    
    public void displayStudentInfo(){
 System.out.println("Name:"+name);
System.out.println("Rollno:"+rollNo);
System.out.println("Grade:"+grade);
System.out.println("Marks:"+marks);
System.out.println("Address:"+address);

}
}
public class StudentGradeCalculator {

    private static final String URL = "jdbc:mysql://localhost:3306/StudentManagement"; // Update with your database URL
    private static final String USER="root";
    private static final String PASSWORD="mun143@mun";
    private Scanner sc;
    public StudentGradeCalculator(){
         try{
            Class.forName("com.mysql.cj.jdbc.Driver");
     }
     catch(ClassNotFoundException e){
        System.err.println("JDBC driver not found"+e.getMessage());
     }
     sc=new Scanner(System.in);
}
public void addStudent(Student student){
    String query ="Insert it Students(name,rollNo,grade,marks,address) VALUES(?,?,?,?,?)";
try (Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
PreparedStatement stmt = conn.prepareStatement(query)) {
    stmt.setString(1, student.getName());
    stmt.setInt(2, student.getRollNo());
    stmt.setString(3, student.getGrade());
    stmt.setDouble(4,student.getMarks());
    stmt.setString(5,student.getAddress());
    stmt.executeUpdate();

    System.out.println("Student added:"+student.getName());
    }
    catch(SQLException e){
        System.err.println("Error adding Student:"+e.getMessage());
    }
}
public void editStudent(int rollNo) {
    String query = "UPDATE Students SET name = ?, grade = ?, marks = ?, address = ? WHERE roll_no = ?";
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement stmt = conn.prepareStatement(query)) {

        System.out.print("Enter new name: ");
        String name = sc.nextLine();
        System.out.print("Enter new grade: ");
        String grade = sc.nextLine();
        System.out.print("Enter new marks: ");
        double marks = sc.nextDouble();
        sc.nextLine(); // Consume newline
        System.out.print("Enter new address: ");
        String address = sc.nextLine();
        stmt.setString (1,name);
        stmt.setInt(2,rollNo);
        stmt.setDouble(3,marks);
        stmt.setString(4,address);
        stmt.setString(5,grade);

        int rowsAffected=stmt.executeUpdate();
        if(rowsAffected>0){
            System.out.println("Student updated with roll number:"+rollNo);
         }
         else{
            System.out.println("No student found with this roll number:"+rollNo);
         } 
         }
         catch(SQLException e){
            System.err.println("error updating student:"+e.getMessage());
         }
        }  
          public Student searchStudent(int rollNo) {
            String query = "SELECT * FROM Students WHERE roll_no = ?";
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement stmt = conn.prepareStatement(query)) {
    
                stmt.setInt(1, rollNo);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    return new Student(
                            rs.getString("name"),
                            rs.getInt("roll_no"),
                            rs.getString("grade"),
                            rs.getDouble("marks"),
                            rs.getString("address")
                    );
                }
            } catch (SQLException e) {
                System.err.println("Error searching for student: " + e.getMessage());
            }
            return null; // Student not found
        }
    
        public List<Student> displayAllStudents() {
            List<Student> students = new ArrayList<>();
            String query = "SELECT * FROM Students";
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {
    
                while (rs.next()) {
                    Student student = new Student(
                            rs.getString("name"),
                            rs.getInt("roll_no"),
                            rs.getString("grade"),
                            rs.getDouble("marks"),
                            rs.getString("address")
                    );
                    students.add(student);
                }
            } catch (SQLException e) {
                System.err.println("Error retrieving students: " + e.getMessage());
            }
            return students; // Return the list of students
        }
    
        public void menu() {
            while (true) {
                System.out.println("\n=== Student Management System ===");
                System.out.println("1. Add Student");
                System.out.println("2. Edit Student");
                System.out.println("3. Search Student");
                System.out.println("4. Display All Students");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
    
                int choice = sc.nextInt();
                sc.nextLine(); // Consume newline
    
                switch (choice) {
                    case 1:
                        // Adding a new student
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter roll number: ");
                        int rollNo = sc.nextInt();
                        sc.nextLine(); // Consume newline
                        System.out.print("Enter grade: ");
                        String grade = sc.nextLine();
                        System.out.print("Enter marks: ");
                        double marks = sc.nextDouble();
                        sc.nextLine(); // Consume newline
                        System.out.print("Enter address: ");
                        String address = sc.nextLine();
    
                        Student newStudent = new Student(name, rollNo, grade, marks, address);
                        addStudent(newStudent);
                        break;
    
                    case 2:
                        // Editing existing student information
                        System.out.print("Enter roll number of student to edit: ");
                        int editRollNo = sc.nextInt();
                        sc.nextLine(); // Consume newline
                        editStudent(editRollNo);
                        break;
    
                    case 3:
                        // Searching for a student
                        System.out.print("Enter roll number to search: ");
                        int searchRollNo = sc.nextInt();
                        sc.nextLine(); // Consume newline
                        Student foundStudent = searchStudent(searchRollNo);
                        if (foundStudent != null) {
                            System.out.println("Student found:");
                            foundStudent.displayStudentInfo();
                        } else {
                            System.out.println("Student not found with roll number: " + searchRollNo);
                        }
                        break;
    
                    case 4:
                        // Displaying all students
                        List<Student> students = displayAllStudents();
                        if (students.isEmpty()) {
                            System.out.println("No students available.");
                        } else {
                            System.out.println("List of Students:");
                            for (Student student : students) {
                                student.displayStudentInfo();
                                System.out.println(); // Add a newline for better readability
                            }
                        }
                        break;
    
                    case 5:
                        // Exit the application
                        System.out.println("Exiting the application.");
                        sc.close();
                        return;
    
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        }
    
    
    public static void main(String[] args){
    
        StudentGradeCalculator sgc = new StudentGradeCalculator();
        sgc.menu(); // Start the user interaction

    }
}
