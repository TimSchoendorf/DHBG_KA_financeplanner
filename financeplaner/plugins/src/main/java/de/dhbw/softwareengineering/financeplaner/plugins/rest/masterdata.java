package de.dhbw.softwareengineering.financeplaner.plugins.rest;

import de.dhbw.softwareengineering.financeplaner.adapters.dto.MasterDataDto;
import de.dhbw.softwareengineering.financeplaner.application.MasterDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class masterdata {

    @Autowired
    MasterDataService service;

    @GetMapping("/masterdata/getMasterdata/{user}")
    public ResponseEntity<MasterDataDto> getMasterdata(@PathVariable String email) {

        Optional<MasterDataDto> masterdata = service.getMasterData(email);

        return masterdata.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/masterdata/createMasterdata")
    public ResponseEntity<MasterDataDto> createMasterdata(@RequestBody MasterDataDto dto) {

        try {
            return ResponseEntity.ok(service.create(dto));
        } catch (Exception exception) {

            if (exception.getMessage() != null && exception.getMessage().equals("Jpa not found")) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/masterdata/updateMasterdata")
    public ResponseEntity<MasterDataDto> updateMasterdata(@RequestBody MasterDataDto dto) {

        try {
            return ResponseEntity.ok(service.update(dto));
        } catch (Exception exception) {

            if (exception.getMessage() != null && exception.getMessage().equals("Jpa not found")) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/masterdata/deleteMasterdata/{user}")
    public void deleteMasterdata(@PathVariable String zip) {
        service.delete(zip);
    }
}
