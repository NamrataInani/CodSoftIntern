import java.util.*;
public class GradeCalcu {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
System.out.println("Enter the number of subjects");
int numSubjects=sc.nextInt();
if(numSubjects<=0){
    System.out.println("Please enter valid number of subjects");
    return;
}
int totalMarks=0;
int maxMarksPerSub=100;
for(int i=1;i<=numSubjects;i++){
    System.out.println("Enter marks obtained in subject"+i+"(out of 100)");
    int marks=sc.nextInt();
    if(marks<0 || marks>maxMarksPerSub){
        System.out.println("Marks should be in th range of 0-100");
   i--;

    }
    else{
        totalMarks+=marks;
    }
}
double averagePercentage=(double)totalMarks/(numSubjects+maxMarksPerSub)*100;
System.out.println("Total Marks"+totalMarks);
System.out.println("AveragePercentage:"+averagePercentage+"%");
    
String grade;
if(averagePercentage>=90){
    grade="A+";
    }
    else if(averagePercentage>=80){
       grade="A";
    }
    else if(averagePercentage>=70){
        grade="B";
    }
    else if(averagePercentage>=60){
        grade="C";
    }
    else if(averagePercentage>=50){
        grade="D";
    }
    else {
        grade="F";
    }
    System.out.println("Grade:"+grade);
}
}
