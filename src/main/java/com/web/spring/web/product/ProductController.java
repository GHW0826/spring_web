package com.web.spring.web.product;

import com.web.spring.api.product.Brand;
import com.web.spring.api.product.Category;
import com.web.spring.api.product.ProductEntity;
import com.web.spring.api.product.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/web")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/product/register")
    public String createProductForm(Model model) {
        model.addAttribute("product", new ProductDefaultForm());
        return "product/createProductForm";
    }

    @PostMapping("/product/register")
    public String createProduct(@ModelAttribute("product") ProductDefaultForm product) {
        ProductEntity newProduct = new ProductEntity(product);
        productService.registerProduct(newProduct);
        return "redirect:/web";
    }

    @GetMapping("/product/{productId}")
    public String updateProductForm(@PathVariable("productId") Long productId, Model model) {
        log.info("GetMappingGetMappingGetMappingGetMappingGetMappingGetMapping");
        ProductEntity productEntity = productService.findById(productId).get();
        ProductUpdateForm product = new ProductUpdateForm(productEntity);
        model.addAttribute("product", product);
        return "product/updateProductForm";
    }

    @PutMapping("/product/{productId}")
    public String updateProduct(@PathVariable("productId") Long productId, @ModelAttribute(name = "product") ProductUpdateForm product) {
        productService.updateProduct(product.getId(), product.getProductName(), product.getBrand(), product.getPrice(), product.getCategory(), product.getStockQuantity());
        return "redirect:/web";
    }

    @DeleteMapping("/product/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId) {
        productService.deleteProduct(productId);
        return "redirect:/web";
    }

    @GetMapping("/products")
    public String productList(Model model) {
        model.addAttribute("products", productService.findAll().stream()
                                                    .map(ProductEntity.findByIdResponse::new)
                                                    .collect(Collectors.toList()));
        return "product/productListForm";
    }
}
