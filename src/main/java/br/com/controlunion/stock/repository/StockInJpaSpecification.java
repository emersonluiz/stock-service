package br.com.controlunion.stock.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.controlunion.stock.model.ProductCategory;
import br.com.controlunion.stock.model.StockIn;
import br.com.controlunion.stock.model.Product;

public class StockInJpaSpecification implements Specification<StockIn> {

    @Override
    public Predicate toPredicate(Root<StockIn> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
        // TODO Auto-generated method stub
        return null;
    }

    private void setProduct(Predicate predicate, Root<StockIn> root, CriteriaBuilder cb, int productId) {
        Join<StockIn, Product> productJoin = root.join("product", JoinType.INNER);
        predicate.getExpressions().add(cb.and(cb.equal(productJoin.get("id"), productId)));
    }

    private void setProductCategory(Predicate predicate, Root<StockIn> root, CriteriaBuilder cb, int productCategoryId) {
        Join<Product, ProductCategory> productCategoryJoin = root.join("productCategory", JoinType.INNER);
        predicate.getExpressions().add(cb.and(cb.equal(productCategoryJoin.get("id"), productCategoryId)));
    }

}
