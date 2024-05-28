package IPA16;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Music[] musics = new Music[4];
        for (int i = 0; i < 4; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            sc.nextLine();
            double d = sc.nextDouble();
            sc.nextLine();

            musics[i] = new Music(a, b, c, d);
        }
        int par2 = sc.nextInt();sc.nextLine();
        int par = sc.nextInt();sc.nextLine();
        
        int ans1 = findAvgOfCount(musics, par2);
        if(ans1 != 0) System.out.println(ans1);
        else System.out.println("No playlist found");

        Music[]ans2 = sortTypeByDuration(musics, par);
        if(ans2 != null){
            for (int i = 0; i < ans2.length; i++) {
                System.out.println(ans2[i].getType());
            }
        }else System.out.println("No playlist found with mentioned attribute");
    }

    public static int findAvgOfCount(Music[]musics, int par2){
        int c = 0;
        int sum =0;
        for (int i = 0; i < musics.length; i++) {
            if(musics[i].getCount() > par2){
                sum += musics[i].getCount();
                c++;
            }
        }
        if(c > 0) return sum/c;
        else return 0;
    }

    public static Music[] sortTypeByDuration(Music[] musics, int par) {
        Music[] obj = new Music[0];

        double[] ans = new double[0];

        for (int i = 0; i < musics.length; i++) {
            if (musics[i].getDuration() > par) {
                ans = Arrays.copyOf(ans, ans.length + 1);
                ans[ans.length - 1] = musics[i].getDuration();
            }
        }
        Arrays.sort(ans);

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < musics.length; j++) {
                if (ans[i] == musics[j].getDuration()) {
                    obj = Arrays.copyOf(obj, obj.length + 1);
                    obj[obj.length - 1] = musics[j];
                }
            }
        }

        if (obj.length > 0)
            return obj;
        else
            return null;

    }
}

class Music {
    public int playListNo;
    public String type;
    public int count;
    public double duration;

    public Music(int playListNo,
            String type,
            int count,
            double duration) {
        this.playListNo = playListNo;
        this.type = type;
        this.count = count;
        this.duration = duration;
    }

    public double getDuration() {
        return duration;
    }

    public int getCount(){
        return count;
    }

    public String getType(){
        return type;
    }
}