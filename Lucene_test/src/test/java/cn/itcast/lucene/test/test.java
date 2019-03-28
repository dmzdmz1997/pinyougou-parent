package cn.itcast.lucene.test;

import cn.itcast.lucene.dao.BookDao;
import cn.itcast.lucene.dao.impl.BookDaoImpl;
import cn.itcast.lucene.pojo.Book;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.FileDescriptor;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 朱惠
 * @date 2019/3/23 - 9:16
 */
public class test<bookList> {
    @Test
    public void createIndex() throws Exception {

        BookDao bookDao = new BookDaoImpl();
        List<Book> bookList = bookDao.findAll();

        // 创建文档集合对象
        List<Document> documents = new ArrayList<Document>();
        for (Book book : bookList) {
            Document doc = new Document();
            doc.add(new TextField("id", book.getId() + "", Field.Store.YES));
            // 图书名称
            doc.add(new TextField("bookName",book.getBookName(), Field.Store.YES));
            doc.add(new TextField("bookPrice",book.getPrice() + "", Field.Store.YES));
            // 图书图片
            doc.add(new TextField("bookPic",book.getPic(), Field.Store.YES));
            // 图书描述
            doc.add(new TextField("bookDesc",book.getBookDesc(), Field.Store.YES));
            documents.add(doc);
        }
        //创建分词器
        Analyzer analyzer = new StandardAnalyzer();
        //配置索引库
        IndexWriterConfig indexWriterConfig =
                new IndexWriterConfig(Version.LUCENE_4_10_3, analyzer);
        indexWriterConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
        // 创建索引库目录对象，用于指定索引库存储位置
        Directory directory = FSDirectory.open(new File("F:\\index"));
        // 创建索引库操作对象，用于把文档写入索引库
        IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);
        // 循环文档，写入索引库
        for (Document document : documents){
            /** addDocument方法：把文档对象写入索引库 */
            indexWriter.addDocument(document);
// 提交事务
            indexWriter.commit();
        }
        // 释放资源
        indexWriter.close();

    }
    @Test
    public void searchIndex()throws Exception{

        // 创建分析器对象，用于分词
        Analyzer analyzer = new StandardAnalyzer();
        // 创建查询解析器对象
        QueryParser queryParser = new QueryParser("bookName", analyzer);
        // 解释查询字符串，得到查询对象
        Query query = queryParser.parse("bookName:java");
        // 创建索引库存储目录
        Directory directory = FSDirectory.open(new File("F:\\index"));
        // 创建IndexReader读取索引库对象
        IndexReader indexReader = DirectoryReader.open(directory);
        // 创建IndexSearcher，执行搜索索引库
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        /**
         * search方法：执行搜索
         * 参数一：查询对象
         * 参数二：指定搜索结果排序后的前n个（前10个）
         */
        TopDocs topDocs = indexSearcher.search(query, 10);
        // 处理结果集
        System.out.println("总命中的记录数：" + topDocs.totalHits);
        // 获取搜索到得文档数组
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        // ScoreDoc对象：只有文档id和分值信息
        for (ScoreDoc scoreDoc : scoreDocs){
            System.out.println("--------华丽分割线----------");
            System.out.println("文档id: " + scoreDoc.doc
                    + "\t文档分值：" + scoreDoc.score);
            // 根据文档id获取指定的文档
            Document doc = indexSearcher.doc(scoreDoc.doc);
            System.out.println("图书Id：" + doc.get("id"));
            System.out.println("图书名称：" + doc.get("bookName"));
            System.out.println("图书价格：" + doc.get("bookPrice"));
            System.out.println("图书图片：" + doc.get("bookPic"));
            System.out.println("图书描述：" + doc.get("bookDesc"));
        }
        // 释放资源
        indexReader.close();
    }

    /** 根据term分词删除索引 */
    @Test
    public void deleteIndexByTerm() throws Exception{
        // 创建分析器，用于分词
        Analyzer analyzer = new IKAnalyzer();
        // 创建索引库配置信息对象
        IndexWriterConfig iwc = new IndexWriterConfig(Version.LUCENE_4_10_3,analyzer);
        // 创建索引库存储目录
        Directory directory = FSDirectory.open(new File("F:\\index"));
        // 创建IndexWriter，操作索引库
        IndexWriter indexWriter = new IndexWriter(directory, iwc);
        // 创建条件对象
        Term term = new Term("bookName", "java");
        // 使用IndexWriter对象，执行删除
        indexWriter.deleteDocuments(term);
        // 关闭，释放资源
        indexWriter.close();
    }
    /**删除所有索引*/
    @Test
    public void deleteAllIndex() throws Exception{
        // 创建分析器，用于分词
        Analyzer analyzer = new IKAnalyzer();
        // 创建索引库配置信息对象
        IndexWriterConfig iwc = new IndexWriterConfig(Version.LUCENE_4_10_3,analyzer);
        // 创建索引库存储目录
        Directory directory = FSDirectory.open(new File("F:\\index"));
        // 创建IndexWriter，操作索引库
        IndexWriter indexWriter = new IndexWriter(directory, iwc);
        // 创建条件对象
       indexWriter.deleteAll();
        // 关闭，释放资源
        indexWriter.close();
    }
    @Test
    public void updateIndex() throws Exception{
        Analyzer analyzer = new IKAnalyzer();
        // 创建索引库配置信息对象
        IndexWriterConfig iwc = new IndexWriterConfig(Version.LUCENE_4_10_3,analyzer);
        // 创建索引库存储目录
        Directory directory = FSDirectory.open(new File("F:\\index"));
        // 创建IndexWriter，操作索引库
        IndexWriter indexWriter = new IndexWriter(directory, iwc);
        Document doc = new Document();
        doc.add(new StringField("id","9527", Field.Store.YES));
        doc.add(new TextField("name", "lucene solr dubbo zookeeper", Field.Store.YES));
        // 创建查询条件对象
        Term term = new Term("name","lucene");
        // 使用indexWriter对象，执行更新
        indexWriter.updateDocument(term, doc);
        // 提交事务
        indexWriter.commit();
        // 关闭，释放资源
        indexWriter.close();
    }
}