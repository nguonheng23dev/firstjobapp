package firstjobapp_ms.java_spring.Repository;

import firstjobapp_ms.java_spring.Entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
