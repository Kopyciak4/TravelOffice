package com.company;


import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;

public class Test {

    private static Logger logger = Logger.getLogger(Test.class.getPackage().getName());


    public static void main(String[] args) {

        Logger.getLogger("").removeHandler(new ConsoleHandler());
        try {
            Handler handler = new FileHandler("log.txt");
            handler.setFormatter(new SimpleFormatter());
            logger.addHandler(handler);
        }catch (IOException e){
            logger.log(Level.WARNING, e.getMessage(), e);
        }


        TravelOffice travelOffice = new TravelOffice();
        TravelOfficeService travelOfficeService = new TravelOfficeService(travelOffice);
        MainHandler mainHandler = new MainHandler(travelOfficeService, logger);

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
