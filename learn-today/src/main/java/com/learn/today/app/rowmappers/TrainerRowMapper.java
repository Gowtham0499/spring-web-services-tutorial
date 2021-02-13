package com.learn.today.app.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.learn.today.app.model.Trainer;

@Component
public class TrainerRowMapper implements RowMapper<Trainer> {

	@Override
	public Trainer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Trainer trainer = new Trainer();
		trainer.setTrainerId(rs.getString(1));
		trainer.setPassword(rs.getString(2));
		return trainer;
	}

}
