package org.baeldung.persistence.dao.home;

import java.util.List;

import org.baeldung.persistence.model.home.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepositry extends JpaRepository<News, Long>{
    List<News> findAll();
    List<News> findByStatus(int status);
}
