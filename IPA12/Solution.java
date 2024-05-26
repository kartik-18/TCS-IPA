package IPA12;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cinema[] cinemas = new Cinema[4];
        for (int i = 0; i < cinemas.length; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            sc.nextLine();
            int d = sc.nextInt();
            sc.nextLine();

            cinemas[i] = new Cinema(a, b, c, d);

        }
        String dir = sc.nextLine();
        int rat = sc.nextInt();
        sc.nextLine();
        int bud = sc.nextInt();
        sc.nextLine();

        int ans1 = findAvgBudgetByDirector(cinemas, dir);
        if (ans1 > 0)
            System.out.println(ans1);
        else
            System.out.println("Sorry - The given director has not yet directed any movie");

        Cinema ans2 = getMovieByRatingBudget(cinemas, rat, bud);
        if (ans2 != null)
            System.out.println(ans2.getMovieID());
        else
            System.out.println("Sorry - No movie is available with the specified rating and budget requirement");

    }

    public static int findAvgBudgetByDirector(Cinema[] cinemas, String dir) {
        int res = 0;
        int count = 0;
        for (int i = 0; i < cinemas.length; i++) {
            if (cinemas[i].getDirector().equalsIgnoreCase(dir)) {
                count++;
                res += cinemas[i].getBudget();
            }
        }

        return res / count;
    }

    public static Cinema getMovieByRatingBudget(Cinema[] cinemas, int rat, int bud) {
        for (int i = 0; i < cinemas.length; i++) {
            if (cinemas[i].getBudget() == bud && cinemas[i].getRating() == rat) {
                if (bud % rat == 0)
                    return cinemas[i];
            }
        }
        return null;
    }
}

class Cinema {
    public int movieId;
    public String director;
    public int rating;
    public int budget;

    public Cinema(int movieId, String director, int rating, int budget) {
        this.movieId = movieId;
        this.director = director;
        this.rating = rating;
        this.budget = budget;
    }

    public String getDirector() {
        return director;
    }

    public int getBudget() {
        return budget;
    }

    public int getRating() {
        return rating;
    }

    public int getMovieID() {
        return movieId;
    }
}