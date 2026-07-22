package org.example.backend.dto.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.backend.model.ERole;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleResponseDto {
    private Long id;
    private ERole role;

    public void set() {
    }
}
