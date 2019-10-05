package ru.basis.fias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.basis.fias.dao.HibernateDao;
import ru.basis.fias.domain.AddressObject;

import java.util.List;

@Service
public class FiasService {

	@Autowired
	private HibernateDao dao;

	public HibernateDao getDao() {
		return dao;
	}

	public void setDao(HibernateDao dao) {
		this.dao = dao;
	}

	public List<AddressObject> loadAddressObjects(String parentGuid) {
		return dao.loadAddressObjects(parentGuid);
	}

	public AddressObject loadAddressObject(String guid) {
		return dao.loadAddressObject(guid);
	}
}
