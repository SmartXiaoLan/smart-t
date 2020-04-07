package cn.smart.web.controller;

import cn.smart.pojo.PageResult;
import cn.smart.service.SearchItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchItemService searchItemService;

    @RequestMapping("/searchItem")
    public ModelAndView searchItem(ModelAndView modelAndView, String query, @RequestParam(value = "page", defaultValue = "1") Integer page,
                                   @RequestParam(value = "rows", defaultValue = "20") Integer rows) {
        if (query.trim().equals("")){
            modelAndView.setViewName("showItem");
            modelAndView.addObject("msg","Content is Null!!");
            return modelAndView;
        }
        try {
            PageResult result = this.searchItemService.searchItem(query, page, rows);
            modelAndView.addObject("result", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.setViewName("showItem");
        return modelAndView;

    }
}
