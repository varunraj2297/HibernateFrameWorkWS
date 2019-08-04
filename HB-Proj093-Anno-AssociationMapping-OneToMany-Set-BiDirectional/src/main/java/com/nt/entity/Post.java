package com.nt.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="POST_O2M_BI")
public class Post  implements Serializable{
	@Id
	@GenericGenerator( name = "gen1",strategy="increment")
	@GeneratedValue(generator="gen1")
	private int postId;
	@Column(length=50)
	@Type(type="string")
	private String postName;
	@Column(length=15)
	@Type(type="string")
	private String postSubject;
	@Column(length=15)
	@Type(type="string")
	private String postedBy;
	@Type(type="date")
	private Date postedDate;
	@ManyToOne(targetEntity=Blog.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="blog_id",referencedColumnName="blogid")
	private Blog blog;
	public Post() {
	   System.out.println("Post-0-param constructor");
	}
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", postName=" + postName + ", postSubject=" + postSubject + ", postedBy="
				+ postedBy + ", postedDate=" + postedDate + "]";
	}
	
}
