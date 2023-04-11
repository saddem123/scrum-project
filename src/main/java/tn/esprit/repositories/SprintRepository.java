package tn.esprit.rh.achat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.rh.achat.entities.Sprint;

import java.util.List;

@Repository
public interface SprintRepository extends JpaRepository<Sprint, Long> {

}
