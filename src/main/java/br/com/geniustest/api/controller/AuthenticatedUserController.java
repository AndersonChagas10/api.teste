package br.com.geniustest.api.controller;

import br.com.geniustest.api.dto.AuthenticatedUserResponseDTO;
import br.com.geniustest.api.mapper.AuthenticatedUserMapper;
import br.com.geniustest.api.model.User;
import br.com.geniustest.api.util.GeniustestApiUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "AuthenticatedUser")
@RestController
public class AuthenticatedUserController {

    @Autowired
    private AuthenticatedUserMapper authenticatedUserMapper;

    @GetMapping("/me")
    public ResponseEntity<AuthenticatedUserResponseDTO> me() {
        User authenticatedUser = GeniustestApiUtil.getAuthenticatedUser();
        return new ResponseEntity<>(authenticatedUserMapper.toDTO(authenticatedUser), HttpStatus.OK);
    }

}
