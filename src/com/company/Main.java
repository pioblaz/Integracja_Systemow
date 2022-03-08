package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int liczba_Dell = 0, liczba_Asus = 0, liczba_Fujitsu = 0, liczba_Huawei = 0, liczba_MSI = 0, liczba_Samsung = 0, liczba_Sony = 0;
        FileReader fr = null;
        String linia = "";
        List<String> list = new ArrayList<>();
        list.add(0, "Lp.");
        list.add(1, "nazwa producenta");
        list.add(2, "przekątna ekranu");
        list.add(3, "rozdzielczość ekranu");
        list.add(4, "rodzaj powierzchni ekranu");
        list.add(5, "czy ekran jest dotykowy");
        list.add(6, "nazwa procesora");
        list.add(7, "liczba rdzeni fizycznych");
        list.add(8, "prędkość taktowania MHz");
        list.add(9, "wielkość pamięci RAM");
        list.add(10, "pojemność dysku");
        list.add(11, "rodzaj dysku");
        list.add(12, "nazwa układu graficznego");
        list.add(13, "pamięć układu graficznego");
        list.add(14, "nazwa systemu operacyjnego");
        list.add(15, "rodzaj napędu fizycznego w komputerze");

        try {
            fr = new FileReader("src/com/company/katalog.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Blad przy otwieraniu pliku!");
        }

        BufferedReader br = new BufferedReader(fr);
        try {
            for (int i = 0; i < 635; i++) {
                System.out.print("-");
            }

            System.out.print("\n");

            for (int i = 0; i < list.size(); i++) {
                if (i == 0)
                    System.out.print(list.get(i) + "\t" + "|");
                else {
                    show(list.get(i));
                }
            }

            System.out.print("\n");

            for (int i = 0; i < 635; i++) {
                System.out.print("-");
            }

            System.out.print("\n");

            int j = 1;
            while (null != (linia = br.readLine())) {
                String[] words = linia.split(";", -1);

                System.out.print(j + "\t" + "|");
                int i = 0;
                for (String word : words) {
                    if (word.isEmpty() && i < words.length - 1)
                        show("Brak informacji");
                    else if (!word.isEmpty())
                        show(word);

                    if (i == 0) {
                        if (word.equals("Dell")) {
                            liczba_Dell++;
                        } else if (word.equals("Asus")) {
                            liczba_Asus++;
                        } else if (word.equals("Fujitsu")) {
                            liczba_Fujitsu++;
                        } else if (word.equals("Huawei")) {
                            liczba_Huawei++;
                        } else if (word.equals("MSI")) {
                            liczba_MSI++;
                        } else if (word.equals("Sony")) {
                            liczba_Sony++;
                        } else if (word.equals("Samsung")) {
                            liczba_Samsung++;
                        }
                    }

                    i++;
                    if (i > words.length - 1) {
                        System.out.print("\n");
                        i = 0;
                    }
                }
                j++;
            }
        } catch (IOException e) {
            System.out.println("Blad odczytu pliku!");
        }

        System.out.println("\nLiczba komputerow Dell: " + liczba_Dell);
        System.out.println("Liczba komputerow Asus: " + liczba_Asus);
        System.out.println("Liczba komputerow Fujitsu: " + liczba_Fujitsu);
        System.out.println("Liczba komputerow Huawei: " + liczba_Huawei);
        System.out.println("Liczba komputerow MSI: " + liczba_MSI);
        System.out.println("Liczba komputerow Sony: " + liczba_Sony);
        System.out.println("Liczba komputerow Samsung: " + liczba_Samsung);

        try {
            fr.close();
        } catch (IOException e) {
            System.out.println("Blad przy zamykaniu pliku!");
        }
    }

    public static void show(String word) {
        int size = word.length();
        System.out.print(" " + word);
        for (int i = 0; i < 40 - size; i++) {
            System.out.print(" ");
        }
        System.out.print("|");
    }
}
