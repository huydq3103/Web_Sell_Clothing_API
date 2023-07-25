package com.example.sell_clothing_api.Repository;

import com.example.sell_clothing_api.Model.SanPham;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface ISanPhamrepository extends JpaRepository<SanPham, BigInteger> {

    List<SanPham> findByTenSanPham(String ten);

//    List<SanPham> findAllByChatLieuAndAndLoaiSanPhamAndMauSacAndNhaSanXuat(String keyword);
}
