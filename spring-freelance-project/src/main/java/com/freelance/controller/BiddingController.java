package com.freelance.controller;

import com.freelance.model.BidDetailsView;
import com.freelance.model.Bidding;
import com.freelance.model.Projects;
import com.freelance.service.IBiddingService;
import com.freelance.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author - Akash
 * @date - 17-05-2022
 * @project - E-Freelance-Website
 */
@RestController
@RequestMapping("/bidding-api")
public class BiddingController {

    private IBiddingService biddingService;
    private IProjectService projectService;
    @Autowired
    public void setProjectService(IProjectService projectService) {
        this.projectService = projectService;
    }
    @Autowired
    public void setBiddingService(IBiddingService biddingService) {
        this.biddingService = biddingService;
    }

    /**
     *
     * @param bidding
     * @return adds the bid and returns the string message
     */
    @PostMapping("/freelancers/bids/project-id/{pid}/freelance-id/{fid}")
    ResponseEntity<String> addBid(@RequestBody Bidding bidding,@PathVariable("pid") int projectId,@PathVariable("fid") int freelanceId){
        biddingService.addBid(bidding,projectId,freelanceId);
        return ResponseEntity.ok("Successfully Bidded");
    }

    /**
     *
     * @param bidId
     * @return update the bid and returns the string message
     */
    @DeleteMapping("/freelancers/bids/bid-id/{bidId}")
    ResponseEntity<String> deleteBid(@PathVariable("bidId") int bidId){
        biddingService.deleteBid(bidId);
        return ResponseEntity.ok("Deleted Bid");
    }

    /**
     *
     * @param bidId
     * @return bid information
     */
    @GetMapping("/bids/bid-id/{bidId}")
    ResponseEntity<BidDetailsView> getById(@PathVariable("bidId") int bidId){
        return ResponseEntity.ok(biddingService.getById(bidId));
    }

    /**
     *
     * @param projectId
     * @return list of bidding in the project
     */
    @GetMapping("/clients/bids/project-id/{pId}")
    ResponseEntity<List<Bidding>> getByProjectId(@PathVariable("pId") int projectId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","list of Bidding by project id");
        return ResponseEntity.ok().headers(headers).body(biddingService.getByProjectId(projectId));
    }

    /**
     *
     * @param freelanceId
     * @return list of biddings by the freelancer
     */
    @GetMapping("/freelancers/bids/freelance-id/{fId}")
    ResponseEntity<List<Bidding>> getByFreelanceId(@PathVariable("fId") int freelanceId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","list of Bidding by freelance id");
        return ResponseEntity.ok().headers(headers).body(biddingService.getByFreelanceId(freelanceId));
    }

    /**
     *
     * @param bidDateTime
     * @param projectId
     * @return list of bidding sorted by date and iin a single project
     */
    @GetMapping("/clients/bids/date/{date}/project-id/{pid}")
    ResponseEntity<List<Bidding>> getByNewBid(@PathVariable("date") LocalDateTime bidDateTime,@PathVariable("pid")  int projectId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","list of Bidding by new date");
        return ResponseEntity.ok().headers(headers).body(biddingService.getByNewBid(bidDateTime,projectId));
    }

    /**
     *
     * @param projectId
     * @return single project with the project id
     */
    @GetMapping("/projects/project-id/{pid}")
    ResponseEntity<Projects> getByProId(@PathVariable("pid")int projectId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","project by project id");
        return ResponseEntity.ok().headers(headers).body(projectService.getById(projectId));
    }

    /**
     *
     * @return list of all projects
     */
    @GetMapping("/projects")
    ResponseEntity<List<Projects>> getAll(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","list of projects");
        return ResponseEntity.ok().headers(headers).body(projectService.getAll());
    }

    /**
     *
     * @param projectName
     * @return project by project name
     */
    @GetMapping("/projects/project-name/{name}")
    ResponseEntity<Projects> findByProjectNameStartingWith(@PathVariable("name")String projectName) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","list of projects by name");
        return ResponseEntity.ok().headers(headers).body(projectService.findByProjectNameStartingWith(projectName));
    }

    /**
     *
     * @param budget
     * @return list of projects filtered by the budget
     */
    @GetMapping("/projects/budget/{budget}")
    ResponseEntity<List<Projects>> findByBudget(@PathVariable("budget")double budget) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","list of projects by budget");
        return ResponseEntity.ok().headers(headers).body(projectService.findByBudget(budget));
    }

    /**
     *
     * @param duration
     * @return
    list of projects filtered by the duration
     */
    @GetMapping("/projects/duration/{duration}")
    ResponseEntity<List<Projects>> findByDuration(@PathVariable("duration")String duration) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","list of projects by duration");
        return ResponseEntity.ok().headers(headers).body(projectService.findByDuration(duration));
    }

    /**
     *
     * @param projectCategory
     * @return list of projects in the same category
     */
    @GetMapping("/projects/category/{category}")
    ResponseEntity<List<Projects>> findByProjectCategory(@PathVariable("category")String projectCategory) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","list of projects by category");
        return ResponseEntity.ok().headers(headers).body(projectService.findByProjectCategory(projectCategory));
    }

    /**
     *
     * @param duration
     * @param payPerHour
     * @return
    list of projects filtered by duration and pay per hour
     */
    @GetMapping("/projects/duration/{duration}/pay-per-hour/{payperhour}")
    ResponseEntity<List<Projects>> findByDurationAndPayPerHour(@PathVariable("duration")String duration,@PathVariable("payperhour")String payPerHour){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","list of Projects by duration and payperhour");
        return ResponseEntity.ok().headers(headers).body(projectService.findByDurationAndPayPerHour(duration, payPerHour));
    }

}
