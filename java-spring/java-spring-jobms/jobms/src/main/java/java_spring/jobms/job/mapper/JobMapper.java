package java_spring.jobms.job.mapper;

import java_spring.jobms.job.Job;
import java_spring.jobms.job.dto.JobDTO;
import java_spring.jobms.job.external.Company;
import java_spring.jobms.job.external.Review;

import java.util.List;

public class JobMapper {
    public static JobDTO mapToJobWithCompanyDto(
            Job job,
            Company company,
            List<Review> reviews){
        JobDTO jobDTO = new JobDTO();
        jobDTO.setId(job.getId());
        jobDTO.setTitle(job.getTitle());
        jobDTO.setDescription(job.getDescription());
        jobDTO.setLocation(job.getLocation());
        jobDTO.setMinSalary(job.getMinSalary());
        jobDTO.setMaxSalary(job.getMaxSalary());
        jobDTO.setCompany(company);
        jobDTO.setReviews(reviews);

        return jobDTO;
    }
}
