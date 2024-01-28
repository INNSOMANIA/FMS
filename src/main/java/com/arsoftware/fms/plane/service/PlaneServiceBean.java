package com.arsoftware.fms.plane.service;

import com.arsoftware.fms.plane.dto.PlaneDTO;
import com.arsoftware.fms.plane.persistens.db.PlaneRepository;
import com.arsoftware.fms.plane.persistens.entity.Plane;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlaneServiceBean implements PlaneService {

    PlaneRepository<Plane> planeRepository;

    @Override
    public PlaneDTO getPlane(long planeId) throws Exception {
        Optional<Plane> planeOptional = planeRepository.findById(planeId);
        if (planeOptional.isPresent()) {
            Plane plane = planeOptional.get();
            return new PlaneDTO(
                    plane.getId(),
                    plane.getMake(),
                    plane.getModel(),
                    plane.getCompanyId(),
                    plane.getCaptainPilot(),
                    plane.getCoPilot());
        } else {
            throw new Exception("Plane is not found in the system");
        }
    }

    @Override
    public List<PlaneDTO> getPlaneList() {
        List<Plane> planeList = planeRepository.findAll();
        return planeList.stream().map(plane -> new PlaneDTO(
                        plane.getId(),
                        plane.getMake(),
                        plane.getModel(),
                        plane.getCompanyId(),
                        plane.getCaptainPilot(),
                        plane.getCoPilot())).
                collect(Collectors.toList());
    }
}
