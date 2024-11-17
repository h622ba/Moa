package com.example.moa.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
//必要なクラスをインポートします
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.moa.mappers.CaseMapper;
import com.example.moa.model.Case;
import com.example.moa.service.CaseService;

@Controller // このクラスがWebコントローラーであることを示します
public class LoginController {
	
	final private CaseService service;
	
	@Autowired
	public LoginController(CaseService service) {
		this.service = service;
	}

    @GetMapping("/login") // "/login"というURLに対するGETリクエストを処理します
    public String login() {
        return "login";  // login.htmlを表示します
    }
    
    @GetMapping("/") // ルートURL ("/") に対するGETリクエストを処理します
    public String redirectToIndex() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // 現在のユーザーの認証情報を取得します
        if (authentication != null && authentication.isAuthenticated()) { // ユーザーがログインしている場合
            return "redirect:/index";  // "/index"にリダイレクトします
        }
        return "redirect:/login"; // ユーザーがログインしていない場合、"/login"にリダイレクトします
    }
    
    @GetMapping("/index") // "/index"というURLに対するGETリクエストを処理します
    public String index(Model model) {
    	List<Case> cases = service.selectAll();
        model.addAttribute("cases", cases);
        return "index"; // index.htmlを表示します
    }
    
    @GetMapping("/index/search") // "/index"というURLに対するGETリクエストを処理します
    public String indexSearch(Model model, @RequestParam(name = "words", defaultValue = "") String words,
    							@RequestParam(name = "ken", defaultValue = "0") int ken,
    							@RequestParam(name = "occupation", defaultValue = "0") int occupation,
    							@RequestParam(name = "industry", defaultValue = "0") int industry,
    							@RequestParam(name = "price", defaultValue = "0") int price) {
    	Case cases = new Case(words, ken, occupation, industry, price);
    	List<Case> cases1 = service.selectSearch(cases);
        model.addAttribute("cases", cases1);
        return "index"; // index.htmlを表示します
    }
    
    @GetMapping("/add")
    public String addForm() {
    	return "add";
    }
    
    @PostMapping("/add")
	public String add(@RequestParam("ken") int ken,
						@RequestParam("occupation") int occupation,
						@RequestParam("industry") int industry,
						@RequestParam("lowprice") int lowprice,
						@RequestParam("highprice") int highprice,
						@RequestParam("startdate") String startdate,
						@RequestParam("workingdays") String workingdays,
						@RequestParam("overview") String overview, 
						@RequestParam("detail") String detail) {
		Case cases = new Case(ken, occupation, industry, lowprice, highprice, startdate, workingdays, overview, detail);
		service.add(cases);
		return "redirect:/";
	}
    
    @PostMapping("/delete")
	public String delete(@RequestParam("case_id") int id) {
		Case cases = new Case(id);
		service.del(cases);
		return "redirect:/";
	}

    @GetMapping("/update")
    public String updateShow(Model model, @RequestParam("case_id") int id) {
    	Case cases = new Case(id);
    	Case cases1 = service.updateSearch(cases);
        model.addAttribute("cases", cases1);
    	return "update";
    }
    
    @PostMapping("/update")
	public String update(@RequestParam("case_id") int id,
			@RequestParam("ken") int ken,
			@RequestParam("occupation") int occupation,
			@RequestParam("industry") int industry,
			@RequestParam("lowprice") int lowprice,
			@RequestParam("highprice") int highprice,
			@RequestParam("startdate") String startdate,
			@RequestParam("workingdays") String workingdays,
			@RequestParam("overview") String overview, 
			@RequestParam("detail") String detail) {
		Case cases = new Case(id, ken, occupation, industry, lowprice, highprice, startdate, workingdays, overview, detail);
		service.up(cases);
		return "redirect:/";
	}
}