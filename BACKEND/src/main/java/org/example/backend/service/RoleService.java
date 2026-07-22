package org.example.backend.service;

import org.example.backend.dto.request.RoleRequestDto;
import org.example.backend.dto.response.RoleResponseDto;

public interface RoleService {
    public RoleResponseDto saveRole(RoleRequestDto roleRequestDto);
}
