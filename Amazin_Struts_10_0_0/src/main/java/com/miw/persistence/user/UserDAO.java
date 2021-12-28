package com.miw.persistence.user;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.miw.model.User;
import com.miw.persistence.Dba;

public class UserDAO implements UserDataService {

	protected Logger logger = LogManager.getLogger(getClass());

	public List<User> getUsers() throws Exception {
		List<User> resultList = null;

		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();

			resultList = em.createQuery("Select a From User a", User.class).getResultList();

			logger.debug("Result list: " + resultList.toString());
			for (User next : resultList) {
				logger.debug("next user: " + next);
			}

		} finally {
			// 100% sure that the transaction and entity manager will be closed
			dba.closeEm();
		}

		// We return the result
		return resultList;
	}

	public void insertUser(User u) throws Exception {

		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();

			em.createQuery("INSERT INTO USER VALUES(" + u.getId()
					+ ", " + u.getUser() + ", " + u.getPassword() + ")",
					User.class).getResultList();

			logger.debug("Insert user " + u);

		} finally {
			// 100% sure that the transaction and entity manager will be closed
			dba.closeEm();
		}

	}

}
