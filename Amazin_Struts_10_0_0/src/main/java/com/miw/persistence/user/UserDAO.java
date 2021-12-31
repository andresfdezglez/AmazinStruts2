package com.miw.persistence.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

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

		}

		finally {
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
			em.persist(u);
			em.getTransaction().commit();
			logger.debug("User inserted " + u);

		} finally {
			// 100% sure that the transaction and entity manager will be closed
			dba.closeEm();
		}

	}

	public User getUserByUserName(String username) {
		User user = null;

		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();

			user = em.createQuery("Select a From User a where user=?", User.class).setParameter(1, username)
					.getSingleResult();

			logger.debug("User found: " + user.toString());

		} catch (NoResultException e) {
			return null;
		}

		finally {
			// 100% sure that the transaction and entity manager will be closed
			dba.closeEm();
		}

		// We return the result
		return user;

	}

	public User getUserByUserNameAndPassword(String username, String password) {
		User user = null;

		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();

			user = em.createQuery("Select a From User a where user=? and password=?", User.class)
					.setParameter(1, username).setParameter(2, password).getSingleResult();

			logger.debug("User found: " + user.toString());

		} catch (NoResultException e) {
			return null;
		}

		finally {
			// 100% sure that the transaction and entity manager will be closed
			dba.closeEm();
		}

		// We return the result
		return user;
	}

}
