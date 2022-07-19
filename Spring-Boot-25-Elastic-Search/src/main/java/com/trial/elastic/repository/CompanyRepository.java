package com.trial.elastic.repository;

import com.trial.elastic.entity.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository  extends ElasticsearchRepository<Company, String> {

    Page<Company> findByName(String name, Pageable pageable);

//    @Query("{\"bool\": {\"must\": [{\"match\": {\"employees.name\": \"?0\"}}]}}")
//    Page<Company> findByEmployeesNameUsingCustomQuery(String name, Pageable pageable);
}
