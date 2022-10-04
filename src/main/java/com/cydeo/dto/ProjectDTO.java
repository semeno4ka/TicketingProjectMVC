package com.cydeo.dto;

import com.cydeo.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {


    private String projectName;
    private String projectCode;
    private UserDTO assignedManager;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private String projectDetail;
    private Status projectStatus;
}
/*
// WHATEVER IS NOT STRING REQUIRES CONVERTER
    private String projectName;
    private String projectCode;
    private UserDTO assignedManager;
    @DateTimeFormat(pattern = "yyyy-MM-dd")// instead of using Converter
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd") //Spring does require the input in particular format, which is also displayed when you get a mistake a
    private LocalDate endDate;
    private String projectDetails;
    private Status projectStatus;

 */