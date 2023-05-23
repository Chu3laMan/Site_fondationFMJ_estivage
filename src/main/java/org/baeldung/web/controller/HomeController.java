package org.baeldung.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.baeldung.persistence.model.home.News;
import org.baeldung.persistence.model.home.SliderImage;
import org.baeldung.service.home.NewsService;
import org.baeldung.service.home.ServiceImageService;
import org.baeldung.service.home.SliderService;
import org.baeldung.web.util.numberOfSlider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
	@Autowired
	private NewsService newsService;
    @Autowired
    private SliderService sliderService;
    @Autowired 
    //private ServiceImageService serviceImageService;
    @GetMapping("/")
    public String root() {
        return "redirect:home.html";
    }/*
	 * fetch ImageSlider from database and return them to the view to be displayed
	 */
	@GetMapping("/home.html")
	public String getSliderImages(Model model)
	{
		 List<numberOfSlider> numberOfSliders =  new ArrayList<>(); int counter = 0;
		
		 List<SliderImage> images = sliderService.findAllActiveSlider(1);
		 images.forEach(image ->{numberOfSlider nb = new numberOfSlider();
		 nb.setNumber(counter +1);
		 numberOfSliders.add(nb);	 	 
		 });
		 //News 
		 List<News> news = newsService.getAllActiveNews(1);	 
		 model.addAttribute("images",  images);
		 model.addAttribute("numberOfSliders",numberOfSliders);
		 model.addAttribute("news", news);
		 return "/home.html";
	}
	
	@GetMapping("/akhbar/{id}")
	public String shwoAkhbar(@PathVariable("id") Long id ,Model model)
	{
		News feed = newsService.getOneNews(id);
		model.addAttribute("feed", feed);
		return "/akhbar.html";
	}
	
    
    /*@GetMapping("/home")
    public String getIndex() {
        return "home";
    }*/
   
    @GetMapping("/user")
    public String userIndex() {
        return "User/profile1";
    }

    @GetMapping("/home-03")
    public String getindex_alt2() {
        return "home-03";
    }
    @GetMapping("/home-02")
    public String gethome_02() {
        return "home-02";
    }
    @GetMapping("/blog-list-01")
    public String getblog_lis_01() {
        return "blog-list-01";
    }
    @GetMapping("/blog-list-02")
    public String getblog_list_02() {
        return "blog-list-02";
    }
    @GetMapping("/blog-dtail-01")
    public String getblog_detail_01() {
        return "blog-detail-01";
    }
    @GetMapping("/blog-dtail-02")
    public String getblog_detail_02() {
        return "blog-detail-02";
    }
    @GetMapping("/category-01")
    public String getcategory_01() {
        return "category-01";
    }
    @GetMapping("/category-02")
    public String getcategory_02() {
        return "category-02";
    }
    @GetMapping("/components")
    public String getcomponents() {
        return "components";
    }
    @GetMapping("/typography")
    public String gettypography() {
        return "typography";
    }
    @GetMapping("/animations")
    public String getanimations() {
        return "animations";
    }
    @GetMapping("/icon-variations")
    public String geticon_variations() {
        return "icon-variations";
    }
    @GetMapping("/icons")
    public String geticons() {
        return "icons";
    }
  /*  @GetMapping("/login")
    public String login() {
        return "registration";
    }*/
    @GetMapping("/about")
    public String getabout() {
        return "about";
    }
 
    @GetMapping("/testimonials")
    public String gettestimonials() {
        return "testimonials";
    }
    @GetMapping("/404")
    public String get404() {
        return "404";
    }
    @GetMapping("/portfolio-2cols")
    public String getportfolio_2cols() {
        return "portfolio-2cols";
    }
    @GetMapping("/portfolio-3cols")
    public String getportfolio_3cols() {
        return "portfolio-3cols";
    }
    @GetMapping("/portfolio-4cols")
    public String getportfolio_4cols() {
        return "portfolio-4cols";
    }
    @GetMapping("/portfolio-detail")
    public String getportfolio_detail() {
        return "portfolio-detail";
    }
    @GetMapping("/contact")
    public String getcontact() {
        return "contact";
    }
    @GetMapping("/blog-left-sidebar")
    public String getblog_left_sidebar() {
        return "blog-left-sidebar";
    }
    @GetMapping("/blog-right-sidebar")
    public String getblog_right_sidebar() {
        return "blog-right-sidebar";
    }
    @GetMapping("/publication5.html")
    public String getpost_left_sidebar() {
        return "/publication5.html";
    }
    @GetMapping("/post-right-sidebar")
    public String getpost_right_sidebar() {
        return "post-right-sidebar";
    }
   

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "/error/access-denied";
    }

}
