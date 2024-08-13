package com.tia102g1.csform;

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

import com.tia102g1.csform.model.CsFormVO;
import com.tia102g1.member.model.Member;
import com.tia102g1.orderlist.model.OrderListVO;
import com.tia102g1.qutype.model.QuTypeVO;
import com.tia102g1.staff.model.StaffVO;


public class CompositeQuery_CsForm {
	public static Predicate get_aPredicate_For_AnyDB(CriteriaBuilder builder, Root<CsFormVO> root, String columnName,
			String value) {

		Predicate predicate = null;

		try {
			// 用於Integer //紀錄編號、處理狀態
			if ("csFormId".equals(columnName) || "status".equals(columnName)) {
				predicate = builder.equal(root.get(columnName), Integer.valueOf(value)); // root代表查詢的實體型別
				
			// 用於varchar //摘要
//			} else if ("summary".equals(columnName)) {
//				predicate = builder.like(root.get(columnName), "%" + value + "%");
			
			// 有最低購物金金額 就查詢 大於等於 最低購物金者
//			} else if ("amountMin".equals(columnName)) {
//				predicate = builder.greaterThanOrEqualTo(root.get("amount"), Integer.valueOf(value));
//			
//			// 有最高購物金金額 就查詢 小於等於 最高購物金者
//			} else if ("amountMax".equals(columnName)) {
//				predicate = builder.lessThanOrEqualTo(root.get("amount"), Integer.valueOf(value));
			
		    //有取得日期 就查 大於等於 取得日期者
//			} else if ("getDt".equals(columnName)) {
//				predicate = builder.greaterThanOrEqualTo(root.get(columnName), java.sql.Date.valueOf(value));
//				
//			//有到期日 就查 小於等於 到期日者
//			} else if ("expiryDt".equals(columnName)) {
//				predicate = builder.lessThanOrEqualTo(root.get(columnName), java.sql.Date.valueOf(value));
				
			//客訴日期(相等)
			} else if ("quDate".equals(columnName)) {
				predicate = builder.equal(root.get(columnName), java.sql.Date.valueOf(value));
			
			//會員編號、會員姓名(轉成id)
			} else if ("memberId".equals(columnName)) {
				Member member = new Member();
				member.setMemberId(Integer.valueOf(value));
				predicate = builder.equal(root.get("member"), member);
			
			//訂單編號
			} else if ("orderListId".equals(columnName)) {
				OrderListVO orderListVO = new OrderListVO();
				orderListVO.setOrderListId(Integer.valueOf(value));
				predicate = builder.equal(root.get("orderListVO"), orderListVO);
			
			//客服問題類型
			} else if ("quTypeId".equals(columnName)) {
				QuTypeVO quTypeVO = new QuTypeVO();
				quTypeVO.setQuTypeId(Integer.valueOf(value));
				predicate = builder.equal(root.get("quTypeVO"), quTypeVO);
			
			//客服人員
			} else if ("staffId".equals(columnName)) {
				StaffVO staffVO = new StaffVO();
				staffVO.setStaffId(Integer.valueOf(value));
				predicate = builder.equal(root.get("staffVO"), staffVO);
	
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return predicate;
	}

	@SuppressWarnings("unchecked")
	public static List<CsFormVO> getAllC(Map<String, String[]> map, Session session) {
//		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		List<CsFormVO> list = null;
		try {
			// 【●創建 CriteriaBuilder】
			CriteriaBuilder builder = session.getCriteriaBuilder();
			// 【●創建 CriteriaQuery】
			CriteriaQuery<CsFormVO> criteriaQuery = builder.createQuery(CsFormVO.class);
			// 【●創建 Root】
			Root<CsFormVO> root = criteriaQuery.from(CsFormVO.class);

			List<Predicate> predicateList = new ArrayList<Predicate>();
			List<Predicate> orList = new ArrayList<Predicate>();

			Set<String> keys = map.keySet();
			int count = 0;
			for (String key : keys) {
				String value = map.get(key)[0];
				System.out.println("查詢欄位: "+ key + "內容: " + value);
				if (value != null && value.trim().length() != 0 && !"action".equals(key)) {
					count++;
					
					if("name".equals(key)) {
						List<Member> listMember = session.createQuery("from Member where name like :name", Member.class)
								.setParameter("name", "%" + value + "%")
								.list();
						for(int i = 0; i < listMember.size(); i++) {
							String id = listMember.get(i).getMemberId().toString();
							orList.add(get_aPredicate_For_AnyDB(builder, root, "memberId", id.trim()));
							
						}
						Predicate p1 = builder.and(predicateList.toArray(new Predicate[predicateList.size()]));
						Predicate p2 = builder.or(orList.toArray(new Predicate[orList.size()]));
						criteriaQuery.where(p1, p2);
						
						
					} else {
						predicateList.add(get_aPredicate_For_AnyDB(builder, root, key, value.trim()));
						Predicate p1 = builder.and(predicateList.toArray(new Predicate[predicateList.size()]));
						criteriaQuery.where(p1);
					}
					System.out.println("有送出查詢資料的欄位數count = " + count);
				}
			}

			System.out.println("predicateList.size()=" + predicateList.size());
			System.out.println("orList.size()=" + orList.size());
			
			criteriaQuery.orderBy(builder.asc(root.get("csFormId")));
			// 【●最後完成創建 javax.persistence.Query●】
			Query query = session.createQuery(criteriaQuery); // javax.persistence.Query; //Hibernate 5 開始 取代原												// org.hibernate.Query 介面
			list = query.getResultList();

			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
//			throw ex; // System.out.println(ex.getMessage());
			System.out.println(ex.getMessage());
		} finally {
			session.close();
			// HibernateUtil.getSessionFactory().close();
		}
		return list;
	}
}
