package firstjobapp_ms.java_spring.Repository;

import firstjobapp_ms.java_spring.Entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
