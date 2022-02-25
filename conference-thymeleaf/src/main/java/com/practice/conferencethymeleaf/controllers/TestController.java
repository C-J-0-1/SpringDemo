package com.practice.conferencethymeleaf.controllers;

import com.practice.conferencethymeleaf.models.*;
import com.practice.conferencethymeleaf.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/*@Controller
public class TestController {
    @GetMapping("/session")
    public String getSessions(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "Session";
    }
}*/

@Controller
public class TestController {

    @Autowired
    private SessionJpaRepository sessionJpaRepository;

    @Autowired
    private SpeakerJpaRepository speakerJpaRepository;

    @Autowired
    private TicketPriceJpaRepository ticketPriceJpaRepository;

    @Autowired
    private TicketTypeJpaRepository ticketTypeJpaRepository;

    @Autowired
    private TimeSlotJpaRepository timeSlotJpaRepository;

    @GetMapping("/sessionTest")
    public String getSessions(Model model) {
        List<Session> session = sessionJpaRepository.findAll();
        model.addAttribute("sessions", session);
        return "Session";
    }

    @GetMapping("/speakerTest")
    public String getSpeakers(Model model) {
        List<Speaker> speaker = speakerJpaRepository.findAll();
        model.addAttribute("speakers", speaker);
        return "Speaker";
    }

    @GetMapping("/ticketPriceTest")
    public String getTicketPrices(Model model) {
        List<TicketPrice> ticketPrice = ticketPriceJpaRepository.findAll();
        model.addAttribute("ticketPrices", ticketPrice);
        return "TicketPrice";
    }

    @GetMapping("/ticketTypeTest")
    public String getTicketTypes(Model model) {
        List<TicketType> ticketType = ticketTypeJpaRepository.findAll();
        model.addAttribute("ticketTypes", ticketType);
        return "TicketType";
    }

    @GetMapping("/timeSlotTest")
    public String getTimeSlots(Model model) {
        List<TimeSlot> timeSlot = timeSlotJpaRepository.findAll();
        model.addAttribute("timeSlots", timeSlot);
        return "TimeSlot";
    }
}
