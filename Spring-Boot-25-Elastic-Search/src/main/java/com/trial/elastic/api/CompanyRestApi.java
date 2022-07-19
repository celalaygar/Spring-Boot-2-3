package com.trial.elastic.api;

import com.trial.elastic.entity.Company;
import com.trial.elastic.entity.Employee;
import com.trial.elastic.repository.CompanyRepository;
import com.trial.elastic.repository.EmployeeRepository;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyRestApi {
    private static String INDEX_NAME = "company";
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    /**
     * link: localhost:8980/company/name
     * get Company by company name
     */
    @PostMapping("/name")
    List<Company> getCompaniesByEmployeesName(@RequestBody Company company) {
        Page<Company> employeesPage = companyRepository.findByName(company.getName(), PageRequest.of(0, 20));
        return employeesPage.getContent();
    }

    /**
     * link : localhost:8980/company/save
     * save Company
     */
    @PostMapping("/save")
    Company saveCompany(@RequestBody Company company) {
        List<Employee> employees = company.getEmployees();
        company.setEmployees(new ArrayList<>());

        Company finalCompany = company;
        employees.forEach(item -> {
            item = employeeRepository.save(item);
            finalCompany.getEmployees().add(item);
        });
        company = companyRepository.save(finalCompany);
        return company;
    }

    /**
     * link : localhost:8980/company/get-all
     * get all Company
     */
    @GetMapping("/get-all")
    List<Company> getAll( ){
        Page<Company> employeesPage = companyRepository.findAll( PageRequest.of(0, 20));
        return employeesPage.getContent();
    }


    @GetMapping("/search")
    List<SearchHit<Company>> getCompaniesByDescription(@RequestParam("search") String searchTerm) {

        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchQuery("description", searchTerm))
                .build();
        return elasticsearchOperations.search(searchQuery, Company.class,
                IndexCoordinates.of(INDEX_NAME)).getSearchHits();
    }
    @GetMapping("/employee/get-all")
    List<Employee> getAllEmployee( ){
        Page<Employee> employeesPage = employeeRepository.findAll( PageRequest.of(0, 100));
        return employeesPage.getContent();
    }
}
