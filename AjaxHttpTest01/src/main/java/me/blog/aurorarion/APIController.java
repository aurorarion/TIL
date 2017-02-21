package me.blog.aurorarion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.blog.aurorarion.VO.NameVO;
import me.blog.aurorarion.VO.TableVO;

@RestController
@RequestMapping("/table")

public class APIController {

	@RequestMapping(value = "", method = RequestMethod.POST)
	public List<NameVO> table(@RequestBody TableVO tableVO) {
		
		System.out.println(tableVO.getTable() + "," + tableVO.getLimit());
		
		String[] customers = {"C.asdf", "C.qwer", "C.fghldsfkas", "C.aghdfkeiofk", "C.:fgkri9ekjfgls", "C.asdk43itfdkfasf"};
		String[] products = {"P.asdf", "P.qwer", "P.fghldsfkas", "P.aghdfkeiofk", "P.:fgkri9ekjfgls", "P.asdk43itfdkfasf"};
		String[] suppliers = {"S.asdf", "S.qwer", "S.fghldsfkas", "S.aghdfkeiofk", "S.:fgkri9ekjfgls", "S.asdk43itfdkfasf"};
		
		String[] ret = null;
		int tempLength;
		switch(tableVO.getTable()) {
		case "customers" :
			tempLength = tableVO.getLimit() > customers.length ? customers.length : tableVO.getLimit();
			ret = new String[tempLength];
			System.arraycopy(customers, 0, ret, 0, tempLength);
			break;
		case "products" :
			tempLength = tableVO.getLimit() > products.length ? customers.length : tableVO.getLimit();
			ret = new String[tempLength];
			System.arraycopy(products, 0, ret, 0, tempLength);
			break;
		case "suppliers" :
			tempLength = tableVO.getLimit() > suppliers.length ? customers.length : tableVO.getLimit();
			ret = new String[tempLength];
			System.arraycopy(suppliers, 0, ret, 0, tempLength);
			break;
		}
		
		List<NameVO> list = new ArrayList<>();
		for(int i = 0; i < ret.length; i++) {
			NameVO name = new NameVO();
			name.setName(ret[i]);
			list.add(name);
		}

		return list;
	}
	
}