package tn.esprit.rh.achat.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.rh.achat.entities.Project;
import tn.esprit.rh.achat.entities.Role;
import tn.esprit.rh.achat.entities.Sprint;
import tn.esprit.rh.achat.entities.User;
import tn.esprit.rh.achat.repositories.ProjectRepository;
import tn.esprit.rh.achat.repositories.SprintRepository;
import tn.esprit.rh.achat.repositories.UserRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
@AllArgsConstructor
public class ExamServiceImpl implements IExamService {


    UserRepository userRepository;
    SprintRepository sprintRepository;
    ProjectRepository projectRepository;
    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public void assignProjectToDeveloper(int projectId, int devId) {
        Project project = projectRepository.findById(projectId).orElse(null);
        User developer = userRepository.findById(devId).orElse(null);
        developer.getProjets().add(project);
        userRepository.save(developer);
    }

    @Override
    public void assignProjectToScrum(int projectId, String fName, String lName) {
        Project project = projectRepository.findById(projectId).orElse(null);
        User scrumMaster = userRepository.findByFirstNameAndLastNameAndRole(fName,lName, Role.SCRUM_MASTER);
        scrumMaster.getMasterProjets().add(project);
        userRepository.save(scrumMaster);
    }

    @Override
    public Set<Project> getProjectsByScrumMaster(String fName, String lName) {
        User scrumMaster = userRepository.findByFirstNameAndLastNameAndRole(fName, lName, Role.SCRUM_MASTER);
        return  scrumMaster.getMasterProjets();
    }

    @Override
    public void addSprintAndAssignToProject(Sprint sprint, int idProject) {
        Project project = projectRepository.findById(idProject).orElse(null);
        sprint.setProjet(project);
        sprintRepository.save(sprint);
    }

    @Scheduled(cron = "*/30 * * * * *")
    public void getProjectCurrentSprints(){
        List<Project> projects = (List<Project>) projectRepository.findAll();
        for (Project p : projects) {
            for (Sprint sprint : p.getSprints()) {
                if (sprint.getStartDate().before(new Date()))
                    log.info(p.getTitle());
            }

        }
    }
}