package com.practice.conferencethymeleaf.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "time_slots")
public class TimeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long time_slot_id;

    @Column(name = "time_slot_date")
    private LocalDate timeSlotDate;
    private LocalTime start_time;
    private LocalTime end_time;
    private int is_keynote_time_slot;

    public TimeSlot(){}

    public long getTime_slot_id() {
        return time_slot_id;
    }

    public void setTime_slot_id(long time_slot_id) {
        this.time_slot_id = time_slot_id;
    }

    public LocalDate getTimeSlotDate() {
        return timeSlotDate;
    }

    public void setTimeSlotDate(LocalDate timeSlotDate) {
        this.timeSlotDate = timeSlotDate;
    }

    public LocalTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalTime start_time) {
        this.start_time = start_time;
    }

    public LocalTime getEnd_time() {
        return end_time;
    }

    public void setEnd_time(LocalTime end_time) {
        this.end_time = end_time;
    }

    public int getIs_keynote_time_slot() {
        return is_keynote_time_slot;
    }

    public void setIs_keynote_time_slot(int is_keynote_time_slot) {
        this.is_keynote_time_slot = is_keynote_time_slot;
    }
}
