package cn.smart.dao;

import cn.smart.pojo.PageResult;
import org.apache.solr.client.solrj.SolrQuery;

public interface SolrDao {

    PageResult searchItem(SolrQuery solrQuery) throws Exception;
}
