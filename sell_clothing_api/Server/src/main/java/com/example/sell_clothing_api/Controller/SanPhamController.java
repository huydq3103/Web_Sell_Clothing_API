package com.example.sell_clothing_api.Controller;

import com.example.sell_clothing_api.Model.ResponeObject;
import com.example.sell_clothing_api.Model.SanPham;
import com.example.sell_clothing_api.Service.ISanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clothing-store")
@CrossOrigin(origins = "*", maxAge = -1)
public class SanPhamController {

    @Autowired
    private ISanPhamService sanPhamService;

    @GetMapping("/hien-thi")
    private List<SanPham> hienThi(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {
        Page page = (Page) sanPhamService.getAll(pageNo);
        List<SanPham> list = (List<SanPham>) page.getContent();
        return list;
    }

    @PostMapping("/insert")
    ResponseEntity<ResponeObject> add(@RequestBody SanPham sanPham) {
        // check name just exists
        List<SanPham> list_found = sanPhamService.list_check_Exists(sanPham.getTenSanPham().trim());
        if (list_found.size() > 0) { // if exitst
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new ResponeObject
                            ("failed", "has already exists name :" + sanPham.getTenSanPham(), ""));
        } else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponeObject
                            ("success", "insert successful", sanPhamService.add(sanPham)));

        }

    }

    @PutMapping("/update/{id}")
    ResponseEntity<ResponeObject> update(@RequestBody SanPham sanPham, @PathVariable("id") BigInteger idSanPham) {
        // check name just exists
        Optional<SanPham> list_found = sanPhamService.findbyId(idSanPham);
        if (list_found.isEmpty()) { // if exitst
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponeObject
                            ("failed", "Cannot found product with id  :" + idSanPham, ""));
        } else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponeObject
                            ("success", "Update successful", sanPhamService.update(sanPham, idSanPham)));

        }

    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<ResponeObject> delete(@PathVariable("id") BigInteger idSanPham) {
        // check name just exists
        Optional<SanPham> list_found = sanPhamService.findbyId(idSanPham);
        if (list_found.isEmpty()) { // if exitst
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponeObject
                            ("failed", "Cannot found product with id  :" + idSanPham, ""));
        } else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponeObject
                            ("success", "delete successful", sanPhamService.delete(idSanPham)));

        }

    }


}
