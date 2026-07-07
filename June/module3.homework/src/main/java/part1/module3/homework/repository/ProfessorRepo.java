package part1.module3.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import part1.module3.homework.entity.Professor;

@Repository
public interface ProfessorRepo extends JpaRepository<Professor, Long> {
}
