package com.example.MyAccountantBackEnd.service;

import com.example.MyAccountantBackEnd.entity.Karyawan;
import com.example.MyAccountantBackEnd.exception.AllException;
import com.example.MyAccountantBackEnd.repository.KaryawanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KaryawanServiceImpl implements KaryawanService {
    @Autowired
    private KaryawanRepository karyawanRepository;

    @Override
    public Karyawan addKaryawan(Karyawan karyawan) {
        karyawan.setKodekaryawan(UUIDGeneratorService.generateKaryawan());

        return karyawanRepository.save(karyawan);
    }

    @Override
    public List<Karyawan> showAllKaryawan() {


        return karyawanRepository.findAll();
    }

    @Override
    public Karyawan fetchKaryawanById(Long id) throws AllException {
        Optional<Karyawan> karyawan = karyawanRepository.findById(id);

        if(!karyawan.isPresent()){
            throw new AllException("Karyawan tidak ditemukan");
        }
        return karyawan.get();
    }

    @Override
    public void deleteKaryawanById(Long id) throws AllException {
        boolean exist = karyawanRepository.existsById(id);
        if(!exist){
            throw new AllException("karyawan dengan Id" + id + "tidak ada");
        }
        karyawanRepository.deleteById(id);


    }

    @Override
    public Karyawan updateKaryawan(Long id, Karyawan karyawan) throws AllException {
        Karyawan updatedKaryawan = karyawanRepository.findById(id)
                .orElseThrow(() -> new AllException("karyawan dengan Id" + id + "tidak ada"));


        updatedKaryawan.setNama(karyawan.getNama());
        updatedKaryawan.setEmail(karyawan.getEmail());
        updatedKaryawan.setJabatan(karyawan.getJabatan());
        updatedKaryawan.setPhone(karyawan.getPhone());
        updatedKaryawan.setImageurl(karyawan.getImageurl());
        updatedKaryawan.setTgl_lahir(karyawan.getTgl_lahir());
        karyawanRepository.save(updatedKaryawan);

        return updatedKaryawan;
    }
}
