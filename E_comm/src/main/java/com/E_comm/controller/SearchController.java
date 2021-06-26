package com.E_comm.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.E_comm.domain.Product;
import com.E_comm.domain.User;
import com.E_comm.service.ProductService;
import com.E_comm.service.UserService;

@Controller
public class SearchController {

	@Autowired
	private UserService userService;

	@Autowired
	private ProductService productService;

	@RequestMapping("/searchByCategory")
	public String searchByCategory(@RequestParam("category") String category, Model model, Principal principal) {

		if (principal != null) {
			String username = principal.getName();
			User user = userService.findByUsername(username);
			model.addAttribute("user", user);
		}

		String classActiveCategory = "active" + category;
		classActiveCategory = classActiveCategory.replaceAll("\\s+", "");
		classActiveCategory = classActiveCategory.replaceAll("&", "");
		model.addAttribute(classActiveCategory, true);

		List<Product> productList = productService.findByCategory(category);

		if (productList.isEmpty()) {
			model.addAttribute("emptyList", true);
			return "productpage";
		}

		model.addAttribute("productList", productList);

		return "productPage";
	}

	@RequestMapping("/searchProduct")
	public String searchProduct(@ModelAttribute("keyword") String keyword, Principal principal, Model model) {

		if (principal != null) {
			String username = principal.getName();
			User user = userService.findByUsername(username);
			model.addAttribute("user", user);
		}

		List<Product> productList = productService.blurrySearch(keyword);

		if (productList.isEmpty()) {
			model.addAttribute("emptyList", true);
			return "productpage";
		}

		model.addAttribute("productList", productList);

		return "productPage";
	}
}
