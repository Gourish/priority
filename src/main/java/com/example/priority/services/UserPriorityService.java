package com.example.priority.services;

import com.example.priority.api.PriorityArea;
import com.example.priority.model.UserPriority;
import com.example.priority.repositories.UserPriorityRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserPriorityService {
@Autowired
    private AreaService areaService;
@Autowired
    private UserService userService;
@Autowired
    private UserPriorityRepository userPriorityRepository;

    /**
     * It adds the userpriorites to the userpriority table in priority database
     * It validates if the areas exists in area table  also it validates if user with given userId exists in user table
     * @param userId
     * @param userPrioritydata
     *
     */
    public void addUserPriorities(Integer userId,List<PriorityArea> userPrioritydata)
    {
            AtomicInteger priorityId  = new AtomicInteger(1);
            List<String> areaNames = userPrioritydata.stream().map(PriorityArea ->PriorityArea.getAreaName()).collect(Collectors.toList());
            if(areaService.areValidAreas(areaNames) && userService.doesUserExists(userId))
            {
                List<UserPriority> userPriorities = userPrioritydata.stream().map(priorityArea ->
                    getUserPriorityForPriorityArea(userId,priorityId,priorityArea)
                ).collect(Collectors.toList());
                userPriorityRepository.saveAll(userPriorities);
            }
            else
            {
                throw new RuntimeException("Invalid areas or UserName");
            }
    }

    /**
     *  It converts priorityArea to userPriority.
     *  It also validates if the rating for the particular area lies between values 1 and 5 both inclusive.
     * @param userId
     * @param priorityId
     * @param priorityArea
     * @return
     */
    private UserPriority getUserPriorityForPriorityArea(Integer userId, AtomicInteger priorityId,PriorityArea priorityArea){
        UserPriority userPriority = new UserPriority();
        userPriority.setUserId(userId);
        Integer areaId = areaService.findAreaIdByAreaName(priorityArea.getAreaName());
        userPriority.setAreaId(areaId);
        userPriority.setPriority(priorityId.getAndIncrement());
        Integer rating = priorityArea.getRating();
        if(rating<1 || rating >5)
            throw new RuntimeException("Invalid Rating");
        else
            userPriority.setRating(rating);
        userPriority.setRating(priorityArea.getRating());
        return userPriority ;
    }
}
