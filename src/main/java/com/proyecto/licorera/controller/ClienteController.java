package com.proyecto.licorera.controller;

import com.proyecto.licorera.dto.ClienteDto;
import com.proyecto.licorera.dto.ErrorResponse;
import com.proyecto.licorera.dto.SuccessMessage;
import com.proyecto.licorera.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteController {

    private static final String SUCCESS = "successfully saved or updated";

    private static final String DELETE = "removed successfully";

    private static final String UPDATE = "successfully updated";

    @Autowired
    private ClienteService clienteService;

    @ResponseBody
    @GetMapping("/controller/get/cliente/{idCliente}")
    public ResponseEntity<?> getCliente(@PathVariable("idCliente") Long idCliente){

        ErrorResponse errorResponse = new ErrorResponse();

        try {
            ClienteDto clienteDto = new ClienteDto();
            clienteDto = clienteService.getClienteById(idCliente);
            return ResponseEntity.status(HttpStatus.OK).body(clienteDto);

        } catch (Exception e){
            errorResponse.setMessage(e.getMessage());
            errorResponse.setDateTransaction(ZonedDateTime.now());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

        }


    }

    @ResponseBody
    @GetMapping("/controller/get/list-clientes")
    public ResponseEntity<?> getListClientes(){

        ErrorResponse errorResponse = new ErrorResponse();
        try {
            List<ClienteDto> listClienteDto = new ArrayList<>();
            listClienteDto = clienteService.getListClientes();
            return ResponseEntity.status(HttpStatus.OK).body(listClienteDto);

        } catch (Exception e){
            errorResponse.setMessage(e.getMessage());
            errorResponse.setDateTransaction(ZonedDateTime.now());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping("/controller/post/cliente")
    public ResponseEntity<?> createCliente(@RequestBody ClienteDto clienteDto){

        ErrorResponse errorResponse = new ErrorResponse();
        try {
            clienteService.createCliente(clienteDto);
            SuccessMessage successMessage = new SuccessMessage(SUCCESS);
            return ResponseEntity.status(HttpStatus.CREATED).body(successMessage);

        } catch (Exception e){
            errorResponse.setMessage(e.getMessage());
            errorResponse.setDateTransaction(ZonedDateTime.now());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/controller/delete/cliente/{idCliente}")
    public ResponseEntity<?> deleteCliente(@PathVariable("idCliente") Long idCliente){

        ErrorResponse errorResponse = new ErrorResponse();
        try {
            clienteService.deleteCliente(idCliente);
            SuccessMessage successMessage = new SuccessMessage(DELETE);
            return ResponseEntity.status(HttpStatus.OK).body(successMessage);

        } catch (Exception e){
            errorResponse.setMessage(e.getMessage());
            errorResponse.setDateTransaction(ZonedDateTime.now());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/controller/put/cliente")
    public ResponseEntity<?> updateCliente(@RequestBody ClienteDto clienteDto){

        ErrorResponse errorResponse = new ErrorResponse();
        try {
            clienteService.updateCliente(clienteDto);
            SuccessMessage successMessage = new SuccessMessage(UPDATE);
            return ResponseEntity.status(HttpStatus.CREATED).body(successMessage);

        } catch (Exception e){
            errorResponse.setMessage(e.getMessage());
            errorResponse.setDateTransaction(ZonedDateTime.now());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }


}
