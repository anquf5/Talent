package com.talent.talent.role;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/role")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public List<Role> getRoles(){
        return roleService.getRoles();
    }

    @GetMapping(path = "{roleId}")
    public Role getRole(@PathVariable("roleId") Long roleId){
        return roleService.getRole(roleId);
    }

    @PostMapping(path = "add")
    public void addNewRole(@RequestBody RoleRequest roleRequest){
        roleService.addNewRole(roleRequest);
    }

    @DeleteMapping(path = "{roleId}")
    public void deleteRole(@PathVariable("roleId") Long id){
        roleService.deleteRole(id);
    }

    @PutMapping(path = "{roleId}")
    public void updateRole(
            @PathVariable("roleId") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String position
    ){
        roleService.updateRole(id, name, description, position);
    }
}
