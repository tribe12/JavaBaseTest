package cn.wgh.Algorithmic;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.ListUtils;
import org.junit.Test;

public class 查询父级 {
	@Test
	public void 查询父级ID直到根节点() throws Exception {
		List<Integer> treeIds = new ArrayList<Integer>();
		//得到需要的子集id
		List<Integer> idList = getIds();
		treeIds = ListUtils.sum(treeIds, idList);
		for (Integer id : idList) {
			treeIds = packtree(id,treeIds);
		}
		System.out.println(treeIds);
	}

	private List<Integer> getIds() {
		List<Integer> idList = new ArrayList<Integer>();
		idList.add(0);
		idList.add(2);
		idList.add(6);
		idList.add(15);
		return idList;
	}

	private synchronized List<Integer> packtree(Integer id, List<Integer> treeIds) {
		// 查询父id
		if (id != null) {
			Integer pId = getPidById(id);
			List<Integer> emp = new ArrayList<Integer>();
			emp.add(pId);
			if (pId != null) {
				treeIds = ListUtils.sum(treeIds, emp);
				if (!pId.equals(0)) {
					treeIds = packtree(pId, treeIds);
				}
			}
		}
		return treeIds;
	}

	/**
	 * 根据id查询父级id
	 * @param id
	 * @return
	 */
	private Integer getPidById(Integer id) {
		Integer pId = null ;
		// ...
		if(id.equals(10)){
			pId = 9;
		}else if(id.equals(9)){
			pId = 8;
		}else if(id.equals(8)){
			pId = 7;
		}else if(id.equals(7)){
			pId = 6;
		}else if(id.equals(6)){
			pId = 5;
		}else if(id.equals(5)){
			pId = 4;
		}else if(id.equals(4)){
			pId = 3;
		}else if(id.equals(3)){
			pId = 2;
		}else if(id.equals(2)){
			pId = 1;
		}else if(id.equals(1)){
			pId = 0;
		}else if(id.equals(19)){
			pId = 8;
		}else if(id.equals(18)){
			pId = 7;
		}else if(id.equals(17)){
			pId = 6;
		}else if(id.equals(16)){
			pId = 5;
		}else if(id.equals(15)){
			pId = 4;
		}else if(id.equals(14)){
			pId = 3;
		}else if(id.equals(13)){
			pId = 2;
		}else if(id.equals(12)){
			pId = 1;
		}else if(id.equals(11)){
			pId = 0;
		}
		return pId;
	}
}
