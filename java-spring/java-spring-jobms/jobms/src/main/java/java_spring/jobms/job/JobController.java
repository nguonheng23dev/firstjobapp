package java_spring.jobms.job;

import java_spring.jobms.job.dto.JobDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<JobDTO>> findAll(){
        return ResponseEntity.ok(jobService.findAll());
    }
    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job added successfully!", HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<JobDTO> getJobById(@PathVariable Long id){
        JobDTO jobDTO = jobService.getJobById(id);
        if(jobDTO != null)
            return new ResponseEntity<>(jobDTO, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        boolean deleted = jobService.deleteJobById(id);
        if(deleted)
            return new ResponseEntity<>("Job deleted successfully!", HttpStatus.OK);
        return new ResponseEntity<>("Job Not Found!",HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job updatedJob){
        boolean updated = jobService.updateJob(id,updatedJob);
        if(updated)
            return new ResponseEntity<>("Job updated successfully!", HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}


/*
    GET /jobs: Get all jobs
    GET /jobs/{id}: Get a specific job by ID
    POST /jobs: Create a new job
    DELETE /jobs/{id}: Delete a specific job by ID
    PUT /jobs/{id}: Update a specific job
    GET /jobs/{id}/company: Get the company associated with a specific job by ID

    Example API URLs: {base_url}
 */
