package controller;

import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.IProductService;
import service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final IProductService productService = new ProductService();

    @GetMapping("")
    public String index(Model model) {
        List<Product> productList = productService.findAllProduct();
        model.addAttribute("productList", productList);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/edit";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/delete";
    }

    @GetMapping("/{id}/details")
    public String details(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/details";
    }

    @GetMapping("/{name}/search-result")
    public String details(@PathVariable String name, Model model) {
        model.addAttribute("product", productService.findByName(name));
        return "/search-result";
    }

    @PostMapping("/save")
    public String save(Product product,  RedirectAttributes redirect) {
        product.setId((int) (Math.random() * 10000));
        productService.create(product);
        redirect.addFlashAttribute("success", "Create product successfully!");
        return "redirect:/product";
    }

    @PostMapping("/update")
    public String update(Product product) {
        productService.update(product.getId(), product);
        return "redirect:/product";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productService.remove(product.getId());
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/product";
    }
}
