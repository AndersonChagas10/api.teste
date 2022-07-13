package br.com.geniustest.api.dto;

import br.com.geniustest.api.generic.GenericResponseDTO;
import br.com.geniustest.api.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticatedUserResponseDTO implements GenericResponseDTO {
    private String name;
    private String email;
    private List<Role> roles;
}
