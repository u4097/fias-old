package ru.basis.fias.dao;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.basis.fias.domain.AddressObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class HibernateDao {

	@Autowired(required = true)
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<AddressObject> loadAddressObjects(String parentGuid) {
		Session currentSession = sessionFactory.getCurrentSession();
//		Query query = currentSession.createQuery("from AddressObject ao where ao.actStatus = 1 and ao.parentGuid = :parentGuid order by ao.offName");
		SQLQuery query = currentSession.createSQLQuery("select a.aoid, a.aoguid, a.code, a.offname, a.parentguid, a.shortname, b.parentguid hasChildren, a.aolevel, a.postalcode from addrobj a left join addrobj b on a.aoguid = b.parentguid and b.actstatus = 1  where a.parentguid = :parentGuid and a.actstatus = 1 group by a.aoid order by a.offname");
		query.setString("parentGuid", parentGuid);
		List<Object[]> list = query.list();
		List<AddressObject> aos = new ArrayList<AddressObject>();
		for (Object[] fields : list) {
			AddressObject addressObject = createAddressObject(fields);
			aos.add(addressObject);
		}
		return aos;
	}

	private AddressObject createAddressObject(Object[] fields) {
		AddressObject addressObject = new AddressObject();
		addressObject.setActStatus(1);
		addressObject.setId((String) fields[0]);
		addressObject.setGuid((String) fields[1]);
                addressObject.setLevel((Integer)fields[7]);
		addressObject.setCode((String) fields[2]);
		addressObject.setOffName((String) fields[3]);
		addressObject.setParentGuid((String) fields[4]);
		addressObject.setShortName((String) fields[5]);
		addressObject.setHasChildren(fields[6] != null);
                addressObject.setPostalCode((String) fields[8]);
		return addressObject;
	}

	public AddressObject loadAddressObject(String guid) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from AddressObject ao where ao.actStatus = 1 and ao.guid = :guid");
		query.setString("guid", guid);
		List<AddressObject> list = query.list();
		if ((list != null) && (list.size() != 0) ) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public AddressObject loadAddressObjectWithChildren(String guid) {
		Query query = sessionFactory.getCurrentSession().createQuery("from AddressObject ao where ao.actStatus = 1 and ao.guid = :guid");
		query.setString("guid", guid);
		Iterator iterator = query.iterate();
		if (iterator.hasNext()) {
			AddressObject result = (AddressObject) iterator.next();
			result.setChildren(loadAddressObjects(result.getGuid()));
			return result;
		} else {
			return null;
		}
	}

}
