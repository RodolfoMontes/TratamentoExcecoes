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

/**
 *
 * @author Rodolfo Montes
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        
        Scanner sc = new Scanner (System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Room Number: ");
        int number = sc.nextInt();
        System.out.print("Check-In date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-Out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());
        // Date tem um metodo que teste se a data é depois da outra, que seria "AFTER"
        if (!checkOut.after(checkIn)) {  // Neste if estou dizendo " Não é depois de checkIn" 
            System.out.println("Error in reservation: Check-out date must be "
                                + "after check-in date!");
        }else{
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: "+ reservation);
            
            System.out.println();
            System.out.println("Enter data to update the reservarion: ");
            System.out.print("Check-In date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-Out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());
            
            Date now = new Date();
            
            
            // Se a data do checkin for antetior ou checkout for anterior, faça:
            if (checkIn.before(now) || checkOut.before(now)) {
                System.out.println("Error in reservatiorn: Reservation dates for update must be future dates. ");
            }else if(!checkOut.after(checkIn)){
                System.out.println("Error in reservation: Check-out date must be "
                                + "after check-in date!");
            } else{
                reservation.updateDates(checkIn, checkOut);
                System.out.println("Reservation: "+ reservation);
            }
            

        }
        
        
        
        
        sc.close();
    }
    
}
