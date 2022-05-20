package com.freelance.service;

import com.freelance.exceptions.FreelanceNotFoundException;
import com.freelance.model.Freelance;
import com.freelance.repository.IFreelanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author - Akash
 * @Date - 16-05-2022
 */
@Service
public class FreelanceServiceImpl implements IFreelanceService{
    private IFreelanceRepository freelanceRepository;
    @Autowired
    public void setFreelanceRepository(IFreelanceRepository freelanceRepository) {
        this.freelanceRepository = freelanceRepository;
    }

    /**
     *
     * @param freelance
     */
    @Override
    public void addFreelancer(Freelance freelance) {
        freelanceRepository.save(freelance);
    }

    /**
     *
     * @param freelance
     */
    @Override
    public void updateFreelancer(Freelance freelance) {
        freelanceRepository.save(freelance);
    }

    /**
     *
     * @param freelanceId
     */
    @Override
    public void deleteFreelancer(int freelanceId) {
        freelanceRepository.deleteById(freelanceId);
    }

    /**
     *
     * @param freelanceId
     * @return freelancer by id
     * @throws FreelanceNotFoundException
     */
    @Override
    public Freelance getById(int freelanceId) throws FreelanceNotFoundException{
        Freelance freelance = freelanceRepository.findById(freelanceId).get();
        if (freelance == null)
            throw new FreelanceNotFoundException("Invalid Id entered -- No freelancer found with ID - "+freelanceId);

        return freelance;
    }

    /**
     *
     * @return list of freelancers available
     */
    @Override
    public List<Freelance> getAll() {
        return freelanceRepository
                .findAll()
                .stream()
                .sorted(Comparator.comparing(Freelance::getFreelancerName))
                .collect(Collectors.toList());
    }

    /**
     *
     * @param freelanceName
     * @return list fo freelancers with name starting with
     * @throws FreelanceNotFoundException
     */
    @Override
    public List<Freelance> getByFreelancerNameStarting(String freelanceName) throws FreelanceNotFoundException {
        List<Freelance> freelances = freelanceRepository.findByFreelancerNameStarting(freelanceName);
        if (freelances.isEmpty())
            throw new FreelanceNotFoundException("No Freelancer Found with name : "+freelanceName);
        return freelances
                .stream()
                .sorted(Comparator.comparing(Freelance::getFreelancerName))
                .collect(Collectors.toList());
    }

    /**
     *
     * @param ratings
     * @return list of freelancers with ratings
     * @throws FreelanceNotFoundException
     */
    @Override
    public List<Freelance> getByRatings(double ratings) throws FreelanceNotFoundException{
        List<Freelance> freelances = freelanceRepository.findByRatings(ratings);
        if (freelances.isEmpty())
            throw new FreelanceNotFoundException("No Freelancer Found with rating less than : "+ratings);
        return freelances
                .stream()
                .sorted(Comparator.comparing(Freelance::getFreelancerName))
                .collect(Collectors.toList());
    }

    /**
     *
     * @param category
     * @return list of freelancers in category
     * @throws FreelanceNotFoundException
     */
    @Override
    public List<Freelance> getByCategory(String category) throws FreelanceNotFoundException{
        List<Freelance> freelances = freelanceRepository.findByCategory(category);
        if (freelances.isEmpty())
            throw new FreelanceNotFoundException("No Freelancer Found in category : "+category);
        return freelances
                .stream()
                .sorted(Comparator.comparing(Freelance::getFreelancerName))
                .collect(Collectors.toList());
    }

    /**
     *
     * @param skill
     * @return list of freelancers in specified skills
     * @throws FreelanceNotFoundException
     */
    @Override
    public List<Freelance> getBySkill(String skill) throws FreelanceNotFoundException{
        List<Freelance> freelances = freelanceRepository.findBySkill(skill);
        if (freelances.isEmpty())
            throw new FreelanceNotFoundException("No Freelancer Found with skill : "+skill);
        return freelances
                .stream()
                .sorted(Comparator.comparing(Freelance::getFreelancerName))
                .collect(Collectors.toList());
    }

