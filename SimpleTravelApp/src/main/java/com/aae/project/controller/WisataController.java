package com.aae.project.controller;

import com.aae.project.exception.ResourceNotFoundException;
import com.aae.project.model.Wisata;
import com.aae.project.repository.WisataRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fauzan
 */
@RestController
@RequestMapping
public class WisataController {
    
    @Autowired
    WisataRepository wisataRepository;
    
    @GetMapping("/wisata")
    public List<Wisata> getAllWisata(){
        return wisataRepository.findAll();
    }
    
    @PostMapping("/wisata")
    public Wisata createWisata(@Valid @RequestBody Wisata wisata){
        return wisataRepository.save(wisata);
    }

    @GetMapping("/wisata/{kode}")
    public Wisata getWisataById(@PathVariable(value = "kode") Integer kode){
    	return wisataRepository.findById(kode)
    				.orElseThrow(()->new ResourceNotFoundException("Wisata","kode",kode));
    }

    @PutMapping("/wisata/{kode}")
    public Wisata updateWisata(@PathVariable(value = "kode") Integer kode,
    								@Valid @RequestBody Wisata wisata){
    	Wisata wst=wisataRepository.findById(kode).
                orElseThrow(()->new ResourceNotFoundException("Wisata","kode",kode));;
    	wst.setNamaWisata(wisata.getNamaWisata());
    	wst.setAlamat(wisata.getAlamat());
    	wst.setDeskripsi(wisata.getDeskripsi());
    	wst.setHargaTiket(wisata.getHargaTiket());

    	Wisata updatedWisata=wisataRepository.save(wst);
    	return updatedWisata;
    }

    @DeleteMapping("/wisata/{kode}")
    public ResponseEntity<?> deleteWisata(@PathVariable(value="kode") Integer kode){
    	Wisata wisata=wisataRepository.findById(kode)
                        .orElseThrow(()->new ResourceNotFoundException("Wisata","kode",kode));
    	wisataRepository.delete(wisata);

    	return ResponseEntity.ok().build();
    }
}
