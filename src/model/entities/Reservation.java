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

    public long duration() {
        long diff = checkOut.getTime() - checkIn.getTime(); // diferença entre as duas datas pegando milisegundos (getTime retorna milisegundos)
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // Transformando o milisegundos em dias.
    }

    public String updateDates(Date checkIn, Date checkOut) {
        Date now = new Date();
        // Se a data do checkin for antetior ou checkout for anterior, faça:
        if (checkIn.before(now) || checkOut.before(now)) {
            return "Error in reservatiorn: Reservation dates for update must be future dates. ";
        }
        if (!checkOut.after(checkIn)) {
            return "Error in reservation: Check-out date must be after check-in date!";
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut; //Metodos para atualizar o checkIn e o checkOut.

        return null;
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
