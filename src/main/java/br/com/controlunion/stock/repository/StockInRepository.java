package br.com.controlunion.stock.repository;

import java.util.List;

import javax.inject.Named;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.controlunion.stock.dto.StockDto;
import br.com.controlunion.stock.model.StockIn;

@Named
public interface StockInRepository extends JpaRepository<StockIn, Integer> {

    Page<StockIn> findByProductId(int productId, Pageable pageable);

    Page<StockIn> findByProductProductCategoryId(int productCategoryId, Pageable pageable);

    Page<StockIn> findByProductIdAndProductProductCategoryId(int productId, int productCategoryId, Pageable pageable);

    @Query("select new br.com.controlunion.stock.dto.StockDto(pd, sum(si.quantity), s) from StockIn si join si.product pd left join si.size s where pd.id = ?1 group by pd, s")
    List<StockDto> findSum(int productId);

    //@Query("select new br.com.controlunion.stock.dto.StockDto(pd, sum(si.quantity)) from StockIn si join si.product pd where pd.id = ?1 group by pd")
    //StockDto findSum1(int productId);

    @Query("select new br.com.controlunion.stock.dto.StockDto(pd, sum(si.quantity), s) from StockIn si join si.product pd left join si.size s where pd.enable = true group by pd, s")
    List<StockDto> findAllSum();
}
