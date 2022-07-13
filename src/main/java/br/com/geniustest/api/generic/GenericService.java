package br.com.geniustest.api.generic;

import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@SuppressWarnings("java:S119")
public abstract class GenericService<ResponseDTO extends GenericResponseDTO, Entity extends GenericEntity> implements IGenericService<ResponseDTO> {

    protected final JpaSpecificationRepository<Entity, Integer> repository;
    protected final GenericMapper<?, ResponseDTO, Entity> genericMapper;

    protected GenericService(JpaSpecificationRepository<Entity, Integer> repository, GenericMapper<?, ResponseDTO, Entity> genericMapper) {
        this.repository = repository;
        this.genericMapper = genericMapper;
    }

    @SuppressWarnings("unused")
    protected List<Entity> findAllByQuery(String query) {
        return Collections.emptyList();
    }

    @Transactional(readOnly = true)
    public List<ResponseDTO> listAll(String query) {
        List<Entity> list = null;

        if (StringUtils.isNotBlank(query)) {
            list = findAllByQuery(query);
        } else {
            list = repository.findAll();
        }

        return list.stream().map(genericMapper::toDTO).toList();
    }

}
