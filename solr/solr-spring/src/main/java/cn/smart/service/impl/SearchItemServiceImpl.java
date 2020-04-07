package cn.smart.service.impl;

import cn.smart.dao.SolrDao;
import cn.smart.pojo.PageResult;
import cn.smart.service.SearchItemService;
import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Solr搜索业务层
 */
@Service
public class SearchItemServiceImpl implements SearchItemService {

    @Autowired
    private SolrDao solrDao;

    @Override
    public PageResult searchItem(String query, Integer page, Integer rows) throws Exception {
        //创建查询条件
        SolrQuery solrQuery = new SolrQuery();
        //添加查询条件
        solrQuery.setQuery(query);
        //默认检索域
        solrQuery.set("df", "item_keywords");
        //设置分页
        solrQuery.setStart((page - 1) * rows);
        solrQuery.setRows(rows);
        //设置高亮
        solrQuery.setHighlight(true);
        solrQuery.addHighlightField("item_title");
        //设置高亮样式
        solrQuery.setHighlightSimplePre("<em style='color:red;'>");
        solrQuery.setHighlightSimplePost("</em>");


        //调用SolrDao
        PageResult result = this.solrDao.searchItem(solrQuery);
        //数据填充
        result.setPageIndex(page);
        //总页数
        Long total = result.getTotalNum() / rows;
        if (result.getTotalNum() % rows > 0) total ++;

        result.setTotalPage(total);

        return result;
    }


}
