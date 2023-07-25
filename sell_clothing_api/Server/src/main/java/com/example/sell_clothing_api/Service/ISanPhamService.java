package com.example.sell_clothing_api.Service;

import com.example.sell_clothing_api.Model.SanPham;
import org.springframework.data.domain.Page;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface ISanPhamService {

    Page<SanPham> getAll(Integer pageNo);

    Boolean add(SanPham sanPham);

    Boolean update(SanPham sanPham, BigInteger idSanPham);

    Boolean delete(BigInteger idSanPham);

//    List<SanPham> list_Found(String keyword);

    List<SanPham> list_check_Exists(String tenSanPham);

    Optional<SanPham> findbyId(BigInteger idSanPham);

}
