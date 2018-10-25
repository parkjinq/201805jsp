package kr.or.ddit.prod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.prod.dao.IProdDao;
import kr.or.ddit.prod.dao.ProdDao;
import kr.or.ddit.prod.model.ProdVO;
import kr.or.ddit.util.model.PageVO;

public class ProdService implements IProdService {

	private static IProdService service = null;
	private IProdDao dao = null;
	
	private ProdService() {
		dao = ProdDao.getInstance();
	}
	
	public static IProdService getInstance() {
		if(service == null){
			service = new ProdService();
		}
		return service;
	}
	
	@Override
	public Map<String, Object> selectProdPageList(PageVO pageVO) {
		Map<String, Object> resultMap = new HashMap<String, Object>();

		List<ProdVO> pdList = dao.selectProdPageList(pageVO);
		int pdCnt = dao.getProdCnt();
		
		resultMap.put("pdList", pdList);
		resultMap.put("pdCnt", (int) (Math.ceil((double)pdCnt / pageVO.getPageSize())));
		
		return resultMap;
	}

	@Override
	public ProdVO selectProd(String prod_id) {
		ProdVO prodVO = dao.selectProd(prod_id);
		return prodVO;
	}

	@Override
	public int getProdCnt() {
		int pdCnt = dao.getProdCnt();
		return pdCnt;
	}

	@Override
	public List<ProdVO> selectProdByLgu(String prod_lgu) {
		List<ProdVO> prodList = dao.selectProdByLgu(prod_lgu);
		return prodList;
	}

}
