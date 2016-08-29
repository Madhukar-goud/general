package com.madhukar.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class FlickrImages {

	String title;
	String link;
	Media media;
	String date_taken;
	String description;
	String published;
	String author;
	String author_id;
	String tags;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	public String getDate_taken() {
		return date_taken;
	}
	public void setDate_taken(String date_taken) {
		this.date_taken = date_taken;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPublished() {
		return published;
	}
	public void setPublished(String published) {
		this.published = published;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(String author_id) {
		this.author_id = author_id;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	
	public Media getMedia() {
		return media;
	}
	public void setMedia(Media media) {
		this.media = media;
	}
	@Override
	public String toString() {
		return "FlickrImages [title=" + title + ", link=" + link + ", media=" + media + ", date_taken=" + date_taken
				+ ", description=" + description + ", published=" + published + ", author=" + author + ", author_id="
				+ author_id + ", tags=" + tags + "]";
	}
	
}
