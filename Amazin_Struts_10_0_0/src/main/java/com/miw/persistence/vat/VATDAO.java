package com.miw.persistence.vat;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.apache.logging.log4j.*;

import com.miw.model.VAT;
import com.miw.persistence.Dba;

public class VATDAO implements VATDataService {

	protected Logger logger = LogManager.getLogger(getClass());

	public List<VAT> getVATs() throws Exception {

		List<VAT> resultList = null;

		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();

			resultList = em.createQuery("Select a From VAT a", VAT.class).getResultList();

			logger.debug("Result list: " + resultList.toString());

		} finally {
			// 100% sure that the transaction and entity manager will be closed
			dba.closeEm();
		}

		// We return the result
		return resultList;
	}

	public VAT getVATByTaxGroup(int taxgroup) {
		VAT vat = null;

		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();

			vat = em.createQuery("Select a From VAT a where taxgroup=?", VAT.class).setParameter(1, taxgroup)
					.getSingleResult();

			logger.debug("VAT found: " + vat.toString());

		} catch (NoResultException e) {
			return null;
		}

		finally {
			// 100% sure that the transaction and entity manager will be closed
			dba.closeEm();
		}

		// We return the result
		return vat;
	}
}