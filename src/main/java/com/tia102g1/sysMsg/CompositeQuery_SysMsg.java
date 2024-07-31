package com.tia102g1.sysMsg;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tia102g1.sysMsg.model.SysMsgVO;

public class CompositeQuery_SysMsg {
	
	public static Predicate get_aPredicate_For_AnyDB(CriteriaBuilder builder, Root<SysMsgVO> root, String columnName, String value) {
		
		Predicate predicate = null;
		
		if("type".equals(columnName) || "status".equals(columnName))
			predicate = builder.equal(root.get(columnName), Integer.valueOf(value));
		else if("msgTitle".equals(columnName) || "msgContent".equals(columnName))
			predicate = builder.equal(root.get(columnName), "%" + value + "%");
		return predicate;
	}
	
	@SuppressWarnings("unchecked")
	public static List<SysMsgVO> getAllC(Map<String,String[]> map, Session session){
		Transaction tx = session.beginTransaction();
		List<SysMsgVO> list = null;
		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<SysMsgVO> criteriaQuery =builder.createQuery(SysMsgVO.class);
			Root<SysMsgVO> root = criteriaQuery.from(SysMsgVO.class);
			List<Predicate> predicateList = new ArrayList<Predicate>();
			
			Set<String> keys = map.keySet();
			int count = 0;
			for(String key : keys) {
				String value = map.get(key)[0];
				if(value != null && value.trim().length() != 0 && !"action".equals(key)) {
					count++;
					predicateList.add(get_aPredicate_For_AnyDB(builder, root, key, value.trim()));
					System.out.println("送出查詢的欄位 = " + count);
				}
			}
			System.out.println("predicateList.size() = " + predicateList.size());
			criteriaQuery.where(predicateList.toArray(new Predicate[predicateList.size()]));
			criteriaQuery.orderBy(builder.asc(root.get("sysMsgId")));
			Query query = session.createQuery(criteriaQuery);
			list = query.getResultList();
			tx.commit();
		} catch(RuntimeException re) {
			if(tx !=null)
				tx.rollback();
			throw re;
		}finally {
			session.close();
		}
		
		return list;
	}
}
