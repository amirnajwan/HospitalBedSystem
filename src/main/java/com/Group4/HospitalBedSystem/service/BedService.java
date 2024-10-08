package com.Group4.HospitalBedSystem.service;

import com.Group4.HospitalBedSystem.dto.response.BedResponse;
import com.Group4.HospitalBedSystem.entity.BedEntity;
import com.Group4.HospitalBedSystem.entity.generator.BedIdgenerator;
import com.Group4.HospitalBedSystem.repository.BedRepository;
import com.Group4.HospitalBedSystem.service.general.SuccessAndDataResponse;
import com.zaxxer.hikari.util.SuspendResumeLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BedService {
    @Autowired
    private BedRepository repository;
    @Autowired
    private BedIdgenerator bedIdgenerator;

    //Post method
    public ResponseEntity<?> saveBed(BedEntity bed){
        SuccessAndDataResponse result = new SuccessAndDataResponse();
        try {
            if (bed != null) {
                String newBedId = bedIdgenerator.generateNewBedId();
                bed.setBedTypeId(newBedId);
                if (repository.save(bed) != null) {
                    result.setSuccess(true);
                    result.setMessage("Added new bed.");
                    result.setData(bed);
                } else {
                    result.setMessage("Failed to add bed");
                }
                System.out.println("test from BedService Class.");
                result.setData(bed);
                return ResponseEntity.ok(result);
            } else {
                return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e){
            result.setMessage(e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Get methods
    public ResponseEntity<?> getBeds(){
        SuccessAndDataResponse result = new SuccessAndDataResponse();
        List<BedEntity> beds = repository.findAll();
        try {
            if (beds != null){
                result.setSuccess(true);
                result.setMessage("Bed found.");
                List<BedResponse> bedList = new ArrayList<>();
                for (BedEntity bed : beds){
                    bedList.add(mapBedEntityToBedDetail(bed));
                }
                result.setData(bedList);
            } else {
                result.setMessage("Bed not found.");
            }
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> getBedByBedTypeId(String bedTypeId){
        SuccessAndDataResponse result = new SuccessAndDataResponse();
        try {
            BedEntity bed = repository.findBedByBedTypeId(bedTypeId);
            if (bed != null){
                result.setSuccess(true);
                result.setMessage("Bed found.");
                result.setData(this.mapBedEntityToBedDetail(bed));
            } else {
                result.setMessage("Bed not found.");
            }
            return ResponseEntity.ok(result);
        } catch (Exception e){
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> getBedByBedStatus(String bedStatus){
        SuccessAndDataResponse result = new SuccessAndDataResponse();
        List<BedEntity> beds = repository.findAll();
        try {
            if (beds != null){
                result.setSuccess(true);
                result.setMessage("Bed found.");
                List<BedResponse> bedList = new ArrayList<>();
                for (int i = 0; i < beds.size(); i++){
                    if (beds.get(i).getBedStatus().equals(bedStatus)){
                        bedList.add(mapBedEntityToBedDetail(beds.get(i)));
                    }
                }
                result.setData(bedList);
            } else {
                result.setMessage("Bed not found.");
            }
            return ResponseEntity.ok(result);
        } catch (Exception e){
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> getBedById(int id){
        SuccessAndDataResponse result = new SuccessAndDataResponse();
        try {
            BedEntity bed = repository.findById(id).orElse(null);
            if (bed != null) {
                result.setSuccess(true);
                result.setMessage("Bed found.");
                result.setData(this.mapBedEntityToBedDetail(bed));
            } else {
                result.setMessage("Bed not found.");
            }
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> getBedByName(String name){
        SuccessAndDataResponse result = new SuccessAndDataResponse();
        try {
            BedEntity bed = repository.findBedByName(name);
            if (bed != null) {
                result.setSuccess(true);
                result.setMessage("Bed found.");
                result.setData(this.mapBedEntityToBedDetail(bed));
            } else {
                result.setMessage("Bed not found.");
            }
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Delete method
    public ResponseEntity<?> deleteBed(int id){
        SuccessAndDataResponse result = new SuccessAndDataResponse();
        try {
            repository.deleteById(id);
            result.setSuccess(true);
            result.setMessage("Deleted bed with id : " + id);
        } catch (Exception e) {
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(result);
    }

    //Update method
    public ResponseEntity<?> updateBed(BedEntity bed){
        SuccessAndDataResponse result = new SuccessAndDataResponse();
        try {
            BedEntity existBed = repository.findById(bed.getId()).orElse(null);
            if (existBed != null){
                existBed.setWardType(bed.getWardType());
                existBed.setBedTypeId(bed.getBedTypeId());
                existBed.setName(bed.getName());
                existBed.setBedStatus(bed.getBedStatus());
                existBed.setPricePerDay(bed.getPricePerDay());
                if (repository.save(existBed) != null){
                    result.setSuccess(true);
                    result.setMessage("Successfully update a bed.");
                    result.setData(existBed);
                } else {
                    result.setMessage("Failed to update a bed.");
                }
            } else {
                result.setMessage("Bed not found.");
            }
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public BedResponse mapBedEntityToBedDetail(BedEntity bedEntity){
        BedResponse data = new BedResponse();
        data.setId(bedEntity.getId());
        data.setWardType(bedEntity.getWardType());
        data.setBedTypeId(bedEntity.getBedTypeId());
        data.setName(bedEntity.getName());
        data.setBedStatus(bedEntity.getBedStatus());
        data.setPricePerDay(bedEntity.getPricePerDay());
        return data;
    }
}
