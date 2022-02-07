package repositories;

import models.studentlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentlistRepository extends JpaRepository<studentlist, Integer> {

}