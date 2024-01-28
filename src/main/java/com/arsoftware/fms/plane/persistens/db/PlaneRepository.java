package com.arsoftware.fms.plane.persistens.db;

import com.arsoftware.fms.plane.persistens.entity.Plane;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlaneRepository<T extends Plane> extends JpaRepository<Plane, Long> {

    Optional<Plane> findById(long planeId);

    List<Plane> findAll();
}
