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
public class TaskDTO {

    private Long id;// create ourselves in order to make tasks unique
    private ProjectDTO projectDTO;
    private UserDTO assignedEmployee;
    private String taskSubject;
    private String taskDetails;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate assignedDate;
    private Status taskStatus;
}
