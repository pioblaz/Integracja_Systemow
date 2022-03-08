package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        FileReader fr = null;
        String linia = "";
        List<String> list = new ArrayList<>();
        list.add(0,"nazwa producenta");
        list.add(1,"przekątna ekranu");
        list.add(2,"rozdzielczość ekranu");
        list.add(3,"rodzaj powierzchni ekranu");
        list.add(4,"czy ekran jest dotykowy");
        list.add(5,"nazwa procesora");
        list.add(6,"liczba rdzeni fizycznych");
        list.add(7,"prędkość taktowania MHz");
        list.add(8,"wielkość pamięci RAM");
        list.add(9,"pojemność dysku");
        list.add(10,"rodzaj dysku");
        list.add(11,"nazwa układu graficznego");
        list.add(12,"pamięć układu graficznego");
        list.add(13,"nazwa systemu operacyjnego");
        list.add(14,"rodzaj napędu fizycznego w komputerze");

        try {
            fr = new FileReader("src/com/company/katalog.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Blad przy otwieraniu pliku!");
        }

        BufferedReader br = new BufferedReader(fr);
        try {
            while (null != (linia = br.readLine())) {
                System.out.println(linia);
            }
        } catch (IOException e) {
            System.out.println("Blad odczytu pliku!");
        }

        try {
            fr.close();
        } catch (IOException e) {
            System.out.println("Blad przy zamykaniu pliku!");
        }
    }
}
