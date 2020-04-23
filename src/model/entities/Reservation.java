/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Rodolfo Montes
 */
public class Reservation {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    
    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }


    public Date getCheckOut() {
        return checkOut;
    }

    public long duration(){
        long diff = checkOut.getTime() - checkIn.getTime(); // diferença entre as duas datas pegando milisegundos (getTime retorna milisegundos)
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // Transformando o milisegundos em dias.
    }
    
    public void updateDates(Date checkIn , Date checkOut){
        this.checkIn = checkIn;
        this.checkOut = checkOut; //Metodos para atualizar o checkIn e o checkOut.
    }

    @Override
    public String toString() {
        return "Room"
                + roomNumber
                + ", Check-in: "
                + sdf.format(checkIn)
                + ", Check-out: "
                + sdf.format(checkOut)
                + ", "
                + duration()
                + " nights";
    }
    
    
    
}
