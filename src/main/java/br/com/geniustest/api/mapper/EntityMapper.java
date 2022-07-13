package br.com.geniustest.api.mapper;

import br.com.geniustest.api.dto.EntityDTO;
import br.com.geniustest.api.generic.GenericEntity;
import org.mapstruct.Mapper;
import org.mapstruct.TargetType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
@Mapper(componentModel = "spring")
@SuppressWarnings("java:S119")
public abstract class EntityMapper {

    @Autowired
    private EntityManager entityManager;

    public <Entity extends GenericEntity> Entity resolve(EntityDTO reference, @TargetType Class<Entity> entityClass) {
        return reference != null ? entityManager.find(entityClass, reference.getId()) : null;
    }

    public EntityDTO toEntityDTO(GenericEntity entity) {
        return entity != null ? new EntityDTO(entity.getId()) : null;
    }
}
