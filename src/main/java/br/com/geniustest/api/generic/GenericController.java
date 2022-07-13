package br.com.geniustest.api.generic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@SuppressWarnings("java:S119")
public abstract class GenericController<ResponseDTO extends GenericResponseDTO> {

    protected final IGenericService<ResponseDTO> service;

    protected GenericController(IGenericService<ResponseDTO> service) {
        this.service = service;
    }

    @GetMapping(path = "/all")
    public List<ResponseDTO> listAll(@RequestParam(required = false) String query) {
        return service.listAll(query);
    }

}
