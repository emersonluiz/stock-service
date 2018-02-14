package br.com.controlunion.stock.rest;

import java.net.URI;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.controlunion.stock.model.StockOut;
import br.com.controlunion.stock.service.StockOutService;

@RestController
@RequestMapping("/stock/out")
public class StockOutResource extends ExceptionResource {

    @Inject
    StockOutService stockOutService;

    @RequestMapping(method = RequestMethod.POST, consumes = { "application/json" }, produces = { "application/json" })
    public ResponseEntity<StockOut> create(@RequestBody @Valid StockOut stockOut) throws Exception {
        stockOutService.create(stockOut);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(stockOut.getId()).toUri();
        return ResponseEntity.created(location).body(stockOut);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="/{stockOutId}", method = RequestMethod.GET, produces = { "application/json" })
    public StockOut findOne(@PathVariable("stockOutId") int stockOutId) throws Exception {
        return stockOutService.findOne(stockOutId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value="/{stockOutId}", method = RequestMethod.PUT)
    public void update(@PathVariable("stockOutId") int stockOutId, @RequestBody StockOut stockOut) throws Exception {
        stockOutService.update(stockOutId, stockOut);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value="/{stockOutId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("stockOutId") int stockOutId) throws Exception {
        stockOutService.delete(stockOutId);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, produces = { "application/json" })
    public Page<StockOut> findAll(@RequestParam(required = false, value = "productId") Integer productId, 
                           @RequestParam(required = false, value = "productCategoryId") Integer productCategoryId,
                           Pageable pageable) throws Exception {
        return stockOutService.findAll(productCategoryId, productId, pageable);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="/employee/{employeeId}", method = RequestMethod.GET, produces = { "application/json" })
    public Page<StockOut> findByEmployeeId(@PathVariable("employeeId") int employeeId, 
                                           @RequestParam(required = false, value = "productCategoryId") Integer productCategoryId, 
                                           Pageable pageable) throws Exception {
        return stockOutService.findByEmployee(employeeId, productCategoryId, pageable);
    }
}
