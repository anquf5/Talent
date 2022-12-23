package com.talent.talent.role;

import com.talent.talent.company.Company;
import com.talent.talent.company.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    private RoleRepository roleRepository;
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    public Role getRole(Long roleId) {
        return roleRepository
                .findById(roleId)
                .orElseThrow(() -> new IllegalStateException(
                        "company with id " + roleId + " does not exists"));
    }

    public Role addNewRole(RoleRequest roleRequest) {
        Role role = new Role();
        if (roleRequest.name != null) role.setName(roleRequest.name);
        if (roleRequest.description != null) role.setDescription(roleRequest.description);
        if (roleRequest.companyId != null) {
            Company company = companyRepository.findById(roleRequest.companyId).get();
            role.setCompany(company);
        }
        if (roleRequest.location != null) role.setLocation(roleRequest.location);
        return roleRepository.save(role);
    }

    public void deleteRole(Long roleId) {
        boolean exists = roleRepository.existsById(roleId);
        if (!exists){
            throw new IllegalStateException(
                    "role with id " + roleId + " does not exists");
        }
        roleRepository.deleteById(roleId);
    }

    public void updateRole(Long id, String name, String description, String position) {
        Role role = roleRepository
                .findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "role with id " + id + " does not exists")
                );
        if (name != null && name.length() > 0){
            role.setName(name);
        }

        if (description != null && description.length() > 0){
            role.setDescription(description);
        }

        if (position != null && position.length() > 0){
            role.setLocation(position);
        }

        role.setUpdate_date(LocalDate.now());
    }
}
