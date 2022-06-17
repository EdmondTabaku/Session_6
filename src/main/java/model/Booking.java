package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "booking_date")
    private Date bookingDate;

    @Column(name = "status")
    private String status;


    public Integer getId() {
        return id;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
