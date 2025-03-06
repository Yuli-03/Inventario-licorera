package com.proyecto.licorera.controller;

import com.proyecto.licorera.dto.ClienteDto;
import com.proyecto.licorera.dto.ErrorResponse;
import com.proyecto.licorera.dto.ProveedorDto;
import com.proyecto.licorera.dto.SuccessMessage;
import com.proyecto.licorera.service.ClienteService;
import com.proyecto.licorera.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProveedorController {

    private static final String SUCCESS = "successfully saved or updated";

    private static final String DELETE = "removed successfully";

    private static final String UPDATE = "successfully updated";

    @Autowired
    private ProveedorService proveedorService;

    @ResponseBody
    @GetMapping("/controller/get/proveedor/{idProveedor}")
    public ResponseEntity<?> getProveedor(@PathVariable("idProveedor") Long idProveedor){

        ErrorResponse errorResponse = new ErrorResponse();

        try {
            ProveedorDto proveedorDto = new ProveedorDto();
            proveedorDto = proveedorService.getProveedorById(idProveedor);
            return ResponseEntity.status(HttpStatus.OK).body(proveedorDto);

        } catch (Exception e){
            errorResponse.setMessage(e.getMessage());
            errorResponse.setDateTransaction(ZonedDateTime.now());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

        }


    }

    @ResponseBody
    @GetMapping("/controller/get/list-proveedores")
    public ResponseEntity<?> getListProveedores(){

        ErrorResponse errorResponse = new ErrorResponse();
        try {
            List<ProveedorDto> listProveedorDto = new ArrayList<>();
            listProveedorDto = proveedorService.getListProveedores();
            return ResponseEntity.status(HttpStatus.OK).body(listProveedorDto);

        } catch (Exception e){
            errorResponse.setMessage(e.getMessage());
            errorResponse.setDateTransaction(ZonedDateTime.now());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping("/controller/post/proveedor")
    public ResponseEntity<?> createProveedor(@RequestBody ProveedorDto proveedorDto){

        ErrorResponse errorResponse = new ErrorResponse();
        try {
            proveedorService.createProveedor(proveedorDto);
            SuccessMessage successMessage = new SuccessMessage(SUCCESS);
            return ResponseEntity.status(HttpStatus.CREATED).body(successMessage);

        } catch (Exception e){
            errorResponse.setMessage(e.getMessage());
            errorResponse.setDateTransaction(ZonedDateTime.now());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/controller/delete/proveedor/{idProveedor}")
    public ResponseEntity<?> deleteProveedor(@PathVariable("idProveedor") Long idProveedor){

        ErrorResponse errorResponse = new ErrorResponse();
        try {
            proveedorService.deleteProveedor(idProveedor);
            SuccessMessage successMessage = new SuccessMessage(DELETE);
            return ResponseEntity.status(HttpStatus.OK).body(successMessage);

        } catch (Exception e){
            errorResponse.setMessage(e.getMessage());
            errorResponse.setDateTransaction(ZonedDateTime.now());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/controller/put/proveedor")
    public ResponseEntity<?> updateProveedor(@RequestBody ProveedorDto proveedorDto){

        ErrorResponse errorResponse = new ErrorResponse();
        try {
            proveedorService.updateProveedor(proveedorDto);
            SuccessMessage successMessage = new SuccessMessage(UPDATE);
            return ResponseEntity.status(HttpStatus.CREATED).body(successMessage);

        } catch (Exception e){
            errorResponse.setMessage(e.getMessage());
            errorResponse.setDateTransaction(ZonedDateTime.now());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }


}
