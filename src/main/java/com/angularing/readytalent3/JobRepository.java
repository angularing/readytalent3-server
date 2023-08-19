package com.angularing.readytalent3;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "jobs", path = "jobs")
public interface JobRepository extends CrudRepository<Job, Long> {
    List<Job> findByTitle(String title);
    Job findById(long id);
}
