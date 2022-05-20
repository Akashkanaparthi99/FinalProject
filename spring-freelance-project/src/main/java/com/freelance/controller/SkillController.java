package com.freelance.controller;

import com.freelance.model.Skill;
import com.freelance.service.ISkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author - Akash
 * @date - 17-05-2022
 * @project - E-Freelance-Website
 */
@RestController
@RequestMapping("/freelance-api")
public class SkillController {
    private ISkillService skillService;
    @Autowired
    public void setSkillService(ISkillService skillService) {
        this.skillService = skillService;
    }

    /**
     *
     * @param skill
     * @return add's the skill the returns the response entity message
     */
    @PostMapping("/skills")
    ResponseEntity<String> addSkill(@RequestBody Skill skill){
        skillService.addSkill(skill);
        return ResponseEntity.ok("Added Skill");
    }

    /**
     *
     * @param skill
     * @return update's the skill the returns the response entity message
     */
    @PutMapping("/skills")
    ResponseEntity<String> updateSkill(@RequestBody Skill skill){
        skillService.updateSkill(skill);
        return ResponseEntity.ok("updated Skill");
    }

    /**
     *
     * @param skillId
     * @return delete's the skill the returns the response entity message
     */
    @DeleteMapping("/skills/skill-id/{skillId}")
    ResponseEntity<String> deleteSkill(@PathVariable("skillId") int skillId){
        skillService.deleteSkill(skillId);
        return ResponseEntity.ok("deleted Skill");
    }

    /**
     *
     * @param skillId
     * @return skill by taking skill id
     */
    @GetMapping("/skills/get-by-id/{skillId}")
    ResponseEntity<Skill> getById(@PathVariable("skillId") int skillId){
        return ResponseEntity.ok(skillService.getById(skillId));
    }

    /**
     *
     * @return list of all skills
     */
    @GetMapping("/skills")
    ResponseEntity<List<Skill>> getAll(){
        return ResponseEntity.ok(skillService.getAll());
    }

}
