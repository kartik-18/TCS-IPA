package IPA14;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory[]inventories = new Inventory[4];
        for (int i = 0; i < inventories.length; i++) {
            String a= sc.nextLine();
            int b = sc.nextInt();sc.nextLine();
            int c = sc.nextInt();sc.nextLine();
            int d = sc.nextInt();sc.nextLine();

            inventories[i] = new Inventory(a, b, c, d);
        }
        int limit = sc.nextInt();sc.nextLine();

        Inventory[]ans = Replenish(inventories, limit);
        for (int i = 0; i < ans.length; i++) {
            if(ans[i].getThreshold() > 75)System.out.println(ans[i].getInventryId()+" Critical Filling");
            else if(ans[i].getThreshold() >= 50 && ans[i].getThreshold() <= 75)System.out.println(ans[i].getInventryId()+" Moderate Filling");
            else System.out.println(ans[i].getInventryId()+" Non-Critical Filling");
        }
    }
    public static Inventory[] Replenish(Inventory[]inventories, int limit){
        Inventory[]obj = new Inventory[0];
        for (int i = 0; i < inventories.length; i++) {
            if(limit >= inventories[i].getThreshold()){
                obj = Arrays.copyOf(obj, obj.length+1);
                obj[obj.length - 1] = inventories[i];
            }
        }
        return obj;
    }
}

class Inventory{
    public String inventoryId;
    public int maximumQuantity;
    public int currentQuantity;
    public int threshold;
    
    public Inventory(String inventoryId, int maximumQuantity, int currentQuantity,int threshold  ){
        this.inventoryId = inventoryId;
        this.maximumQuantity = maximumQuantity;
        this.currentQuantity = currentQuantity;
        this.threshold = threshold;
    }

    public int getThreshold(){
        return threshold;
    }

    public String getInventryId(){
        return inventoryId;
    }
}