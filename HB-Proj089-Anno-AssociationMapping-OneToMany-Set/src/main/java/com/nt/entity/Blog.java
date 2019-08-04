package com.nt.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="BLOG_O2M")
public class Blog implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int blogid;
	@Column(length=30)
	@Type(type="string")
	 private String blogName;
	@Column(length=15)
	@Type(type="string") 
	private String blogDomain;
	@OneToMany(targetEntity = Post.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY,orphanRemoval=true) 
	@JoinColumn(name="blog_id",referencedColumnName="blogid")
	@LazyCollection(LazyCollectionOption.EXTRA)
	@Fetch(FetchMode.SUBSELECT)   //only works for QBC
	private Set<Post> posts;
	
	public Blog() {
	     System.out.println("Blog-0-param-constructor");
	}	
	
	@Override
	public String toString() {
		return "Blog [blogid=" + blogid + ", blogName=" + blogName + ", blogDomain=" + blogDomain + "]";
	}

}
