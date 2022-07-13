package br.com.geniustest.api.generic;

import br.com.geniustest.api.exception.EntityException;
import br.com.geniustest.api.repository.specification.AbstractFilterSpecification;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("java:S119")
public abstract class GenericRestService<RequestDTO extends GenericRequestDTO, ResponseDTO extends GenericResponseDTO, Entity extends GenericEntity>
        extends GenericService<ResponseDTO, Entity>
        implements IGenericRestService<RequestDTO, ResponseDTO> {

    protected final GenericMapper<RequestDTO, ResponseDTO, Entity> genericRestMapper;

    protected GenericRestService(JpaSpecificationRepository<Entity, Integer> repository, GenericMapper<RequestDTO, ResponseDTO, Entity> genericRestMapper) {
        super(repository, genericRestMapper);
        this.genericRestMapper = genericRestMapper;
    }

    @SuppressWarnings("unused")
    protected Page<Entity> findByQuery(Pageable pageable, String query) {
        return null;
    }

    protected Specification<Entity> buildDefaultSpecification(List<FilterCriteria> filters) {
        return new AbstractFilterSpecification<>(filters) {
            @Override
            public Predicate toPredicate(Root<Entity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return buildFilterPredicate(root, criteriaBuilder);
            }
        };
    }

    protected void overridePropertyOnCreateForDTO(RequestDTO requestDTO) {
    }

    protected void overridePropertyOnUpdateForDTO(RequestDTO requestDTO) {
    }

    protected void overridePropertyOnCreateForEntity(Entity entity) {
    }

    protected void overridePropertyOnUpdateForEntity(Entity entity) {
    }

    @Transactional(readOnly = true)
    public Page<ResponseDTO> list(Pageable pageable, String query, List<FilterCriteria> filters) {
        Page<Entity> list = null;

        if (StringUtils.isNotBlank(query)) {
            list = findByQuery(pageable, query);
        } else {
            list = repository.findAll(Specification.where(buildDefaultSpecification(filters)), pageable);
        }

        return new PageImpl<>(list.stream().map(genericRestMapper::toDTO).toList(), pageable, list.getTotalElements());
    }

    @Transactional(readOnly = true)
    public Optional<ResponseDTO> get(Integer id) {
        Optional<Entity> entity = repository.findById(id);
        return entity.map(genericRestMapper::toDTO);
    }

    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO create(RequestDTO requestDTO) {
        this.overridePropertyOnCreateForDTO(requestDTO);
        Entity entity = genericRestMapper.toEntity(requestDTO);
        this.overridePropertyOnCreateForEntity(entity);
        repository.saveAndFlush(entity);
        return genericRestMapper.toDTO(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO update(Integer id, RequestDTO requestDTO) {
        Optional<Entity> dbOptional = repository.findById(id);
        if (dbOptional.isEmpty()) {
            throw new EntityException("Entity not found.");
        }

        Entity entity = dbOptional.get();
        this.overridePropertyOnUpdateForDTO(requestDTO);
        genericRestMapper.updateEntityFromDto(requestDTO, entity);
        this.overridePropertyOnUpdateForEntity(entity);
        repository.saveAndFlush(entity);
        return genericRestMapper.toDTO(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        Optional<Entity> dbOptional = repository.findById(id);
        if (dbOptional.isEmpty()) {
            throw new EntityException("Entity not found.");
        }

        repository.deleteById(id);
    }

}
