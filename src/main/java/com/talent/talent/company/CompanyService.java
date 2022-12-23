package com.talent.talent.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getCompanies(){
        return companyRepository.findAll();
    }

    public Company getCompany(Long companyId){
        return companyRepository
                .findById(companyId)
                .orElseThrow(() -> new IllegalStateException(
                "company with id " + companyId + " does not exists"));
    }

    public void addNewCompany(Company company) {
        companyRepository.save(company);
    }

    public void findCompanyByName(Company company){
        Optional<Company> companyOptional = companyRepository
                .findCompanyByName(company.getName());
        if (companyOptional.isEmpty()){

        }
    }

    public void deleteCompany(Long companyId) {
        companyRepository
                .findById(companyId)
                .orElseThrow(() -> new IllegalStateException(
                        "company with id " + companyId + " does not exists")
                );
        companyRepository.deleteById(companyId);
    }

    public void updateCompany(
            Long companyId,
            String name,
            String intro,
            String link
    ) {
        Company company = companyRepository
                .findById(companyId)
                .orElseThrow(() -> new IllegalStateException(
                "company with id " + companyId + " does not exists")
        );
        if (name != null && name.length() > 0){
            company.setName(name);
        }

        if (intro != null && intro.length() > 0){
            company.setIntro(intro);
        }

        if (link != null && link.length() > 0){
            company.setLink(link);
        }
    }
}
