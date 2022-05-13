package com.spring.bookinventory.DAO;

import com.spring.bookinventory.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


@Component
public interface SalesRepository extends JpaRepository<Sales, Integer> {
}

//
//    Integer findByGenre(String genre);
//}
//
//abstract class Queries implements SalesRepository{
//
//    @PersistenceContext
//    EntityManager em;
//
//    @Override
//    public List<Book> findByGenre(String bookId) {
//
////        CriteriaBuilder cb = em.getCriteriaBuilder();
////        CriteriaQuery<Book> cr =  cb.createQuery(Book.class);
////        Root<Book> root = cr.from(Book.class);
////        cr.select(root).where(cb.equal(root.get("bookId"), "Software Architecture"));
////
////        Query query = em.createQuery(cr);
////        return query.getResultList();
//
//        Query query = em.createQuery("")
//    }