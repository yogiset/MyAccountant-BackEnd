package com.example.MyAccountantBackEnd.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.repository.Modifying;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@DynamicInsert
@DynamicUpdate
@Table(name = "karyawan")
public class Karyawan {
    @Id
    @SequenceGenerator(name = "karyawan_sequence",sequenceName = "karyawan_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "karyawan_sequence")
    private Long id;
    private String nama;
    private String email;
    private String jabatan;
    private String phone;
    @Column(columnDefinition="text")
    private String imageurl;
    private LocalDate tgl_lahir;
    private Integer umur;
    private String kodekaryawan;


    public Integer getUmur() {
        return Period.between(this.tgl_lahir,LocalDate.now()).getYears();

    }
}
