package com.example.MyAccountantBackEnd.controller;

import com.example.MyAccountantBackEnd.entity.Karyawan;
import com.example.MyAccountantBackEnd.exception.AllException;
import com.example.MyAccountantBackEnd.service.karyawan.KaryawanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/karyawan")
public class KaryawanController {
    @Autowired
    private KaryawanService karyawanService;

    @PostMapping("/add")
    public Karyawan addKaryawan(@RequestBody Karyawan karyawan) throws AllException {
        return karyawanService.addKaryawan(karyawan);
    }

    @GetMapping("/all")
    public List<Karyawan> showAllKaryawan(){
        return karyawanService.showAllKaryawan();
    }

    @GetMapping("/cari/{id}")
    public Karyawan fetchKaryawanById(@PathVariable("id") Long id) throws AllException {
        return karyawanService.fetchKaryawanById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteKaryawanById(@PathVariable("id") Long id) throws AllException {
        karyawanService.deleteKaryawanById(id);
        return "Data karyawan telah dihapus!!";
    }

    @PutMapping("/update/{id}")
    public Karyawan updateKaryawan(@PathVariable("id") Long id,
                                   @RequestBody Karyawan karyawan) throws AllException {
        return karyawanService.updateKaryawan(id,karyawan);
    }

    @DeleteMapping("/deletecode/{kodekaryawan}")
    public String deleteKaryawanByCode(@PathVariable("kodekaryawan")String kodekaryawan) throws AllException {
        karyawanService.deleteKaryawanByKodeKaryawan(kodekaryawan);
        return "Data Karyawan telah dihapus!!";
    }

    @PutMapping("/updatecode/{kodekaryawan}")
    public Karyawan updateKaryawanByCode(@PathVariable("kodekaryawan")String kodekaryawan, @RequestBody Karyawan karyawan ) throws AllException {
        return karyawanService.updateKaryawanByKodeKaryawan(kodekaryawan,karyawan);
    }

}
