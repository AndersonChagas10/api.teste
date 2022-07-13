package br.com.geniustest.api.generic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
@SuppressWarnings("java:S119")
public interface IGenericRestService<RequestDTO extends GenericRequestDTO, ResponseDTO extends GenericResponseDTO> {

    public Page<ResponseDTO> list(Pageable pageable, String query, List<FilterCriteria> filters);

    public Optional<ResponseDTO> get(Integer id);

    public ResponseDTO create(RequestDTO requestDTO);

    public ResponseDTO update(Integer id, RequestDTO requestDTO);

    public void delete(Integer id);

}
