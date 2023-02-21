package com.mis.studentdata.repository;
import com.mis.studentdata.entities.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StudentRepo extends JpaRepository<Students,Long> {

}