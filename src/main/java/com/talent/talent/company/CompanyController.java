package com.talent.talent.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path ="api/company")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }
    @GetMapping
    public List<Company> getCompanies(){
        return companyService.getCompanies();
    }

    @GetMapping(path = "{companyId}")
    public Company getCompanies(@PathVariable("companyId") Long id){
        return companyService.getCompany(id);
    }

    @PostMapping(path = "add")
    public void registerNewCompany(@RequestBody Company company){
        companyService.addNewCompany(company);
    }

    @DeleteMapping(path = "{companyId}")
    public void deleteCompany(@PathVariable("companyId") Long id){
        companyService.deleteCompany(id);
    }

    @PutMapping(path = "{companyId}")
    public void updateCompany(
            @PathVariable("companyId") Long companyId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String intro,
            @RequestParam(required = false) String link
            ){
        companyService.updateCompany(companyId, name, intro, link);
    }
}
