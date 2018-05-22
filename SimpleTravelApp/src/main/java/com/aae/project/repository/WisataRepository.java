package com.aae.project.repository;


import com.aae.project.model.Wisata;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author fauzan
 */
@Repository
public interface WisataRepository extends JpaRepository<Wisata, Integer>{
    Optional<Wisata> findById(Integer id);
}
