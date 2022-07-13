package br.com.geniustest.api.generic;

import org.mapstruct.MappingTarget;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
@SuppressWarnings("java:S119")
public interface GenericMapper<RequestDTO extends GenericRequestDTO, ResponseDTO extends GenericResponseDTO, Entity extends GenericEntity> {

    ResponseDTO toDTO(Entity entity);

    Entity toEntity(RequestDTO dto);

    void updateEntityFromDto(RequestDTO dto, @MappingTarget Entity entity);
}
