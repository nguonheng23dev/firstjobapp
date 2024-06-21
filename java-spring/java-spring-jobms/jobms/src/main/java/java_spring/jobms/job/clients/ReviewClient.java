package java_spring.jobms.job.clients;

import java_spring.jobms.job.external.Company;
import java_spring.jobms.job.external.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="REVIEW-SERVICE")

public interface ReviewClient {
    @GetMapping("/api/reviews")
    List<Review> getReviews(@RequestParam("companyId") Long companyId);
}
