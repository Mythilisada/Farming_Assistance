package com.farm.capg.services;

import com.farm.capg.model.AdminTips;

public interface AdminTipsService {
	
	AdminTips saveTips(AdminTips adminTips);
	AdminTips delTips(AdminTips adminTips);
	AdminTips getAdminTipsBysno(int sno);

}
