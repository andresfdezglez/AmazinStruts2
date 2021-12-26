package com.miw.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.*;

public class Dba {

	private static volatile boolean initialized = false;
	private static Boolean lock = true;
	private static EntityManagerFactory emf = null;

	protected Logger logger = LogManager.getLogger(getClass());

	private EntityManager outer;

	public Dba() {
		this(false);
	}

	public Dba(boolean readOnly) {

		initialize();
		openEm(readOnly);
	}

	public void openEm(boolean readOnly) {
		if (outer != null) {
			return;
		}

		try
		{
		outer = emf.createEntityManager();
		}
		catch ( Exception e)
		{
			logger.error("Problems creating em");
			e.printStackTrace();
		}

		if (readOnly == false) {
			outer.getTransaction().begin();
		}
	}

	/**
	 * Get the outer transaction; an active transaction must already exist for this
	 * to succeed.
	 */
	public EntityManager getActiveEm() {
		if (outer == null) {
			throw new IllegalStateException("No transaction was active!");
		}

		return outer;
	}

	/**
	 * Close the entity manager, properly committing or rolling back a transaction
	 * if one is still active.
	 */
	public void closeEm() {
		if (outer == null) {
			return;
		}

		try {
			if (outer.getTransaction().isActive()) {

				if (outer.getTransaction().getRollbackOnly()) {
					outer.getTransaction().rollback();
				} else {
					outer.getTransaction().commit();
				}
			}

		} finally {
			outer.close();
			outer = null;
		}
	}

	/**
	 * Mark the transaction as rollback only, if there is an active transaction to
	 * begin with.
	 */
	public void markRollback() {

		if (outer != null) {
			outer.getTransaction().setRollbackOnly();
		}
	}

	public boolean isRollbackOnly() {
		return outer != null && outer.getTransaction().getRollbackOnly();
	}

	// thread safe way to initialize the entity manager factory.
	private void initialize() {

		if (initialized) {
			return;
		}

		synchronized (lock) {

			if (initialized) {
				return;
			}

			initialized = true;

			try {
				emf = Persistence.createEntityManagerFactory("JPA_PU");

			} catch (Throwable t) {
				logger.error("Failed to setup persistence unit!", t);
				return;
			}
		}
	}
}