package com.lenscart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lenscart.entity.Frames;

/***************************
 * Frame Repository Class
 *
 * Created By: Laxman Adkune
 * Date: 09/08/2022
 ***************************/

@Repository
public interface FrameRepository extends JpaRepository<Frames, Integer>{

}
