package com.practice.companysecurity.controllers;

import com.practice.companysecurity.models.Leave;
import com.practice.companysecurity.repositories.LeaveJpaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leave")
public class LeaveController {
    @Autowired
    private LeaveJpaRepository leaveJpaRepository;

    @GetMapping
    public List<Leave> getLeaveList(){
        return leaveJpaRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Leave getLeave(@PathVariable Integer id){
        return leaveJpaRepository.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createLeave(@RequestBody final Leave leave){
        leaveJpaRepository.saveAndFlush(leave);
    }

    @DeleteMapping
    @RequestMapping("/delete/{id}")
    public void deleteLeave(@PathVariable Integer id){
        leaveJpaRepository.deleteById(id);
    }

    @PutMapping
    public Leave updateLeave(@PathVariable Integer id, @RequestBody Leave leave){
        Leave currentLeave = leaveJpaRepository.getById(id);
        BeanUtils.copyProperties(leave, currentLeave, "leave_id");
        return leaveJpaRepository.saveAndFlush(leave);
    }
}
