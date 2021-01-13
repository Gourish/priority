package com.example.priority.controller;

import com.example.priority.api.PriorityArea;
import com.example.priority.model.Area;
import com.example.priority.services.AreaService;
import com.example.priority.services.UserPriorityService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/priority")
@AllArgsConstructor
public class PriorityController {
    @Autowired
     private final AreaService areaService;
    @Autowired
     private final UserPriorityService userPriorityService;

    /**
     *  It returns all the areas in area table
     * @return
     */
    @GetMapping("/allAreas")
    public List<Area> getAllAreas( ) {
        return areaService.findAllAreas();
    }

    /**
     * It adds the userPriorities to the userPriority table.
     * @param userId
     * @param data
     */
    @PostMapping("/user/{userId}")
    public void addPriorities(@PathVariable(name = "userId") Integer userId,
                               @RequestBody List<PriorityArea> data) {
         userPriorityService.addUserPriorities(userId,data);
    }
}
