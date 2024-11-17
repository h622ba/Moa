package com.example.moa.mappers;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.moa.model.Case;

@Mapper
public interface CaseMapper {
	List<Case> all();
	List<Case> search(Case cases);
	void insert(Case cases);
	void delete(Case cases);
	Case upSearch(Case cases);
	void update(Case cases);
}
