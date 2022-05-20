package com.freelance.service;

import com.freelance.exceptions.ProjectNotFoundException;
import com.freelance.model.Projects;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface IProjectService {
    Projects getById(int projectId) throws ProjectNotFoundException;
    List<Projects> getAll();

    Projects findByProjectNameStartingWith(String projectName) throws ProjectNotFoundException;
    List<Projects> findByBudget(double budget) throws ProjectNotFoundException;
    List<Projects> findByDuration(String duration) throws ProjectNotFoundException;
    List<Projects> findByProjectCategory(String projectCategory) throws ProjectNotFoundException;

    List<Projects> findByDurationAndPayPerHour(String duration,String payPerHour) throws ProjectNotFoundException;

}
