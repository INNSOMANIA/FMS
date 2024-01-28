package com.arsoftware.fms.plane.unit;

import com.arsoftware.fms.plane.dto.PlaneDTO;
import com.arsoftware.fms.plane.persistens.entity.Plane;

import java.util.ArrayList;
import java.util.List;

public class PlaneHelper {
    protected static Plane getSamplePlane() {
        Plane plane = new Plane();
        plane.setId(1000L);
        plane.setMake("MAKE");
        plane.setModel("MODEL");
        plane.setCompanyId(1L);
        plane.setCaptainPilot("CAPTAIN_PILOT");
        plane.setCoPilot("CO_PILOT");

        return plane;
    }

    protected static List<Plane> getSamplePLaneList() {
        List<Plane> planeList = new ArrayList<>();
        planeList.add(getSamplePlane());
        planeList.add(getSamplePlane());

        return planeList;
    }

    protected static PlaneDTO getSamplePlaneDTO() {
        return new PlaneDTO(1000L,
                "MAKE",
                "MODEL",
                1L,
                "CAPTAIN_PILOT",
                "CO_PILOT");
    }

    protected static List<PlaneDTO> getSamplePlaneDTOList() {
        List<PlaneDTO> planeDTOList = new ArrayList<>();
        planeDTOList.add(new PlaneDTO(1000L,
                "MAKE",
                "MODEL",
                1L,
                "CAPTAIN_PILOT",
                "CO_PILOT"));

        return planeDTOList;
    }
}
