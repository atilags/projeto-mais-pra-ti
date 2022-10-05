package repository;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Repository<T> {

	Map<Long, T> dataBase;

	public Repository() {
		this.dataBase = new TreeMap<>();
	}

	public void insert(long id, T t) {
		this.dataBase.put(id, t);
	}

	public List<T> findAll() {
		return this.dataBase.values().stream().collect(Collectors.toList());
	}

	public T findById(long id) {
		return this.dataBase.get(id);
	}
	
	public void update(long id, T t) {
		this.dataBase.replace(id, t);
	}

	public void delete(long id) {
		this.dataBase.remove(id);
	}
}
