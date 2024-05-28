package IPA13;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Antenna[] antennas = new Antenna[4];
        for (int i = 0; i < antennas.length; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            double d = sc.nextDouble();
            sc.nextLine();

            antennas[i] = new Antenna(a, b, c, d);
        }

        String aName = sc.nextLine();
        double val = sc.nextDouble();
        sc.nextLine();

        int ans1 = searchAntennaByName(antennas, aName);
        if (ans1 != 0)
            System.out.println(ans1);
        else
            System.out.println("There is no antenna with the given parameter");

        Antenna[] ans2 = sortAntennaByVSWR(antennas, val);
        if (ans2 != null) {
            for (int i = 0; i < ans2.length; i++) {
                System.out.println(ans2[i].getProjectLead());
            }
        } else
            System.out.println("No Antenna found");
    }

    public static int searchAntennaByName(Antenna[] antennas, String aName) {
        for (int i = 0; i < antennas.length; i++) {

            if (antennas[i].getAntenaName().equalsIgnoreCase(aName)) {
                return antennas[i].getAntenaId();
            }
        }
        return 0;
    }

    public static Antenna[] sortAntennaByVSWR(Antenna[] antennas, double val) {
        Antenna[] obj = new Antenna[0];
        double[] arr = new double[0];
        for (int i = 0; i < antennas.length; i++) {
            if (antennas[i].getAntennaVSWR() < val) {
                arr = Arrays.copyOf(arr, arr.length + 1);
                arr[arr.length - 1] = antennas[i].getAntennaVSWR();
            }
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < antennas.length; j++) {
                if (arr[i] == antennas[j].getAntennaVSWR()) {
                    obj = Arrays.copyOf(obj, obj.length + 1);
                    obj[obj.length - 1] = antennas[j];
                }
            }
        }

        if (obj.length > 0)
            return obj;
        else
            return null;
    }
}

class Antenna {
    public int antennaid;
    public String antennaName;
    public String projectLead;
    public double antennaVSWR;

    public Antenna(int antennaid, String antennaName, String projectLead, double antennaVSWR) {
        this.antennaid = antennaid;
        this.antennaName = antennaName;
        this.projectLead = projectLead;
        this.antennaVSWR = antennaVSWR;
    }

    public int getAntenaId() {
        return antennaid;
    }

    public String getAntenaName() {
        return antennaName;
    }

    public double getAntennaVSWR() {
        return antennaVSWR;
    }

    public String getProjectLead() {
        return projectLead;
    }
}