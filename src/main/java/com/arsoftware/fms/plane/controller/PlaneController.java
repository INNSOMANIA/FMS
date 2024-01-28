package com.arsoftware.fms.plane.controller;

import com.arsoftware.fms.plane.dto.PlaneDTO;
import com.arsoftware.fms.plane.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/plane")
public class PlaneController {

    @Autowired
    PlaneService planeService;

    @GetMapping(value = "/{planeId}")
    public PlaneDTO getPlane(@PathVariable("planeId") long planeId) throws Exception {
        return planeService.getPlane(planeId);
    }

    @GetMapping(value = "")
    public List<PlaneDTO> getPlaneList() {
        return planeService.getPlaneList();
    }
}
