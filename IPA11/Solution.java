package IPA11;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Institution[] inst = new Institution[4];
        Scanner sc = new Scanner(System.in);
        for(int i = 0 ; i < 4; i++){
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();sc.nextLine();
            int d = sc.nextInt();sc.nextLine();
            String e = sc.nextLine();

            inst[i] = new Institution(a, b, c, d, e);
        }
        String loc = sc.nextLine();
        String name = sc.nextLine();

        int ans1 = FindNumClearancedByLoc(inst, loc);
        if(ans1 > 0 )System.out.println(ans1);
        else System.out.println("There are no cleared students in this particular location");

      
        Institution ans2 = UpdateInstitutionGrade(inst, name);
        if(ans2 != null){
            int rating = (ans2.getNoOfStudentsPlaced()*100)/ans2.getNoOfStudentsCleared();
            if(rating >= 80) System.out.println(ans2.getInstitutionName() +" :: "+ 'A');
            else System.out.println(ans2.getInstitutionName()+" :: "+'B');
        }
    }

    public static int FindNumClearancedByLoc(Institution[]inst , String loc){
        int count = 0;
        for (int i = 0; i < inst.length; i++) {
            if(inst[i].getLocation().equalsIgnoreCase(loc)){
                count += inst[i].getNoOfStudentsCleared();
            }
        }
        return count;
    }

    public static Institution UpdateInstitutionGrade(Institution[]inst , String name){
        for (int i = 0; i < inst.length; i++) {
            if(inst[i].getInstitutionName().equalsIgnoreCase(name)){
                return inst[i];
            }
        }
        return null;
    }
}

class Institution {
    public int institutionId;
    public String institutionName;
    public int noOfStudentsPlaced;
    public int noOfStudentsCleared;
    public String location;
    public String grade;

    public Institution(int institutionId, String institutionName, int noOfStudentsPlaced, int noOfStudentsCleared,
            String location) {
                this.institutionId = institutionId;
                this.institutionName = institutionName;
                this.noOfStudentsPlaced = noOfStudentsPlaced;
                this.noOfStudentsCleared = noOfStudentsCleared;
                this.location = location;
    }

    public int getNoOfStudentsPlaced(){
        return noOfStudentsPlaced;
    }

    public String getLocation(){
        return location;
    }
    public String getInstitutionName(){
        return institutionName;
    }

    public int getNoOfStudentsCleared(){
        return noOfStudentsCleared;
    }
}