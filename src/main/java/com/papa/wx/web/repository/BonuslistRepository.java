package com.papa.wx.web.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.papa.wx.web.model.Bonuslist;

public interface BonuslistRepository extends JpaRepository<Bonuslist, Long> {
	Bonuslist findById(long id);
	List<Bonuslist> findAll();
	List<Bonuslist> findByCreattime(Date start, Date end);

}
