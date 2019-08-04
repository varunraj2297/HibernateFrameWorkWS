package com.nt.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Blog;
import com.nt.entity.Post;
import com.nt.utility.HibernateUtil;

public class OneToManyDAOImpl  implements OneToManyDAO{

	@Override
	public void saveData() {
		
		Blog blog1=null;
		Post post1=null,post2=null,post3=null;
		List<Post> posts=null;
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		
		blog1=new Blog();
		blog1.setBlogName("Java by harikrishna");
		blog1.setBlogDomain("JAVA");
		
		post1=new Post();
		post1.setPostName("Runnable Interface");
		post1.setPostedBy("pankaj");
		post1.setPostedDate(new Date());
		post1.setPostSubject("Multithreading");
		
		post2=new Post();
		post2.setPostName("Vector");
		post2.setPostedBy("shubham");
		post2.setPostedDate(new Date(119,8,14));
		post2.setPostSubject("Collection");
		
		post3=new Post();
		post3.setPostName("String Pooling");
		post3.setPostedBy("yogesh");
		post3.setPostedDate(new Date(119,8,13));
		post3.setPostSubject("StringHandling");
		
		posts=new ArrayList<Post>();
		posts.add(post1);     
		posts.add(post2);
		posts.add(post3);
		
		blog1.setPosts(posts);
		
		ses=HibernateUtil.getSession();
		try {
			tx=ses.beginTransaction();
			ses.save(blog1);
			flag=true;
		}
		catch (HibernateException he) {
			flag=false;
			he.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Objects are Saved");
			}
			else {
				tx.rollback();
				System.out.println("Objects are not saved");
			}
			
			HibernateUtil.closeSession(ses);
		}
	
   }
	
	@Override
	public void loadData() {
		Session ses=null;
		Query query=null;
		Stream<Blog> blogStream=null;
		
		ses=HibernateUtil.getSession();
		query=ses.createQuery("from Blog");
		blogStream=query.getResultStream();
		blogStream.forEach(blog->{
			System.out.println("parent::"+blog);
			//System.out.println(blog.getPosts().size());
			blog.getPosts().stream().forEach(post->{
				System.out.println("child::"+post);
			}); 
		});
		
		HibernateUtil.closeSession(ses);
	}

	@Override
	public void loadDataUsingQBC() {
		Session ses=null;
		Criteria criteria=null;
		Stream<Blog> stream=null;
 		try {
		     ses=HibernateUtil.getSession();
		     criteria=ses.createCriteria(Blog.class);
		     stream=criteria.list().stream();
		     stream.forEach(blog->{
		    	 System.out.println("parent ::"+blog);
		    	 blog.getPosts().stream().forEach(post->{
		    		 System.out.println("child::"+post);
		    	 });
		     });
		}
 		catch (HibernateException he) {
			he.printStackTrace();
		}
 		finally {
			HibernateUtil.closeSession(ses);
		}
	}

	@Override
	public void deleteOneChildOfAParent() {
		Session ses=null;
		
		Blog blog=null;
		Transaction tx=null;
		
		List<Post> childs=null;
		Post post=null;
		boolean flag=false;
		
		
		ses=HibernateUtil.getSession();
		try {
			blog=ses.get(Blog.class, 47);
			childs=blog.getPosts();
			//post=ses.get(Post.class,6);
			tx=ses.beginTransaction();
			
			childs.remove(2);
		    flag=true;
		}
		catch (HibernateException he) {
			flag=false;
			he.printStackTrace();
		}
		catch (Exception e) {
			flag=false;
			e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("object is deleted");
			}
			else {
				tx.rollback();
				System.out.println("object is not deleted");	
			}
			HibernateUtil.closeSession(ses);
		}
	
		
		
	}
}
