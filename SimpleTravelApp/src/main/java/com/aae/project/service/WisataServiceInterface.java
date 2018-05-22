package com.aae.project.service;

import com.aae.project.model.Wisata;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author fauzan
 */
public interface WisataServiceInterface {
    Optional <Wisata> findById(Integer Id);
    
    Page<Wisata>findAllWisataPageable(Pageable pageable);
}
