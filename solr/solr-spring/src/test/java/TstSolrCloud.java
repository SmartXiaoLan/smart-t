import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TstSolrCloud {

    /**
     * 测试Spring整合SolrCloud
     */
    @Test
    public void solrCloudInsert() throws Exception{
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/application*");
        SolrServer server = ac.getBean(SolrServer.class);
        SolrInputDocument document = new SolrInputDocument();
        document.addField("id","ShaoTeemo2");
        document.addField("item_title","ShaoTeemo22");
        document.addField("item_price","2333");
        server.add(document);
        server.commit();
        server.shutdown();
    }
}
