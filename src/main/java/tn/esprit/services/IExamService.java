package tn.esprit.rh.achat.services;

import tn.esprit.rh.achat.entities.Project;
import tn.esprit.rh.achat.entities.Sprint;
import tn.esprit.rh.achat.entities.User;

import java.util.List;
import java.util.Set;

public interface IExamService {

	public User addUser(User user);

	public Project addProject(Project project);

	public void assignProjectToDeveloper(int projectId, int devId);

	public void assignProjectToScrum(int projectId, String fName, String lName);

	public Set<Project> getProjectsByScrumMaster(String fName, String lName);

	public void addSprintAndAssignToProject(Sprint sprint, int idProject);
}
