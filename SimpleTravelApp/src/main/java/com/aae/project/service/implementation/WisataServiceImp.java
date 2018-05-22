package com.aae.project.service.implementation;

import com.aae.project.model.Wisata;
import com.aae.project.repository.WisataRepository;
import com.aae.project.service.WisataServiceInterface;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author fauzan
 */
@Service
public class WisataServiceImp implements WisataServiceInterface{
    private final WisataRepository repo;

    @Autowired 
    public WisataServiceImp(WisataRepository wisataRepository){
    	this.repo=wisataRepository;
    }

    @Override
    public Page<Wisata> findAllWisataPageable(Pageable pageable){
    	return repo.findAll(pageable);
    }

    @Override
    public Optional<Wisata> findById(Integer id){
    	return repo.findById(id);
    }
}
