package IPA4;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Medicine []med = new Medicine[4];
        Scanner sc = new Scanner(System.in);

        for(int i = 0 ; i < 4; i++){
            String a = sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();sc.nextLine();
            med[i] = new Medicine(a, b, c, d);
        }

        String inp = sc.nextLine();
        int [] ans = getPriceByDisease(med,inp);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }

    }
    public static int[] getPriceByDisease(Medicine[]med,String inp){
        int [] obj = new int[0];
        for(int i = 0 ; i < 4 ; i++){
            if(med[i].getDisease().equalsIgnoreCase(inp)){
                obj = Arrays.copyOf(obj, obj.length+1);
                obj[obj.length -1] = med[i].getPrice();
            }
        }
        Arrays.sort(obj);
        return obj;
    }
}

class Medicine{
    public String medicineName;
    public String batch;
    public String disease;
    public int price;

    public Medicine(String medicineName, String batch, String disease, int price){
        this.medicineName = medicineName;
        this.batch = batch;
        this.disease = disease;
        this.price = price;
    }

    public int getPrice(){
        return price;
    }
    public String getMedicineName(){
        return medicineName;
    }
    public String getBatch(){
        return batch;
    }
    public String getDisease(){
        return disease;
    }
}