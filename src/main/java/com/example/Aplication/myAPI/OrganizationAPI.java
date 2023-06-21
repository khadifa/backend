package com.example.Aplication.myAPI;

import com.example.Aplication.model.Organization;
import com.example.Aplication.model.Students;
import com.example.Aplication.repository.OrganizationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping

public class OrganizationAPI {
    @Autowired

    private OrganizationRepo organizationRepo;

    @GetMapping("allOrganization")
    public ResponseEntity<?> getorganization() {
        try {
            List<Organization> organizationList = organizationRepo.findAll();
            if (organizationList.isEmpty()) {
                return new ResponseEntity<>("not founded", HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(organizationList, HttpStatus.ACCEPTED);
            }
        } catch (Exception exception) {
            return new ResponseEntity<>("Error in netwok", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/byId{OrgId}")
    public ResponseEntity<?> getById(@PathVariable int OrgId) {
        try {
            Optional<Organization> optionalOrganization = organizationRepo.findById(OrgId);
            if (optionalOrganization.isPresent()) {
                return new ResponseEntity<>(optionalOrganization, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("no data", HttpStatus.NOT_FOUND);
            }
        } catch (Exception exception) {
            return new ResponseEntity<>("server error", HttpStatus.ACCEPTED);
        }
    }

    @DeleteMapping("/byId{OrgId}")
    public ResponseEntity<?> delete(@PathVariable int OrgId) {
        try {
            organizationRepo.deleteById(OrgId);
            return new ResponseEntity<>("succesefully deleted", HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>("no data dalated", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addorganization(@RequestBody Organization organization) {
        try {
            Organization organization1 = organizationRepo.save(organization);
            return new ResponseEntity<>("inserted succesefully", HttpStatus.ACCEPTED);


        } catch (Exception exception) {
            return new ResponseEntity<>("Not Found", HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/updates{OrgId}")
    public ResponseEntity<?> updatesOrganization(@PathVariable int OrgId, @RequestBody Organization organization) {
        try {
            if (organizationRepo.findById(OrgId).isPresent()) {
                Organization organization1 = organizationRepo.save(organization);
                organization1.setOrgId(organization.getOrgId());
                organization1.setOrgName(organization.getOrgName());
                organization1.setOrgEmail(organization.getOrgEmail());
                organization1.setOrgAddress(organization.getOrgAddress());
                organization1.setOrgAddress(organization.getOrgAddress());
                organization1.setOrgName(organization.getOrgNumber());
                Organization updatesOrganization = organizationRepo.save(organization1);
                return new ResponseEntity<>("good",HttpStatus.ACCEPTED);
            } else {
                return new ResponseEntity<>("not amizing", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception exception) {
            return new ResponseEntity<>("tatizo", HttpStatus.NOT_FOUND);
        }
    }
}