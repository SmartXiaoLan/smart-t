package cn.smart;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

public class Test {

    private static String SOLR_URL = "http://192.168.66.186:8080/solr";

    public static void main(String[] args) throws Exception {
        //添加文案
//        solrInsert();
//        solrDelete();
//        solrSearch();
//        solrCloudInsert();
        solrCloudDelete();
//        solrCloudQuery();
    }


    /**
     * 向索引库中添加文档
     *
     * @throws Exception
     */
    public static void solrInsert() throws Exception {
        //创建SolrJ的链接对象
        SolrServer server = new HttpSolrServer(SOLR_URL);
        //创建Solr文档对象
        for (int i = 0; i < 20; i++) {
            SolrInputDocument document = new SolrInputDocument();
            //向文档对象中添加需要插入到索引库的内容
            document.addField("id", "SmartTeemo" + i);
            document.addField("item_title", "烧提莫" + i);
            document.addField("item_price", 6300 - i);
            //讲文档插入到solr的索引库中
            server.add(document);
        }

        //事务提交
        server.commit();
    }

    /**
     * 删除索引库内容
     *
     * @throws Exception
     */
    public static void solrDelete() throws Exception {
        SolrServer server = new HttpSolrServer(SOLR_URL);
        //给定删除条件
        //1.根据主键删除
        server.deleteById("test");
        //2.根据查询删除
//        server.deleteByQuery("id:id_value");
        server.deleteByQuery("*:*");
        server.commit();
    }

    /**
     * 查询索引库
     */
    public static void solrSearch() throws Exception {
        SolrServer server = new HttpSolrServer(SOLR_URL);
        //创建查询条件
        SolrQuery query = new SolrQuery();
        query.setQuery("烧提");
        query.set("df", "item_keywords");
        //分页
        query.setStart(10);
        query.setRows(10);

        //执行查询
        QueryResponse result = server.query(query);
        //
        SolrDocumentList documentList = result.getResults();
        //满足数据的总条数
        System.out.println("总条数:" + documentList.getNumFound());

        for (SolrDocument document : documentList) {
            System.out.println("title:" + document.get("item_title"));
            System.out.println("price:" + document.get("item_price"));
        }
    }

    /**
     * 向集群索引库中添加文档
     */
    public static void solrCloudInsert() throws Exception {
        //zookeeper地址
        String zhHost = "192.168.66.186:2181,192.168.66.186:2182,192.168.66.186:2183";
        //创建solrCloud对象
        CloudSolrServer cloudSolrServer = new CloudSolrServer(zhHost);
        //给定索引库
        cloudSolrServer.setDefaultCollection("collection2");
        //创建Solr文档对象
        SolrInputDocument document = new SolrInputDocument();
        //向文档对象中添加需要插入到索引库的内容
        document.addField("id", "SmartTeemo");
        document.addField("item_title", "烧提莫");
        document.addField("item_price", 6300);

        cloudSolrServer.add(document);
        //提交
        cloudSolrServer.commit();
        //关闭连接
        cloudSolrServer.shutdown();
    }

    /**
     * 删除集群中的文档
     */
    public static void solrCloudDelete() throws Exception {
        String zhHost = "192.168.66.186:2181,192.168.66.186:2182,192.168.66.186:2183";
        //创建SolrCloud对象
        CloudSolrServer solrServer = new CloudSolrServer(zhHost);
        solrServer.setDefaultCollection("collection2");
        solrServer.deleteByQuery("*:*");
        solrServer.commit();
        solrServer.shutdown();
    }

    /**
     * 查询集群中的文档
     */
    public static void solrCloudQuery() throws Exception {
        String zhHost = "192.168.66.186:2181,192.168.66.186:2182,192.168.66.186:2183";
        //创建SolrCloud对象
        CloudSolrServer solrServer = new CloudSolrServer(zhHost);
        solrServer.setDefaultCollection("collection2");
        SolrQuery query = new SolrQuery();
        query.setQuery("烧提");
        query.set("df", "item_keywords");
        query.setRows(10);
        //开始查询
        QueryResponse response = solrServer.query(query);
        SolrDocumentList results = response.getResults();
        System.out.println("总条数:" + results.getNumFound());
        for (SolrDocument document : results) {
            System.out.println("title:" + document.get("item_title"));
            System.out.println("price:" + document.get("item_price"));
        }
        solrServer.shutdown();
    }


}
