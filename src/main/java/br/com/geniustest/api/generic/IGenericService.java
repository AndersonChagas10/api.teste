package br.com.geniustest.api.generic;

import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
@SuppressWarnings("java:S119")
public interface IGenericService<ResponseDTO extends GenericResponseDTO> {

	public List<ResponseDTO> listAll(String query);
	
}
