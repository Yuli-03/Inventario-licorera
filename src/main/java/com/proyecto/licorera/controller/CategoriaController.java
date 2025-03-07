package com.proyecto.licorera.controller;

import com.proyecto.licorera.dto.CategoriaDto;
import com.proyecto.licorera.dto.ErrorResponse;
import com.proyecto.licorera.dto.ProveedorDto;
import com.proyecto.licorera.dto.SuccessMessage;
import com.proyecto.licorera.service.CategoriaService;
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
public class CategoriaController {

    private static final String SUCCESS = "successfully saved or updated";

    private static final String DELETE = "removed successfully";

    private static final String UPDATE = "successfully updated";

    @Autowired
    private CategoriaService categoriaService;

    @ResponseBody
    @GetMapping("/controller/get/categoria/{idCategoria}")
    public ResponseEntity<?> getCategoria(@PathVariable("idCategoria") Long idCategoria){

        ErrorResponse errorResponse = new ErrorResponse();

        try {
            CategoriaDto categoriaDto = new CategoriaDto();
            categoriaDto = categoriaService.getCategoriaById(idCategoria);
            return ResponseEntity.status(HttpStatus.OK).body(categoriaDto);

        } catch (Exception e){
            errorResponse.setMessage(e.getMessage());
            errorResponse.setDateTransaction(ZonedDateTime.now());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

        }


    }

    @ResponseBody
    @GetMapping("/controller/get/list-categorias")
    public ResponseEntity<?> getListCategorias(){

        ErrorResponse errorResponse = new ErrorResponse();
        try {
            List<CategoriaDto> listCategoriaDto = new ArrayList<>();
            listCategoriaDto = categoriaService.getListCategorias();
            return ResponseEntity.status(HttpStatus.OK).body(listCategoriaDto);

        } catch (Exception e){
            errorResponse.setMessage(e.getMessage());
            errorResponse.setDateTransaction(ZonedDateTime.now());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping("/controller/post/categoria")
    public ResponseEntity<?> createCategoria(@RequestBody CategoriaDto categoriaDto){

        ErrorResponse errorResponse = new ErrorResponse();
        try {
            categoriaService.createCategoria(categoriaDto);
            SuccessMessage successMessage = new SuccessMessage(SUCCESS);
            return ResponseEntity.status(HttpStatus.CREATED).body(successMessage);

        } catch (Exception e){
            errorResponse.setMessage(e.getMessage());
            errorResponse.setDateTransaction(ZonedDateTime.now());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/controller/delete/categoria/{idCategoria}")
    public ResponseEntity<?> deleteCategoria(@PathVariable("idCategoria") Long idCategoria){

        ErrorResponse errorResponse = new ErrorResponse();
        try {
            categoriaService.deleteCategoria(idCategoria);
            SuccessMessage successMessage = new SuccessMessage(DELETE);
            return ResponseEntity.status(HttpStatus.OK).body(successMessage);

        } catch (Exception e){
            errorResponse.setMessage(e.getMessage());
            errorResponse.setDateTransaction(ZonedDateTime.now());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/controller/put/categoria")
    public ResponseEntity<?> updateCategoria(@RequestBody CategoriaDto categoriaDto){

        ErrorResponse errorResponse = new ErrorResponse();
        try {
            categoriaService.updateCategoria(categoriaDto);
            SuccessMessage successMessage = new SuccessMessage(UPDATE);
            return ResponseEntity.status(HttpStatus.CREATED).body(successMessage);

        } catch (Exception e){
            errorResponse.setMessage(e.getMessage());
            errorResponse.setDateTransaction(ZonedDateTime.now());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }


}
