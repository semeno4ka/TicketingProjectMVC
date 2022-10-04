package com.cydeo.dto;

import com.cydeo.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor


public class TaskDTO {

    private Long id;// create ourselves in order to make tasks unique
    private ProjectDTO projectDTO;
    private UserDTO assignedEmployee;
    private String taskSubject;
    private String taskDetails;
    private Status taskStatus;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate assignedDate;
}
