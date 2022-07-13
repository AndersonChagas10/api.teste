package br.com.geniustest.api.generic;

import br.com.geniustest.api.swagger.ApiPageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;

@SuppressWarnings("java:S119")
public abstract class GenericRestController<RequestDTO extends GenericRequestDTO, ResponseDTO extends GenericResponseDTO> extends GenericController<ResponseDTO> {

    protected final IGenericRestService<RequestDTO, ResponseDTO> restService;

    protected GenericRestController(IGenericRestService<RequestDTO, ResponseDTO> service, IGenericService<ResponseDTO> superservice) {
        super(superservice);
        this.restService = service;
    }

    @GetMapping
    @ApiPageable
    public Page<ResponseDTO> list(@ApiIgnore Pageable pageable, @RequestParam(required = false) String query, @RequestParam(required = false) List<FilterCriteria> filters) {
        return restService.list(pageable, query, filters);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> get(@PathVariable Integer id) {
        return new ResponseEntity<>(restService.get(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> save(@Valid @RequestBody RequestDTO requestDTO) {
        return new ResponseEntity<>(restService.create(requestDTO), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ResponseDTO> update(@PathVariable Integer id, @Valid @RequestBody RequestDTO requestDTO) {
        return new ResponseEntity<>(restService.update(id, requestDTO), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        restService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
