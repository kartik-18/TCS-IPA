package IPA8;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Employee [] emp = new Employee[5];
        Scanner sc = new Scanner(System.in);
        for(int i = 0 ; i < 5; i++){
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();sc.nextLine();
            int e = sc.nextInt();sc.nextLine();
            emp[i] = new Employee(a, b, c, d, e);
        }
        int par1 = sc.nextInt();sc.nextLine();
        String par2 = sc.nextLine();

        String[] ans1 = findDept(emp, par1);
        if(ans1 != null){
            for(int i = 0 ; i < ans1.length-1; i++){
                System.out.print(ans1[i] +", ");
            }
            System.out.print(ans1[ans1.length-1]);
            System.out.println();
        }else{
            System.out.println("No Department found");
        }

        int ans2 = findSecondHighestSalary(emp, par2);
        if(ans2 > 0)System.out.println(ans2);
        else System.out.println("No data found");
    }

    public static String[] findDept(Employee[]emp, int par1){
        String [] obj = new String[0];
        for(int i = 0 ; i < 5; i++){
            if(emp[i].getSalary() == par1 && emp[i].getRating() >= 3){
                obj = Arrays.copyOf(obj,obj.length+1);
                obj[obj.length - 1] = emp[i].getDept();
            }
        }
        if(obj.length>0)return obj;
        else return null;
    }

    public static int findSecondHighestSalary(Employee[]emp, String par2){
        int[]obj = new int[0];
        for(int i = 0 ; i < 5 ; i++){
            if(emp[i].getDept().equalsIgnoreCase(par2)){
                obj = Arrays.copyOf(obj,obj.length+1);
                obj[obj.length - 1] = emp[i].getSalary();
            }
        }
        Arrays.sort(obj);
        if(obj.length>=2)return obj[obj.length - 2];
        else return 0;
    }
}

class Employee{
    public int empId;
    public String empName;
    public String dept;
    public int rating;
    public int salary;

    public Employee(int empId, String empName, String dept , int rating , int salary){
        this.empId = empId;
        this.empName = empName;
        this.dept = dept;
        this.rating = rating;
        this.salary = salary;
    }

    public int getSalary(){
        return salary;
    }
    public int getRating(){
        return rating;
    }

    public String getDept(){
        return dept;
    }
}