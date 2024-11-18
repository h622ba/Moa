package com.example.moa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.moa.mappers.CaseMapper;
import com.example.moa.model.Case;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
public class CaseService {
	
	private final CaseMapper caseMapper;
	
	@Autowired
	public CaseService(CaseMapper caseMapper) {
		this.caseMapper = caseMapper;
	}
	
	public List<Case> selectAll() {
		return caseMapper.all();
	}
	
	public List<Case> selectSearch(Case cases) {
		return caseMapper.search(cases);
	}
	
	public void add(Case cases) {
		caseMapper.insert(cases);
	}
	
	public void del(Case cases) {
		caseMapper.delete(cases);
	}
	
	public Case updateSearch(Case cases) {
		return caseMapper.upSearch(cases);
	}
	
	public void up(Case cases) {
		caseMapper.update(cases);
	}
}
