package com.codility.tasks.hibernate.solution.demotaskapplication.demotaskapplication1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findTasksById(Long id);

}
