package com.social.enactive.bot.mongo;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public abstract class AbstractRepository<T> {

	protected final MongoTemplate template;
	protected final Class<T> objClass;

	public AbstractRepository(MongoTemplate template, Class<T> clazz) {
		this.template = template;
		this.objClass = clazz;
	}

	public T insert(T obj) {
		template.insert(obj, collectionName());
		return obj;
	}

	public T update(T obj) {
		template.save(obj, collectionName());
		return obj;
	}
	
	public List<T> inserAll(List<T> objs) {
		template.insert(objs, collectionName());
		return objs;
	}
	
	public List<T> removeAll(List<String> ids) {
		return template.findAllAndRemove(Query.query(Criteria.where("id").in(ids)), objClass, collectionName());
	}

	public T find(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		}

		return template.findById(id, objClass, collectionName());
	}

	public String collectionName() {
		return objClass.getSimpleName();
	}

	public List<T> list() {
		return template.findAll(objClass, collectionName());
	}

	public List<T> list(List<String> ids) {
		return template.find(new Query(Criteria.where("id").all(ids)), objClass);
	}

}