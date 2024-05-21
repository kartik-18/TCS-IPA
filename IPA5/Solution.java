package IPA5;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AutonomousCar[] car = new AutonomousCar[4];
        for (int i = 0; i < 4; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            sc.nextLine();
            int d = sc.nextInt();
            sc.nextLine();
            String e = sc.nextLine();

            car[i] = new AutonomousCar(a, b, c, d, e);
        }
        String env = sc.nextLine();
        String brd = sc.nextLine();

        int ans1 = findTestPassedByEnv(car, env);
        if (ans1 == 0) {
            System.out.println("There are no tests passed in this particular environment");
        } else {
            System.out.println(ans1);
        }

        AutonomousCar ans2 = updateCarGrade(car, brd);
        if (ans2 != null) {
            int rating = (ans2.getNoOfTestsPassed() * 100) / ans2.getNoOfTestsConducted();
            if (rating >= 80) {
                System.out.println(ans2.getBrand() + "::" + "A1");
            } else {
                System.out.println(ans2.getBrand() + "::" + "B2");
            }
        } else {
            System.out.println("No Car is available with the specified brand");
        }
    }

    public static int findTestPassedByEnv(AutonomousCar[] car, String env) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (car[i].getEnviroment().equalsIgnoreCase(env)) {
                count += car[i].getNoOfTestsPassed();
            }
        }
        return count;
    }

    public static AutonomousCar updateCarGrade(AutonomousCar[] car, String brd) {
        for (int i = 0; i < 4; i++) {
            if (car[i].getBrand().equalsIgnoreCase(brd)) {
                // rating = (car[i].getNoOfTestsPassed() * 100)/car[i].getNoOfTestsConducted();
                // if (rating >= 80) return new String{car[i].getBrand(),"a"};
                return car[i];
            }
        }
        return null;

    }
}

class AutonomousCar {
    public int carld;
    public int noOfTestsConducted;
    public int noOfTestsPassed;

    public String brand, enviroment;

    public AutonomousCar(int carld, String brand, int noOfTestsConducted, int noOfTestsPassed, String enviroment) {
        this.carld = carld;
        this.brand = brand;
        this.noOfTestsConducted = noOfTestsConducted;
        this.noOfTestsPassed = noOfTestsPassed;
        this.enviroment = enviroment;
    }

    public int getCarld() {
        return carld;
    }

    public int getNoOfTestsConducted() {
        return noOfTestsConducted;
    }

    public int getNoOfTestsPassed() {
        return noOfTestsPassed;
    }

    public String getBrand() {
        return brand;
    }

    public String getEnviroment() {
        return enviroment;
    }
}