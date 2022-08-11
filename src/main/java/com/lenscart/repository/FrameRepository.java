package com.lenscart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lenscart.entity.Frames;

@Repository
public interface FrameRepository extends JpaRepository<Frames, Integer>{

}
