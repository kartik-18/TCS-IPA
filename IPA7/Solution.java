package IPA7;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Course[] course = new Course[4];
        for (int i = 0; i < course.length; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            double c = sc.nextDouble();
            sc.nextLine();
            String d = sc.nextLine();
            boolean e = sc.nextBoolean();sc.nextLine();
            course[i] = new Course(a, b, c, d, e);
        }
        double par2 = sc.nextDouble();sc.nextLine();
        String par1 = sc.nextLine();
        int ans = CountCourse(course, par1, par2);
        if(ans != 0){
            System.out.println(ans);
        }else{
            System.out.println("No course found");
        }
    }
    public static int CountCourse(Course[]course, String par1, double par2){
        int count  =0;
        for(int i= 0 ; i < 4; i++){
            if(((course[i].getHaveCertificate()) && (course[i].getCourserating()>= par2) )&& course[i].getMode().equalsIgnoreCase(par1) ){
                count++;
            }
        }
        return count;
    }
}

class Course {
    public int courseId;
    public String courseName;
    public double courseRating;
    public String mode;
    public boolean haveCertificate;

    public Course(int courseId, String courseName, double courseRating, String mode, boolean haveCertificate) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseRating = courseRating;
        this.mode = mode;
        this.haveCertificate = haveCertificate;
    }

    public boolean getHaveCertificate(){
        return haveCertificate;
    }
    public double getCourserating(){
        return courseRating;
    }
    public String getCoursename(){
        return courseName;
    }
    public String getMode(){
        return mode;
    }
}