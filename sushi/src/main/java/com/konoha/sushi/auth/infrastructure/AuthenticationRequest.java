package com.konoha.sushi.auth.infrastructure;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {
    @NotNull(message = "The email is mandatory")
    private String userName;
    @NotNull(message = "The password is mandatory")
    @Length(min = 5, message = "The password should be at least of 5 characters of length")
    private String password;
}
