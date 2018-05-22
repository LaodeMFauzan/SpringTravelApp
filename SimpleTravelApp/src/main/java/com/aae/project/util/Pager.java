package com.aae.project.util;

import com.aae.project.model.Wisata;
import org.springframework.data.domain.Page;

/**
 *
 * @author fauzan
 */
public class Pager {
    private final Page<Wisata> wisata;

    public Pager(Page<Wisata> wisata){
    	this.wisata=wisata;
    }

    public int getPageIndex(){
    	return wisata.getNumber()+1;
    }

    public int getPageSize(){
    	return wisata.getSize();
    }

     public boolean hasNext() {
        return wisata.hasNext();
    }

    public boolean hasPrevious() {
        return wisata.hasPrevious();
    }

    public int getTotalPages() {
        return wisata.getTotalPages();
    }

    public long getTotalElements() {
        return wisata.getTotalElements();
    }

    public boolean indexOutOfBounds() {
        return this.getPageIndex() < 0 || this.getPageIndex() > this.getTotalElements();
    }

}
