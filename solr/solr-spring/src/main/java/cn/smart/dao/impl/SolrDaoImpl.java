package cn.smart.dao.impl;

import cn.smart.dao.SolrDao;
import cn.smart.pojo.PageResult;
import cn.smart.pojo.TbItem;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class SolrDaoImpl implements SolrDao {

    @Autowired
    private CloudSolrServer solrServer;

    @Override
    public PageResult searchItem(SolrQuery solrQuery) throws Exception {
        QueryResponse query = this.solrServer.query(solrQuery);
        SolrDocumentList documentList = query.getResults();
        //处理结果集
        PageResult pageResult = new PageResult();
        //总条数
        pageResult.setTotalNum(documentList.getNumFound());
        List<TbItem> items = new ArrayList<>();
        //取高亮信息
        Map<String, Map<String, List<String>>> highlighting = query.getHighlighting();
        //模型转换
        for (SolrDocument doc:documentList){
            TbItem item = new TbItem();
            item.setId(Long.parseLong(doc.get("id").toString()));
            item.setImage(doc.get("item_image").toString());
//            item.setTitle(doc.get("item_title").toString());
            item.setSell_Point(doc.get("item_sell_point").toString());
            item.setPrice((Long) doc.get("item_price"));
            List<String> list = highlighting.get(doc.get("id")).get("item_title");
            String title = "";
            if (list != null && list.size() > 0) title = list.get(0);
            else title = doc.get("item_title").toString();
            item.setTitle(title);
            items.add(item);
        }
        pageResult.setResult(items);
        return pageResult;
    }
}
