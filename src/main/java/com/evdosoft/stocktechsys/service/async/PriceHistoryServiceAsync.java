package com.evdosoft.stocktechsys.service.async;

import java.util.List;

import com.evdosoft.stocktechsys.models.Company;

public interface PriceHistoryServiceAsync {

    void prepareAndDownloadPriceHistoryAsync(List<Company> companyList);    
//    void prepareAndDownloadPriceHistory();
}
