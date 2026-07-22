package org.example.backend.dto.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.backend.model.ERole;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleRequestDto {
    private ERole role;
}
