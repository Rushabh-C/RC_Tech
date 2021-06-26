package com.E_comm.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.E_comm.domain.CartItem;
import com.E_comm.domain.Product;
import com.E_comm.domain.ShoppingCart;
import com.E_comm.domain.User;
import com.E_comm.service.CartItemService;
import com.E_comm.service.ProductService;
import com.E_comm.service.ShoppingCartService;
import com.E_comm.service.UserService;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

	@Autowired
	private UserService userService;

	@Autowired
	private CartItemService cartItemService;

	@Autowired
	private ProductService productService;

	@Autowired
	private ShoppingCartService shoppingCartService;

	@RequestMapping("/cart")
	public String shoppingCart(Model model, Principal principal) {

		User user = userService.findByUsername(principal.getName());
		ShoppingCart shoppingCart = user.getShoppingCart();

		List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);

		shoppingCartService.updateShoppingCart(shoppingCart);

		model.addAttribute("cartItemList", cartItemList);
		model.addAttribute("shoppingCart", shoppingCart);

		return "shoppingCart";
	}

	@RequestMapping("/addItem")
	public String addItem(@ModelAttribute("product") Product product, @ModelAttribute("qty") String qty, Model model,
			Principal principal) {

		User user = userService.findByUsername(principal.getName());
		product = productService.findById(product.getId());

		if (Integer.parseInt(qty) > product.getInStockNumber()) {
			model.addAttribute("notEnoughStock", true);
			return "forward:/productDetail?id=" + product.getId();
		}

		CartItem cartItem = cartItemService.addProductToCartItem(product, user, Integer.parseInt(qty));
		model.addAttribute("addProductSuccess", true);

		return "forward:/productDetail?id=" + product.getId();
	}

	@RequestMapping("/updateCartItem")
	public String updateCartItem(@ModelAttribute("id") Long cartItemId, @ModelAttribute("qty") int qty) {

		CartItem cartItem = cartItemService.findById(cartItemId);
		cartItem.setQty(qty);
		cartItemService.updateCartItem(cartItem);

		return "forward:/shoppingCart/cart";
	}

	@RequestMapping("/removeItem")
	public String removeItem(@RequestParam("id") Long id) {

		cartItemService.removeCartItem(cartItemService.findById(id));

		return "forward:/shoppingCart/cart";
	}
}
