package com.enviro.assessment.grad001.pulengtshaba.controller;

import com.enviro.assessment.grad001.pulengtshaba.model.EnvironmentalData;
import com.enviro.assessment.grad001.pulengtshaba.service.EnviromentalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/files")
public class EnviromentalDataController {

    @Autowired
    private EnviromentalDataService service;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            service.saveFile(file);
            return ResponseEntity.ok("File uploaded and processed successfully");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Failed to process file");
        }
    }

    @GetMapping("/data/{id}")
    public ResponseEntity<EnvironmentalData> getDataById(@PathVariable Long id) {
        EnvironmentalData data = service.getDataById(id);
        if (data != null) {
            return ResponseEntity.ok(data);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    @GetMapping("/data")
    public ResponseEntity<List<EnvironmentalData>> getAllData() {
        List<EnvironmentalData> allData = service.getAllData();
        return ResponseEntity.ok(allData);
    }
}

