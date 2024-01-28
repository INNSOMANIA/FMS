package com.arsoftware.fms.plane.service;

import com.arsoftware.fms.plane.dto.PlaneDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PlaneService {

    PlaneDTO getPlane(long planeId) throws Exception;

    List<PlaneDTO> getPlaneList();
}
