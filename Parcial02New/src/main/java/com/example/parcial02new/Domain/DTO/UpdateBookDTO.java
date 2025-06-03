package com.example.parcial02new.Domain.DTO;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBookDTO {
    @NotBlank
    private String title;
    @NotBlank
    private String language;
}