    /**
     *
     * @param noOfProjects
     * @return list of freelancers with number of projects done
     * @throws FreelanceNotFoundException
     */
    @Override
    public List<Freelance> getByNoOfProjects(int noOfProjects) throws FreelanceNotFoundException{
        List<Freelance> freelances = freelanceRepository.findByNoOfProjects(noOfProjects);
        if (freelances.isEmpty())
            throw new FreelanceNotFoundException("No Freelancer Found with projects : "+noOfProjects);
        return freelances
                .stream()
                .sorted(Comparator.comparing(Freelance::getFreelancerName))
                .collect(Collectors.toList());
    }

    /**
     *
     * @param category
     * @param rating
     * @return list of freelancers in category and with ratings
     * @throws FreelanceNotFoundException
     */
    @Override
    public List<Freelance> getByCategoryAndRating(String category, double rating) throws FreelanceNotFoundException{
        List<Freelance> freelances = freelanceRepository.findByCategoryAndRating(category, rating);
        if (freelances.isEmpty())
            throw new FreelanceNotFoundException("No Freelancer Found in : "+category+" with rating - "+rating);
        return freelances
                .stream()
                .sorted(Comparator.comparing(Freelance::getFreelancerName))
                .collect(Collectors.toList());
    }

    /**
     *
     * @param category
     * @param skill
     * @return list of freelancers in category with the skills
     * @throws FreelanceNotFoundException
     */
    @Override
    public List<Freelance> getByCategoryAndSkill(String category, String skill) throws FreelanceNotFoundException{
        List<Freelance> freelances = freelanceRepository.findByCategoryTypeAndSkillName(category, skill);
        if (freelances.isEmpty())
            throw new FreelanceNotFoundException("No Freelancer Found in : "+category+" and with skill "+skill);
        return freelances
                .stream()
                .sorted(Comparator.comparing(Freelance::getFreelancerName))
                .collect(Collectors.toList());
    }

    /**
     *
     * @param rating
     * @param skill
     * @return list of freelancers with rating and in specified skills
     * @throws FreelanceNotFoundException
     */
    @Override
    public List<Freelance> getByRatingAndSkill(double rating, String skill) throws FreelanceNotFoundException{
        List<Freelance> freelances = freelanceRepository.findByRatingAndSkillName(rating, skill);
        if (freelances.isEmpty())
            throw new FreelanceNotFoundException("No Freelancer Found with rating : "+rating+" and having skill "+skill);
        return freelances
                .stream()
                .sorted(Comparator.comparing(Freelance::getFreelancerName))
                .collect(Collectors.toList());
    }

    /**
     *
     * @param skill1
     * @param skill2
     * @return list of freelancers having 2 skills
     * @throws FreelanceNotFoundException
     */
    @Override
    public List<Freelance> getByTwoSkills(String skill1, String skill2) throws FreelanceNotFoundException{
        List<Freelance> freelances = freelanceRepository.findByTwoSkillsNames(skill1, skill2);
        if (freelances.isEmpty())
            throw new FreelanceNotFoundException("No Freelancer Found having skills : "+skill1+" "+skill2);
        return freelances
                .stream()
                .sorted(Comparator.comparing(Freelance::getFreelancerName))
                .collect(Collectors.toList());
    }

    /**
     *
     * @param category
     * @param rating
     * @param skill
     * @return list of freelancers in category and having rating with skills
     * @throws FreelanceNotFoundException
     */
    @Override
    public List<Freelance> getByCategoryAndRatingAndSkill(String category, double rating, String skill) throws FreelanceNotFoundException{
        List<Freelance> freelances = freelanceRepository.findByCategoryAndRatingAndSkill(category, rating, skill);
        if (freelances.isEmpty())
            throw new FreelanceNotFoundException("No Freelancer Found in category : "+category+" having rating "+
                    rating+" and also having skills "+ skill);
        return freelances
                .stream()
                .sorted(Comparator.comparing(Freelance::getFreelancerName))
                .collect(Collectors.toList());
    }
}
