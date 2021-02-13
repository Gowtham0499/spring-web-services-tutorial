package com.learn.today.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.learn.today.app.exceptions.TrainerNotFoundException;
import com.learn.today.app.model.Trainer;
import com.learn.today.app.rowmappers.TrainerRowMapper;

@Component
public class TrainerDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	TrainerRowMapper rowMapper;

	public int save(Trainer trainer) {
		int result = jdbcTemplate.update("insert into trainer (trainer_id, password) values (?, ?)", new Object[] { trainer.getTrainerId(), trainer.getPassword() });
		return result;
	}
	
	public Trainer findById(int id) {
		Trainer trainer;
		try {
			trainer = jdbcTemplate.queryForObject("select * from trainer where trainer_id=?", rowMapper, new Object[] {id});
		} catch (RuntimeException ex) {
			throw new TrainerNotFoundException("Searched Data not Found.");
		}
		return trainer;
	}

	public int update(Trainer trainer) {
		int result = jdbcTemplate.update("update trainer set password=? where trainer_id=?", new Object[] { trainer.getPassword(), trainer.getTrainerId() });
		return result;
	}

}
