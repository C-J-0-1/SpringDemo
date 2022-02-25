package com.practice.conferencesecurity.controllers;

import com.practice.conferencesecurity.models.*;
import com.practice.conferencesecurity.repositories.*;
import com.practice.conferencesecurity.services.MyUserDetailService;
import com.practice.conferencesecurity.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailService myUserDetailService;

    @Autowired
    private JwtUtil jwtUtil;

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

    @RequestMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    //For JWT
//    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
//    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
//                            authenticationRequest.getPassword())
//            );
//        } catch (BadCredentialsException e){
//            System.out.println("Incorrect Username or Password" + e);
//        }
//        final UserDetails userDetails = myUserDetailService.loadUserByUsername(authenticationRequest.getUsername());
//        final String jwt = jwtUtil.generateToken(userDetails);
//        System.out.println(jwt);
//
//        return ResponseEntity.ok(new AuthenticationResponse(jwt));
////        return jwtUtil.generateToken(myUserDetailService.loadUserByUsername(myUserDetail.getUsername()));
//    }

    @RequestMapping("/User/index")
    public String getIndexPage(){
        return "index";
    }

    @GetMapping("/User/sessionTest")
    public String getSessions(Model model) {
        List<Session> session = sessionJpaRepository.findAll();
        model.addAttribute("sessions", session);
        return "Session";
    }

    @GetMapping("/User/speakerTest")
    public String getSpeakers(Model model) {
        List<Speaker> speaker = speakerJpaRepository.findAll();
        model.addAttribute("speakers", speaker);
        return "Speaker";
    }

    @GetMapping("/Admin/ticketPriceTest")
    public String getTicketPrices(Model model) {
        List<TicketPrice> ticketPrice = ticketPriceJpaRepository.findAll();
        model.addAttribute("ticketPrices", ticketPrice);
        return "TicketPrice";
    }

    @GetMapping("/Admin/ticketTypeTest")
    public String getTicketTypes(Model model) {
        List<TicketType> ticketType = ticketTypeJpaRepository.findAll();
        model.addAttribute("ticketTypes", ticketType);
        return "TicketType";
    }

    @GetMapping("/Admin/timeSlotTest")
    public String getTimeSlots(Model model) {
        List<TimeSlot> timeSlot = timeSlotJpaRepository.findAll();
        model.addAttribute("timeSlots", timeSlot);
        return "TimeSlot";
    }

    @PostMapping("/logout")
    public String logout(){
        return "logout";
    }
}
