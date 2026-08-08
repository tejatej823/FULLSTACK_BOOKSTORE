package org.example.backend.controller;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.example.backend.dto.request.RoleRequestDto;
import org.example.backend.dto.response.RoleResponseDto;
import org.example.backend.model.Role;
import org.example.backend.repository.RoleRepository;
import org.example.backend.service.RoleService;
import org.example.backend.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/api/role")
public class RoleController {

    private final RoleService roleService;
    private final RoleRepository roleRepository;

    @Autowired
    public RoleController(RoleService roleService,RoleRepository roleRepository){
        this.roleService=roleService;
        this.roleRepository=roleRepository;
    }

    @PostMapping("/")
    ResponseEntity<?> addRole(@RequestBody @Valid RoleRequestDto roleRequestDto){
        RoleResponseDto roleResponseDto=roleService.saveRole(roleRequestDto);
        ApiResponse<RoleResponseDto>response=new ApiResponse<>(true,"Role added successfully",roleResponseDto);
        return ResponseEntity.status(200).body(response);
    } 

    @GetMapping("/")
    ResponseEntity<?>getRoles(){
        List<Role>roles=roleRepository.findAll();
        return ResponseEntity.status(200).body(roles);
    }
}
