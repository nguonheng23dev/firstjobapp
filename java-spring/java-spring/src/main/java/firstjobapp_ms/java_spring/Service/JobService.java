package firstjobapp_ms.java_spring.Service;

import firstjobapp_ms.java_spring.Entity.Job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);

    Job getJobById(Long id);
    boolean deleteJobById(Long id);

    boolean updateJob(Long id, Job updatedJob);
}
