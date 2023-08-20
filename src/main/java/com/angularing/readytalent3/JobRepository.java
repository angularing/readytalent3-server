package com.angularing.readytalent3;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200", "https://readytalent3.vercel.app/"})
@RepositoryRestResource(collectionResourceRel = "jobs", path = "jobs")
public interface JobRepository extends CrudRepository<Job, Long> {
    List<Job> findByTitle(String title);
    Job findById(long id);
}
