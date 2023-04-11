package tn.esprit.rh.achat.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.rh.achat.entities.Project;

import java.util.Date;
import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Integer> {
   List<Project> findBySprintsStartDate(Date dateNow);
}
