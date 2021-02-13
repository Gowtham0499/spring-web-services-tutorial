package com.learn.today.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.today.app.dao.TrainerDao;
import com.learn.today.app.model.Trainer;

@Service
public class TrainerService {
	
	@Autowired
	private TrainerDao trainerDao;

	public int saveTrainer(Trainer trainer) {
		int result = trainerDao.save(trainer);
		return result;
	}

	public int updatePassword(Trainer trainer) {
		int result = trainerDao.update(trainer);	
		return result;
	}

	public Trainer findTrainerById(int id) {
		Trainer trainer = trainerDao.findById(id);
		return trainer;
	}

}
