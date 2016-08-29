package com.madhukar.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class FlickrResponse {

	String title;
	String link;
	String description;
	String modified;
	String generator;
	List<FlickrImages> items;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getModified() {
		return modified;
	}
	public void setModified(String modified) {
		this.modified = modified;
	}
	public String getGenerator() {
		return generator;
	}
	public void setGenerator(String generator) {
		this.generator = generator;
	}
	public List<FlickrImages> getItems() {
		if (items == null) {
			items = new ArrayList<>();
		}
		return items;
	}
	public void setItems(List<FlickrImages> flickrImagesList) {
		this.items = flickrImagesList;
	}
	@Override
	public String toString() {
		return "FlickrResponse [title=" + title + ", link=" + link + ", description=" + description + ", modified="
				+ modified + ", generator=" + generator + ", items=" + items + "]";
	}

	
	
}
