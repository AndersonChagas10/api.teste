package br.com.geniustest.api.mapper;

import br.com.geniustest.api.dto.AuthenticatedUserResponseDTO;
import br.com.geniustest.api.model.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AuthenticatedUserMapper {

    AuthenticatedUserResponseDTO toDTO(User entity);

}
