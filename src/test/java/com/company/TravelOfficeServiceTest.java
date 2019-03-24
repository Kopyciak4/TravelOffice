package com.company;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class TravelOfficeServiceTest {

    private TravelOfficeService travelOfficeService;
    private DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void initService() {
        TravelOffice office = new TravelOffice();
        travelOfficeService = Mockito.spy(new TravelOfficeService(office));

    }

    @BeforeClass
    public static void initLog() {
        MainHandler.log = Logger.getLogger(TravelOfficeServiceTest.class.getPackage().getName());
    }

    @Test
    public void customersAddition() {
        assertNotNull(travelOfficeService.addCustomer("name1", "steet1", "zip", "city"));
    }
    @Test
    public void checkIfAdditionWorksWithMoreThanOneCustomer() {
        travelOfficeService.addCustomer("bob", "sead", "123-123", "bytom");
        Customer customer = new Customer("test");
        Address address = new Address("test", "321-321", "btm");
        customer.setAddress(address);
        assertEquals(customer,travelOfficeService.addCustomer("test", "test", "321-321", "btm"));
    }

    @Test
    public void checkIfTripTypeIsCorrect() {
        LocalDate begDate = LocalDate.parse("2018-01-02", format);
        LocalDate endDate = LocalDate.parse("2013-01-02", format);

        assertTrue("typ abroad", travelOfficeService.addAbroadTrip(begDate, endDate, "bangladesz",300, 5000) instanceof AbroadTrip);

        assertTrue(travelOfficeService.addDomesticTrip(begDate, endDate, "bangladesz", 3000, 50000) instanceof DomesticTrip);

    }

    @Test
    public void checkIfPriceOfTripIsProperlyCalculated() {
        LocalDate begDate = LocalDate.parse("2018-01-02", format);
        LocalDate endDate = LocalDate.parse("2013-01-02", format);
        Trip trip = travelOfficeService.addDomesticTrip(begDate, endDate, "bangladesz",300, 5000);
        assertEquals(4700, trip.getPrice());
        Trip trip2 = travelOfficeService.addAbroadTrip(begDate, endDate, "bangladesz",300, 5000);
        assertEquals(5300, trip2.getPrice());
    }

    @Test
    public void checkIfCustomerIsSaved() {
        Customer customer = travelOfficeService.addCustomer("bob", "abc", "131-213", "qwe");
        assertSame(customer,  travelOfficeService.getCustomerToAssign(customer.getName()));

    }

    @Test
    public void checkIfTripIsAddedCorectly() {
        LocalDate begDate = LocalDate.parse("2018-01-02", format);
        LocalDate endDate = LocalDate.parse("2013-01-02", format);
        Trip trip = travelOfficeService.addDomesticTrip(begDate, endDate, "bangladesz",300, 5000);
        assertSame(trip, travelOfficeService.getTripToAssign(trip.getDestination()) );
    }


    @Test
    public void receivingCustomerWhenDoesntExist() {
        assertNull(travelOfficeService.getCustomerToAssign("bob") );
    }

    @Test
    public void receivingTripWhenDoesntExist() {
        assertNull(travelOfficeService.getTripToAssign("kongo") );
    }

    @Test
    public void checkIfTripWasSuccessfullyRemoved() {
        LocalDate begDate = LocalDate.parse("2018-01-02", format);
        LocalDate endDate = LocalDate.parse("2013-01-02", format);
        Trip trip = travelOfficeService.addDomesticTrip(begDate, endDate, "bangladesz",300, 5000);
        assertTrue(travelOfficeService.removeTrip(trip.getDestination()));
        assertNull(travelOfficeService.getTripToAssign(trip.getDestination()));
    }

    @Test
    public void checkIfTripCanBeRemovedWhileNotExists() {
        assertFalse(travelOfficeService.removeTrip("kongo"));
    }

    @Test
    public void checkIfCustomerWasSuccessfullyRemoved() {
        Customer customer = travelOfficeService.addCustomer("bambo", "dqqwe", "213-12", "badh");
        assertTrue(travelOfficeService.removeCustomer(customer.getName()));
        assertNull(travelOfficeService.getCustomerToAssign(customer.getName()));
    }

    @Test
    public void checkIfCustomerCanBeRemovedWhileNotExists() {
        assertFalse(travelOfficeService.removeCustomer("bambo"));
    }

    @Test
    public void checkIfAssignedCorrectly() {
        LocalDate begDate = LocalDate.parse("2018-01-02", format);
        LocalDate endDate = LocalDate.parse("2013-01-02", format);
        Trip trip = travelOfficeService.addDomesticTrip(begDate, endDate, "bangladesz",300, 5000);
        Customer customer = travelOfficeService.addCustomer("bambo", "dqqwe", "213-12", "badh");
        travelOfficeService.assign(customer, trip);
        assertEquals(trip,customer.getTrip());
    }

    @Test
    public void reciveCustomerFromList() {
        System.setOut(new PrintStream(outContent));
        Customer customer = travelOfficeService.addCustomer("bambo", "dqqwe", "213-12", "badh");
        travelOfficeService.showCustomers();
        assertEquals(customer.toString() + "\r\n", outContent.toString());
        System.setOut(originalOut);
    }

    @Test
    public void reciveTripFromList() {
        LocalDate begDate = LocalDate.parse("2018-01-02", format);
        LocalDate endDate = LocalDate.parse("2013-01-02", format);
        Trip trip = travelOfficeService.addDomesticTrip(begDate, endDate, "bangladesz",300, 5000);
        System.setOut(new PrintStream(outContent));
        travelOfficeService.showTrips();
        assertEquals(trip.toString() + "\r\n", outContent.toString());
        System.setOut(originalOut);
    }









}

