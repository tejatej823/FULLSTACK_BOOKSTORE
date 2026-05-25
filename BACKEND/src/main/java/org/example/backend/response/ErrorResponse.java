package org.example.backend.response;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse<T> {
    private int status;
    private String error;
    private T message;
}
