package IPA6;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Movie[]mov = new Movie[4];
        for(int i = 0 ; i < 4 ; i++){
            String a = sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();sc.nextLine();
            mov[i] = new Movie(a,b,c,d);
        }
        String sg = sc.nextLine();

        Movie[]ans = getMovieByGenre(mov, sg);
        for(int i = 0 ; i < ans.length ; i++){
            if(ans[i].getBudget() > 80000000){
                System.out.println("High Budget Movie");
            }
            else{
                System.out.println("Low Budget Movie");
            }
        }
        
    }
    public static Movie[] getMovieByGenre(Movie[] mov,String sg){
            Movie[] obj = new Movie[0];
            for(int i = 0 ; i < 4; i++){
                if(mov[i].getGenre().equalsIgnoreCase(sg)){
                    obj = Arrays.copyOf(obj, obj.length+1);
                    obj[obj.length-1] = mov[i];
                }
            }
            return obj;
    }
}

class Movie{
    public String movieName;
    public String company;
    public String genre;
    public int budget;

    public Movie(String movieName, String company,String genre, int budget){
        this.movieName = movieName;
        this.company = company;
        this.genre = genre;
        this.budget = budget;
    }
    public String getGenre(){
        return genre;
    }
    public int getBudget(){
        return budget;
    }
}