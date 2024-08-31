package com.enviro.assessment.grad001.pulengtshaba.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class EnvironmentalData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;
    private String data;
    private LocalDateTime processedDate;

    public EnvironmentalData(String fileName, String data, LocalDateTime processedDate) {
        this.fileName = fileName;
        this.data = data;
        this.processedDate = processedDate;
    }
    public EnvironmentalData(){

    }

    public LocalDateTime getProcessedDate() {
        return processedDate;
    }

    public void setProcessedDate(LocalDateTime processedDate) {
        this.processedDate = processedDate;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
// Getters and setters
}
