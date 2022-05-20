package com.freelance.service;

import com.freelance.exceptions.FreelanceNotFoundException;
import com.freelance.model.Freelance;

import java.util.List;

public interface IFreelanceService {

    void addFreelancer(Freelance freelance);
    void updateFreelancer(Freelance freelance);
    void deleteFreelancer(int freelanceId);

    Freelance getById(int freelanceId)throws FreelanceNotFoundException;
    List<Freelance> getAll();

    List<Freelance> getByFreelancerNameStarting(String freelanceName) throws FreelanceNotFoundException;
    List<Freelance> getByRatings(double ratings)throws FreelanceNotFoundException;
    List<Freelance> getByCategory(String category)throws FreelanceNotFoundException;
    List<Freelance> getBySkill(String skill)throws FreelanceNotFoundException;
    List<Freelance> getByNoOfProjects(int noOfProjects)throws FreelanceNotFoundException;
    List<Freelance> getByCategoryAndRating(String category,double rating)throws FreelanceNotFoundException;
    List<Freelance> getByCategoryAndSkill(String category,String skill)throws FreelanceNotFoundException;
    List<Freelance> getByRatingAndSkill(double rating,String skill)throws FreelanceNotFoundException;
    List<Freelance> getByTwoSkills(String skill1,String skill2)throws FreelanceNotFoundException;
    List<Freelance> getByCategoryAndRatingAndSkill(String category,double rating,String skill)throws FreelanceNotFoundException;


}
