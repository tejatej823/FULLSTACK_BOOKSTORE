package org.example.backend.util;
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
