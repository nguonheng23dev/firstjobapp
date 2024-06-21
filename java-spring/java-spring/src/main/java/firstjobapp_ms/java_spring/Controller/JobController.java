package firstjobapp_ms.java_spring.Controller;

import firstjobapp_ms.java_spring.Entity.Company;
import firstjobapp_ms.java_spring.Entity.Job;
import firstjobapp_ms.java_spring.Service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/api/jobs")
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<Job>> findAll(){
        return ResponseEntity.ok(jobService.findAll());
    }
    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job added successfully!", HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id);
        if(job != null)
            return new ResponseEntity<>(job, HttpStatus.OK);
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
