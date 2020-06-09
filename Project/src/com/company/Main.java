package com.company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Connection conn = DBConnection.getConnection();
        Scanner input = new Scanner(System.in);
        try
        {
            int userChoice;
            userChoice = menu();

            if (userChoice == 1) {
                System.out.println("List of Precious stones below");
                String query = "Select * From preciousstone";
                Statement st = conn.createStatement();
                ResultSet rst = st.executeQuery(query);


                System.out.println("Choose from these choices");
                try {
                    while (rst.next()) {
                        System.out.println(rst.getInt("id") + " - " + rst.getString("name")
                                + " / with Price per Karat $" + rst.getInt("price"));
                    }
                    int IDnum = input.nextInt();


                    ResultSet oneRs = st.executeQuery("select * from preciousstone Where id = " + IDnum + " ");
                    oneRs.next();
                    int price = oneRs.getInt("price");


                    System.out.println("Let`s consider weight of one stone");
                    System.out.println("Enter diameter in cm");
                    int diameter = input.nextInt();
                    System.out.println("Enter height in cm");
                    int height = input.nextInt();
                    System.out.println("Enter density g/cm^3");
                    int density = input.nextInt();


                    Stone stone = new PreciousStone(price, diameter, height, density);


                    System.out.println("How many stones do you prefer in your necklace?");
                    int N = input.nextInt();
                    stone.Necklace();
                    System.out.println("Total Cost $" + (N * stone.priceInfo()));
                    System.out.println("Total Weight " + (N * stone.weightInfo()) + " karats");
                } catch (Exception e){
                    System.out.println("Seems like you entered incorrect value");
                    System.out.println(e);
                }
            }

            else if (userChoice == 2) {
                System.out.println("List of Semi Precious stones below");
                String query1 = "Select * From semipreciousstone";
                Statement s = conn.createStatement();
                ResultSet rs = s.executeQuery(query1);

                System.out.println("Choose from these choices");
                try {
                    while (rs.next()) {
                        System.out.println(rs.getInt("id") + " - " + rs.getString("name")
                                + " / with Price per Karat $" + rs.getInt("price"));
                    }
                    int IDnum = input.nextInt();


                    ResultSet oneRs = s.executeQuery("select * from semipreciousstone Where id = " + IDnum + " ");
                    oneRs.next();
                    int price = oneRs.getInt("price");


                    System.out.println("Let`s consider weight of one stone");
                    System.out.println("Enter diameter in cm");
                    int diameter = input.nextInt();
                    System.out.println("Enter height in cm");
                    int height = input.nextInt();
                    System.out.println("Enter density g/cm^3");
                    int density = input.nextInt();


                    Stone stone = new PreciousStone(price, diameter, height, density);

                    System.out.println("How many stones do you prefer in your necklace?");
                    int N = input.nextInt();
                    stone.Necklace();
                    System.out.println("Total Cost $" + (N * stone.priceInfo()));
                    System.out.println("Total Weight " + (N * stone.weightInfo()) + " karats");
                }catch (Exception e){
                    System.out.println("Seems like you entered incorrect value");
                    System.out.println(e);
                }
            }
            else if (userChoice == 3) {
                System.out.println("See you soon!");
                System.exit(0);
            }
            else {
                    System.out.println("Seems like you entered incorrect value");
            }


        }catch(Exception e)
        {
            e.printStackTrace();
        }finally
        {
            try{
                conn.close();
            }catch(SQLException ex)
            {
                ex.printStackTrace();
            }
        }
    }


    public static int menu(){
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println("Hello, I am an personal assistant in making necklace. ");
        System.out.println("Which type of stone do you prefer for necklace?");
        System.out.println("Choose from these choices");
        System.out.println("-------------------------\n");
        System.out.println("1 - Precious");
        System.out.println("2 - Semi Precious");
        System.out.println("3 - Exit");

        selection = input.nextInt();
        return selection;
    }
}
