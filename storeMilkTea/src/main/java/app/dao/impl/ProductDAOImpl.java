package app.dao.impl;

import app.dao.GenericDAO;
import app.dao.ProductDAO;
import app.model.Category;
import app.model.Product;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.hibernate.search.FullTextQuery;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.SearchFactory;
import org.hibernate.search.query.dsl.QueryBuilder;

import java.util.List;

public class ProductDAOImpl extends GenericDAO<Integer, Product> implements ProductDAO {

    @Override
    public List<Product> loadAllProduct() {
        return getSession().createQuery("From Product", Product.class).getResultList();
    }

    @Override
    public List<Product> getRelateProducts(Category category, int maxResult) {
        return getSession()
                .createQuery("FROM Product p WHERE p.category = :category", Product.class)
                .setParameter("category", category)
                .setMaxResults(maxResult)
                .getResultList();
    }

    @Override
    public void resetIndexs() {
        FullTextSession fullTextSession = Search.getFullTextSession(getSession());
        fullTextSession.createIndexer(Product.class).start();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Product> searchProducts(String content) throws InterruptedException {
        FullTextSession fullTextSession = Search.getFullTextSession(getSession());
        fullTextSession.createIndexer().startAndWait();
        SearchFactory searchFactory = fullTextSession.getSearchFactory();
        QueryBuilder queryBuilder = searchFactory.buildQueryBuilder().forEntity(Product.class).get();
        Query luceneQuery = queryBuilder.keyword().wildcard().onField("name").matching("*" + content + "*").createQuery();

        FullTextQuery query = fullTextSession.createFullTextQuery(luceneQuery, Product.class);

        Sort sort = new Sort(new SortField("name", SortField.Type.STRING, false));
        query.setSort(sort);

        return query.list();
    }

}
