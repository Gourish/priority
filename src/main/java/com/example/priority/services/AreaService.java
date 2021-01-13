package com.example.priority.services;

import com.example.priority.model.Area;
import com.example.priority.repositories.AreaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Component
public class AreaService
{
    @Autowired
    private final AreaRepository areaRepository;

    /**
     * It finds the areaId using the given areaName
     * @param areaName
     * @return
     */
    public Integer findAreaIdByAreaName(String areaName)
    {
        Integer areaId = null;
        Area area = areaRepository.findByAreaName(areaName);
        if(area!=null) {
            areaId = area.getAreaId();
        }
        return areaId;
    }

    /**
     * It returns all the areas in the area table.
     * @return
     */
    public List<Area> findAllAreas()
    {
        return areaRepository.findAll();
    }

    /**
     * It checks if all the given areas are present in area table.
     * @param areaNames
     * @return
     */
    public boolean areValidAreas(List<String> areaNames){
        List<Area> areaInDb = areaRepository.findAll();
        List<String> AreaNamesInDb= areaInDb.stream().map(area -> area.getAreaName()).collect(Collectors.toList());
        if(AreaNamesInDb.size()!=areaNames.size())
            return false;
        for(String areaName:areaNames)
        {
            if(!AreaNamesInDb.contains(areaName))
            {
                return false;
            }
        }
        return true;
    }
}
