// package IPA3;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Player[] p = new Player[4];
        for(int i = 0 ; i < p.length ; i++){
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();sc.nextLine();
            p[i]= new Player(a, b, c, d);
        }
        String i1 = sc.nextLine();
        String i2 = sc.nextLine();
        int ans1 = findPointsForGivenSkill(p, i1);
        if(ans1 >0)System.out.println(ans1);
        else System.out.println("The given Skill is not available");

        Player ans2 = getPlayerBasedOnLevel(p, i1, i2);
        if(ans2 != null)System.out.println(ans2.getplayerId());
        else System.out.println("No player is available with specified level, skill and eligibility points");
        
    
    }
    public static int findPointsForGivenSkill(Player[]p,String i1){
        int count = 0;
        for(int i = 0 ; i < 4; i++){
            if(p[i].getSkill().equalsIgnoreCase(i1)==true){
                count+=p[i].getPoint();
            }
        }
        return count;
    }

    public static Player getPlayerBasedOnLevel(Player[]p,String i1, String i2){
        for(int i = 0 ; i < 4 ; i++){
            if(p[i].getSkill().equalsIgnoreCase(i1) && p[i].getLevel().equalsIgnoreCase(i2) && p[i].getPoint()>=20){
                return p[i];
            }
        }
        return null;
    }
}

class Player{
    public int playerId;
    public int points;
    public String skill;
    public String level;

    public Player(int playerId, String skill, String level, int points){
         this.playerId = playerId;
         this.skill = skill;
         this.level = level;
         this.points = points;
    }

    public int getplayerId(){
        return playerId;
    }
    public int getPoint(){
        return points;
    }

    public String getSkill(){
        return skill;
    }
    public String getLevel(){
        return level;
    }
}