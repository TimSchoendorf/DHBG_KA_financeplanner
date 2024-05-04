package de.dhbw.softwareengineering.financeplaner.plugins.rest;

import de.dhbw.softwareengineering.writingorganizer.application.MasterdataMasterdataService;
import de.dhbw.softwareengineering.writingorganizer.adapters.masterdata.MasterdataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class InputController {

    @Autowired
    MasterdataService service;

    @GetMapping("/masterdata/getMasterdata/{user}")
    public ResponseEntity<MasterdataDto> getMasterdata(@PathVariable User user) {

        Optional<MasterdataDto> masterdata = service.getMasterdata(user);

        return masterdata.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/masterdata/createMasterdata")
    public ResponseEntity<MasterdataDto> createMasterdata(@RequestBody MasterdataDto dto) {

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
    public ResponseEntity<MasterdataDto> updateMasterdata(@RequestBody MasterdataDto dto) {

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
    public void deleteMasterdata(@PathVariable User user) {
        service.delete(user);
    }
}
