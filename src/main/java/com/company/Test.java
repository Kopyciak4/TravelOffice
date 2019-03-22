package com.company;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        TravelOfficeService travelOfficeService = new TravelOfficeService();
       // TravelOffice travelOffice = new TravelOffice();
        MainHandler mainHandler = new MainHandler(travelOfficeService);

        int action;
        do {
            System.out.println(
            "Podaj numer akcji \n"
                    + "1. Dodaj klienta \n"
                    + "2. Dodaj wycieczke \n"
                    + "3. Przypisz wycieczke do klienta \n"
                    + "4. Usun klienta \n"
                    + "5. Usun wycieczke \n"
                    + "6. Pokaz klientow \n"
                    + "7. Pokaz wycieczki \n"
                    + "8. Wyjdz");
            Scanner sc = new Scanner(System.in);

            action = sc.nextInt();
            switch (action) {
                case 1:
                    mainHandler.addCustomer();
                    break;
                case 2:
                    mainHandler.addTrip();
                    break;
                case 3:
                    mainHandler.assign();
                    break;
                case 4:
                    mainHandler.removeCustomer();
                    break;
                case 5:
                    mainHandler.removeTrip();
                    break;
                case 6:
                    mainHandler.showCustomers();
                    break;
                case 7:
                    mainHandler.showTrips();
                    break;
                case 8:
                    break;
                default:
                    System.out.println("zly numer");
            }
        }while(action != 8);



    }
}
