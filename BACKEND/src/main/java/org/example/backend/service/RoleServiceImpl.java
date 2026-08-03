package org.example.backend.service;

import org.example.backend.dto.request.RoleRequestDto;
import org.example.backend.dto.response.RoleResponseDto;
import org.example.backend.model.ERole;
import org.example.backend.model.Role;
import org.example.backend.repository.RoleRepository;
import org.hibernate.engine.spi.EntityUniqueKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;

    @Autowired
    RoleServiceImpl(RoleRepository roleRepository){
        this.roleRepository=roleRepository;
    }

    public RoleResponseDto saveRole(RoleRequestDto roleRequestDto){
        Role role=new Role();
        role.setRole(roleRequestDto.getRole());
        roleRepository.save(role);
        RoleResponseDto roleResponseDto=new RoleResponseDto();
        roleResponseDto.setId(role.getId());
        roleResponseDto.setRole(role.getRole());
        return roleResponseDto;
    }


}
