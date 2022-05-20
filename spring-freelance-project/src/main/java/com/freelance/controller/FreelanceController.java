package com.freelance.controller;

import com.freelance.model.Freelance;
import com.freelance.service.IFreelanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author - Akash
 * @Date - 16-05-2022
 */
@RestController
@RequestMapping("/freelance-api")
public class FreelanceController {

    private IFreelanceService freelanceService;
    @Autowired
    public void setFreelanceService(IFreelanceService freelanceService) {
        this.freelanceService = freelanceService;
    }

    /**
     * @author Akash
     * @param freelance
     * @return
     *          this method adds freelancer and returns a string message
     */
    @PostMapping("/freelancers")
    public ResponseEntity<String> addFreelancer(@RequestBody Freelance freelance){
        freelanceService.addFreelancer(freelance);
        return ResponseEntity.ok("Added Freelancer successfully");
    }

    /**
     * @author Akash
     * @param freelance
     * @return
     *          this method updates the freelancer data and returns a String message
     */
    @PutMapping("/freelancers")
    public ResponseEntity<String> updateFreelancer(@RequestBody Freelance freelance){
        freelanceService.updateFreelancer(freelance);
        return ResponseEntity.ok("Updated Freelancer Data successfully");
    }

    /**
     *
     * @param freelanceId
     * @return
     *          deletes the freelancer
     */
    @DeleteMapping("/freelancers/freelancer-id/{freelanceId}")
    public ResponseEntity<String> deleteFreelancer(@PathVariable("freelanceId") int freelanceId){
        freelanceService.deleteFreelancer(freelanceId);
        return ResponseEntity.ok("Deleted");
    }

    /**
     *
     * @param freelanceId
     * @return
     *          gets the freelancer
     */
    @GetMapping("/freelancers/get-by-id/{freelanceId}")
    public ResponseEntity<Freelance> getById(@PathVariable("freelanceId")int freelanceId){
        Freelance freelance = freelanceService.getById(freelanceId);
        return ResponseEntity.ok(freelance);
    }

    /**
     *
     * @return
     *          show the list of all freelancers
     */
    @GetMapping("/freelancers")
    public ResponseEntity<List<Freelance>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(freelanceService.getAll());
    }

    /**
     *
     * @param freelanceName
     * @return list of freelancers have with the name
     */
    @GetMapping("/freelancers/freelancer-name/{freelanceName}")
    ResponseEntity<List<Freelance>> getByFreelancerNameStarting(@PathVariable("freelanceName") String freelanceName) {
        return ResponseEntity.status(HttpStatus.OK).body(freelanceService.getByFreelancerNameStarting("%"+freelanceName+"%"));
    }

    /**
     *
     * @param ratings
     * @return list of freelancers with rating less than
     */
    @GetMapping("/freelancers/rating/{rating}")
    ResponseEntity<List<Freelance>> getByRatings(@PathVariable("rating") double ratings) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","list of freelancers by name starting");
        return ResponseEntity.ok().headers(headers).body(freelanceService.getByRatings(ratings));
    }

    /**
     *
     * @param category
     * @return list of freelancers belonging to the given category
     */
    @GetMapping("/freelancers/category/{category}")
    ResponseEntity<List<Freelance>> getByCategory(@PathVariable("category") String category) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","list of freelancers  in category");
        return ResponseEntity.ok().headers(headers).body(freelanceService.getByCategory(category));
    }

    /**
     *
     * @param skill
     * @return list of freelancers having the same skill
     */
    @GetMapping("/freelancers/skill/{skill}")
    ResponseEntity<List<Freelance>> getBySkill(@PathVariable("skill") String skill){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","list of freelancers having skill");
        return ResponseEntity.ok().headers(headers).body(freelanceService.getBySkill(skill));
    }

    /**
     *
     * @param noOfProjects
     * @return list of freelancers having done more projects
     */
    @GetMapping("/freelancers/no-of-projects/{projects}")
    ResponseEntity<List<Freelance>> getByNoOfProjects(@PathVariable("projects")int noOfProjects){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","list of freelancers by mo.of projects");
        return ResponseEntity.ok().headers(headers).body(freelanceService.getByNoOfProjects(noOfProjects));
    }

    /**
     *
     * @param category
     * @param rating
     * @return list of freelancers belong to one category and having rating less than
     */
    @GetMapping("/freelancers/category/{category}/rating/{rating}")
    ResponseEntity<List<Freelance>> getByCategoryAndRating(@PathVariable("category") String category,@PathVariable("rating")double rating){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","list of freelancers by category and rating");
        return ResponseEntity.ok().headers(headers).body(freelanceService.getByCategoryAndRating(category, rating));
    }

    /**
     *
     * @param category
     * @param skill
     * @return list of freelancers belong to one category and having the same skill
     */
    @GetMapping("/freelancers/category/{category}/skill/{skill}")
    ResponseEntity<List<Freelance>> getByCategoryAndSkill(@PathVariable("category") String category,@PathVariable("skill") String skill){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","list of freelancers by category and skill");
        return ResponseEntity.ok().headers(headers).body(freelanceService.getByCategoryAndSkill(category, skill));
    }

    /**
     *
     * @param rating
     * @param skill
     * @return
    list of freelancers having the same skill and rated less than the given rating
     */
    @GetMapping("/freelancers/rating/{rating}/skill/{skill}")
    ResponseEntity<List<Freelance>> getByRatingAndSkill(@PathVariable("rating") double rating,@PathVariable("skill") String skill){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","list of freelancers by rating and skill");
        return ResponseEntity.ok().headers(headers).body(freelanceService.getByRatingAndSkill(rating, skill));
    }

    /**
     *
     * @param skill1
     * @param skill2
     * @return list of freelancers having same two skills
     */
    @GetMapping("/freelancers/skill1/{skill1}/skill2/{skill2}")
    ResponseEntity<List<Freelance>> getByTwoSkills(@PathVariable("skill1") String skill1,@PathVariable("skill2") String skill2){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","list of freelancers by skill1 and skill2");
        return ResponseEntity.ok().headers(headers).body(freelanceService.getByTwoSkills(skill1, skill2));
    }

    /**
     *
     * @param category
     * @param rating
     * @param skill
     * @return list of freelancers belong to one category and having rating and same skill
     */
    @GetMapping("/freelancers/category/{category}/rating/{rating}/skill/{skill}")
    ResponseEntity<List<Freelance>> getByCategoryAndRatingAndSkill(@PathVariable("category") String category,@PathVariable("rating") double rating,@PathVariable("skill") String skill){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","list of freelancers by category and rating and skill");
        return ResponseEntity.ok().headers(headers).body(freelanceService.getByCategoryAndRatingAndSkill(category, rating,skill));
    }

}
