package tn.esprit.rh.achat.controllers;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rh.achat.entities.Project;
import tn.esprit.rh.achat.entities.Sprint;
import tn.esprit.rh.achat.entities.User;
import tn.esprit.rh.achat.services.IExamService;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
public class ExamRestController {

    IExamService examService;

    @PostMapping("/ajouterUser")
    public User addUser(User user){
        return examService.addUser(user);
    }

    @PostMapping("/addProject")
    public Project addProject(@RequestBody Project project){
        return examService.addProject(project);
    }

    @PostMapping("/assignProjectToDeveloper")
    public void assignProjectToDeveloper(int projectId, int devId){
        examService.assignProjectToDeveloper(projectId, devId);
    }

    @PutMapping("/assignProjectToScrum")
    public void assignProjectToScrum(int projectId, String fName, String lName){
        examService.assignProjectToScrum(projectId,fName,lName);
    }

    @GetMapping("/getProjectsByScrumMaster")
    public Set<Project> getProjectsByScrumMaster(String fName, String lName){
        return examService.getProjectsByScrumMaster(fName,lName);
    }

    @PostMapping("/ajouterSprint/{idProject}")
    public void addSprintAndAssignToProject(@RequestBody Sprint sprint,@PathVariable int idProject){
        examService.addSprintAndAssignToProject(sprint,idProject);
    }
}