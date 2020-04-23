/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg137exemplo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;
import model.exceptions.DomainException;

/**
 *
 * @author Rodolfo Montes
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        try{
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            System.out.print("Room Number: ");
            int number = sc.nextInt();
            System.out.print("Check-In date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Check-Out date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());


            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservarion: ");
            System.out.print("Check-In date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-Out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: "+ reservation);

        }catch(ParseException e){
            System.out.println("Invalid date format.");
        }catch(DomainException e){
            System.out.println("Error in reservation: " +e.getMessage());
        }catch(RuntimeException e){ // Qualquer exception que aparecer, ele não irá quebrar e será tratada neste catch
            System.out.println("Unexpected error!");
        }
        
        sc.close();
    }
    
}
