package com.enviro.assessment.grad001.pulengtshaba.service;

import com.enviro.assessment.grad001.pulengtshaba.model.EnvironmentalData;
import com.enviro.assessment.grad001.pulengtshaba.repository.EnvironmentalDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EnviromentalDataService {

    @Autowired
    private EnvironmentalDataRepository repository;

    public EnvironmentalData saveFile(MultipartFile file) throws IOException {
        EnvironmentalData data = new EnvironmentalData();
        data.setFileName(file.getOriginalFilename());
        data.setData(new String(file.getBytes()));
        data.setProcessedDate(LocalDateTime.now());
        return repository.save(data);
    }

    public EnvironmentalData getDataById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<EnvironmentalData> getAllData() {
        return repository.findAll();
    }
}

