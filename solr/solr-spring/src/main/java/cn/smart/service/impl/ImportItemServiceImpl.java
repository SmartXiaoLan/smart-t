package cn.smart.service.impl;

import cn.smart.mapper.ItemMapper;
import cn.smart.pojo.TbItem;
import cn.smart.service.ImportItemService;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImportItemServiceImpl implements ImportItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private SolrServer solrServer;

    /**
     * 导入数据
     */
    @Override
    public void importItem() {
        //查询数据库中的数据
        List<TbItem> itemList = this.itemMapper.findAll();
        List<SolrInputDocument> documentList = new ArrayList<>();
        //模型转换
        for (TbItem item : itemList) {
            SolrInputDocument document = new SolrInputDocument();
            document.setField("id", item.getId() + "");
            document.setField("item_title", item.getTitle());
            document.setField("item_sell_point", item.getSell_Point());
            document.setField("item_price", item.getPrice());
            document.setField("item_image", item.getImage());
            documentList.add(document);
        }
        try {
            this.solrServer.add(documentList);
            solrServer.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
