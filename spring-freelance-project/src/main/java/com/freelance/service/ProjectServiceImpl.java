package com.freelance.service;

import com.freelance.exceptions.ProjectNotFoundException;
import com.freelance.model.Projects;
import com.freelance.repository.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author - Akash
 * @date - 18-05-2022
 * @project - E-Freelance-Website
 */
@Service
public class ProjectServiceImpl implements IProjectService{
    private IProjectRepository projectRepository;
    @Autowired
    public void setProjectRepository(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    /**
     *
     * @param projectId
     * @return single project details
     * @throws ProjectNotFoundException
     */
    @Override
    public Projects getById(int projectId) throws ProjectNotFoundException {
        return projectRepository
                .findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException("Invalid Project Id"));
    }

    /**
     *
     * @return list of all project's
     */
    @Override
    public List<Projects> getAll() {
        return projectRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Projects::getProjectName))
                .collect(Collectors.toList());
    }

    /**
     *
     * @param projectName
     * @return Project object with matching name
     * @throws ProjectNotFoundException
     */
    @Override
    public Projects findByProjectNameStartingWith(String projectName) throws ProjectNotFoundException {
        Projects project = projectRepository.findByProjectNameStartingWith(projectName);
        if (project == null)
            throw new ProjectNotFoundException("No Projects Found");
        return project;
    }

    /**
     *
     * @param budget
     * @return list of Projects with budget less than
     * @throws ProjectNotFoundException
     */
    @Override
    public List<Projects> findByBudget(double budget) throws ProjectNotFoundException {
        List<Projects> projects = projectRepository.findByBudget(budget)
                .stream()
                .sorted(Comparator.comparing(Projects::getProjectName))
                .collect(Collectors.toList());
        if (projects.isEmpty())
            throw new ProjectNotFoundException("No Projects Found");
        return projects;
    }

    /**
     *
     * @param duration
     * @return list of Projects with duration
     * @throws ProjectNotFoundException
     */
    @Override
    public List<Projects> findByDuration(String duration) throws ProjectNotFoundException {
        List<Projects> projects = projectRepository.findByDuration(duration)
                .stream()
                .sorted(Comparator.comparing(Projects::getProjectName))
                .collect(Collectors.toList());
        if (projects.isEmpty())
            throw new ProjectNotFoundException("No Projects Found");
        return projects;
    }

    /**
     *
     * @param projectCategory
     * @return list of Projects with category matching
     * @throws ProjectNotFoundException
     */
    @Override
    public List<Projects> findByProjectCategory(String projectCategory) throws ProjectNotFoundException {
        List<Projects> projects = projectRepository.findByProjectCategory(projectCategory)
                .stream()
                .sorted(Comparator.comparing(Projects::getProjectName))
                .collect(Collectors.toList());
        if (projects.isEmpty())
            throw new ProjectNotFoundException("No Projects Found");
        return projects;
    }

    /**
     *
     * @param duration
     * @param payPerHour
     * @return list of Projects with duration and payPerHour
     * @throws ProjectNotFoundException
     */
    @Override
    public List<Projects> findByDurationAndPayPerHour(String duration, String payPerHour) throws ProjectNotFoundException {
        List<Projects> projects = projectRepository.findByDurationAndPayPerHour(duration,payPerHour)
                .stream()
                .sorted(Comparator.comparing(Projects::getProjectName))
                .collect(Collectors.toList());
        if (projects.isEmpty())
            throw new ProjectNotFoundException("No Projects Found");
        return projects;
    }

}
