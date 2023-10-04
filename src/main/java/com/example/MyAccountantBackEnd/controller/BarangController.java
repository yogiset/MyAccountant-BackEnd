package com.example.MyAccountantBackEnd.controller;

import com.example.MyAccountantBackEnd.entity.Barang;
import com.example.MyAccountantBackEnd.exception.AllException;
import com.example.MyAccountantBackEnd.service.barang.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/barang")
public class BarangController {
    @Autowired
    private BarangService barangService;

    @PostMapping("/add")
    public Barang addBarang(@RequestBody Barang barang) throws AllException {
        return barangService.addBarang(barang);
    }
    @GetMapping("/all")
    public List<Barang> listBarang(){
        return barangService.listBarang();
    }
    @GetMapping("/cari/{id}")
    public Barang listBarangById(@PathVariable("id")Long id) throws AllException {
        return barangService.listBarangById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBarangById(@PathVariable("id")Long id) throws AllException {
         barangService.deleteBarangById(id);
     return "Data Barang telah dihapus!!";
    }

    @PutMapping("/update/{id}")
    public Barang updateBarangById(@PathVariable("id")Long id,@RequestBody Barang barang ) throws AllException {
        return barangService.updateBarangById(id,barang);
    }


}
