package br.com.controlunion.stock.repository;

import java.util.List;

import javax.inject.Named;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.controlunion.stock.dto.StockDto;
import br.com.controlunion.stock.model.StockOut;

@Named
public interface StockOutRepository extends JpaRepository<StockOut, Integer> {

    Page<StockOut> findByProductId(int productId, Pageable pageable);

    Page<StockOut> findByProductProductCategoryId(int productCategoryId, Pageable pageable);

    Page<StockOut> findByProductIdAndProductProductCategoryId(int productId, int productCategoryId, Pageable pageable);

    Page<StockOut> findByEmployeeIdAndProductProductCategoryIdNotOrderByDateOutDesc(int employeeId, int productCategoryId, Pageable pageable);
    
    Page<StockOut> findByEmployeeIdAndProductProductCategoryIdOrderByDateOutDesc(int employeeId, int productCategoryId, Pageable pageable);

    @Query("select new br.com.controlunion.stock.dto.StockDto(pd, sum(so.quantity), s) from StockOut so join so.product pd left join so.size s where pd.id = ?1 group by pd, s")
    List<StockDto> findSum(int productId);

    @Query("select new br.com.controlunion.stock.dto.StockDto(pd, sum(so.quantity), s) from StockOut so join so.product pd left join so.size s where pd.enable = true group by pd, s")
    List<StockDto> findAllSum();

    @Query("SELECT s FROM StockOut s WHERE s.id IN "
            + "(SELECT MAX(so.id) FROM StockOut so join so.product p join so.employee e WHERE p.enable = 'true'"
            + " AND p.validity IS NOT NULL AND p.validity != 0 AND e.id = ?1 GROUP BY p.id)")
    List<StockOut> findValidity(int employeeId);
}
