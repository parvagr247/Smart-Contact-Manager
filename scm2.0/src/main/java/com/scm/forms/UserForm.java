package com.scm.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserForm {

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3, message = "Minimum 3 Characters is Required")
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be blank")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 6, message = "Minimum 6 Characters is Required")
    private String password;

    @NotBlank(message = "About cannot be blank")
    private String about;

    @Size(min=8, max=12, message = "Invalid Phone Number")
    private String phoneNumber;
}
