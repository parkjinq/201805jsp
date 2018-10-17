package kr.or.ddit.prod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.SqlFactoryBuilder;
import kr.or.ddit.prod.model.ProdVO;
import kr.or.ddit.util.model.PageVO;

public class ProdDao implements IProdDao{
	
	private SqlSessionFactory factory = null;
	private SqlSession session = null;
	private static IProdDao dao = null;
	
	private ProdDao() {
		factory = SqlFactoryBuilder.getSqlSessionFactory();
		session = factory.openSession();
	}
	
	public static IProdDao getInstance(){
		if(dao == null){
			dao = new ProdDao();
		}
		return dao;
	}
	
	@Override
	public List<ProdVO> selectProdPageList(PageVO pageVO) {
		List<ProdVO> pdList = session.selectList("prod.selectProdPageList", pageVO);
		return pdList;
	}

	@Override
	public ProdVO selectProd(String prod_id) {
		ProdVO prodVO = session.selectOne("prod.selectProd", prod_id); 
		return prodVO;
	}

	@Override
	public int getProdCnt() {
		int pdCnt = session.selectOne("prod.getProdCnt");
		return pdCnt;
	}

}
