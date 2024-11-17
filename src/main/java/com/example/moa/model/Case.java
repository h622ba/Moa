package com.example.moa.model;

public class Case {

	private int id;
	private int ken;
	private int occupation;
    private int industry;
	private int price;
	private int lowprice;
	private int highprice;
	private String startdate;
	private String workingdays;
	private String overview;
	private String detail;
	private String words;

	public Case(int id) {
		this.id = id;
	}
	
	public Case(String words, int ken, int occupation, int industry, int price) {
		this.words = words;
		this.ken = ken;
		this.occupation = occupation;
		this.industry = industry;
		this.price = price;
	}
	
	public Case(int ken, int occupation, int industry, int lowprice, int highprice, String startdate, String workingdays, String overview, String detail) {
		this.ken = ken;
		this.occupation = occupation;
		this.industry = industry;
		this.lowprice = lowprice;
		this.highprice = highprice;
		this.startdate = startdate;
		this.workingdays = workingdays;
		this.overview = overview;
		this.detail = detail;
	}
	
	public Case(int id, int ken, int occupation, int industry, int lowprice, int highprice, String startdate, String workingdays, String overview, String detail) {
		this.id = id;
		this.ken = ken;
		this.occupation = occupation;
		this.industry = industry;
		this.lowprice = lowprice;
		this.highprice = highprice;
		this.startdate = startdate;
		this.workingdays = workingdays;
		this.overview = overview;
		this.detail = detail;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getKen() {
		return ken;
	}

	public void setKen(int ken) {
		this.ken = ken;
	}

	public int getOccupation() {
		return occupation;
	}

	public void setOccupation(int occupation) {
		this.occupation = occupation;
	}

	public int getIndustry() {
		return industry;
	}

	public void setIndustry(int industry) {
		this.industry = industry;
	}

	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getLowprice() {
		return lowprice;
	}

	public void setLowprice(int lowprice) {
		this.lowprice = lowprice;
	}
	
	public int getHighprice() {
		return highprice;
	}
	
	public void setHighprice(int highprice) {
		this.highprice = highprice;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getWorkingdays() {
		return workingdays;
	}

	public void setWorkingdays(String workingdays) {
		this.workingdays = workingdays;
	}

	public String getOverview() {
		return overview;
	}
	
	public void setOverview(String overview) {
		this.overview = overview;
	}
	
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	public String getWords() {
		return words;
	}
	
	public void setWords(String words) {
		this.words = words;
	}

}
